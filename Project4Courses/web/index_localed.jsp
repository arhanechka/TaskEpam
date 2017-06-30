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
    <h2>${index_titul}</h2>
        </div>
        <p>${index_text}</p>
    </div>
    <div class="well well-lg col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3 col-md-6 col-md-offset-3 col-lg-7 col-lg-offset-3">
        <div class="row">
            <div class="col-sm-9 col-sm-offset-2 col-xs-12 horiz-p-0px col-md-7 col-md-offset-3 col-lg-6 col-lg-offset-3">
                    <a href="./Controller?page=LOGIN_STUDENT">
                        <button type="submit" value="reg_student" name="reg_student" class="btn btn-primary" id="l_s">${index_button_login_student}
                        </button>
                    </a>
                    <a href="./Controller?page=LOGIN_TEACHER">
                    <button type="submit" value="reg_teacher" name="reg_teacher" class="btn btn-primary">${index_button_login_teacher}</button>
                </a>
                </div>
            </div>
            <p class="col-sm-5 col-sm-offset-4 col-xs-7 col-xs-offset-3"><br>
                ${index_button_new_student}?</p>
            <div class="row">
                <div class="col-sm-5 col-sm-offset-4 col-xs-6 col-xs-offset-3">
                    <a href="./Controller?page=NEW_STUDENT">
                    <button type="submit" value="new_student" name="new_student" class="btn btn-primary btn-large">${index_button_new_student}</button>
                </a>
                </div>
            </div>
    </div>
</div>
</body>
</html>