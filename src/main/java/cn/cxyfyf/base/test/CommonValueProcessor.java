package cn.cxyfyf.base.test;

import cn.cxyfyf.base.framework.anno.CommonValue;
import cn.cxyfyf.base.framework.utils.DateUtils;
import cn.cxyfyf.base.framework.utils.StringUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 描述 通用值处理器 @CommonValue <br/>
 * 核心通过 反射 + 注解 + 泛型 进行动态处理
 * @author cxyfyf
 * Create by 2022/12/8 17:08
 */
public class CommonValueProcessor<T> {


    /**
     * 处理单个实体类全部带@CommonValue的字段数据
     * @param t model
     */
    public void dealWithData(T t) {

        if (Objects.isNull(t)) return; // 判空

        // 获取所有要查询的值，转换为 id -> name 形式
        Map<String, String> map = this.getValueMap(Lists.newArrayList(t), null);

        // 通过反射 和注解值 处理 数据
        this.dealWithClass(t, map, null);

    }
    /**
     * 处理单个实体类数据
     * @param t model 已实例化的实体类
     * @param allowFields 要处理的字段 多个，逗号分开，小驼峰形式 例：userId,userName,phone
     */
    public void dealWithData(T t, String allowFields) {

        if (Objects.isNull(t)) return; // 判空

        // 要处理的字段列表
        List<String> allowList = StringUtils.isEmpty(allowFields) ? Collections.emptyList() :
                Arrays.stream(allowFields.split(",")).map(String::trim).filter(StringUtils::isNotEmpty).toList();

        // 获取所有要查询的值，转换为 id -> name 形式
        Map<String, String> map = this.getValueMap(Lists.newArrayList(t), allowList);

        // 通过反射 和注解值 处理 数据
        this.dealWithClass(t, map, allowList);

    }

    /**
     * 处理列表中全部带@CommonValue的字段数据
     * @param list 列表数据
     */
    public void dealWithListData(List<T> list) {

        if (CollectionUtils.isEmpty(list)) return;  // 判空

        // 获取所有要查询的值，转换为 id -> name 形式
        Map<String, String> map = this.getValueMap(list, null);

        // 通过反射 和注解值 处理 数据
        for (T t : list) {
            this.dealWithClass(t, map, null);
        }

    }

    /**
     * 处理单个实体类数据
     * @param list 列表数据
     * @param allowFields 要处理的字段列表
     */
    public void dealWithListData(List<T> list, String allowFields) {

        if (CollectionUtils.isEmpty(list)) return;  // 判空

        // 要处理的字段列表
        List<String> allowList = StringUtils.isEmpty(allowFields) ? Collections.emptyList() :
                Arrays.stream(allowFields.split(",")).map(String::trim).filter(StringUtils::isNotEmpty).toList();

        // 获取所有要查询的值，转换为 id -> name 形式
        Map<String, String> map = this.getValueMap(list, null);

        // 通过反射 和注解值 处理 数据
        for (T t : list) {
            this.dealWithClass(t, map, allowList);
        }

    }

