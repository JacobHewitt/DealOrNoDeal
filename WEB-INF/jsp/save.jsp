<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>UoN Sales Home</title>
  <%@include file="/WEB-INF/jsp/includes/css.jsp" %>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
	<h1>Save Game?</h1>
	<form action="SaveGame" method="post" >
		<input type="submit" value="Yes" />
	</form>
	<form action="Game" method="post">
		<input type="submit" value="No" />
	</form>
	
</body>
</html>