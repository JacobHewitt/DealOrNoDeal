package game.config;
import game.models.GameUsers;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//This class gets ran on application start-up. I create my GameUsers object to keep a list of all of the users in the system.

@WebListener
public class Setup implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		//create instance of GameUsers to hold all of the users in the application.
		GameUsers users = new GameUsers();
		servletContextEvent.getServletContext().setAttribute("users", users); //make it accessible.
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
