
relationships among objects and their purpose:

	GameUsers:
		This object is initialized on application start-up. It has a List of User objects which
		can be checked to see if the user logging in is a return user or a new user.
	
	User:
		This object is used to represent each user in the game. The unique identifier for each user is the
		'username' String. It also contains a GameModel object which contains the individual users game.
	
	GameModel:
		This object is used to represent the game. It's constructor initializes all of the Case objects and holds them in a random order.
	
	Case:
		This object is used to represent each case in the game. It holds a value and a boolean to show if it is open or not.
	
servlets:
	
	LoginController:
		This servlet is called when the user logs in. It either returns a user from the 'GameUsers' object or creates a new 'User' object and
		and adds it to the 'GameUsers' object. The User object is also used as a way of session tracking.
		
	NewGameController:
		This servlet is called when the user starts a new game. It calls the method to reset the users 'GameModel' object within the 'User' object
		It also has a method to return the 'GameModel' object.
	
	ResumeGameController:
		This servlet is called when the user chooses to resume their game. It retrieves the 'GameModel' object from the 'User' object and sets it
		as a Session variable. 
		
	GameController:
		This servlet is called when the user is playing their game. It checks that the user is currently in a game and forewards them to the 
		correct jsp pages. (bank offers depending on round)
		
	SaveGameController:
		This servlet is called when the user wishes to save their game at the end of a round. It deletes the users 'GameModel' session variable
		and returns them to the homepage where they have the option to start a new game or resume their game.
		
	LogoutController:
		This servlet is called when the user logs out. It deletes all of the Users session variables so they are completely logged out of the 
		application.
		
Session tracking:
	I have implements session tracking by creating a session variable associated with the user. This gets deleted (set 'null') when the users logs out.
	
	request.getSession().setAttribute("user", user);
	
Game Saving:
	The game saves its Users and Users Games by having a GameUsers object. This object is initialized on the applications start-up. As long as the
	application keeps running on the server it will have this information stored. 

Undergraduate

C3218832_assignment2/
or
C3218832_assignment2/index.jsp
	
	