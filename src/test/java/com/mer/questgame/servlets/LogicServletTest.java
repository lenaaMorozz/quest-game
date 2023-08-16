package com.mer.questgame.servlets;

import com.mer.questgame.model.Player;
import com.mer.questgame.model.QuestionTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class LogicServletTest {

    @Mock
    HttpServletRequest requestMock;
    @Mock
    HttpServletResponse responseMock;
    @Mock
    HttpSession currentSessionMock;
    @Mock
    RequestDispatcher dispatcherMock;
    @Spy
    LogicServlet logicServletSpy;
    @Mock
    QuestionTreeNode questionTreeNode;
    @Spy
    Player player = new Player();

    @BeforeEach
    void init() throws ServletException, IOException {
        Mockito.when(requestMock.getSession()).thenReturn(currentSessionMock);
        Mockito.when(requestMock.getParameter("answer")).thenReturn("first");
        Mockito.when(questionTreeNode.getFirst()).thenReturn(questionTreeNode);
        Mockito.when(questionTreeNode.getFirst().isGameIsOver()).thenReturn(true);
        Mockito.when(logicServletSpy.extractQuestionTreeNode(currentSessionMock))
                .thenReturn(questionTreeNode);
        Mockito.when(currentSessionMock.getAttribute("player")).thenReturn(new Player());
        Mockito.when(requestMock.getParameter("username")).thenReturn("Lena");
        Mockito.when(logicServletSpy.extractQuestionTreeNode(currentSessionMock))
                .thenReturn(questionTreeNode);
        Mockito.when(logicServletSpy.extractQuestionTreeNode(currentSessionMock).getContext())
                .thenReturn("any question");
        Mockito.when(questionTreeNode.getCorrectAnswer()).thenReturn("correct answer");
        Mockito.when(questionTreeNode.getWrongAnswer()).thenReturn("wrong answer");
        Mockito.when(requestMock.getRequestDispatcher("/game.jsp"))
                .thenReturn(dispatcherMock);

        logicServletSpy.doGet(requestMock, responseMock);
    }

    @Test
    void doGetWhenSetAttributeUsername() {
        player.setName("Lena");
        Mockito.verify(currentSessionMock).setAttribute("username", player.getName());
    }

    @Test
    void doGetWhenSetAttributeQuantityGames() {

        Mockito.verify(currentSessionMock).setAttribute("quantityGames", player.getQuantityGames());
    }

    @Test
    void doGetWhenSetAttributeQuestion() {
        Mockito.verify(currentSessionMock).setAttribute("question", "any question");
    }

    @Test
    void doGetWhenSetAttributeFirstAnswer() {
        Mockito.verify(currentSessionMock).setAttribute("firstAnswer", "correct answer");
    }

    @Test
    void doGetWhenSetAttributeSecondAnswer() {
        Mockito.verify(currentSessionMock).setAttribute("secondAnswer", "wrong answer");
    }

    @Test
    void doGetWhenForwardToGameJsp() throws ServletException, IOException {
        Mockito.verify(dispatcherMock).forward(requestMock, responseMock);
    }


}
