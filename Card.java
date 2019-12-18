package War;
/**
 *  models a Card object to be use to emulate a playing card,
 *  such as having a face and suit. Each card has a int value.
 *  @author MANUEL BELTRAN
 * **/
public class Card {
	
	private String face;
	private String suit;
	private int value;
	private boolean ace;

	/**
	 * creates an face and suit object and initializes value and ace boolean
	 * @param cardFace - face of a card
	 * @param cardSuit - suit of a card
	 * **/
	public Card(String cardFace, String cardSuit){
		face = cardFace;
		suit = cardSuit;
		value = 0;
		ace = false;
	}
	
	/**
	 * Method with set change Card object's value to 1, generally an Ace
	 * **/
	public void AceValuetoOne() { value = 1; }
	
	/**
	 * Method with set change Card object's value to 11, generally an Ace
	 * **/
	public void AceValuetoEleven() { value = 11; }
	
	/**
	 * Method to check object's ace boolean value
	 * @return ace - boolean value that determines if object is an ace
	 * **/
	public boolean isAce() { return ace; }
	
	/**
	 * Object's default print
	 * @return String - Gives the face,suit, and value status of this object
	 * **/
	public String toString(){ 
		return (face + " of " + suit + 
				", Value: " + value);
	}
	
	/**
	 * Determines what the value of this Card object is based on the face
	 * **/
	public void determineCardValue() {
		if (face == "Jack" || face == "Queen" || face == "King"){
			setValue(10);
		}
		else if (face == "Ace"){
			ace = true;
			AceValuetoEleven();
		}
		else {
			int faceToValue = Integer.parseInt(face);
			setValue(faceToValue);
		}
	}
	
	/**
	 * Gets the Card object's value
	 * @return value - the point value of a Card object
	 * **/
	public int getCardValue() { return value; }
	
	/**
	 * Method to set Card object's value to preferred amount
	 * @param resetValue - new value amount to reset value as
	 * **/
	public void setValue(int resetValue) { value = resetValue; }
}

