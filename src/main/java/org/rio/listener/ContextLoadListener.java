package org.rio.listener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/7/29
 **/
/*@WebListener("contextLoadListener")
public class ContextLoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/application.xml");
        sce.getServletContext().setAttribute("applicationContext", context);
    }
}*/
