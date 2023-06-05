package com.book.servlet.auth;

import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        ThymeleafUtil.process("register.html",new Context(),resp.getWriter());
    }

    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        Context context = new Context();
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        String username = req.getParameter("register_user");
        String nickname = req.getParameter("register_nick");
        String password = req.getParameter("register_password");
        String password1 = req.getParameter("sure");
        if (username.equals("") || nickname.equals("") || password.equals("")){
            resp.getWriter().println("<script>alert('用户信息不全！');setTimeout(function(){window.location.href='register'},2000);</script>");
        } else {
            if (!password.equals(password1)) {
                resp.getWriter().println("<script>alert('密码不一致,请重试！');setTimeout(function(){window.location.href='register'},2000);</script>");
            } else {
                boolean s = service.register(username, nickname, password);
                if (!s) {
                    resp.getWriter().println("<script>alert('用户已存在或其他问题，请检查！');setTimeout(function(){window.location.href='register'},2000);</script>");
                } else {
                    resp.getWriter().println("<script>alert('注册成功！3秒后返回登录');setTimeout(function(){window.location.href='login'},3000);</script>");
                }
            }
        }
    }
}
