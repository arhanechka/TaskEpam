<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>User timetable</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- Latest compiled and minified JavaScript -->
    <script src="js/bootstrap.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="css/additional.css">
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="./error.html">Elective System</a>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="container">
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="./index.jsp">Home</a></li>
                            <li><a href="./about.html">About</a></li>
                            <li><a href="./contacts.html">Contact</a></li>
                        </ul>
                    </div>
                    <!--/.navbar-collapse -->
                </div>
            </nav>
        </div>
    </div>
</div>

<div class="container-fluid">

    <div class="well">
        <h1>Welcome, ${currentStudent1.getFirstName()} ${currentStudent1.getLastName()}!</h1>
    </div>
    <p class="page-header">
    <h2>Your cources ...</h2>
    <div class="row">
        <div class="col-sm-4">
            <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                    <caption class="current_curs_caption">Current cources</caption>
                    <thead>
                    <tr>
                        <th>Cource name</th>
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
        <div class="col-sm-4">
            <div class="table-responsive ">
                <table class="table table-striped table-hover table-bordered">
                    <caption class="finished_curs_caption">Finished cources</caption>
                    <thead>
                    <tr>
                        <th>Cource name</th>
                        <th>Marks</th>
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