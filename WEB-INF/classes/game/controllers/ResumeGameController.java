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

/* This servlet is called when the user wishes to resume their game.
 * It first checks that the user is logged in and has already started a game.
 * It then sends them to the url stored in the string 'url'
*/

@WebServlet(urlPatterns = {"/Resume"})
public class ResumeGameController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "/Game";
		
		// get the User object associated with the user.
		User user = (User) request.getSession().getAttribute("user");
		
		// redirect the user if they are not logged in.
		if(request.getSession().getAttribute("user") == null){
			response.sendRedirect("C3218832_assignment2/index.jsp");
			return;
		}
		
		// check if the user is already in a game and redirect them to the Game servlet.
		if(request.getSession().getAttribute("inGame")=="true"){
			response.sendRedirect("Game"); 
			return;
		}
		
		//return the GameModel from the user and set it as a session attribute so it can be accessed by other classes on the server.
		GameModel game = user.getGame(); 
		request.getSession().setAttribute("game", game);
		
		// redirect the user to the url stored in the string 'url'
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
		
	}
	
}
