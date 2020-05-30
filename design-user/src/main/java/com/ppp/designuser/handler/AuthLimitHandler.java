package com.ppp.designuser.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yangli@elane.cn
 * @Despriction:  用户权限不足返回的数据
 * @Package: com.ppp.designuser.handler
 * @Date:Created in 2020/5/30 16:14
 * @Modify By:
 */
public class AuthLimitHandler implements AccessDeniedHandler {

    /**
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //authentication.getPrincipal()中保存所有的登陆成功的用户信息
        out.write(new ObjectMapper().writeValueAsString("用户权限不足" + e));
        out.flush();
        out.close();
    }
}
