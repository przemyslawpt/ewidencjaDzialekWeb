<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Logowanie</title>
    <link href="https://fonts.googleapis.com/css?family=Nobile:400,700i|Oswald:400,700&amp;subset=latin-ext" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <header>
        <div id="panel">
            <form action="/loginCheck" method="post" >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <span>${msg}</span>
                <label for="username">Nazwa użytkownika:</label>
                <input type="text" id="username" name="username">
                <label for="password">Hasło:</label>
                <input type="password" id="password" name="password">
                <div id="lower">
                <input type="submit" value="ZALOGUJ">
                </div>
            </form>
        </div>
     <i><img src="img/mapazpinezka.jpg"></i>
    </header>

</body>
</html>