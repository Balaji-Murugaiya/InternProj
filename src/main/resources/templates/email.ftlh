<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login taken place from this emailID!</title>
</head>
<body>
<div style="margin-top: 10px">Hello,</div>
<br/>
<div>A login has taken place with the following login details IP address:${emailDetails.ipAddress}
    <br>City: ${emailDetails.city}
    <br>Latitude:${emailDetails.latitude}
    <br>Longitude:${emailDetails.longitude}
</div>
<br>
<div>
    If it is not you click the button below to disable the login
    <form method="get" action="http://fccae699b3ee.ngrok.io/lo/${emailDetails.encodedSessionID}">
        <input type="submit" value="Logout" />
    </form>
</div>
<br>
</body>
</html>