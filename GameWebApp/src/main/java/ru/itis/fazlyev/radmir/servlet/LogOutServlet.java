package ru.itis.fazlyev.radmir.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logOut", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c: cookies) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }

        HttpSession httpSession = req.getSession(false);

        if (httpSession != null) {
            httpSession.invalidate();
        }
        resp.sendRedirect("authentication.ftl");
    }
}
