package com.ppp.designuser.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yangli@elane.cn
 * @Despriction:  登录失败返回失败信息
 * @Package: com.ppp.designuser.handler
 * @Date:Created in 2020/5/30 15:31
 * @Modify By:
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

    /**
     *
     * @param request  http请求参数
     * @param response  http返回参数，可自由封装
     * @param e  封装异常信息
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (e instanceof LockedException) {
            out.write(new ObjectMapper().writeValueAsString("账户被锁定，请联系管理员"));
        }
        else if (e instanceof CredentialsExpiredException) {
            out.write(new ObjectMapper().writeValueAsString("密码过期，请联系管理员"));
        }
        else if (e instanceof AccountExpiredException) {
            out.write(new ObjectMapper().writeValueAsString("账户过期，请联系管理员"));
        }
        else if (e instanceof DisabledException) {
            out.write(new ObjectMapper().writeValueAsString("账户被禁用，请联系管理员"));
        }
        /*在spring security中账号和密码错误都返回BadCredentialsException异常*/
        else if (e instanceof BadCredentialsException) {
            out.write(new ObjectMapper().writeValueAsString("用户名或者密码错误，请重新输入"));
        } else {
            out.write(new ObjectMapper().writeValueAsString("账户异常，请联系管理员"));
        }
        out.flush();
        out.close();
    }
}
