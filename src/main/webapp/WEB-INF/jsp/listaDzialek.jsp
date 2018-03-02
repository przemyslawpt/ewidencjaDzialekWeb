<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pl">

<head>
    <meta charset="UTF-8">
    <title>listaDzialek</title>
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
        Ewidencja działek dla Gminy Pokój
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
    <div>
       <c:forEach items="${dzialkaList}" var="entry">
        ${entry.numerEwidencyjny}<br>
        ${entry.obreb}<br>
    </c:forEach>
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
               
                <tr>   
                    <td>
                    1    
                    </td>
                    <td>
                    2    
                    </td>
                    <td>
                    3   
                    </td>
                    <td>
                     4   
                    </td>
                    <td>
                    5    
                    </td>
                    <td>
                    6    
                    </td>
                    <td>
                    7    
                    </td>
                    <td>
                    8    
                    </td>
                    <td>
                    9    
                    </td>
                    <td>
                    10    
                    </td>
                    <td>
                    11
                    </td>
                    <td>
                    12    
                    </td>
                    <td>
                    13    
                    </td>
                    <td>
                    14
                    </td>
                    <td>
                    15    
                    </td>
                    <td id="td16">
                       
                    </td>
                </tr>
        </table>
    </div>
</body>

</html>
