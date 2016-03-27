package game.controllers;
import game.models.GameUsers;
import game.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

/* This servlet is used to log the user out of their session and return them back to the index page.
 * It will remove all of the user session variables stored on the server.
*/

@WebServlet(urlPatterns = {"/Logout"})
public class LogoutController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//check that the user is logged in. If not redirect them to index.jsp.
		if(request.getSession().getAttribute("user") == null){
			response.sendRedirect("index.jsp"); 
		}else{
			//set all of the users session attributes to null so they are no longer logged in.
			request.getSession().setAttribute("user", null) ;
			request.getSession().setAttribute("casesLeft", null);
			request.getSession().setAttribute("round", null);
			request.getSession().setAttribute("moneyOffer", null);
			response.sendRedirect("index.jsp"); //redirect them to index.jsp
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		doPost(request, response);
		
	}
	
	
}
