package ru.alexkm07;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/temp-serv")
public class JspServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Vasya","PLO",21));
        users.add(new User("Sveta","SLO",59));
        users.add(new User("Olya","GRLO",84));

        req.setAttribute("users",users);

        getServletContext().getRequestDispatcher("/first-jsp.jsp").forward(req,resp);
    }
}
