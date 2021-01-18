<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: qikaimeng
  Date: 2021/1/17
  Time: 下午4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showTime</title>
</head>
<body>

<%
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
                out.println("<h1>欢迎回来您上次访问的时间为<h1>"+decode);
                //最后在重新更改这次访问的时间
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
                break;
            }

        }

    }
    if( flag == false){
        Cookie cookie = new Cookie("lastTime","0");
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
        out.println("<h1>欢迎您首次登录<h1>");
    }
%>
</body>
</html>
