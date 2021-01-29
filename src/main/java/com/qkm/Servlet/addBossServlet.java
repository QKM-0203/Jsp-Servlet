package com.qkm.Servlet;

import com.qkm.DAO.bossServiceImp;
import com.qkm.user.Boss;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addBossServlet")
public class addBossServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        request.getSession().setAttribute("ku","两次密码不一致");
        if(password1.equals(password1)){
            bossServiceImp bossServiceImp = new bossServiceImp();
            Boss boss = new Boss();
            boss.setPassword(password);
            boss.setName(username);
            bossServiceImp.addBoss(boss);
            request.getSession().setAttribute("ku","注册成功");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
