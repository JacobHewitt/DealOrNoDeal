<%@ page import="game.models.Case" %>
<%@ page import="java.util.List" %>
<%@ page import="game.models.GameModel" %>
<jsp:useBean id="game" type="game.models.GameModel" scope="session" />
<div id="gameWrap">
<h1>In Game</h1><h3>cases left this round: <jsp:getProperty name="game" property="casesLeftThisRound" /></h3>
<div id="chestWrap" >
<%-- This next part writes the individual chests to the page. Either as a button or as a div. --%>
<%
	List<Case> cases = ((GameModel) session.getAttribute("game")).getCases();
	for (int x = 0; x < cases.size(); x++){
	if (cases.get(x).isOpened()==false){%>
	<div class="chests" >
	<form action="Game" method="post">
		<input type="hidden" name="caseNumber" value="<%=x%>"/>
		<input type="submit" value="Chest: <%=x+1%>" class="button" />
	</form>
	</div>
	<%}else{%>
	<div class="chests" >
		<p>case: <%=x%> </p>
		<p>Money: <%=cases.get(x).getValue()%></p>
	</div>
	<%}%>
	
	
	
	
	<%}
%>
</div>
</div>
