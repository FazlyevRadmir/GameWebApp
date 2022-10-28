<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="profile.css">
    <link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<form action="profile" method="post">
<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">${username}</span><span class="text-black-50">${email}</span><span> </span></div>
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-6"><label class="labels">Username</label><input type="text" class="form-control" name="username" readonly value="${username}"></div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">Name</label><input type="text" class="form-control" name="firstName" value="${firstName}"></div>
                    <div class="col-md-12"><label class="labels">Surname</label><input type="text" class="form-control" name="secondName" value="${secondName}"></div>
                    <div class="col-md-12"><label class="labels">Email Address</label><input type="text" class="form-control" name="email" value="${email}"></div>
                    <div class="col-md-12"><label class="labels">Phone Number</label><input type="text" class="form-control" name="phoneNumber" value="${phoneNumber}"></div>
                    <div class="col-md-12"><label class="labels">City</label><input type="text" class="form-control" name="city" value="${city}"></div>
                    <div class="col-md-12"><label class="labels">Gender</label>
                    <select name="gender" class="form-control" id="inputGender" >
                        <option value="" class="form-control">>> Choose your gender <<</option>
                        <option value="man" class="form-control">man</option>
                        <option value="woman" class="form-control" >woman</option>
                        <option value="" class="form-control" >transgender (omg...)</option>
                    </select>
                </div>
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit" >Save Profile</button></div>
            </div>
        </div>
    </div>
</div>
</div>
</form>
</body>
</html>

