package cn.qkm.CharacterFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.util.HashSet;
import java.util.Iterator;

public class servletCharacterFilterWrapper extends HttpServletRequestWrapper {

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */
    public servletCharacterFilterWrapper(HttpServletRequest request) {
        super(request);
    }
    @Override
    public String getParameter(String name){
        HashSet<String> strings = new HashSet<>();
        strings.add("你妈的");
        strings.add("你奶奶的");
        strings.add("你爸爸的");
        strings.add("他妈的");
        Iterator<String> iterator = strings.iterator();
        String parameter = getRequest().getParameter(name);
        while(iterator.hasNext()){
            String next = iterator.next();
            parameter = parameter.replaceAll(next, "****");
        }
        System.out.println(parameter);
        return parameter;
    }
}
