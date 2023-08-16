package com.mer.questgame.servlets;

import com.mer.questgame.model.Player;
import com.mer.questgame.model.QuestionTreeNode;
import com.mer.questgame.model.repository.RepositoryLinkedList;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/start")
@Log4j2
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        log.info("Create session {}", httpSession.getId());

        Player player = new Player();
        httpSession.setAttribute("player", player);

        QuestionTreeNode questionTreeNode = new RepositoryLinkedList().getFirstQuestionTreeNode();
        httpSession.setAttribute("questionTreeNode", questionTreeNode);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
