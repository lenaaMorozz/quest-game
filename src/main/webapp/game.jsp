<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>game</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<%--<jsp:useBean id="player" class="com.mer.questgame.servlets.InitServlet" scope="session" />--%>
<%--<c:set var="username" value="<%=player.getName%>"/>--%>

<h1>Игрок - ${username}, игра - ${quantityGames}</h1>
<form method="GET" action="game">
    <p>${question}</p>
    <p>
        <input type="radio" value="first" name="answer"/>${firstAnswer}
    </p>
    <p>
        <input type="radio" value="second" name="answer"/>${secondAnswer}
    </p>
    <p>
        <button type="submit">Дальше</button>
    </p>
</form>
</body>
</html>
