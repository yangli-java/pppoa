package com.ppp.designuser.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yangli@elane.cn
 * @Despriction:
 * @Package: com.ppp.designuser.handler
 * @Date:Created in 2020/5/30 15:55
 * @Modify By:
 */
public class LogoutSuccessfulHandler implements LogoutSuccessHandler {

    /**
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //authentication.getPrincipal()中保存所有的登陆成功的用户信息
        out.write(new ObjectMapper().writeValueAsString("注销登录成功"));
        out.flush();
        out.close();
    }
}
