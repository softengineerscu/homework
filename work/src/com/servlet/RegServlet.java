package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        //��ȡ�û�ע����Ϣ
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String question = req.getParameter("question");
        String answer = req.getParameter("answer");
        String email = req.getParameter("email");
        System.out.println("��ȡ�û�ע����Ϣ�ɹ�");
        //ʵ����UserDao����
        UserDao userDao = new UserDao();
        if (username != null) {
            //ʵ����һ��User����
            User user = new User();
            //���û���������Ը�ֵ
            user.setUsername(username);
            user.setPassword(password);
            user.setSex(sex);
            user.setQuestion(question);
            user.setAnswer(answer);
            user.setEmail(email);
            userDao.saveUser(user);
            req.setAttribute("info", "ע��ɹ��� <br>");
        } else {
            req.setAttribute("info", "���û��Դ��ڣ�<br>");
        }
        //ת����message.jspҳ��
        req.getRequestDispatcher("message.jsp").forward(req, resp);
    }

}
