<!DOCTYPE html>
<html lang="ru">

<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>

<div class="container-fluid">
    <form action="./Controller" method="POST" class="form-signin">
         <h2 class="form-signin-heading">Entrance</h2>
        <input type="hidden" name="page" value="LIST_COURSE_STUDENT">

        <label for="inputEmail" class="sr-only">Email</label>
        <input id="inputEmail" class="form-control" placeholder="Email" name="email" required type="text">
        <label for="inputPassword" class="sr-only">Password</label>
        <input id="inputPassword" class="form-control" placeholder="Password" name="password" required type="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>
</html>