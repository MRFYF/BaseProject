package cn.cxyfyf.base.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 文件存储对象 hc_sys_media
 * 
 * @author fengyingfeng
 * @date 2021-10-08
 */

@Data
@TableName("hc_sys_media")
public class SysMedia implements Serializable{

    private static final long serialVersionUID = 8629191001732154759L;
    /** 主键 */
    @TableId
    private Long id;

    /** 原文件名 */
    private String originName;

    /** 文件名 */
    private String fileName;

    /** 文件类型 */
    private String mediaType;

    /** md5值 */
    private String md5;

    /** 文件大小 */
    private Long size;

    /** 文件访问的url */
    private String fileUrl;

    /** 有效, 0:无效,已删除; 1:有效,正常(默认) */
    private Integer valid;

    /** 备注 */
    private String remark;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    private Date createTime;

    /** 更新人 */
    private String updateBy;

    /** 更新时间 */
    private Date updateTime;


}
