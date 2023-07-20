<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>quest game</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1>Quest Game</h1>
<p> Привет! Тебя украли инопланетяне, ты находишься на летающей тарелке. Инопланетяне зададут тебе несколько вопросов,
    если ты ответишь правильно, то они не станут проводить на тебе опыты и отпустят тебя! Желаю тебе удачи!</p>

<form method="POST" action="game">
    Введите ваше имя: <br>
    <input type="text" name="username">
    <input type="submit" value="Начать"  />

</form>

<br/>
<button onclick="location.href='/game'">Начать</button>


</body>
</html>