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

//This servlet is called when the user wishes to save their game.

@WebServlet(urlPatterns = {"/SaveGame"})
public class SaveGameController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "/index.jsp";
		String referer = request.getHeader("Referer");
		
		//check the user is loged in.
		User user = (User) request.getSession().getAttribute("user");
		if(request.getSession().getAttribute("user") == null){
			response.sendRedirect(referer);
			return;
		}else if(request.getSession().getAttribute("game")==null){
			response.sendRedirect(referer);
			return;
		}
		
		// set the users GameModel object to null (end his game) (its still stored)
		request.getSession().setAttribute("game", null);
		
		// direct the user to the page stored in the string 'url'
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}
	
}
