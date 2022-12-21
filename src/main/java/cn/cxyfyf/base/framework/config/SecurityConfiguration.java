//package cn.cxyfyf.base.framework.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration(proxyBeanMethods = false)
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//        http.authorizeHttpRequests(authorize ->
//                {
//                    try {
//                        authorize.requestMatchers(new CustomerRequestMatcher())
//                                .permitAll()
//                                .anyRequest().authenticated().and()
//                                .oauth2ResourceServer()
//                                .jwt();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            )
//            .formLogin(withDefaults())
//            .logout().invalidateHttpSession(true).deleteCookies("JSESSIONID");;
//        http.csrf().disable(); //关闭 csrf 防护
//        http.headers().frameOptions().disable();
//        return http.build();
//    }
//
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}