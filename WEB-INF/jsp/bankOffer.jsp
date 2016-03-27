<jsp:useBean id="game" type="game.models.GameModel" scope="session" />
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>UoN Sales Home</title>
  <%@include file="/WEB-INF/jsp/includes/css.jsp" %>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
	<h1>Bank Offer!</h1>
	<h2>You have made it to round: <jsp:getProperty name="game" property="round" /></h2>
	<h3>Money so far: <jsp:getProperty name="game" property="money" /></h3>
	<form action="Game" method="post">
		<input type="hidden" value="cashout" name="cashout"/>
		<input type="submit" value="Deal"/>
	</form>
	<form action="Game" method="post">
		<input type="hidden" value="continue" name="continue" />
		<input type="submit" value="NoDeal"/>
	</form>
	
	
	

</body>
</html>