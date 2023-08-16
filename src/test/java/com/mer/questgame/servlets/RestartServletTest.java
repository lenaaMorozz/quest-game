package com.mer.questgame.servlets;

import com.mer.questgame.model.Player;
import com.mer.questgame.model.QuestionTreeNode;
import com.mer.questgame.model.repository.RepositoryLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class RestartServletTest {

    @Mock
    HttpServletRequest requestMock;
    @Mock
    HttpServletResponse responseMock;
    @Mock
    HttpSession currentSessionMock;
    @Spy
    RestartServlet restartServletSpy;
    @Spy
    Player player = new Player();

    @BeforeEach
    void init() throws IOException {
        Mockito.when(requestMock.getSession()).thenReturn(currentSessionMock);
        Mockito.when(currentSessionMock.getAttribute("player")).thenReturn(player);
        Mockito.when(player.getQuantityGames()).thenReturn(0);

        restartServletSpy.doGet(requestMock, responseMock);
    }

    @Test
    void doGetWhenSetAttributeQuestionTreeNode() {
        QuestionTreeNode questionTreeNode = new RepositoryLinkedList().getFirstQuestionTreeNode();
        Mockito.verify(currentSessionMock).setAttribute("questionTreeNode", questionTreeNode);
    }

    @Test
    void doGetWhenSetAttributeGameIsOver() {
        Mockito.verify(currentSessionMock).setAttribute("gameIsOver", false);
    }

    @Test
    void doGetWhenSendRedirect() throws IOException {
        Mockito.verify(responseMock).sendRedirect("/game");
    }
}
