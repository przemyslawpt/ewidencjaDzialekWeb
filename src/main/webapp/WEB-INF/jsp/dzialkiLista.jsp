<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Dzialki</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/base.css" rel="stylesheet">
<script src="js/base.js"></script>
</head>
<body>
	<div>
		<table>
			<tr>
				<th class="th1"><strong>Numer ewidencyjny</strong></th>			
				<th class="th2"> <strong>Obreb</strong></th>
				<th class="th2"> <strong>wlasnoscRodzajDokumentu</strong></th>
				<th class="th2"> <strong>wlasnoscNumerDokumentu</strong></th>
				<th class="th2"> <strong>udzialy</strong></th>
				<th class="th2"> <strong>powierzchniaDzialki</strong></th>
				<th class="th2"> <strong>powierzchniaZabudowy</strong></th>
				<th class="th2"> <strong>przeznaczenie</strong></th>
				<th class="th2"> <strong>aktualneWykorzystanie</strong></th>
				<th class="th2"> <strong>planWykorzystaniaLata</strong></th>
				<th class="th2"> <strong>uwagi</strong></th>
				<th class="th2"> <strong>skladKomisji</strong></th>
			</tr>
			<c:forEach var="dzialka" items="${dzialkaList}">
				<tr class="tr1">
					<td class="td1">${dzialka.numerEwidencyjny}</td>
					<td class="td2">${dzialka.obreb}</td>
					<td class="td1">${dzialka.wlasnoscRodzajDokumentu}</td>
					<td class="td2">${dzialka.wlasnoscNumerDokumentu}</td>
					<td class="td2">${dzialka.udzialy}</td>
					<td class="td2">${dzialka.powierzchniaDzialki}</td>
					<td class="td2">${dzialka.powierzchniaZabudowy}</td>
					<td class="td2">${dzialka.przeznaczenie}</td>
					<td class="td2">${dzialka.aktualneWykorzystanie}</td>
					<td class="td2">${dzialka.planWykorzystaniaLata}</td>
					<td class="td2">${dzialka.uwagi}</td>
					<td class="td2">${dzialka.skladKomisji}</td>																
				</tr>
				<tr class="tr2" />
			</c:forEach>
		</table>
		<button onclick="greeting()">Powitanie</button>
	</div>

<img src="img/dog.gif" alt="Wesola buzka">

</body>
</html>