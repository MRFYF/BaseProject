package cn.cxyfyf.base.framework.enums;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 代码生成模块选择枚举
 */
@Slf4j
public enum GenEnum {
    OWNER, COMPANY;

    public static void main(String[] args) {
        String groupCode = "Group051407";
        Integer id = groupCode.contains("Group") ? Integer.parseInt(groupCode.replace("Group", "")) : Integer.parseInt(groupCode);

        String format = new DecimalFormat("000000").format(id);
        System.out.println(format);

        ArrayList<String> a = Lists.newArrayList("a", "b", "c", "d");
        ArrayList<String> b = Lists.newArrayList("c", "a", "b", "e");
        System.out.println(CollectionUtils.isEqualCollection(a, b)); // 比较
        System.out.println(CollectionUtils.intersection(a, b)); // 交集
        System.out.println(CollectionUtils.disjunction(a, b)); // 交集的补集
        System.out.println(CollectionUtils.subtract(a, b)); // a 与 b 的差集
        System.out.println(CollectionUtils.subtract(b, a)); // b 与 a 的差集
    }
}
