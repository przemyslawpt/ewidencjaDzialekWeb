<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="UTF-8">
    <title>Dodaj Dzialke</title>
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
        Dodaj działkę do ewidencji
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
        Detale działki:
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
    </div>
    <input type="button" id="zapisz" value="Zapisz">
    </form>
</body>

</html>
