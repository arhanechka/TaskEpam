<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf" %>
<%@ include file="/WEB-INF/view/jspf/header.jspf" %>

<div class="container-fluid">

    <div class="well">
        <h1>History of ${currentCourse.getName()}</h1>
        <%--<input type="hidden" name=${course.getName()} value="SET_STUDENT_MARK">--%>

    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>List of students</th>
                        <th>Mark</th>
                        <th>Comment</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="student" items="${studentListForCurrentCourse}">

                        <form action="./Controller" method="GET">
                            <tr>
                                <td>
                                        ${student.getLastName()} ${student.getFirstName()}
                                </td>
                                <td>

                                    <div class="form-group">
                                        <input type="hidden" name="page" value="SET_STUDENT_MARK">
                                        <input type="hidden" name="studentId" value="${student.getId()}">

                                        <select class="form-control" name="mark" id="student_id_mark1">
                                            <option selected>_</option>
                                            <option>A</option>
                                            <option>B</option>
                                            <option>C</option>
                                            <option>D</option>
                                            <option>E</option>
                                        </select>
                                    </div>

                                </td>
                                <td>
                                    <input type="text" name="comment" class="form-control">
                                </td>
                                <td>
                                    <input type="submit" class="btn-info">
                                </td>
                        </form>
                        </tr>
                    </c:forEach>

                    </tbody>

                </table>
                <a href="./Controller?page=LIST_COURSE_TEACHER">
                    <button class="btn-success">Back</button>
                </a>

                <a href="./Controller?page=CLOSE_COURSE&studentListForCurrentCourse=${studentListForCurrentCourse}">
                    <button class="btn-success">Close course</button>
                </a>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
