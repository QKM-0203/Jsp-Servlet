import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
//关于请求参数的获取
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //通用的获取请求参数的
         //这些方法在post里面是中文会出现乱码的，但是get不会出现，所以如果使用post获取参数的话，就必须设置一个东西如下
        //request.setCharacterEncoding("utf-8");
        //根据参数获取参数值
        System.out.println(request.getParameter("username"));

        //获取参数名称生成一个数组
        Enumeration<String> parameterNames = request.getParameterNames();
        //获取参数值生成一个数组,有一个参数，但有多个参数和值的情况,可以适用于单复选框
        String[] parameterValues = request.getParameterValues("name");
        //获取参数以及参数值生成map
        Map<String, String[]> parameterMap = request.getParameterMap();
      //以上通用的，可以在post里面用也可可以在get里面用

        //获取请求体--请求参数(post方式)
        //字符操作
        BufferedReader reader = request.getReader();
        String line = null;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        //字节和字符都可以
        ServletInputStream inputStream = request.getInputStream();


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         System.out.println(request.getParameter("username"));


        //获取请求参数（get方式）注意和post获取方式不一样哈
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //获取请求方式
        String method = request.getMethod();
        System.out.println(method);
        String name = request.getHeader("user-agent");
        if(name.contains("Chrome")){
            System.out.println("谷歌来了");
        }
        //获取虚拟目录(你设置的那个)/WebServlet15_war_exploded
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //获取所有的请求头，
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            //获取请求头对应的请求值
            System.out.println(request.getHeader(s));
        }
        //获取请求URL
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //获取请求URI
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //URL比URI长，但是URI更大
        //获取从哪来，可以防盗链。
        String referer = request.getHeader("referer");
        System.out.println(referer);
    }

}
