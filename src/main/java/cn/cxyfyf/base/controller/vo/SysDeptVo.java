package cn.cxyfyf.base.controller.vo;

import cn.cxyfyf.base.framework.web.domain.BaseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * 部门表传输对象 sys_dept
 *
 * @author fengyingfeng
 * @date 2022-11-01
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SysDeptVo extends BaseDTO {

private static final long serialVersionUID = -1L;

    /** 父部门id */
    private Long parentId;
    /** 祖级列表 */
    private String ancestors;
    /** 部门名称 */
    private String deptName;
    /** 显示顺序 */
    private Long orderNum;
    /** 负责人 */
    private String leader;
    /** 联系电话 */
    private String phone;
    /** 邮箱 */
    private String email;
    /** 部门状态（0正常 1停用） */
    private String status;
    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public SysDeptVo (){}
}
