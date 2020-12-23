

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Session是在服务器端的共享数据的对象，是一次会话中的多次请求的共享数据，只能是一次会话，浏览器关闭后就不能在获取出来了
 * 获取的多次Session都是同一个Session，Session是通过Cookie实现的，将JSESSIONID=值存在Cookie头中，然后就每次获得就都是同一个Session
 * 如果想让Session在不同的会话中获取的是同一个，可以使用Cookie来设置Cookie的存活时间长一点就可以,如下代码
 * 当服务器关了之后，Session存的东西就没了
 */
@WebServlet("/sessionServlet2")
public class SessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Session对象
        HttpSession session = request.getSession();
        session.setAttribute("qkm","sjb");
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        //设置Session

        /*
        Session的特点：可以用于任意类型,session.setAttribute(String,Object);
        Session和Cookie的区别：Session在服务器端安全，Cookie在客户端不是特别安全
        Session没有存储数量要求，Cookie有，一般情况下在重定向的时候是一次会话，使用Context对象太大就会使用Session代替他
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
