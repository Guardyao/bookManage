package com.book.servlet.pages;

import com.book.entity.User;
import com.book.service.BorrowService;
import com.book.service.TotalService;
import com.book.service.impl.BorrowServiceImpl;
import com.book.service.impl.TotalServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.apache.ibatis.session.SqlSession;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    BorrowService service;
    TotalService totalService;
    @Override
    public void init() throws ServletException {
        service = new BorrowServiceImpl();
        totalService = new TotalServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("borrow_list",service.getBorowList());
        context.setVariable("total",totalService.getTheTotal());
        ThymeleafUtil.process("index.html",context,resp.getWriter());
    }
}
