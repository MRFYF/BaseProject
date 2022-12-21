package cn.cxyfyf.base.framework.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述 通用值处理注解
 * @author cxyfyf
 * Create by 2022/12/7 17:08
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CommonValue {
    /**
     * 查询标识, 字典值必传 声明查询哪个 字典分类 code码 <br/>
     * 多个字典值，逗号分隔 例：DICT508506,DICT747462 <br/>
     * 例如字典表 等级分类编码 DICT508506，其子集就是 青铜 ITEM001、白银 ITEM002、黄金 ITEM003 类似字典形式
     * DATE 用来转 时间转化格式 例 yyyy-MM-dd HH:mm:ss
     */
    String value() default "";
    /**
     * 要赋值字段名称 小驼峰命名方式，DICT、SYSTEM_USER、AREA不传默认替换 查询标识 字段，DATE必传
     */
    String name() default "";
    /**
     * 默认值
     */
    String defaultValue() default "";

    /**
     * 处理值类型。默认字典值
     */
    Type type() default Type.DICT;

    /**
     * 类型
     */
    enum Type {
        /**
         * 字典值
         */
        DICT,
        /**
         * 系统用户赋值
         */
        SYSTEM_USER,
        /**
         * 区域，省市区
         */
        AREA,
        /**
         * 日期
         */
        DATE
    }
}
