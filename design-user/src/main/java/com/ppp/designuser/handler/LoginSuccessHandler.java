package com.ppp.designuser.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yangli@elane.cn
 * @Despriction:  登录成功之后的处理器
 * @Package: com.ppp.designuser.handler
 * @Date:Created in 2020/5/30 14:06
 * @Modify By:
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        FilterChain chain, Authentication authentication) throws IOException, ServletException {

    }

    /**
     *
     * @param request  http请求参数
     * @param response  http返回参数，可自由封装
     * @param authentication  能够获取请求中的用户参数
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //authentication.getPrincipal()中保存所有的登陆成功的用户信息
        out.write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
        out.flush();
        out.close();
    }
}
