<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<f:param locale="${localeController.locale}">--%>
<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<div class="container">
    <div class="jumbotron">
        <div class="page-header">
    <%--<h2>${translate.index.titul}</h2>--%>
    <h2>Welcome to our new Elective System</h2>
        </div>
    <%--<p:commandLink value="English" action="${localeController.selectLanguage('en')}" rendered="${localeController.en}"/>--%>
    <%--<p:commandLink value="Українська" action="${localeController.selectLanguage('ua')}" rendered="${not localeController.en}"/>--%>
        <p>You can find different courses for you distance learning on our web-resource. Please choose your profile and log in, or fill the registration form.</p>
    <%--<p>${translate.index.text}</p>--%>
    </div>
    <div class="well well-lg col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3">
            <div class="row">
                <div class="col-sm-9 col-sm-offset-2 col-xs-12 horiz-p-0px col-md-7 col-md-offset-3 col-lg-6 col-lg-offset-3">
                    <a href="./Controller?page=LOGIN_STUDENT">
                        <button type="submit" value="reg_student" name="reg_student" class="btn btn-primary horiz-p" id="l_s">Login Student
                        </button>
                    </a>
                    <a href="./Controller?page=LOGIN_TEACHER">
                    <button type="submit" value="reg_teacher" name="reg_teacher" class="btn btn-primary horiz-p">Login Teacher</button>
                </a>
                </div>
            </div>
            <p class="col-sm-5 col-sm-offset-4 col-xs-7 col-xs-offset-3"><br>
                New student?</p>
            <div class="row">
                <div class="col-sm-5 col-sm-offset-4 col-xs-6 col-xs-offset-3">
                    <a href="./Controller?page=NEW_STUDENT">
                    <button type="submit" value="new_student" name="new_student" class="btn btn-primary btn-large">New student</button>
                </a>
                </div>
            </div>
    </div>
</div>
</body>
</html>