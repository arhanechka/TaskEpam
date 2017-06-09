<%--
  Created by IntelliJ IDEA.
  User: Anya
  Date: 05.06.2017
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
  <meta charset="windows-1251">
  <title>index</title>
  <style type="text/css">
    @import url("style.css");
  </style>
</head>

<body>
<section>
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <hgroup>
          <h2>
            Welcome to the system of distance cource</h2>
          <h1 class="free">Elective</h1>
        </hgroup>
        <div class="well">
          <div class="input-group">
            <div> <h2>Have been registred?</h2></div>
            <a href="./Controller?page=LOGIN_STUDENT">
              <button class="btn btn-info btn-lg" type="submit" value="reg_student" name="reg_student">Registred student</button></a>
            <a href="./Controller?page=LOGIN_TEACHER">
              <button class="btn btn-info btn-lg" type="submit" value="reg_teacher" name="reg_teacher">Registred teacher</button></a>
          </div>
        </div>
          <div class="input-group">
              <div> <h2>Are you a new participant?</h2></div>

              <a href="./Controller?page=NEW_STUDENT">
                <button class="btn btn-info btn-lg" type="submit" value="new_student" name="new_student">New student</button></a>
            </div>

      </div>
    </div>
  </div>
</section>
</body>
</html>
