<!DOCTYPE html>
<html lang="ru">
<%@ include file="/WEB-INF/view/jspf/head.jspf"%>
<%@ include file="/WEB-INF/view/jspf/header.jspf"%>
<div class="container">
  <h2>Registration</h2>
  <form class="form-horizontal" action="./Controller" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-2"  for="firstname">First Name:</label>
      <div class="col-sm-10">
        <div class="input-group">
            <input type="hidden" name="page" value="STUDENT_NEW_COURSE_LIST">

            <span class="input-group-addon">Text</span>
            <input type="text" class="form-control" name="first_name" id="firstName" placeholder="Enter Your First Name" name = "firstName" required></div>
      </div>
    </div>      
    <div class="form-group">
      <label class="control-label col-sm-2"  for="lastname">Last Name:</label>
      <div class="col-sm-10">
        <div class="input-group">
    <span class="input-group-addon">Text</span>
            <input type="text" class="form-control" name="last_name"  id="lastName" placeholder="Enter Your Last Name" name="lastName" required></div>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="login">Login:</label>
      <div class="col-sm-10">
       <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
           <input type="text" class="form-control" id="login" name="login" placeholder="Enter Login Name" name="login"  required></div>
      </div>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="password">Password:</label>
      <div class="col-sm-10">
       <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>   
        <input type="password" class="form-control" name="password" id="password" placeholder="Enter password" name="password"  required>
          </div>
      </div>
    </div>
                                        
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
       <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
        <input type="email" class="form-control" name="email" id="email" placeholder="Enter email" name="email"  required>
          </div>
      </div>
    </div>

    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>
    </body>
</html>