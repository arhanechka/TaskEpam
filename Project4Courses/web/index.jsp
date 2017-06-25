<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Elective System</a>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="container">
                    <div id="navbar" class="navbar-collapse collapse">
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div><div class="container">
    <div class="jumbotron">
        <div class="page-header">
    <h2>Welcome to our new Elective System!</h2>
        </div>
        <p>Please choose the language:</p>
        <a href="./Controller?page=LOCALE_CHOOSING&locale=en">
            <button type="submit" value="reg_student" name="reg_student" class="btn btn-primary horiz-p" id="l_s">English
            </button>
        </a>
        <a href="./Controller?page=LOCALE_CHOOSING&locale=ua">
            <button type="submit" value="reg_teacher" name="reg_teacher" class="btn btn-primary horiz-p">Українська</button>
        </a>
    </div>

</div>
</body>
</html>