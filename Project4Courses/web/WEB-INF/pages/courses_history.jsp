<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/jspf/head.jspf" %>
<%@ include file="/WEB-INF/view/jspf/header.jspf" %>
<div class="container-fluid">
    <div class="well">
        <h1>${courseName}</h1>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                    <caption class="current_curs_caption">${students_list}</caption>
                    <thead>
                    <tr>
                        <th>${students_list}</th>
                        <th>${mark}</th>
                        <th>${comment}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="list" items="${historyList}">
                        <tr>
                            <td>${list.get(0)} ${list.get(1)}</td>
                            <td>${list.get(2)}</td>
                            <td>${list.get(3)}</td>
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