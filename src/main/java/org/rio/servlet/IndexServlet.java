package org.rio.servlet;

import lombok.extern.slf4j.Slf4j;
import org.rio.bean.Users;
import org.rio.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.ServletContextScope;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/7/29
 **/
@Slf4j
@WebServlet(value = "/hello")
public class IndexServlet extends ServletEnhance {

    private UsersService usersService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = usersService.findById(1L);

        log.info("查询：{}", users);

        log.info("servlet: {}", this);

        resp.getWriter().println(users);
        response(req, resp, users);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Enumeration<String> enumeration = config.getServletContext().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String s = enumeration.nextElement();
            Object o = config.getServletContext().getAttribute(s);
            log.info("上下文：{},  {}", s, o);
        }
        /*config.getServletContext().getServletRegistrations().forEach((k, v) -> {
            log.info("{}   ->    {}", k, v);
        });*/

        WebApplicationContext context = (WebApplicationContext) config.getServletContext().getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springmvc");
        log.info("{}", context.getClass());
        /*for (String name : context.getBeanDefinitionNames()) {
            log.info("bean : {}  --->  {}", name, context.getBean(name));
        }*/

        /*for (String name : context.getParent().getBeanDefinitionNames()) {
            log.info("root bean : {}  --->  {}", name, context.getBean(name));
        }

        UsersService us = context.getBean(UsersService.class);

        System.out.println("us : " + us);

        log.info("scope: {}", config.getServletContext().getAttribute("org.springframework.web.context.support.ServletContextScope"));*/

        WebApplicationContext context1 = (WebApplicationContext) config.getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
        log.info("{}", context1.getClass());
        UsersService us = context1.getBean(UsersService.class);
        log.info("{}", us);

        log.info("{}", context == context1);
        log.info("{}", context.equals(context1));
    }
}
