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

/* This servlet receives the form data from the login page.
 * It then either creates a new user or retrieves the user if he is returning.
*/

@WebServlet(urlPatterns = {"/Game"})
public class GameController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "/WEB-INF/jsp/play.jsp";
		String referer = request.getHeader("Referer");
		
		if(request.getSession().getAttribute("user") == null){
			response.sendRedirect("/C3218832_assignment2/index.jsp");
			return;
		}
		if(request.getSession().getAttribute("game")==null){
			response.sendRedirect("/C3218832_assignment2/index.jsp");
			return;
		}

		User user = (User) request.getSession().getAttribute("user");
		GameModel game = (GameModel) request.getSession().getAttribute("game");
		
		if(request.getParameter("continue")!=null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/save.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		if(request.getParameter("cashout")!=null){
			request.getSession().setAttribute("moneyOffer", game.getMoney());
			user.endGame();
			request.getSession().setAttribute("game", null);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/cashout.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		if(request.getParameter("end")!=null){
			response.sendRedirect("Logout");
			return;
		}
		
		if(request.getParameter("caseNumber")!=null){
			String seatNumber = request.getParameter("caseNumber");
			game.openCase(Integer.parseInt(seatNumber));
			int casesOpened = game.getCasesOpened(); 

			
			switch (casesOpened){
				case 4: 
						url = "/WEB-INF/jsp/bankOffer.jsp";
						break;
				case 7: 
						url = "/WEB-INF/jsp/bankOffer.jsp";
						break;
				case 9: 
						url = "/WEB-INF/jsp/bankOffer.jsp";
						break;
				case 10: 
						url = "/WEB-INF/jsp/bankOffer.jsp";
						break;
				case 11:request.getSession().setAttribute("moneyOffer", game.getMoney());
						user.endGame();
						request.getSession().setAttribute("game", null);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/cashout.jsp");
						dispatcher.forward(request, response);
						return;
			}
			
		}
		
		request.getSession().setAttribute("inGame", true);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}
	
}
