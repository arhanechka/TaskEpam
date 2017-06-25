<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<div class="container-fluid">

    <div class="well">
        <h1>Welcome, ${participant.getFirstName()} ${participant.getLastName()}!</h1>
    </div>
    <div class="col-sm-6">
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
                <caption class="current_curs_caption">Current cources</caption>
                <thead>
                <tr>
                    <th>Cource name</th>
                    <th>Students list</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="course" items="${currentCourseList}">
                    <tr>
                        <td>${course.getName()}</td>
                        <td>
                            <a href="./Controller?page=STUDENTS_LIST_FOR_CURRENT_COURSE&courseId=${course.getId()}">
                                <button class="btn-info">Open</button>
                                </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

        <div class="col-sm-6">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                    <caption class="available_curs_caption">Finished cources</caption>
                    <thead>
                    <tr>
                        <th>Cource name</th>
                        <th>History</th>
                        <th>Start</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course" items="${inactiveCourseList}">
                        <tr>
                        <td>${course.getName()}</td>
                        <td><a href="./Controller?page=COURSES_HISTORY&course=${course.getId()}&courseName=${course.getName()}">History</a></td>
                        <td>
                            <a href="./Controller?page=START_NEW_COURSE&courseId=${course.getId()}&courseName=${course.getName()}">
                            <button class="btn-success">Start</button></a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>