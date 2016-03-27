package game.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Random;
import java.util.Arrays;

/* This class is used to create an object of the game inside of the User object.
 * It contains all the methods to start the game and to play it.
 * 
*/

public class GameModel implements Serializable{

	private List<Case> cases; // List of Case objects
	private double money; // Total money so far
	private int round; // Round Number
	private int casesOpened; // Number of cases opened
	private int casesLeftThisRound; // Number of cases left this round.
	
	//This constructor method initializes all the variables and calls the sortCases() method.
	public GameModel(){
		cases = new LinkedList<>();
		money = 0;
		round = 1;
		casesOpened = 0;
		casesLeftThisRound = 0;
		sortCases();
	}
	
	// This method randomly assigns the values from the array 'values' into the list 'caseValues'
	// This list is then looped through and the value is added to each case in the 'cases' List. 
	// The values added are also removed from 'caseValues' to prevent duplicates.
	private void sortCases(){
		double[] values = {0.5, 1, 10, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000}; //initial values to be implemented into cases.
		List<Double> caseValues = new LinkedList<Double>(); //temporary List to add and remove above values.
		for(int x = 0; x < values.length; x++){ //Loop through the length of the array.
			caseValues.add(values[x]); //add value from array into List.
		}
		
		for(int x = 0; x < values.length; x++){ //Loop through length of the array.
			Random rand = new Random();
			int temp = rand.nextInt(caseValues.size()); //generate a random integer within range of the size of the List 'caseValues'
			double caseValue = caseValues.get(temp); //get the value of the number at that index in the list.
			caseValues.remove(temp); //remove the item at that index in the list.
			Case toAdd = new Case(caseValue); //create a new Case with the value.
			cases.add(toAdd); //add the Case to the 'cases' List.
		}
	}
	
	// This method returns a boolean if the case referred to by the parameter is open or not.
	public boolean isCaseOpen(int caseNumber){
		Case temp = cases.get(caseNumber); //get case referred to by input parameter.
		if(temp == null){ //check if case exists.
			return false;
		}else{
			if(temp.isOpened() == false){ //check if case has been opened or not.
				return false;
			}else{
				return true;
			}
		}
		
	}
	
	//return the number of cases created.
	public int numOfCases(){
		int toReturn = 0;
		for(Case c : cases){
			toReturn++;
		}
		return toReturn;
	}
	
	//return the number of cases left
	public int getCasesLeft(){
		int toReturn = 12;
		return (toReturn - casesOpened);
	}
	
	//This function opens the case referred to by the input parameter on the 'cases' List
	public void openCase(int input){
		if(cases.get(input).isOpened()==true){ //check if case is already open.
			return;
		}else{
			casesOpened++;
			cases.get(input).setOpened(); //set case as open.
			
			//This function sets the correct round depending on how many cases have been opened.
			if(casesOpened >=11){
				round = 5;
			}else if(casesOpened >= 10){
				round = 5;
			}else if(casesOpened >= 9){
				round = 4;
			}else if(casesOpened >= 7){
				round = 3;
			}else if(casesOpened >=4){
				round = 2;
			}
		}
	
	}
	
	//This function returns the Money offer (used at the end of each round)
	public Double getMoney(){
		double toReturn = 0;
		for(Case c : cases){ //loop through all cases.
			if(c.isOpened() == false){ //check if they are not open.
				toReturn+=c.getValue(); //get case value and add it to the variable 'toReturn'.
			}
		}
		toReturn=toReturn/getCasesLeft(); //divide the 'toReturn' variable by the number of cases left.
		return toReturn;
	
	}
	
	//This function returns the number of cases left to open this round.
	public int getCasesLeftThisRound(){
		int toReturn = 0;
		switch(round){
			case 1: toReturn = (4-casesOpened);
					break;
			case 2: toReturn = (7-casesOpened);
					break;
			case 3: toReturn = (9-casesOpened);
					break;
			case 4: toReturn = (10-casesOpened);
					break;
			case 5: toReturn = (11-casesOpened);
					break;
		}
		return toReturn;
	}
	
	//This function returns the value of the case referred to by the input parameter.
	public Double getCaseValue(int caseNumber){
		return cases.get(caseNumber).getValue();
	}
	
	//This function returns the 'cases' list
	public List<Case> getCases(){
		return cases;
	}
	
	//This function returns the variable 'casesOpened'
	public int getCasesOpened(){
		return casesOpened;
	}
	
	//This function returns the 'round' variable.
	public int getRound(){
		return round;
	}
}