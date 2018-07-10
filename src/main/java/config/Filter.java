package config;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Do filter ");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
