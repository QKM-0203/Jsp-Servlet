

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/SixServlet")
public class SixServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        重定向：发生在想响应的时候
         方法1 响应.sendRedirect("路径")
          方法2 设置状态码setStatus(302) 然后setHeader("location","路径")
         */
        //路径的要求给客户端用加虚拟目录就是工程名称，但是给服务器用不用加虚拟目录
        //转发为服务器端的要求，重新定向为服务器端的要求，所以重新定向要写虚拟目录
        //可以用contextPath(方法获取虚拟目录)
        //获取流之前设置响应编码形式，设置为浏览器的解码形式，但是你得知道浏览器的解码形势
        //有一个很好的方法就是我直接告诉浏览器，然后浏览器用我传的进行解析response.setContentType("Text/html;charset=utf-8")
        response.sendRedirect("https://www.bilibili.com/video/BV14D4y127p6?p=49");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* response.setContentType("Text/html;charset=utf-8");
        //PrintWriter writer = response.getWriter();
        //不设置会有乱码
        writer.println("你好koi");

        */
        ServletOutputStream outputStream = response.getOutputStream();
        //outputStream.println("你好".getBytes("UTF-8"));
        response.sendRedirect("https://www.bilibili.com/video/BV14D4y127p6?p=49");
    }
}
