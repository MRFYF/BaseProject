package cn.cxyfyf.base.controller.to;

import cn.cxyfyf.base.framework.exception.FieldException;
import cn.cxyfyf.base.framework.utils.StringUtils;
import cn.cxyfyf.base.framework.web.domain.BaseDTO;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

/**
 * 部门表接收对象 sys_dept
 * 
 * @author fengyingfeng
 * @date 2022-11-01
 */

@Getter
@Setter
public class SysDeptTo extends BaseDTO {

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

    public SysDeptTo (){}

    /**
     * 判断不能为空
     * @param to 接收对象
     * @param fields 需要校验的字符串
     */
    public static void judgeParam(SysDeptTo to, String fields){
        List<String> fieldList = Lists.newArrayList(fields.split(","));
        if (fieldList.contains("id") && Objects.isNull(to.getId ())) throw new FieldException("部门id 不能为空");
        if (fieldList.contains("parentId") && Objects.isNull(to.getParentId ())) throw new FieldException("父部门id 不能为空");
        if (fieldList.contains("ancestors") && StringUtils.isEmpty(to.getAncestors ())) throw new FieldException("祖级列表 不能为空");
        if (fieldList.contains("deptName") && StringUtils.isEmpty(to.getDeptName ())) throw new FieldException("部门名称 不能为空");
        if (fieldList.contains("orderNum") && Objects.isNull(to.getOrderNum ())) throw new FieldException("显示顺序 不能为空");
        if (fieldList.contains("leader") && StringUtils.isEmpty(to.getLeader ())) throw new FieldException("负责人 不能为空");
        if (fieldList.contains("phone") && StringUtils.isEmpty(to.getPhone ())) throw new FieldException("联系电话 不能为空");
        if (fieldList.contains("email") && StringUtils.isEmpty(to.getEmail ())) throw new FieldException("邮箱 不能为空");
        if (fieldList.contains("status") && StringUtils.isEmpty(to.getStatus ())) throw new FieldException("部门状态（0正常 1停用） 不能为空");
        if (fieldList.contains("delFlag") && StringUtils.isEmpty(to.getDelFlag ())) throw new FieldException("删除标志（0代表存在 2代表删除） 不能为空");
        if (fieldList.contains("createBy") && StringUtils.isEmpty(to.getCreateBy ())) throw new FieldException("创建者 不能为空");
        if (fieldList.contains("createTime") && Objects.isNull(to.getCreateTime ())) throw new FieldException("创建时间 不能为空");
        if (fieldList.contains("updateBy") && StringUtils.isEmpty(to.getUpdateBy ())) throw new FieldException("更新者 不能为空");
        if (fieldList.contains("updateTime") && Objects.isNull(to.getUpdateTime ())) throw new FieldException("更新时间 不能为空");
    }



}
