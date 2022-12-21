//package cn.cxyfyf.base.domain;
//
//import com.google.common.collect.Sets;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Set;
//
//@Getter
//@Setter
//public class UserDetail implements UserDetails {
//
//    private static final long serialVersionUID = -3773580476071907457L;
//
//    /**
//     * 扩展字段
//     */
//    private Long userId;
//    private String authenticationMethod;//认证方式
//
//    /**
//     * 默认字段
//     */
//    private String avatar;
//    private String idName;
//    private String username;
//    private String password;
//    private Boolean enabled;
//    private String mobile;
//    private String bankCardNo;//银行卡号
//    private Collection<SimpleGrantedAuthority> authorities;
//    private Set<String> roleIdSet = Sets.newHashSet();//角色id
//
//    /**
//     * 系统管理用户
//     */
//    public UserDetail(SysUser user, String loginType) {
//        this.setUserId(user.getId());
//        this.setMobile(user.getPhonenumber());
//        this.setUsername(user.getUserName());
//        this.setAvatar(user.getAvatar());
//        this.setAuthenticationMethod(loginType);
//        this.setEnabled(user.getStatus().equals("0"));
//        this.setPassword(user.getPassword());
//        authorities = new ArrayList<>();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
//}
