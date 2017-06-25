<!DOCTYPE html>
<html lang="ru">

<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>

<div class="container-fluid">
    <form action="./Controller" method="POST" class="form-signin">
         <h2 class="form-signin-heading">${login_header}</h2>
        <input type="hidden" name="page" value="LIST_COURSE_STUDENT">

        <label for="inputEmail" class="sr-only">${login_email}</label>
        <input id="inputEmail" class="form-control" placeholder=${login_email} name="email" required type="text">
        <label for="inputPassword" class="sr-only">${login_password}</label>
        <input id="inputPassword" class="form-control" placeholder=${login_password} name="password" required type="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">${login_button}</button>
    </form>
</div>
</body>
</html>