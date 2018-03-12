<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>WyswietlDzialke</title>
    <link href="https://fonts.googleapis.com/css?family=Nobile:400,700i|Oswald:400,700&amp;subset=latin-ext" rel="stylesheet">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <div>
        <img id="herb" src="img/herb.jpeg"></img>
    </div>
    <div id="Tytul">
       Mienie 1.0. Ewidencja mienia Gminy Pokój
    </div>
      <form method="post" action="raportPodglad">
            <div id="Podtytul">Pogdląd działki.
                <input type="hidden" id="raportDzialkaId" name="Id" value="${dzialka.id}" />
                <input type="hidden" id="generuj" value="Drukuj" />
            </div>
        </form>
    <div id="menu">
        <table>
            <tr>
                <td id="m">Menu</strong>
                </td>
            </tr>
            <tr>
                <td id="wyswietl"><a href="/listaDzialek">Wyświetl ewidencję</a></td>
            </tr>
            <tr>
                <td id="wyszukaj"><a href="/wyszukajDzialka">Wyszukaj działki</a></td>
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
            <table id="labels">
                <tr>
                    <th><label for="stanNa">Stan na: </label></th>
                    <td><input type="text" id="stanNa" name="stanNa" readonly="readonly" value="${stanNa}"/></td>
                </tr>
                <tr>
                    <th><label for="Id">Id : </label></th>
                    <td><input type="text" id="Id" name="Id" readonly="readonly" value="${dzialka.id}"/></td>
                </tr>
                <tr>
                    <th><label for="numerewidencyjny">Numer ewidencyjny : </label></th>
                    <td><input type="text" id="numerewidencyjny" name="numerEwidencyjnyDzialka" readonly="readonly" value="${dzialka.numerEwidencyjny}"/></td>
                </tr>
                <tr>
                    <th><label for="obrebgeodezyjny">Obręb geodezyjny : </label></th>
                    <td><input type="text" id="obrebgeodezyjny" name="obrebGeodezyjny" readonly="readonly" value="${dzialka.obreb}"/></td>
                </tr>
                <tr>
                    <th><label for="rodzajwlasnosci">Rodzaj Dokumentu Własności : </label></th>
                    <td><input type="text" id="rodzajwlasnosci" name="rodzajDokumentuWlasności" readonly="readonly" value="${dzialka.wlasnoscRodzajDokumentu}"/></td>
                </tr>
                <tr>
                    <th><label for="numerwlasnosci">Numer Dokumentu Własności : </label></th>
                    <td><input type="text" id="numerwlasnosci" name="numerDokumentuWlasności" readonly="readonly" value="${dzialka.wlasnoscNumerDokumentu}"/></td>
                </tr>
                <tr>
                    <th><label for="charakterwladania">Charakter Władania : </label></td>
                        <td><input type="text" id="charakterwladania" name="charakterWladania" readonly="readonly" value="${dzialka.charakterWladania}"/></td>
                </tr>
                <tr>
                    <th><label for="udzialy">Udziały : </label></th>
                    <td><input type="text" id="udzialy" name="udzialy" readonly="readonly" value="${dzialka.udzialy}"/></td>
                </tr>
                <tr>
                    <th><label for="powierzchniadzialki">Powierzchnia Dzialki : </label></th>
                    <td><input type="text" id="powierzchniadzialki" name="powierzchniaDzialki" readonly="readonly" value="${dzialka.powierzchniaDzialki}"/></td>
                </tr>
                <tr>
                    <th><label for="powierzchniazabudowy">Powierzchnia Zabudowy : </label></th>
                    <td><input type="text" id="powierzchniazabudowy" name="powierzchniaZabudowy" readonly="readonly" value="${dzialka.powierzchniaZabudowy}"/></td>
                </tr>
                <tr>
                    <th><label for="oszacowanawartosc">Oszacowana Wartość : </label></th>
                    <td><input type="text" id="oszacowanawartosc" name="oszacowanaWartosc" readonly="readonly" value="${dzialka.oszacowanaWartosc}"/></td>
                </tr>
                <tr>
                    <th><label for="przeznaczenie">Przeznaczenie : </label></th>
                    <td><input type="text" id="przeznaczenie" name="przeznaczenie" readonly="readonly" value="${dzialka.przeznaczenie}"/></td>
                </tr>
                <tr>
                    <th><label for="aktualnewykorzystanie">Aktualne Wykorzystanie : </label></th>
                    <td><input type="text" id="aktualnewykorzystanie" name="aktualneWykorzystanie" readonly="readonly" value="${dzialka.aktualneWykorzystanie}"/></td>
                </tr>
                <tr>
                    <th><label for="planwykorzystania">Plan Wykorzystania : </label></th>
                    <td><input type="text" id="planwykorzystania" name="planWykorzystania" readonly="readonly" value="${dzialka.planWykorzystaniaLata}"/></td>
                </tr>
                <tr>
                    <th><label for="uwagi">Uwagi : </label></th>
                    <td><input type="text" id="uwagi" name="uwagi" readonly="readonly" value="${dzialka.uwagi}"/></td>
                </tr>
                <tr>
                    <th><label for="skladkomisji">Skład Komisji : </label></th>
                    <td><input type="text" id="skladkomisji" name="skladKomisji" readonly="readonly" value="${dzialka.skladKomisji}"/></td>
                </tr>
            </table>
    </div>
    <div id="stopka">
            <div id="stopka">
        © 2018 Wszystkie prawa zastrzeżone
    </div>
    </div>
</body>

</html>
