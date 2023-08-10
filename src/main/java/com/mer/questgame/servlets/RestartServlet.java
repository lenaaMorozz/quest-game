package com.mer.questgame.servlets;

import com.mer.questgame.model.Player;
import com.mer.questgame.model.QuestionTreeNode;
import com.mer.questgame.model.RepositoryLinkedList;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RestartServlet", value = "/restart")
@Log4j2
public class RestartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        Player player = (Player) httpSession.getAttribute("player");
        player.setQuantityGames(player.getQuantityGames() + 1);
        log.info("{} started {} game", player.getName(), player.getQuantityGames());

        QuestionTreeNode questionTreeNode = new RepositoryLinkedList().getQuestionTreeNode();
        httpSession.setAttribute("questionTreeNode", questionTreeNode);
        httpSession.setAttribute("gameIsOver", false);
        response.sendRedirect("/game");
    }
}
