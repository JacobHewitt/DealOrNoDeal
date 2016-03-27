<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>UoN Sales Home</title>
  <%@include file="/WEB-INF/jsp/includes/css.jsp" %>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
	<h1>Congratulations! you have won: <%=session.getAttribute("moneyOffer")%></h1>
	<form action="Logout" method="post">
		<input type="hidden" value="end" name="end" />
		<input type="submit" value="End Game" />
	</form>
	
</body>
</html>