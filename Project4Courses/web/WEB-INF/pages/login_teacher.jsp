<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<div class="container-fluid">
    <form class="form-signin" action="./Controller" method="POST">
         <h2 class="form-signin-heading">Entrance</h2>
        <input type="hidden" name="page" value="LIST_COURSE_TEACHER">
        <label for="inputEmail" class="sr-only">Email</label>
        <input id="inputEmail" name="email" class="form-control" placeholder="Email" required="" autofocus="" type="text">
        <label for="inputPassword" class="sr-only">Password</label>
        <input id="inputPassword" class="form-control" placeholder="Password" name="password" required="" type="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>
</html>