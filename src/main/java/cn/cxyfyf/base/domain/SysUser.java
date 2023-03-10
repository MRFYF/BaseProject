package cn.cxyfyf.base.domain;

import cn.cxyfyf.base.framework.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户信息表对象 sys_user
 * 
 * @author fengyingfeng
 * @date 2022-11-01
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUser extends BaseEntity {

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

    public SysUser (){}

}
