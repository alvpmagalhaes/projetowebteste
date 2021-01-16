<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

	<head>
<title><fmt:message key="page.title" /></title>
	</head>

	<body>

		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1>
				<fmt:message key="books.welcome" />
			</h1>
			<h2>
				<a href="/<%=contextPath%>/teatro/lista.jsp">
					<fmt:message key="publishers.entity" />
				</a>
				&nbsp;&nbsp;&nbsp;
			    <a href="${pageContext.request.contextPath}/logout.jsp">
					<fmt:message key="exit.link" />
				</a>
				<br/>
				<br/>
				<a href="/<%=contextPath%>/logado/promo/formulario.jsp">
					<fmt:message key="books.create" />
				</a>
			</h2>
			<h3><fmt:message key="books.list" /></h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th><fmt:message key="book.ID" /></th>
					<th><fmt:message key="book.publisher" /></th>
					<th><fmt:message key="book.title" /></th>
					<th><fmt:message key="book.author" /></th>
					<th><fmt:message key="book.year" /></th>
					<th><fmt:message key="book.price" /></th>
					<th><fmt:message key="book.horario" /></th>
				</tr>
				<c:forEach var="promo" items="${requestScope.listapromo}">
					<tr>
						<td>${promo.id}</td>
						<td>${promo.cnpj}</td>
						<td>${promo.nome_peca}</td>
						<td>${promo.url}</td>
						<td>${promo.preco}</td>
						<td>${promo.dia}</td>
						<td>${promo.horario}</td>
						<td><a href="/<%= contextPath%>/promo/edicao?id=${promo.id}">
								<fmt:message key="books.update" />
						</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/<%= contextPath%>/promo/remocao?id=${promo.id}"
							onclick="return confirm('<fmt:message key="confirm.link" />');">
								<fmt:message key="books.delete" />
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</body>
</fmt:bundle>

</html>