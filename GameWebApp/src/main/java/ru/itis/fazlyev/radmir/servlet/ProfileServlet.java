package ru.itis.fazlyev.radmir.servlet;

import ru.itis.fazlyev.radmir.dao.impl.ProfileDaoImpl;
import ru.itis.fazlyev.radmir.model.Profile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "profile", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = (String) req.getSession(false).getAttribute("username");
        ProfileDaoImpl profileDao = new ProfileDaoImpl();

        try {
            HashMap artibs = profileDao.createProfile(user);
            req.setAttribute("username", user);
            req.setAttribute("password", artibs.get("password"));
            req.setAttribute("firstName", artibs.get("firstName"));
            req.setAttribute("secondName", artibs.get("secondName"));
            req.setAttribute("email", artibs.get("email"));
            req.setAttribute("phoneNumber", artibs.get("phoneNumber"));

            req.setAttribute("city", artibs.get("city"));
            req.setAttribute("gender", artibs.get("gender"));

        }catch (Exception e){

        }
        getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
        resp.sendRedirect("profile.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = (String) req.getSession(false).getAttribute("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phoneNumber");
        String city = req.getParameter("city");
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String gender = req.getParameter("gender");

        Profile profile = new Profile(user, firstName, secondName, email, phone, city, gender);
        ProfileDaoImpl profileDao = new ProfileDaoImpl();
        profileDao.updateProfile(profile);

        resp.setHeader("Refresh", "0");
    }
}
