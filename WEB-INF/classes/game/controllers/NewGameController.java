package game.controllers;
import game.models.User;
import game.models.GameModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

/* This servlet is called when the user starts a new game.
 * It creates a new GameModel object within the users User object.
 * It then sets the GameModel as a session attribute so it can be accessed by all pages the user visits. 
*/

@WebServlet(urlPatterns = {"/NewGame"})
public class NewGameController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "/Game";
		String referer = request.getHeader("Referer");
		
		// Check that the user is logged in.
		User user = (User) request.getSession().getAttribute("user");
		if(request.getSession().getAttribute("user") == null){
			response.sendRedirect(referer); //return the user to the previous page.
			return;
		}
		
		// initialize the GameModel object stored in the object User. (create a new game)
		user.newGame();
		
		// return that object created and set it as a session attribute so it can be associated and accessed depending on the user.
		GameModel game = user.getGame();
		request.getSession().setAttribute("game", game);
		
		//send the user to the url stored in 'url'
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}
	
}
