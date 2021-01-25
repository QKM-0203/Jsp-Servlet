package com.qkm.Servlet;

import com.qkm.DAO.UserServiceImp;
import com.qkm.user.PageBean;
import com.qkm.user.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        System.out.println(currentPage);
        String rows = request.getParameter("rows");
        if(currentPage == null || "".equals(currentPage) || Integer.parseInt(currentPage) <= 0){
            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "3";
        }
        UserServiceImp userServiceImp = new UserServiceImp();
        PageBean<user> userByPage = userServiceImp.findUserByPage(Integer.parseInt(currentPage),Integer.parseInt(rows));
        request.setAttribute("userByPage",userByPage);
        request.getRequestDispatcher("/Case/Queue.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
    }
}
