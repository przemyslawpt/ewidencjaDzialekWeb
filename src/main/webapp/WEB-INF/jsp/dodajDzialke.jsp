<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Dodaj Działke</title>

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
        Dodaj działkę do ewidencji
    </div>
    <div id="menu">
        <table>
            <tr>
                <td id="m">Menu</strong>
                </td>
            </tr>
            <tr>
                <td id="wyswietl">Wyświetl ewidencję</td>
            </tr>
            <tr>
                <td id="wyszukaj">Wyszukaj działki</td>
            </tr>
            <tr>
                <td id="dodaj">Dodaj działkę</td>
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
                    <th><label for="rodzajwlasnosci">Rodzaj dokumentu własności : </label></th>
                    <td><input type="text" id="rodzajwlasnosci" name="rodzajDokumentuWlasnoÅci" /></td>
                </tr>
                <tr>
                    <th><label for="numerwlasnosci">Numer dokumentu własności : </label></th>
                    <td><input type="text" id="numerwlasnosci" name="numerDokumentuWlasnoÅci" /></td>
                </tr>
                <tr>
                    <th><label for="charakterwladania">Charakter władania : </label></td>
                        <td><input type="text" id="charakterwladania" name="charakterWladania" /></td>
                </tr>
                <tr>
                    <th><label for="udzialy">Udziały : </label></th>
                    <td><input type="text" id="udzialy" name="udzialy"></td>
                </tr>
                <tr>
                    <th><label for="powierzchniadzialki">Powierzchnia działki : </label></th>
                    <td><input type="text" id="powierzchniadzialki" name="powierzchniaDzialki" /></td>
                </tr>
                <tr>
                    <th><label for="powierzchniazabudowy">Powierzchnia zabudowy : </label></th>
                    <td><input type="text" id="powierzchniazabudowy" name="powierzchniaZabudowy" /></td>
                </tr>
                <tr>
                    <th><label for="oszacowanawartosc">Oszacowana wartość : </label></th>
                    <td><input type="text" id="oszacowanawartosc" name="oszacowanaWartosc" /></td>
                </tr>
                <tr>
                    <th><label for="przeznaczenie">Przeznaczenie : </label></th>
                    <td><input type="text" id="przeznaczenie" name="przeznaczenie" /></td>
                </tr>
                <tr>
                    <th><label for="aktualnewykorzystanie">Aktualne wykorzystanie : </label></th>
                    <td><input type="text" id="aktualnewykorzystanie" name="aktualneWykorzystanie" /></td>
                </tr>
                <tr>
                    <th><label for="planwykorzystania">Plan wykorzystania : </label></th>
                    <td><input type="text" id="planwykorzystania" name="planWykorzystania" /></td>
                </tr>
                <tr>
                    <th><label for="uwagi">Uwagi : </label></th>
                    <td><input type="text" id="uwagi" name="uwagi" /></td>
                </tr>
                <tr>
                    <th><label for="skladkomisji">Skład komisji : </label></th>
                    <td><input type="text" id="skladkomisji" name="skladKomisji" /></td>
                </tr>
            </table>
    </div>
    <input type="button" id="zapisz" value="Zapisz">
    </form>
</body>

</html>
