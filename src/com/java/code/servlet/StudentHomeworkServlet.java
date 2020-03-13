package com.java.code.servlet;

import com.java.code.jdbc.StudentHomeWorkJdbc;
import com.java.code.model.Homework;
import com.java.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/allHomework")
public class StudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //读取所有作业内容
        List<Homework> list = StudentHomeWorkJdbc.showHomework();

        req.setAttribute("list",list);

        //展示给学生
        req.getRequestDispatcher("jsp/queryAllHomework.jsp").forward(req,resp);
    }
}
