package cn.qkm.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    flag = true;
                    //获取之前的Cookie的value值
                    String value = cookie.getValue();
                    //先把value解码因为Cookie不能处理特殊字符比如空格
                    String decode = URLDecoder.decode(value, "utf-8");
                    //在输出
                    response.getWriter().println("<h1>欢迎回来您上次访问的时间为<h1>"+decode);
                    //最后在重新更改这次访问的时间
                    isFirstCookie(cookie,response);
                    break;
                }

            }

        }
        if( flag == false){
            Cookie cookie = new Cookie("lastTime","0");
            isFirstCookie(cookie,response);
            response.getWriter().println("<h1>欢迎您首次登录<h1>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected void isFirstCookie(Cookie cookie,HttpServletResponse response) throws UnsupportedEncodingException {
        //日期的格式化类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        //编码在浏览器中以utf-8
        String encode = URLEncoder.encode(format, "utf-8");
        //给cookie重新设置值
        cookie.setValue(encode);
        //让这个Cookie停留1个月
        cookie.setMaxAge(60*60*60);
        //把新改得Cookie重新响应回去
        response.addCookie(cookie);
    }
}
