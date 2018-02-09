<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Dzialki</title>
<link href="/css/base.css" rel="stylesheet">
<script src="js/base.js"></script>
</head>
<body>
	<div>

		<table>
			<tr>
				<th class="th1"><strong>Numer ewidencyjny</strong></th>			
				<th class="th2"> <strong>Obreb</strong></th>
				<th class="th2"> <strong>charakterWladania</strong></th>
				<th class="th2"> <strong>udzialy</strong></th>
				<th class="th2"> <strong>powierzchnia</strong></th>
			</tr>
			<c:forEach var="dzialka" items="${dzialkaList}">
				<tr class="tr1">
					<td class="td1">${dzialka.numerEwidencyjny}</td>
					<td class="td2">${dzialka.obreb}</td>
					<td class="td1">${dzialka.charakterWladania}</td>
					<td class="td2">${dzialka.udzialy}</td>
					<td class="td2">${dzialka.powierzchnia}</td>
				</tr>
				<tr class="tr2" />
			</c:forEach>
		</table>
		<button onclick="greeting()">Powitanie</button>
	</div>

<img src="img/dog.gif" alt="Wesola buzka">

</body>
</html>