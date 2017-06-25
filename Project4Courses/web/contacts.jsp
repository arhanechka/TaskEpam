<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<div class="container">
    <div class="jumbotron">
        <p>${contacts}:</p>
        <p>${author_name}</p>
        <p>${author_localisation}</p>
        <p>${author_phone}</p>
        <p><a href="mailto:arhanechka@gmail.com">${ask_you_question}</a></p>

    </div>
</div>
</body>
</html>