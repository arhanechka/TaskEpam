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
<div class="container" align="center">
    <h1 class="well">Registration Form</h1>
    <div class="col-lg-12 well">
        <div class="row">
            <br>
            <form action="./Controller" method="POST">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <input type="hidden" name="page" value="LIST_COURSE_STUDENT">
                            <label>First Name</label>
                            <input type="text" placeholder="First name" name = "firstName" class="form-control">
                        </div>
                        <br>
                        <div class="col-sm-4 form-group">
                            <label>Last Name</label>
                            <input type="text" placeholder="Last name" name = "lastName" class="form-control">
                        </div>
                        <br>
                        <div class="col-sm-6 form-group">
                            <label>Login</label>
                            <input type="text" placeholder="Login" name = "login" class="form-control">
                        </div>
                    </div>

                    <br>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" placeholder="Password" name = "password" class="form-control">
                    </div>
                    <br>
                    <div class="form-group">
                        <label>Email Address</label>
                        <input type="email" placeholder="Email" name = "email" class="form-control">
                    </div>
                    <br>
                    <button type="submit" class="btn btn-lg btn-info">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
