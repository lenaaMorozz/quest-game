package com.mer.questgame.servlets;

import com.mer.questgame.model.Player;
import com.mer.questgame.model.QuestionTreeNode;
import com.mer.questgame.model.Repository;
import com.mer.questgame.model.RepositoryLinkedList;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/game")
@Log4j2
public class LogicServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        Player player= (Player) httpSession.getAttribute("player");
        if (player.getName() == null) {
            player.setName(request.getParameter("username"));
            log.info("Username - {}", player.getName());
        }

        player.setQuantityGames(player.getQuantityGames());

        httpSession.setAttribute("username", player.getName());
        httpSession.setAttribute("quantityGames", player.getQuantityGames());

        QuestionTreeNode questionTreeNode = extractQuestionTreeNode(httpSession);

        f(request, questionTreeNode, httpSession);

        extractQuestionTreeNode(httpSession);

        String question = questionTreeNode.getContext();
        httpSession.setAttribute("question", question);
        httpSession.setAttribute("firstAnswer", questionTreeNode.getCorrectAnswer());
        httpSession.setAttribute("secondAnswer", questionTreeNode.getWrongAnswer());



        request.getRequestDispatcher("/game.jsp").forward(request, response);

    }

    private QuestionTreeNode extractQuestionTreeNode(HttpSession httpSessions) {
        return (QuestionTreeNode) httpSessions.getAttribute("questionTreeNode");
    }

    private void f(HttpServletRequest request, QuestionTreeNode questionTreeNode, HttpSession httpSession) {
        String answer = request.getParameter("answer");
        if (answer != null) {
            log.info("answer - {}", answer);
            if (answer.equals("first")) {
                httpSession.setAttribute("questionTreeNode", questionTreeNode.getFirst());
            } else {
                httpSession.setAttribute("questionTreeNode", questionTreeNode.getSecond());
            }
        }
    }

}