    /**
     * 处理具体对象
     * @param t 实体类
     * @param map 数据集
     * @param allowList 要处理的字段列表
     */
    private void dealWithClass(T t, Map<String, String> map, List<String> allowList) {

        // 获取class 对象
        Class<?> aClass = t.getClass();
        // 获取字段数组
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            // 判断若allowList不为空，且不在要处理的字段列表之中的字段直接跳过
            if (CollectionUtils.isNotEmpty(allowList) && !allowList.contains(field.getName())) continue;
            // 获取注解数据
            CommonValue commonValue = field.getAnnotation(CommonValue.class);
            // 不为空
            if (Objects.nonNull(commonValue)) {
                // 获取要调用的方法名
                String setMethodName = this.getSetMethodName(commonValue, field);
                // 调用set方法，赋值
                this.invokeSetMethod(setMethodName, aClass, field, map, commonValue, t);
            }
        }
    }

    /**
     * 通过反射调用set方法
     * @param setMethodName set方法名称
     * @param aClass 实体类class对象
     * @param field 字段
     * @param map 数据集map
     * @param anno 注解
     * @param t 当前对象
     */
    private void invokeSetMethod(String setMethodName, Class<?> aClass, Field field, Map<String, String> map, CommonValue anno, T t) {
        Method setMethod; // 方法对象
        try {
            // 根据名称获取当前类的set方法
            setMethod = aClass.getDeclaredMethod(setMethodName, String.class);
            // 设置允许访问
            setMethod.setAccessible(true);
            if (Objects.equals(CommonValue.Type.DATE, anno.type())) {
                Object filedValue = this.getObjectFiledValue(field, t);
                if (filedValue == null) return;
                if (filedValue instanceof Date d){
                    setMethod.invoke(t, DateUtils.parseDateToStr(anno.value(), d));
                }
                if (filedValue instanceof LocalDateTime d){
                    setMethod.invoke(t, d.format(DateTimeFormatter.ofPattern(anno.value())));
                }
            } else {
                // 获取字段值
                String filedValue = this.getFiledValue(field, t);
                // 调用set方法，进行赋值
                setMethod.invoke(t, map.getOrDefault(filedValue, anno.defaultValue()));
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // 报错继续运行
        }
    }

    /**
     * 获取set方法名
     * @param commonValue 注解
     * @param field 字段
     * @return set方法名
     */
    private String getSetMethodName(CommonValue commonValue, Field field) {

        String setMethodName = "set";
        //若注解中要赋值的名称为空
        if (StringUtils.isEmpty(commonValue.name())) {
            // 则使用当前字段的字段名进行赋值，即替换
            setMethodName += StringUtils.capitalize(field.getName());
        } else {
            // 则使用注解，字段名
            setMethodName += StringUtils.capitalize(commonValue.name());
        }
        return setMethodName;
    }

    /**
     * 获取字段值
     * @param field 字段
     * @param t 当前实体对象
     * @return 转 string 的字段值
     */
    private String getFiledValue(Field field, T t) {
        try {
            field.setAccessible(true);
            return Objects.isNull(field.get(t)) ? "" : String.valueOf(field.get(t));
        } catch (IllegalAccessException e) {
            return "";
        }
    }

    /**
     * 获取字段值
     * @param field 字段
     * @param t 当前实体对象
     * @return object 的字段值
     */
    private Object getObjectFiledValue(Field field, T t) {
        try {
            field.setAccessible(true);
            return field.get(t);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /**
     * 获取全部要处理的字典数据、系统用户数据、区域数据
     * @param list 列表数据
     * @param allowList 要处理的字段列表
     * @return 数据集 id -> name 形式
     */
    public Map<String, String> getValueMap(List<T> list, List<String> allowList) {
        // 数据集 map
        Map<String, String> map = new HashMap<>();
        // 字典code列表
        Set<String> dictList = new HashSet<>();
        // 用户ID列表
        Set<String> userList = new HashSet<>();
        // 区域code列表
        Set<String> areaList = new HashSet<>();
        for (T t : list) {
            // 获取class 对象
            Class<?> aClass = t.getClass();
            // 获取字段数组
            Field[] fields = aClass.getDeclaredFields();

            for (Field field : fields) {
                // 判断若allowList不为空，且不在要处理的字段列表之中的字段直接跳过
                if (CollectionUtils.isNotEmpty(allowList) && !allowList.contains(field.getName())) continue;

                CommonValue commonValue = field.getAnnotation(CommonValue.class); // 注解数据
                if (Objects.nonNull(commonValue)) {
                    if (Objects.equals(CommonValue.Type.DICT, commonValue.type())) { // 汇总字典code
                        // 处理code数据
                        List<String> dictCodes = StringUtils.isEmpty(commonValue.value()) ? Collections.emptyList() :
                                Arrays.stream(commonValue.value().split(",")).map(String::trim).filter(StringUtils::isNotEmpty).toList();
                        dictList.addAll(dictCodes);
                    }
                    if (Objects.equals(CommonValue.Type.SYSTEM_USER, commonValue.type())) { // 汇总用户ID
                        userList.add(this.getFiledValue(field, t));
                    }
                    if (Objects.equals(CommonValue.Type.AREA, commonValue.type())) { // 汇总区域code
                        areaList.add(this.getFiledValue(field, t));
                    }
                }
            }
        }
        map = getExampleMap(); // 获取数据来源
//        Map<String, String> dict = this.getDictInfo(dictList);
//        if (MapUtils.isNotEmpty(dict)) map.putAll(dict);
//        Map<String, String> user = this.getUserInfo(userList);
//        if (MapUtils.isNotEmpty(user)) map.putAll(user);
//        Map<String, String> area = this.getAreaInfo(areaList);
//        if (MapUtils.isNotEmpty(area)) map.putAll(area);
        return map;
    }

    /**
     * 模拟数据源
     */
    public Map<String, String> getExampleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("item001", "字典值001");
        map.put("user001", "用户001");
        map.put("370200", "青岛市");
        map.put("item002", "字典值002");
        map.put("user002", "用户002");
        map.put("370100", "济南市");
        return map;
    }

}
