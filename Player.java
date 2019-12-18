package War;

import java.util.ArrayList;
/**
 *  models a Player object to be use to emulate a player's attributes,
 *  such as holding and play cards, as well as, wins and losses.
 *  @author MANUEL BELTRAN
 * **/
public class Player {
	
	private ArrayList<Card> playerHand;	
	private int winsTotal;	
	private int lostTotal;

	/**
	 * creates an empty ArrayList of Card objects and initializes win and loss total
	 * **/
	public Player() { 
		playerHand = new ArrayList<Card>();
		winsTotal = 0;
		lostTotal = 0;
		}
	
	/**
	 * Method to get player's hand
	 * @return playerHand - ArrayList of Card objects
	 * **/
	public ArrayList<Card> getPlayerHand(){ return playerHand;}
	
	/**
	 * Method to get player's win count
	 * @return winsTotal - total amount of wins
	 * **/
	public int getWins() {return winsTotal;}
	
	/**
	 * Method to change player's win count
	 * @param x - amount to change wins by
	 * **/
	public void addWins(int x) { winsTotal = winsTotal + x;}
	
	/**
	 * Method to get player's loss count
	 * @return lostTotal - total amount of losses
	 * **/
	public int getLost() {return lostTotal;}
	
	/**
	 * Method to change player's loss count
	 * @param x - amount to change losses by
	 * **/
	public void addLost(int x) { lostTotal = lostTotal + x;}
	
	/**
	 * Method to get amount of Card objects in player's 'hand'
	 * @return playerHand.size() - total amount of Card objects
	 * **/
	public int getPlayerHandSize() { return playerHand.size(); } 

	/**
	 * Method to add Card object to player's hand
	 * @param card - Card object
	 * **/
	public void addPlayerHand(Card card) { playerHand.add(card);}
	
	/**
	 * Method to play player's first Card then remove from hand
	 * @return card - Card object
	 * **/
	public Card playCard() { 
		Card card = playerHand.get(0);
		playerHand.remove(0);
		return card;
		}
	
	/**
	 * Method to rest player's hand
	 * **/
	public void resetHand() { playerHand = new ArrayList<Card>();}

	/**
	 * Default message that this prints
	 * @return String - Total win and lost count
	 * **/
	public String toString() {
		return ("Total wins: " + winsTotal + "\nTotal lost: "+ lostTotal);
	}
}

