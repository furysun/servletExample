package config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
