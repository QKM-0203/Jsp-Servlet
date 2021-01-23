package com.qkm.Servlet;

import com.qkm.DAO.UserQueue;
import com.qkm.DAO.UserQueueImp;
import com.qkm.user.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserQueue userQueueImp = new UserQueueImp();
        List<user> all = userQueueImp.findAll();
        request.setAttribute("user",all);
        response.sendRedirect(request.getContextPath()+"/Case/Queue.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
