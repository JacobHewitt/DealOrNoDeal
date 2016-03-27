package game.controllers;
import game.models.GameUsers;
import game.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* This servlet receives the form data from the login page.
 * It then either creates a new user or retrieves the user if he is returning.
*/
@WebServlet(urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//get form data
		String username = request.getParameter("username");
		String referer = request.getHeader("Referer"); 

		//check if the user entered a user name
		if(username == null){
			// redirect the user to the previous page.
			response.sendRedirect(referer);
			return;
		}
		
		// retrieve the GameUsers object which was initialized on the applications start up.
		GameUsers users = (GameUsers) getServletContext().getAttribute("users");
		User user;
		
		//check if the user has not logged in with before.
		if(users.returnUser(username) == null){
			
			// create a new User object with the user name provided and add it to the users object
			user = new User(username);
			users.addUser(user);
		}else{ //user has logged in before
			user = users.returnUser(username); // retrieve the users User object
		}
		

		// store user in session so all pages and servlets can see the user associated with this session
		request.getSession().setAttribute("user", user);

		//send them back to where they came from
		response.sendRedirect(referer);
	}
}
