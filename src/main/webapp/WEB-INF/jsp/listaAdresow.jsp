<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Dzialki Adresy</title>
<link href="/css/base.css" rel="stylesheet">
<link href="/bootstrap.min.css" rel="stylesheet">
<script src="/jquery-2.2.1.min.js"></script>
<script src="/bootstrap.min.js"></script>
<script src="js/base.js"></script>
</head>
<body>
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

</body>
</html>