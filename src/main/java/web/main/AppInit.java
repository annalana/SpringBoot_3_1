package web.main;

import org.springframework.beans.factory.annotation.Autowired;
import web.config.HibernateConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import web.config.WebConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
