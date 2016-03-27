<jsp:useBean id="user" class="game.models.User" scope="session"/>
			<%if(user.isLoggedIn()) {%>
			<div>
			<%if(user.canResume()) {%>
			<form action="Resume" method="post">
				<input type="submit" value="Resume Game"/>
			</form>
			<form action="NewGame" method="post">
				<input type="submit" value="Start New Game"/>
			</form>
			<%} else {%>
			<form action="NewGame" method="post">
				<input type="submit" value="Start New Game"/>
			</form>
			<%}%>
			</div>
			<%}%>