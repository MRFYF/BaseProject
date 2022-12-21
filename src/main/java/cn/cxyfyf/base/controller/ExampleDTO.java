package cn.cxyfyf.base.controller;

import cn.cxyfyf.base.framework.anno.CommonValue;
import cn.cxyfyf.base.framework.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * dto
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExampleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4473308292250129990L;
    /** id */
    private Long id;
    /** 登录账号 */
    private String loginName;
    /** 用户昵称 */
    private String userName;
    /** 用户类型（00系统用户 01注册用户） */
    private String userType;
    /** 用户邮箱 */
    private String email;
    /** 手机号码 */
    private String phoneNumber;
    /** 用户性别（0男 1女 2未知） */
    private String sex;
    /** 头像路径 */
    private String avatar;
    /** 备注 */
    private String remark;

    @CommonValue(value = "dict001", name = "dictName")
    private String dictCode;
    private String dictName;

    @CommonValue(name = "userName", type = CommonValue.Type.SYSTEM_USER)
    private String userId;

    @CommonValue(type = CommonValue.Type.AREA, name = "cityName")
    private String cityCode;
    private String cityName;

    @CommonValue(value = DateUtils.DATE_PATTERN, type = CommonValue.Type.DATE, name = "createDateStr")
    private Date createDate;
    private String createDateStr;

    @CommonValue(value = DateUtils.DATE_TIME_PATTERN, type = CommonValue.Type.DATE, name = "startDateStr")
    private LocalDateTime startDate;
    private String startDateStr;

    public ExampleDTO(){}
}
