package ru.itis.fazlyev.radmir.servlet;

import ru.itis.fazlyev.radmir.dao.impl.AjaxDaoImpl;
import ru.itis.fazlyev.radmir.dao.impl.UserDaoImpl;
import ru.itis.fazlyev.radmir.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("registration.ftl");
        String username = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        AjaxDaoImpl ajax = new AjaxDaoImpl();
        try {
            out.println(ajax.checkingForTheExistenceOfUser(username));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");

        User user = new User(username, password, firstName, secondName, email, phoneNumber);

        UserDaoImpl userDao = new UserDaoImpl();
        userDao.save(user);
        resp.sendRedirect("authentication.ftl");
    }
}