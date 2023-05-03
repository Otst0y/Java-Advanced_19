<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Lesson-18</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>

<c:choose>
    <c:when test="${mode == 'S_SUCCESS'}">

        <div class="container cabinet mt-5">

            <div class="row d-flex justify-content-center info">

                <div class="col-md-7">

                    <div class="card p-3 py-4">

                        <div class="text-center">

                            <c:if test="${not empty file}">
                                <img src="/photo/${file.id}" class="image rounded-circle"/>
                            </c:if>
                        </div>

                        <div class="text-center mt-3">
                            <span class="bg-secondary p-1 px-4 rounded text-white">Student_ID - ${savedStudent.id}</span>
                            <h5 class="mt-2 mb-0">${savedStudent.firstName} ${savedStudent.lastName}</h5>
                            <span>Age: ${savedStudent.age}</span>

                            <br>

                            <h5>Email: <a href="${savedStudent.email}">${savedStudent.email}</a></h5>


                        </div>

                    </div>

                </div>

            </div>

        </div>
    </c:when>

    <c:when test="${mode == 'S_ERROR'}">
        <body>
        <div class="d-flex align-items-center justify-content-center vh-100">
            <div class="text-center">
                <h1 class="display-1 fw-bold">404</h1>
                <p class="fs-3"><span class="text-danger">Opps!</span> Something wrong </p>
                <p class="lead">
                    Please check that your email and password are correct. Then you will try again.
                </p>
                <a href="/" class="btn btn-primary">Go Home</a>
            </div>
        </div>
        </body>
    </c:when>

    <c:when test="${mode == 'S_REGISTRATION'}">
        <c:set var="s" value="${studentDto}"/>
        <div class="container">
            <div class="row centered-form">
                <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please fill this form</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="save" method="post" enctype="multipart/form-data">
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <input type="text" name="firstName" value="${s.firstName}" id="first_name"
                                                   class="form-control input-sm" placeholder="First Name">
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <input type="text" name="lastName" value="${s.lastName}" id="last_name"
                                                   class="form-control input-sm" placeholder="Last Name">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <input type="age" name="age" value="${s.age}" id="age" class="form-control input-sm"
                                           placeholder="Age">
                                </div>

                                <div class="form-group">
                                    <input type="email" name="email" value="${s.email}" id="email"
                                           class="form-control input-sm" placeholder="Email Address">
                                </div>

                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <input type="password" name="password" value="${s.password}" id="password"
                                                   class="form-control input-sm" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <input type="password" name="cPassword" value="${s.cPassword}"
                                                   id="password_confirmation" class="form-control input-sm"
                                                   placeholder="Confirm Password">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">

                                    <input type="file" name="file" id="file"
                                           class="form-control input-sm customFileInput"/>
                                </div>

                                <input type="submit" value="Register" class="btn btn-info btn-block"
                                       placeholder="Upload your photo">

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:when>

</c:choose>


</body>
</html>