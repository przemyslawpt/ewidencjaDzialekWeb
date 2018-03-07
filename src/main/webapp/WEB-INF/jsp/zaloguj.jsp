<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div id="panel">
           <%--  <form action="/loginCheck" method="post" >
                <label for="username">Nazwa użytkownika:</label>
                <input type="text" id="username" name="username">
                <label for="password">Hasło:</label>
                <input type="password" id="password" name="password">
                
                <input type="submit" value="ZALOGUJ_I_NIE_NARZEKAJ">
            </form> --%>
       <c:url value="/zaloguj" var="/zaloguj"/>
		
		<form:form action="" method="post">
			<label for="username">Nazwa użytkownika:</label>
                <input type="text" id="username" name="username">
                <label for="password">Hasło:</label>
                <input type="password" id="password" name="password">
			<input type="submit"/>
		</form:form>

        </div>
        
     <i><img src="img/mapazpinezka.jpg"></i> 

</body>
</html>