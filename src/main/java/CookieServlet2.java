import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Cookie的原理
 * 一个servlet创建Cookie并发送Cookie
 * 发送的时候会传一个响应头set-cookie:你设置的键=值
 * 在另一个servlet在发送响应时，浏览器会自动的将Cookie放在请求头里面，Cookie:你设置的键=值
 * 这是就可以获取到了Cookie了。
 */
@WebServlet("/CookieServlet2")
public class CookieServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie = new Cookie("1","cookie");
        //将cookie对象传给浏览器
        response.addCookie(cookie);


        //一次发送多个Cookie是可以的
        //创建多个Cookie对象，穿过去
        //Cookie在浏览器中的存活时间
        /*
        1 默认值：浏览器关闭再去访问Cookie就没有了
        2 可以通过设置来加长停留时间
          Cookie对象.setMaxAge(int second)
          通过设置时间来表示
          正数：停留正数的时间后消除，就是说在关闭浏览器之后，如果时间没有结束没，也是可以访问到的，主要以时间为主
          负数：就是默认值，浏览器关闭就结束
          0：删除Cookie，信息
         */
        //Cookie存储中文数据，8之前不可，之后可以,但是特殊字符不支持，比如空格
      //Cookie的获取范围：默认情况下不能共享在不同的项目
        //设置Cookie对象.setPath("/"),就是可以访问同一个服务器下部署的所有项目
        //如果要将不同的服务器的资源共享，可以设置一级域名相同setDomain("一级域名")
        /*
        Cookie的特点保存在用户浏览器中但是存储量少一般只有20多个
        Cookie的作用：在用户不登录的情况下，完成服务器对客户端的识别
         */

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
