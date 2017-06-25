<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>

<div class="container-fluid">

    <div class="well">
        <h1>${greeting}, ${participant.getFirstName()} ${participant.getLastName()}!</h1>
    </div>
    <p class="page-header">
    <h2>${your_courses} ...</h2>
    <div class="row">
        <div class="col-sm-4">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                    <caption class="current_curs_caption">${current_cources}</caption>
                    <thead>
                    <tr>
                        <th>${cource_name}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course" items="${currentCourseList1}">
                        <tr>
                            <td>${course.getName()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="table-responsive ">
                <form action=action="./Controller" method="GET">
                <table class="table table-striped table-hover table-bordered">
                    <caption class="available_curs_caption">${available_cources}</caption>
                    <thead>
                    <tr>
                        <th>${cource_name}</th><th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course1" items="${accessableCourseList1}">
                        <tr>
                            <td>${course1.getName()}</td>
                            <td><a href="./Controller?page=JOIN_NEW_COURSE_LIST&courseId=${course1.getId()}&courseName=${course1.getName()}">
                                <input type="button" value=${join}></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                    </form>
            </div>
        </div>
        </form>
        <div class="col-sm-4">
            <div class="table-responsive ">
                <table class="table table-striped table-hover table-bordered">
                    <caption class="finished_curs_caption">${finished_cources}</caption>
                    <thead>
                    <tr>
                        <th>${cource_name}</th>
                        <th>${mark}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course2" items="${finishedCourseList1}">
                    <tr><td>${course2.getKey()} </td>
                        <td> ${course2.getValue()}</td>
                    </c:forEach></tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
</body>
</html>