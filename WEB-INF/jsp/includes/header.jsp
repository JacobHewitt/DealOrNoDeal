<jsp:useBean id="user" class="game.models.User" scope="session"/>
<header>

	<div id="header">
		<%if (user.isLoggedIn()) {%>
			Welcome: <jsp:getProperty name="user" property="name"/>
			<br/>
			<form action="Logout" method="post">
			<input type="submit" value="Logout" />
			</form>
		<%} else {%>
			<h2>Log in</h2>
			<form action="Login" method="post">
				<input type="text" placeholder="Username..." name="username"/>
				<input type="submit" value="Login"/>
			</form>
		<%}%>
	</div>
	<hr/>
</header>