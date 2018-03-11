<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>

<html lang="pl">
<head>
    <title>listaDzialek</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://fonts.googleapis.com/css?family=Nobile:400,700i|Oswald:400,700&amp;subset=latin-ext" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div>
        <img id="herb" src="img/herb.jpeg"></img>
    </div>
    <div id="Tytul">
        Zautomatyzowana baza mienia dla Gminy Pokój
    </div>
    <div id="Podtytul">		
        Wyniki wyszukiwania dla ewidencja mienia.
	</div>
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
	<div>
        <table id="tabela">
            <tr>
                <th id="th2">Numer
                    <p>Ewidencyjny</p>
                </th>
                <th id="th3">Obręb
                    <p>geodezyjny</p>
                </th>
                <th id="th4">Rodzaj
                    <p>Dokumentu Własności</p>
                </th>
                <th id="th5">Numer
                    <p>Dokumentu Własności</p>
                </th>
                <th id="th6">Charakter
                    <p>Władania</p>
                </th>
                <th id="th7">Udziały</th>
                <th id="th8">Powierzchnia
                    <p>Dzialki</p><p>[ha]</p>
                </th>
                <th id="th9">Powierzchnia
                    <p>Zabudowy</p><p>[m<sup>2</sup>]</p>
                </th>
                <th id="th10">Oszacowana
                    <p>Wartość</p><p>[PLN]</p>
                </th>
                <th id="th11">Przeznaczenie</th>
                <th id="th12">Aktualne
                    <p>Wykorzystanie</p>
                </th>
                <th id="th13">Plan
                    <p>Wykorzystania</p>
                </th>
                <th id="th14">Uwagi</th>
                <th id="th15">Skład
                    <p>Komisji</p>
                </th>
                <th id="th16">Opcje</th>
            </tr>
            <c:forEach items="${dzialkaList}" var="dzialka">
                <tr>
                    <td id="th2">${dzialka.numerEwidencyjny}</td>
                    <td id="th3">${dzialka.obreb}</td>
                    <td id="th4">${dzialka.wlasnoscRodzajDokumentu}</td>
                    <td id="th5">${dzialka.wlasnoscNumerDokumentu}</td>
                    <td id="th6">${dzialka.charakterWladania}</td>
                    <td id="th7">${dzialka.udzialy}</td>
                    <td id="th8">${dzialka.powierzchniaDzialki}</td>
                    <td id="th9">${dzialka.powierzchniaZabudowy}</td>
                    <td id="th10">${dzialka.oszacowanaWartosc}</td>
                    <td id="th11">${dzialka.przeznaczenie}</td>
                    <td id="th12">${dzialka.aktualneWykorzystanie}</td>
                    <td id="th13">${dzialka.planWykorzystaniaLata}</td>
                    <td id="th14">${dzialka.uwagi}</td>
                    <td id="th15">${dzialka.skladKomisji}</td>
                    <td id="th16">
	                    <form method="post" action="podgladDzialka">
		                 <input type="hidden" name="dzialkaId" value="${dzialka.id}">
		                 <input id="podglad" type="submit" value="Podgląd">
		                 </form>
                   	</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>

</html>

