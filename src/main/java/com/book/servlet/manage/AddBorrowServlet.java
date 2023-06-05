package com.book.servlet.manage;

import com.book.service.BorrowService;
import com.book.service.StudentService;
import com.book.service.impl.BorrowServiceImpl;
import com.book.service.impl.StudentServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {
    BorrowService service;
    StudentService studentService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        int sid = Integer.parseInt(req.getParameter("student"));
        int bid = Integer.parseInt(req.getParameter("book"));
        service.addBorrow(sid,bid);
        resp.sendRedirect("index");
    }

    @Override
    public void init() throws ServletException {
        service = new BorrowServiceImpl();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Context context = new Context();
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        context.setVariable("book_rent_list",service.getBooksNotRent());
        context.setVariable("student_list",studentService.getStudent());
        ThymeleafUtil.process("add-borrow.html",context,resp.getWriter());
    }

}
