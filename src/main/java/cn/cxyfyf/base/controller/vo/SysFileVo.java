package cn.cxyfyf.base.controller.vo;

import lombok.Data;

/**
 * 文件信息
 */
@Data
public class SysFileVo {
    /**
     * ID
     */
    private String id;
    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件地址
     */
    private String url;

}
