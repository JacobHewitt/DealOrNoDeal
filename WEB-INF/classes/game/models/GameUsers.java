package game.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* This Class stores all of the User objects
 * It is initialized on application start-up.
*/

public class GameUsers implements Serializable {

	private List<User> users; //List of all user objects.
	
	public GameUsers(){
		users = new LinkedList<>(); //initialize the List of all User objects.
		
	}
	
	// This function allows the User object passed as a parameter to be added to the 'users' list.
	public void addUser(User newUser){
		users.add(newUser); //add user to list.
	}
	
	//This function is used to return the User object referred to by the username string passed in the parameter.
	public User returnUser(String userName){
		User toReturn = null;
		for(User user:users){ //loop through all users in the List.
			if(userName.equals(user.getName())){ //check if current user being looped through has the same username as the parameter.
				toReturn = user; //assign the current user to the toReturn variable.
				break; 
			}
		}
		return toReturn;
		
	}





}