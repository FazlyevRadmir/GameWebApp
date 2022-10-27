<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="registration.css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#usernameID").keyup(function () {
                $.ajax({
                    type: 'GET',
                    url: "registration",
                    data: $("form").serialize(),
                    success: function (result) {
                        if (result.trim() == 'true') {
                            console.log(result,1)
                            document.getElementById("submitbtn").removeAttribute("disabled");
                        }else{
                            console.log(result,2)
                            document.getElementById("submitbtn").setAttribute("disabled", "disabled");
                            $('#username_error').text("Username already registered")
                            document.getElementById('username_error').style.color = "red";
                        }
                    },
                    error: function (result) {
                        console.log(result);
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>Registration</h2>
    </div>
    <form id="formID" class="form" action="registration" method="post" name="vform" onsubmit="return Validate()">
        <div id="username_div" class="form-control">
            <label>Username:</label> <br>
            <input type="text" name="username" class="textInput" id="usernameID" placeholder="Enter a username">
            <div id="username_error"></div>
        </div>
        <div id="password_div" class="form-control">
            <label>Password:</label> <br>
            <input type="password" name="password" class="textInput" placeholder="Enter a password">
            <div id="password_error"></div>
        </div>
        <div id="firstName_div" class="form-control">
            <label>First name:</label> <br>
            <input type="text" name="firstName" class="textInput" placeholder="Enter your name">
            <div id="firstName_error"></div>
        </div>
        <div id="secondName_div" class="form-control">
            <label>Second name:</label> <br>
            <input type="text" name="secondName" class="textInput">
            <div id="secondName_error"></div>
        </div>
        <div id="email_div" class="form-control">
            <label>Email:</label> <br>
            <input type="email" name="email" class="textInput">
            <div id="email_error"></div>
        </div>
        <div id="phoneNumber_div" class="form-control">
            <label>Phone number:</label> <br>
            <input type="text" name="phoneNumber" class="textInput">
            <div id="phoneNumber_error"></div>
        </div>
        <div>
        <input type="submit" value="Sign Up" class="btn" name="register" id="submitbtn">
        </div>
    </form>
</div>
<span id="error" class=""></span>
<script src = "validation.js"></script>
</body>
</html>
