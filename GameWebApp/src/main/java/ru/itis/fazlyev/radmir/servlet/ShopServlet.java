package ru.itis.fazlyev.radmir.servlet;

import ru.itis.fazlyev.radmir.model.Games;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "shop", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("shop.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String select1 = req.getParameter("select1");
        String select2 = req.getParameter("select2");
        String select3 = req.getParameter("select3");
        String select4 = req.getParameter("select4");
        String select5 = req.getParameter("select5");

        String[] selectArray = {select1, select2, select3, select4, select5};

        Games games1 = new Games("Dota 2");
        Games games2 = new Games("Counter-Strike: Global Offensive");
        Games games3 = new Games("PUBG: BATTLEGROUNDS");
        Games games4 = new Games("Rust");
        Games games5 = new Games("Apex Legends");

        List<Games> gamesList = new ArrayList<>();
        HashMap<Integer, Games> gamesHashMap= new HashMap<>();

        gamesHashMap.put(0, games1);
        gamesHashMap.put(1, games2);
        gamesHashMap.put(2, games3);
        gamesHashMap.put(3, games4);
        gamesHashMap.put(4, games5);

        for (int i = 0; i < selectArray.length; i++) {
            System.out.println(selectArray[i]);
            if (Objects.equals(selectArray[i], "on")) {
                gamesList.add(gamesHashMap.get(i));
            } else {

            }
        }
        System.out.println(gamesList);
    }
}
