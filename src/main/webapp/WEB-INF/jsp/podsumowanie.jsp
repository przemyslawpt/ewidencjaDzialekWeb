<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">

<head>
<meta charset="UTF-8">
<title>PodsumowanieDzialke</title>
<link
	href="https://fonts.googleapis.com/css?family=Nobile:400,700i|Oswald:400,700&amp;subset=latin-ext"
	rel="stylesheet">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div>
		<img id="herb" src="img/herb.jpeg"></img>
	</div>
	<div id="Tytul">Zautomatyzowana baza mienia dla Gminy Pokój</div>
	<form method="get" action="podsumowanieHistory">
		<div id="Podtytul">Stan na dzień:
		  <input type="text" id="stanNaDzien" name="stanNaDzien" value="${stanNaDzien}"/>
	    <input type="submit" id="odswiez" value="Odśwież">
		</div>
		</form>
	<div id="menu">
		<table>
			<tr>
				<td id="m">Menu</strong>
				</td>
			</tr>
			<tr>
				<td id="wyswietl"><a href="/listaDzialek">Wyświetl
						ewidencję</a></td>
			</tr>
			<tr>
				<td id="wyszukaj"><a href="/wyszukajDzialka">Wyszukaj
						działki</a></td>
			</tr>
			<tr>
				<td id="dodaj"><a href="/dodajDzialka">Dodaj działkę</a></td>
			</tr>
			<tr>
				<td id="dodaj"><a href="/podsumowanie">Podsumowanie</a></td>
			</tr>
		</table>
	</div>
	<br/>
	<div>
		<table id="labels">
			<tr>
				<th>Przeznaczenie</th>
				<th>Całkowita oszacowania wartość [PLN]</th>
			</tr>
			<c:forEach items="${result}" var="row">
				<tr>
					<th>${row.przeznaczenie}</th>
					<th>${row.calkowitaWartoscOszacowana}</th>
				</tr>
			</c:forEach>
			</table>
                <table id="podsumowanie">	
				<tr>
					<th>${podsumowanie.przeznaczenie}</th>
					<th>${podsumowanie.calkowitaWartoscOszacowana}</th>
				</tr>
		</table>
	</div>
<div id="stopka">
        © by Stowarzyszenie Pokój Organizacja Pożytku Publicznego 2018 Wszystkie prawa zastrzeżone
    </div>
</body>

</html>
