package com.qkm.Servlet;

import com.qkm.DAO.UserServiceImp;
import com.qkm.user.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String qq = request.getParameter("qq");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String mail = request.getParameter("mail");
        String sex = request.getParameter("sex");
        String birth = request.getParameter("birth");
        user user = new user();
        user.setMail(mail);
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setBirth(birth);
        user.setMail(mail);
        user.setQq(qq);
        user.setSex(sex);
        UserServiceImp userServiceImp = new UserServiceImp();
        userServiceImp.updateUser(user);
        response.sendRedirect(request.getContextPath()+"/Case/Queue.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
