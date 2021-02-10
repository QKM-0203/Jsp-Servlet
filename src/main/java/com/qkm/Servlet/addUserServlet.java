package com.qkm.Servlet;

import com.qkm.Service.UserServiceImp;
import com.qkm.user.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String mail = request.getParameter("mail");
        String sex = request.getParameter("sex");
        String birth = request.getParameter("birth");
        String qq = request.getParameter("qq");
        user user = new user();
        user.setAge(Integer.parseInt(age));
        user.setBirth(birth);
        user.setMail(mail);
        user.setName(name);
        user.setQq(qq);
        user.setSex(sex);
        UserServiceImp userServiceImp = new UserServiceImp();
        userServiceImp.addUser(user);
        response.sendRedirect(request.getContextPath()+"/userServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
