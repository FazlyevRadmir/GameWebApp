<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Authentication</title>
    <link rel="stylesheet" type="text/css" href="authentication.css">
</head>

<body>
<div class="container">
    <div class="header">
        <h2>Authentication</h2>
    </div>
    <form id="formID" class="form" action="authentication" method="post" name="vform" onsubmit="return Validate()">
        <div id="username_div" class="form-control">
            <label>Username:</label> <br>
            <input type="text" name="username" class="textInput">
        </div>
        <div id="password_div" class="form-control">
            <label>Password:</label> <br>
            <input type="password" name="password" class="textInput">
        </div>
        <div id="remember_div">
            <input type="checkbox" id="remember">
            <label for="remember">Remember me</label>
        </div>
        <div>
            <input type="submit" value="Sign In" class="btn" name="register">
        </div>
    </form>
</div>
</body>
</html>