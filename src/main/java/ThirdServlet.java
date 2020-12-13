import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//关于请求转发的,先获取一个请求转发的对象转到谁的URL，然后传递请求和响应对象
/*
特点：
 只请求一次
 不能访问外部的资源，只能是项目里面的资源
 浏览器的地址栏不发生改变，只是开始的URL,后面跳转的不出现
 */
/*
request转发的共享资源
三个方法，在Third和Four里面
 */
@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          System.out.println("3");
          //设置共享的资源，相当于键值对。
          request.setAttribute("戚凯萌",18);
          request.getRequestDispatcher("/FourServlet").forward(request,response);
          //在这里面设置，在4里面访问

    }
}
