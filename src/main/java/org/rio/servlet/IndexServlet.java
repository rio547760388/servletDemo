package org.rio.servlet;

import lombok.extern.slf4j.Slf4j;
import org.rio.bean.Users;
import org.rio.service.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/7/29
 **/
@Slf4j
@WebServlet(value = "/hello")
public class IndexServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = usersService.findById(1L);

        log.info("查询：{}", users);

        resp.getWriter().println(users);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        usersService = context.getBean(UsersService.class);
    }
}
