package com.ppp.designuser.config;

import com.ppp.designuser.handler.AuthLimitHandler;
import com.ppp.designuser.handler.LoginFailureHandler;
import com.ppp.designuser.handler.LoginSuccessHandler;
import com.ppp.designuser.handler.LogoutSuccessfulHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: yangli@elane.cn
 * @Despriction:
 * @Package: com.ppp.designuser.config
 * @Date:Created in 2020/5/30 14:00
 * @Modify By:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 用于认证
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*这几个antMatchers顺序很重要，是按照从上往下执行的，所以anyRequest()是应该放在后面的*/
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/doLogin")
//                .usernameParameter("name")//获取前端传入的登录参数,默认为username和password
//                .passwordParameter("passwd")
                /*登录成功之后的处理逻辑，登录成功之后可以不再跳转页面，可直接返回json数据，让前端自行处理*/
                .successHandler(new LoginSuccessHandler())
                .failureHandler(new LoginFailureHandler())
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessfulHandler())
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(new AuthLimitHandler())
                .and()
                .rememberMe()
                .key("yangli")//配置了key之后，该用户即便服务器重启，在账号未过期的前提下依然能够实现rememberMe的效果
                .and()
                .csrf().disable();
    }

    /**
     * 用于授权
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("yangli")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("admin")
                .and()
                .withUser("chy")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("user");
    }

    /**
     * 可以使某一角色同时拥有另一角色的权限
     * 即上级自动拥有下级的权限
     * @return
     */
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return roleHierarchy;
    }
}
