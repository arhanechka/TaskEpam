<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
    <div class="container-fluid">
       
       <div class="well">
           <h1>History of ${courseName}</h1>
       </div>
        <div class="row">
        <div class="col-sm-12">
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
             <caption class="current_curs_caption">List of students</caption>
              <thead>
                <tr>
                  <th>List students</th>
                  <th>Mark</th>
                    <th>Comment</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="list" items="${historyList}">

              <tr><td>${list.get(0)} ${list.get(1)}</td><td>${list.get(2)}</td><td>${list.get(3)}</td></tr>
              </c:forEach>
                <%--<tr><td>Tony</td><td>B</td><td>Good!</td></tr>--%>
                <%--<tr><td>Jack</td><td>C</td><td>Fine</td></tr>--%>
                  </tbody>
            </table>
            </div></div>
                     
        
    </div>
    </div>
    </body>
</html>