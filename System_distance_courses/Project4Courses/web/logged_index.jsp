<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<div class="container-fluid">

    <div class="well">
        <h1>${login_identificator} ${participant.getFirstName()} ${participant.getLastName()}!</h1>
    </div>
    <div class="well well-lg col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3">
        <div class="row">
            <div class="col-sm-9 col-sm-offset-2 col-xs-12 horiz-p-0px col-md-7 col-md-offset-3 col-lg-6 col-lg-offset-3">
                <form class="form-signin" action="./Controller" method="POST">                    <%--<c:choose>--%>
                       <c:choose>
                        <c:when test='${participant.getClass().getSimpleName().equals("Student")}'>
                            <input type="hidden" name="page" value="LIST_COURSE_STUDENT">
                        </c:when>
                        <c:otherwise>
                    <input type="hidden" name="page" value="LIST_COURSE_TEACHER">
                        </c:otherwise>
                    </c:choose>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">${my_page}</button>
                </form>
                <form action="./Controller" method="POST" class="form-signin">
                    <input type="hidden" name="page" value="EXIT">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">${exit}</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>