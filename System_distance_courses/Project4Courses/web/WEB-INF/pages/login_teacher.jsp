<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<div class="container-fluid">
    <form class="form-signin" action="./Controller" method="POST">
         <h2 class="form-signin-heading">${login_header}</h2>
        <input type="hidden" name="page" value="LIST_COURSE_TEACHER">
        <label for="inputEmail" class="sr-only">${login_email}</label>
        <input id="inputEmail" name="email" class="form-control" placeholder=${login_email} required="" autofocus="" type="text">
        <label for="inputPassword" class="sr-only">${login_password}</label>
        <input id="inputPassword" class="form-control" placeholder=${login_password} name="password" required="" type="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">${login_button}</button>
    </form>
</div>
</body>
</html>