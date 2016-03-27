package game.models;

import java.io.Serializable;

// This class is used to represent cases in the game.
// each object created from this class will represent a single case.

public class Case implements Serializable{
	private boolean opened;
	private double value;
	
	public Case(double value){
		opened = false;
		this.value = value;
	}
	
	public void setOpened(){
		opened = true;
	}
	
	public boolean isOpened(){
		return opened;
	}
	
	public Double getValue(){
		return value;
	}
	
}