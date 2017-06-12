<%--
  Created by IntelliJ IDEA.
  User: Anya
  Date: 07.06.2017
  Time: 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student course list:</title>
</head>
<body>
${greeting}
<h3>Your current course list:</h3></br>
<c:choose>
    <c:when test="${currentCourseList}==null">
       <h2>The current course list is empty</h2>
    </c:when>
    <c:otherwise>
        <c:forEach var="course" items="${currentCourseList}">
            <h4>${course.getName()}</h4>
            </br>
        </c:forEach>
    </c:otherwise>
</c:choose>
<h3>Actual courses for join:</h3>
</br>
<c:forEach var="course1" items="${accessableCourseList}">
    <h4>${course1.getName()}</h4>
    </br>
</c:forEach>
<h3>Finished courses:</h3>
</br>
<c:forEach var="course2" items="${finishedCourseList}">
    <h4>${course2.getKey()} ${course2.getValue()}</h4>
    </br>
</c:forEach>
</body>
</html>
