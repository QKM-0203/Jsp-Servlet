package com.qkm.Servlet;

import cn.qkm.Login.SQlQueryUser;
import cn.qkm.Login.User;
import com.qkm.DAO.bossQueueImp;
import com.qkm.user.Boss;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String checkBoard = request.getParameter("checkBoard");
        HttpSession session = request.getSession();
        if(checkBoard == null){
            response.sendRedirect("/Case/home.jsp");
        }
        if(session.getAttribute("checkBoard").equals(checkBoard)){
            session.removeAttribute("checkBoard");
            Boss boss = new Boss();
            String user = request.getParameter("boss");
            boss.setName(user);
            String password = request.getParameter("password");
            boss.setPassword(password);
            bossQueueImp bossQueueImp = new bossQueueImp();
            if(bossQueueImp.findBoss(boss) != null){
                request.getSession().setAttribute("boss",boss);
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