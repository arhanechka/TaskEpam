<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>

<div class="container-fluid">

    <div class="well">
        <h1>History of ${courseName}</h1>
        <input type="hidden" name=${courseName} value="SET_STUDENT_MARK">

    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>List of students</th>
                        <th>Mark</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="student" items="${studentListForCurrentCourse}">
                        <tr>
                            <td>
                                    ${student.getLastName()} ${student.getFirstName()}
                            </td>
                            <td>
                                <form action="./Controller" method="POST">
                                    <div class="form-group">
                                        <input type="hidden" name="page" value="SET_STUDENT_MARK">

                                        <select class="form-control" name="mark" id="student_id_mark1"
                                                onchange="submit()">
                                            <option selected>_</option>
                                            <option>A</option>
                                            <option>B</option>
                                            <option>C</option>
                                            <option>D</option>
                                            <option>E</option>
                                        </select>
                                    </div>
                                </form>
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
