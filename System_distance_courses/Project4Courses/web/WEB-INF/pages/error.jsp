<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<div class="container">
    <div class="jumbotron">
        <div class="page-header">
            <h2>${error_header}!</h2>
        </div>
        <p> ${message}</p>
        <a href="${backButton}">
            <button class="btn-success">${back}</button>
        </a>
    </div>

    </div>

</body>
</html>