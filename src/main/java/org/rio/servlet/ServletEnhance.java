package org.rio.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/8/3
 **/
@Slf4j
public class ServletEnhance extends HttpServlet {
    public <T> void response(HttpServletRequest req, HttpServletResponse resp, T o) {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        try {
            PrintWriter pw = resp.getWriter();
            pw.print(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
