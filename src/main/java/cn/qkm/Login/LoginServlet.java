package cn.qkm.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String user = request.getParameter("User");
        User user1 = new User();
        user1.setNAME(user);
        String password = request.getParameter("Password");
        user1.setPASSWORD(password);
        SQlQueryUser sQlQueryUser = new SQlQueryUser();
        if(sQlQueryUser.isUser(user1) != null){
            request.setAttribute("user",user);
           request.getRequestDispatcher("/Success").forward(request,response);
        } else{
            request.getRequestDispatcher("/Fail").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
/*正确的
戚凯萌 -- 12345678qkm,
 */