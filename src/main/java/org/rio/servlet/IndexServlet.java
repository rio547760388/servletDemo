package org.rio.servlet;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.rio.bean.Users;
import org.rio.example.UsersExample;
import org.rio.mapper.UsersMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/7/29
 **/
@WebServlet(value = "/hello")
public class IndexServlet extends HttpServlet {

    private SqlSessionFactory sqlSessionFactory;
    private Configuration configuration;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UsersExample ue = new UsersExample();
            List<Users> usersList = session.selectList("org.rio.mapper.UsersMapper.selectByExample", ue);
            Users u = usersList.stream().findFirst().get();
            resp.getWriter().println("hello servlet 4.0 " + u.toString());

            UsersMapper usersMapper = configuration.getMapper(UsersMapper.class, session);
            UsersExample uex = new UsersExample();
            uex.createCriteria().andIdEqualTo(1L);
            Users users = usersMapper.selectByPrimaryKey(1L);

            log("查询：" + users.toString());
            Enumeration<String> enumeration = this.getServletContext().getAttributeNames();
            String s = "";
            while (enumeration.hasMoreElements()) {
                s += enumeration.nextElement() + "|";
            }
            System.out.println(s);
            log("上下文中：" + s);

        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        sqlSessionFactory = (SqlSessionFactory) config.getServletContext().getAttribute("sqlSessionFactory");
        configuration = (Configuration) this.getServletContext().getAttribute("mybatisConfiguration");
    }
}
