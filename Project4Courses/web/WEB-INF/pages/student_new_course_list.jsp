<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
    <div class="well">
        <h1>Welcome, ${participant.getFirstName()} ${participant.getLastName()}!</h1>
    </div>
    <p class="page-header">
    <h2>Your cources ...</h2>
    <div class="col-sm-4">
        <div class="table-responsive ">
            <form action=action="./Controller" method="GET">
                <table class="table table-striped table-hover table-bordered">
                    <caption class="available_curs_caption">Available cources</caption>
                    <thead>
                    <tr>
                        <th>Cource name</th><th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course1" items="${accessableCourseList1}">
                        <tr>
                            <td>${course1.getName()}</td>
                            <td><a href="./Controller?page=JOIN_NEW_COURSE_LIST&courseId=${course1.getId()}&courseName=${course1.getName()}">
                                <input type="button" value="Join"></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
    </form>
</div>
</body>
</html>
