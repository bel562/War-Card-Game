package War;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 *  models a deck object to be use to build a deck of cards,
 *  shuffle the deck, or draw a card from deck.
 *  @author MANUEL BELTRAN
 * **/
public class Deck {
	
	private ArrayList<String> faces = new ArrayList<String>(Arrays.asList("Ace", "2",
			"3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"));
	private ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Spades", 
			"Clubs", "Diamonds", "Hearts"));
	private ArrayList<Card> deck;
    
	/**
	 * creates an empty ArrayList of Card objects
	 * **/
	public Deck() {deck = new ArrayList<Card>();}
	
	/**
	 * creates a new deck of 52 card objects
	 * **/
    public void buildDeck() { 
        ArrayList<Card> newDeck = new ArrayList<Card>();
        for (int j = 0; j < faces.size(); j++) {
        	for (int i = 0; i < suits.size(); i++) {
                Card card = new Card(faces.get(j), suits.get(i));
                newDeck.add(card);
                card.determineCardValue();

            }
        }
        deck = newDeck;
    }
    /**
	 * takes a deck and shuffles the order of card objects in the ArrayList
	 * **/
    public void shuffleDeck(){
        ArrayList<Card> newShuffledDeck = new ArrayList<Card>();
        int k = 0;
        while (deck.size() > 0) {
            Random random  = new Random();
            k = random.nextInt(deck.size());
            Card removedCard = deck.remove(k);
            newShuffledDeck.add(removedCard);
        }
      deck = newShuffledDeck;

    }
    /**
	 * removes a Card object from a deck and returns it
	 * @return drawnCard - the first Card object in the deck ArrayList
	 * **/
    public Card drawCard() {
    	if (deck.size() < 1 ) {
    		System.out.println("Out of cards. Building new deck and shuffling...");
    		buildDeck();
    		shuffleDeck();
    	}
    	Card drawnCard = deck.get(0);
    	deck.remove(0);
    	return drawnCard;
    }
    
    /**
	 * adds a Card object to the deck
	 * @param card - Card object to get added to the end of the deck
	 * **/
    public void addCard(Card card) {deck.add(card);}
    
    /**
   	 * getter method for the deck
   	 * @return deck - the ArrayList of Card objects
   	 * **/
    public ArrayList<Card> getDeck() {return deck;}
}

