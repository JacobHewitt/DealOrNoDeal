package game.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

// This class represents the user. It holds a GameModel object which contains their game data.

public class User implements Serializable{
	
	private String name;
	private GameModel gameData; //game data
	
	//must have no argument constructor (java bean)
	public User(){
		
	}
	
	//set name constructor
	public User(String input){
		name = input;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String input){
		name = input;
	}
	
	public boolean isLoggedIn(){
		if(name == null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean canResume(){
		if(gameData!=null){
			return true;
		}else{
			return false;
		}
	}
	
	//restart/start new game for the user.
	public void newGame(){
		gameData = new GameModel();
	}
	
	//end users game.
	public void endGame(){
		gameData = null;
	}
	
	//return the GameModel object
	public GameModel getGame(){
		return gameData;
	}
	
}