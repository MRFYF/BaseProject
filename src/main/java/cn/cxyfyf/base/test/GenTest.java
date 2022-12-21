package cn.cxyfyf.base.test;

import cn.cxyfyf.base.framework.enums.GenEnum;
import cn.cxyfyf.base.framework.utils.gen.GenUtils;

public class GenTest {
    public static void main(String[] args) {
        String[] tables = {"finance_project_allocate_detail"};
        for (String table : tables) {
            GenUtils.generatorCode(table, GenEnum.COMPANY);
        }
    }
}
