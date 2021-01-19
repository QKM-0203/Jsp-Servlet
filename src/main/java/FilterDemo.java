import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器 就是进行一些通用的操作，比如好多servlet都得设置编码，那莫就可以放在Filter里面，
 * 生命周期 init服务器启动时就执行只执行一次。创建Filter对象，doFilter会被执行多次，destroy会在服务器正常关闭的时候就执行
 * 过滤器的执行过程：访问资源先执行过滤器，放行了就去执行资源，执行完回来后在执行过滤器放行底下的代码
 *
 * 过滤器拦截路径配置：拦截目录：/user/* 该目录下所有的资源都得被过滤器执行
 * 拦截所有 /*
 * 拦截后缀名为特定的文件 *.jsp
 * 拦截指定文件 login.jsp
 *
 * 过滤器的配置方式拦截：dispatcherTypes 的5种方式，先了解了2种
 *
 *
 *
 * 过滤器链:就是设置多个过滤器时，会有优先顺序，按照类名的字典顺序比较，先执行谁，回来是反着的
 */
@WebFilter(value = "*.jsp",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})//所有请求和转发的资源都得被过滤器
// 过滤一下，后面那个是拦截方式，默认为request是请求拦截，forward是转发拦截，可以同时设置多个属性，就是该类型的资源在该访问方式下要被过滤器过滤
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //强转转为http的请求和响应
        //增强请求
        //设计模式来增强
        /*

         */
        chain.doFilter(request, response);
        //执行完过滤器的同意放行之后再去执行访问的资源，执行完后来执行底下的代码
        //增强响应
    }

    @Override
    public void destroy() {

    }
}
