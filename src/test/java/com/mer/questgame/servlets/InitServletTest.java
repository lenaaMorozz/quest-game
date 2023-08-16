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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class InitServletTest {
    @Mock
    HttpServletRequest requestMock;
    @Mock
    HttpServletResponse responseMock;
    @Mock
    HttpSession currentSessionMock;
    @Mock
    RequestDispatcher dispatcherMock;
    @Mock
    ServletConfig configMock;
    @Mock
    ServletContext servletContextMock;
    @Spy
    InitServlet initServletSpy;

    @BeforeEach
    void init() throws ServletException {
        Mockito.when(requestMock.getSession(true)).thenReturn(currentSessionMock);
        initServletSpy.init(configMock);
        Mockito.when(configMock.getServletContext()).thenReturn(servletContextMock);
        Mockito.when(initServletSpy.getServletContext().getRequestDispatcher("/index.jsp"))
                .thenReturn(dispatcherMock);
    }

    @Test
    void doGetWhenSetAttributePlayer() throws ServletException, IOException {
        Player player = new Player();
        initServletSpy.doGet(requestMock, responseMock);
        Mockito.verify(currentSessionMock).setAttribute("player", player);
    }

    @Test
    void doGetWhenSetAttributeQuestionTreeNode() throws ServletException, IOException {
        QuestionTreeNode questionTreeNode = new RepositoryLinkedList().getFirstQuestionTreeNode();

        initServletSpy.doGet(requestMock, responseMock);
        Mockito.verify(currentSessionMock).setAttribute("questionTreeNode", questionTreeNode);
    }

    @Test
    void doGetWhenForwardToIndexJsp() throws ServletException, IOException {
        Mockito.when(servletContextMock.getRequestDispatcher("/index.jsp"))
                .thenReturn(dispatcherMock);

        initServletSpy.doGet(requestMock, responseMock);
        Mockito.verify(dispatcherMock).forward(requestMock, responseMock);
    }


}
