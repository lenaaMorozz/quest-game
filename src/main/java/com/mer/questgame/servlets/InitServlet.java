package com.mer.questgame.servlets;

import com.mer.questgame.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        Player player = new Player();
        player.setName(request.getParameter("username"));

        httpSession.setAttribute("player", player);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
