package cn.cxyfyf.base.controller.to;

import cn.cxyfyf.base.framework.exception.FieldException;
import cn.cxyfyf.base.framework.utils.StringUtils;
import cn.cxyfyf.base.framework.web.domain.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用户信息表接收对象 sys_user
 * 
 * @author fengyingfeng
 * @date 2022-11-01
 */

@Getter
@Setter
public class SysUserTo extends BaseDTO {

private static final long serialVersionUID = -1L;

    /** 部门ID */
    private Long deptId;
    /** 登录账号 */
    private String loginName;
    /** 用户昵称 */
    private String userName;
    /** 用户类型（00系统用户 01注册用户） */
    private String userType;
    /** 用户邮箱 */
    private String email;
    /** 手机号码 */
    private String phonenumber;
    /** 用户性别（0男 1女 2未知） */
    private String sex;
    /** 头像路径 */
    private String avatar;
    /** 密码 */
    private String password;
    /** 盐加密 */
    private String salt;
    /** 帐号状态（0正常 1停用） */
    private String status;
    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
    /** 最后登录IP */
    private String loginIp;
    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginDate;
    /** 密码最后更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pwdUpdateDate;
    /** 备注 */
    private String remark;

    public SysUserTo (){}

    /**
     * 判断不能为空
     * @param to 接收对象
     * @param fields 需要校验的字符串 例：id,deptId,loginName,userName
     */
    public static void judgeParam(SysUserTo to, String fields){
        List<String> fieldList = Arrays.stream(fields.split(",")).filter(StringUtils::isNotEmpty).map(String::trim).distinct().collect(Collectors.toList());
        if (fieldList.contains("id") && Objects.isNull(to.getId ())) throw new FieldException("用户ID 不能为空");
        if (fieldList.contains("deptId") && Objects.isNull(to.getDeptId ())) throw new FieldException("部门ID 不能为空");
        if (fieldList.contains("loginName") && StringUtils.isEmpty(to.getLoginName ())) throw new FieldException("登录账号 不能为空");
        if (fieldList.contains("userName") && StringUtils.isEmpty(to.getUserName ())) throw new FieldException("用户昵称 不能为空");
        if (fieldList.contains("userType") && StringUtils.isEmpty(to.getUserType ())) throw new FieldException("用户类型（00系统用户 01注册用户） 不能为空");
        if (fieldList.contains("email") && StringUtils.isEmpty(to.getEmail ())) throw new FieldException("用户邮箱 不能为空");
        if (fieldList.contains("phonenumber") && StringUtils.isEmpty(to.getPhonenumber ())) throw new FieldException("手机号码 不能为空");
        if (fieldList.contains("sex") && StringUtils.isEmpty(to.getSex ())) throw new FieldException("用户性别（0男 1女 2未知） 不能为空");
        if (fieldList.contains("avatar") && StringUtils.isEmpty(to.getAvatar ())) throw new FieldException("头像路径 不能为空");
        if (fieldList.contains("password") && StringUtils.isEmpty(to.getPassword ())) throw new FieldException("密码 不能为空");
        if (fieldList.contains("salt") && StringUtils.isEmpty(to.getSalt ())) throw new FieldException("盐加密 不能为空");
        if (fieldList.contains("status") && StringUtils.isEmpty(to.getStatus ())) throw new FieldException("帐号状态（0正常 1停用） 不能为空");
        if (fieldList.contains("delFlag") && StringUtils.isEmpty(to.getDelFlag ())) throw new FieldException("删除标志（0代表存在 2代表删除） 不能为空");
        if (fieldList.contains("loginIp") && StringUtils.isEmpty(to.getLoginIp ())) throw new FieldException("最后登录IP 不能为空");
        if (fieldList.contains("loginDate") && Objects.isNull(to.getLoginDate ())) throw new FieldException("最后登录时间 不能为空");
        if (fieldList.contains("pwdUpdateDate") && Objects.isNull(to.getPwdUpdateDate ())) throw new FieldException("密码最后更新时间 不能为空");
        if (fieldList.contains("createBy") && StringUtils.isEmpty(to.getCreateBy ())) throw new FieldException("创建者 不能为空");
        if (fieldList.contains("createTime") && Objects.isNull(to.getCreateTime ())) throw new FieldException("创建时间 不能为空");
        if (fieldList.contains("updateBy") && StringUtils.isEmpty(to.getUpdateBy ())) throw new FieldException("更新者 不能为空");
        if (fieldList.contains("updateTime") && Objects.isNull(to.getUpdateTime ())) throw new FieldException("更新时间 不能为空");
        if (fieldList.contains("remark") && StringUtils.isEmpty(to.getRemark ())) throw new FieldException("备注 不能为空");
    }



}
