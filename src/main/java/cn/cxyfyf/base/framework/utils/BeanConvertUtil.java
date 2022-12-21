package cn.cxyfyf.base.framework.utils;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * bean 转换器
 */
@Component
public class BeanConvertUtil {

    private static BeanConvertUtil beanConvertUtil;

    @Resource
    private Mapper mapper;

    @PostConstruct
    private void init () {
        beanConvertUtil = this;
    }

    /**
     * List 实体类 转换器
     *
     * @param source 原数据
     * @param clz    转换类型
     */
    public static <T, S> List<T> convert(List<S> source, Class<T> clz) {
        if (source == null || source.size() == 0) {
            return null;
        }
        List<T> map = new ArrayList<>();
        for (S s : source) {
            map.add(beanConvertUtil.mapper.map(s, clz));
        }
        return map;
    }

    /**
     * Set 实体类 深度转换器
     *
     * @param source 原数据
     * @param clz    目标对象
     */
    public static <T, S> Set<T> convert(Set<S> source, Class<T> clz) {
        if (source == null || source.size() == 0) {
            return null;
        }
        Set<T> set = new TreeSet<>();
        for (S s : source) {
            set.add(beanConvertUtil.mapper.map(s, clz));
        }
        return set;
    }

    /**
     * 实体类 深度转换器
     *
     * @param source 元数据
     * @param clz 目标class对象
     */
    public static <T, S> T convert(S source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        return beanConvertUtil.mapper.map(source, clz);
    }

    public static void convert(Object source, Object object) {
        beanConvertUtil.mapper.map(source, object);
    }

    public static <T> void copyConvert(T source, Object object) {
        beanConvertUtil.mapper.map(source, object);
    }

}

