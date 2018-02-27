<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <title>Dzialki Adresy</title>
        <link href="/css/base.css" rel="stylesheet">
        <script src="js/base.js"></script>
</head>

<body>
    <div>
        Lista Działek
    </div>
    <div>
        <table>
            <tr>
                <th class="th1"><strong>Miejscowosc</strong>
                    </td>
                    <th class="th2"> <strong>Ulica</strong>
                        </td>
            </tr>
            <c:forEach var="adres" items="${adresList}">
                <tr class="tr1">
                    <td class="td1">${adres.miejscowosc}</td>
                    <td class="td2">${adres.ulica}</td>
                </tr>
                <tr class="tr2" />
            </c:forEach>
        </table>
        <button onclick="greeting()">Powitanie</button>
    </div>
    <div>
        <img src="img/dog.gif" alt="Wesola buzka">
    </div>

</body>
</html>