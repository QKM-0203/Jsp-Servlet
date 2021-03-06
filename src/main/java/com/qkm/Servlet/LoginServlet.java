package com.qkm.Servlet;

import com.qkm.Service.bossServiceImp;
import com.qkm.user.Boss;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 登录获取请求参数，然后从数据库验证密码是否正确，利用druid和jdbcTemplate来判断
 * 密码正确登录成功
 * 错误登录失败
 *是一些简单的主要是将最近学得连接起来
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //首先判断验证码是否正确
        HttpSession session = request.getSession();
        session.removeAttribute("ku");
        String checkBoard = request.getParameter("checkBoard");
        if(checkBoard == null){
            session.setAttribute("ku","请输入验证码");
            response.sendRedirect(request.getContextPath()+"/Case/home.jsp");

        }
        if(session.getAttribute("checkBoard").equals(checkBoard)){
            session.removeAttribute("checkBoard");
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("name")){
                    request.getRequestDispatcher("/Case/index.jsp").forward(request,response);
                }
            }
            Boss boss = new Boss();
            String user = request.getParameter("boss");
            String password = request.getParameter("password");
            if(user == null | password == null){
                session.setAttribute("ku","用户名或密码为空");
                response.sendRedirect(request.getContextPath()+"/Case/home.jsp");
            }
            boss.setName(user);
            boss.setPassword(password);
            bossServiceImp bossServiceImp = new bossServiceImp();
            Boss boss1 = bossServiceImp.findBoss(boss);
            if(boss1 != null){
                String remember = request.getParameter("remember");
                if(remember != null){
                    Cookie cookie = new Cookie("name",boss.getName());
                    Cookie password1 = new Cookie("password", boss.getPassword());
                    cookie.setMaxAge(60);
                    password1.setMaxAge(60);
                    response.addCookie(cookie);
                    response.addCookie(password1);
                }
               response.sendRedirect(request.getContextPath()+"/Case/index.jsp");
            } else{
                session.setAttribute("ku","用户名或密码错误");
                response.sendRedirect(request.getContextPath()+"/Case/home.jsp");

            }
        }else{
            session.removeAttribute("checkBoard");
            session.setAttribute("ku","验证码错误");
            response.sendRedirect(request.getContextPath()+"/Case/home.jsp");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
/*正确的
戚凯萌 -- 12345678qkm,
 */