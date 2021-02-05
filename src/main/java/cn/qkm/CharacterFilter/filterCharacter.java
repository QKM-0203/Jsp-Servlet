package cn.qkm.CharacterFilter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("*.jsp")
public class filterCharacter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
       HttpServletRequest servletCharacterFilterWrapper =
               new servletCharacterFilterWrapper((HttpServletRequest) request);
       chain.doFilter(servletCharacterFilterWrapper, response);

    }
}
