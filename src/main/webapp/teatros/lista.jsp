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
				<fmt:message key="purchases.welcome" />
			</h1>
			<h2>
			  	<a href="/<%=contextPath%>/promo/lista.jsp"> 
					<fmt:message key="purchases.create" />
				</a> 
				&nbsp;&nbsp;&nbsp; 
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					<fmt:message key="exit.link" />
				</a>
			</h2>
			<br />
			<h3><fmt:message key="purchases.list" /></h3>
			<br />
		</div>

		<div align="center">
			<table border="1">
				<caption></caption>
				<tr>
					<th><fmt:message key="purchase.ID" /></th>
					<th><fmt:message key="purchase.date" /></th>
					<th><fmt:message key="purchase.value" /></th>
					<th><fmt:message key="purchase.book.author" /></th>
				</tr>
				<c:forEach var="teatro" items="${requestScope.listateatros}">
					<tr>
						<td>${teatro.id}</td>
						<td>${teatro.cnpj}</td>
						<td>${teatro.nome}</td>
						<td>${teatro.cidade}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</fmt:bundle>

</html>