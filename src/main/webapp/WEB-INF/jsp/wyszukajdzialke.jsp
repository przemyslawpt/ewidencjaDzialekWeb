<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Wyszukaj Dzialke</title>
    <link href="https://fonts.googleapis.com/css?family=Nobile:400,700i|Oswald:400,700&amp;subset=latin-ext" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <div>
        <img id="herb" src="img/herb.jpeg"></img>
    </div>
    <div id="Tytul">
        Zautomatyzowana baza działek dla Gminy Pokój
    </div>
    <div id="Podtytul">
        Wyszukaj działkę z ewidencji
    </div>
    <div id="menu">
        <table>
            <tr>
                <td id="m">Menu</strong>
                </td>
            </tr>
            <tr>
                <td id="wyswietl">Wyświetl ewidencję</td>
            </tr>
            <tr>
                <td id="wyszukaj">Wyszukaj działki</td>
            </tr>
            <tr>
                <td id="dodaj">Dodaj działkę</td>
            </tr>
        </table>
    </div>
    <div id="detale">
        Podaj dane wyszukiwania:
    </div>
    <div>
        <form method="post" action="zapiszDzialka">
            <table id="labels">
                <tr>
                    <th><label for="Id">Id : </label></th>
                    <td><input type="text" id="Id" name="Id" /></td>
                </tr>
                <tr>
                    <th><label for="numerewidencyjny">Numer ewidencyjny : </label></th>
                    <td><input type="text" id="numerewidencyjny" name="numerEwidencyjnyDzialka" /></td>
                </tr>
                <tr>
                    <th><label for="obrebgeodezyjny">Obręb geodezyjny : </label></th>
                    <td><input type="text" id="obrebgeodezyjny" name="obrebGeodezyjny" /></td>
                </tr>
                <tr>
                    <th><label for="rodzajwlasnosci">Rodzaj Dokumentu Własności : </label></th>
                    <td><input type="text" id="rodzajwlasnosci" name="rodzajDokumentuWlasności" /></td>
                </tr>
                <tr>
                    <th><label for="numerwlasnosci">Numer Dokumentu Własności : </label></th>
                    <td><input type="text" id="numerwlasnosci" name="numerDokumentuWlasności" /></td>
                </tr>
                <tr>
                    <th><label for="charakterwladania">Charakter Władania : </label></td>
                        <td><input type="text" id="charakterwladania" name="charakterWladania" /></td>
                </tr>
                <tr>
                    <th><label for="udzialy">Udziały : </label></th>
                    <td><input type="text" id="udzialy" name="udzialy"></td>
                </tr>
                <tr>
                    <th><label for="powierzchniadzialki">Powierzchnia Dzialki : </label></th>
                    <td><input type="text" id="powierzchniadzialki" name="powierzchniaDzialki" /></td>
                </tr>
                <tr>
                    <th><label for="powierzchniazabudowy">Powierzchnia Zabudowy : </label></th>
                    <td><input type="text" id="powierzchniazabudowy" name="powierzchniaZabudowy" /></td>
                </tr>
                <tr>
                    <th><label for="oszacowanawartosc">Oszacowana Wartość : </label></th>
                    <td><input type="text" id="oszacowanawartosc" name="oszacowanaWartosc" /></td>
                </tr>
                <tr>
                    <th><label for="przeznaczenie">Przeznaczenie : </label></th>
                    <td><input type="text" id="przeznaczenie" name="przeznaczenie" /></td>
                </tr>
                <tr>
                    <th><label for="aktualnewykorzystanie">Aktualne Wykorzystanie : </label></th>
                    <td><input type="text" id="aktualnewykorzystanie" name="aktualneWykorzystanie" /></td>
                </tr>
                <tr>
                    <th><label for="planwykorzystania">Plan Wykorzystania : </label></th>
                    <td><input type="text" id="planwykorzystania" name="planWykorzystania" /></td>
                </tr>
                <tr>
                    <th><label for="uwagi">Uwagi : </label></th>
                    <td><input type="text" id="uwagi" name="uwagi" /></td>
                </tr>
                <tr>
                    <th><label for="skladkomisji">Skład Komisji : </label></th>
                    <td><input type="text" id="skladkomisji" name="skladKomisji" /></td>
                </tr>
            </table>
            <input type="button" id="wyszukajbutton" value="Wyszukaj">
    </div>
    </form>
    <div>
        <table id="tabela">
            <tr>
                <th id="th1">Id</th>
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
                    <p>Dzialki</p>
                </th>
                <th id="th9">Powierzchnia
                    <p>Zabudowy</p>
                </th>
                <th id="th10">Oszacowana
                    <p>Wartość</p>
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
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach items="${dzialkaList}" var="dzialka">
                <tr>
                    <td id="th1">${dzialka.id}</td>
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
                    <td id="th16">${opcje}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>

</html>
