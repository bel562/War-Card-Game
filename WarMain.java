package War;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  models a game of War using the Deck, Card, and Player Class
 *  @author MANUEL BELTRAN
 * **/
public class WarMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//make two players
		Player player1 = new Player();
		Player com1 = new Player();
		
		//make deck
		Deck deck = new Deck();
		deck.buildDeck();
		//shuffle deck
		deck.shuffleDeck();
		
		//draw 26 cards each
		while (deck.getDeck().size() > 0) {
			player1.addPlayerHand(deck.drawCard());
			com1.addPlayerHand(deck.drawCard());
		}
		
		//initialize continue flag
		String Continue = "y";
		
		while(Continue == "y") {
			//war round:
			while(player1.getPlayerHandSize() > 0 && com1.getPlayerHandSize() > 0) {
				//both players play a card.
				Card card1 = player1.playCard();
				Card card2 = com1.playCard();
				System.out.println("You played "+card1+"\nComputer played "+ card2 +"\n");
				
				
				//path 1:
				//player with the lowest value has 2 choices.
				if (card1.getCardValue() < card2.getCardValue()) {
					System.out.println("Your total value is lower.");
					System.out.println("You have 2 choices.\nChoice 1: play next card. \nChoice 2: surrender cards. "
							+ "\nPress '1' or any key for other choice: ");
					String choice = in.nextLine();
					
					//choice 1: play next card.
					if( choice == "1") {
						Card card3 = player1.playCard();
						System.out.println("You played: " + card3);
						System.out.println("Total value equals " + (card3.getCardValue()+card1.getCardValue()) + ".");
						//if total value is lower or equal, receive all 3 cards.
						if((card3.getCardValue()+card1.getCardValue()) >= card2.getCardValue()) {
							System.out.println("Your total value is higher.\nYou recieve all cards.");
							player1.addPlayerHand(card1);
							player1.addPlayerHand(card2);
							player1.addPlayerHand(card3);
						}
						
						//if total value is higher, lose all 3 cards to opponent.
						else {
							System.out.println("Your total value is lower.\nYou lose all cards.");
							com1.addPlayerHand(card1);
							com1.addPlayerHand(card2);
							com1.addPlayerHand(card3);
						}
					}
					//choice 2: surrender both 2 cards.
					else {
						System.out.println("You surrendered your card.");
						com1.addPlayerHand(card1);
						com1.addPlayerHand(card2);
					}
				}
				
				//choice 2(computer's choice): surrender both 2 cards.
				else if(card1.getCardValue() > card2.getCardValue()) {
					System.out.println("Your card value is higher");
					player1.addPlayerHand(card1);
					player1.addPlayerHand(card2);
					System.out.println("Computer chooses to surrender\nYou recieved both cards! ");
				}
				
				//path 2:played cards are equal.
				else if(card1.getCardValue() == card2.getCardValue()) {
					//make a pile of cards to be given to winner
					ArrayList<Card> pile= new ArrayList<Card>();
					pile.add(card1);
					pile.add(card2);
					
					//repeat path 2 if face up are equal
					//or player doesn't have enough cards to continue.
					//player with higher value wins all.
					//winner of round gets all cards to bottom of deck.
					while(card1.getCardValue() == card2.getCardValue() && player1.getPlayerHandSize() > 3 
							&& com1.getPlayerHandSize() > 3 ) {
						System.out.println("Both cards' values are equal. Must play 2 cards facedown and 1 face up.");
						if(player1.getPlayerHandSize() <= 3){
							System.out.println("Not enough cards to play match.");
							player1.resetHand();
						}
						else if(com1.getPlayerHandSize()  <= 3) {
							System.out.println("Not enough cards to play match.");
							com1.resetHand();
						}
						else {
							//2 cards face down then 1 face up.
							pile.add(player1.playCard());
							pile.add(player1.playCard());
							pile.add(com1.playCard());
							pile.add(com1.playCard());
							
							card1 = player1.playCard();
							card2 = com1.playCard();
							pile.add(card1);
							pile.add(card2);
							System.out.println("You played 2 cards and "+card1+"\nComputer played 2 cards and "+ card2);
						}						
					}
					//player collects pile
					if ( card1.getCardValue() > card2.getCardValue()) {
						System.out.println("You win all " + pile.size() + " cards!");
						for (int i = 0; i < pile.size(); i++) {
							player1.addPlayerHand(pile.get(i));
						}
					}
					//computer collects pile
					else if ( card1.getCardValue() < card2.getCardValue()) {
						System.out.println("Computer wins all " + pile.size() + " cards!");
						for (int i = 0; i < pile.size(); i++) {
							com1.addPlayerHand(pile.get(0));
						}
					}
				}
				//display amount of cards holding at the end of each round
				System.out.println("Your card amount: " + player1.getPlayerHandSize());
				System.out.println("Computer's card amount: " + com1.getPlayerHandSize() +"\n");
			}
			//loser is player with no cards
			if(com1.getPlayerHandSize() == 0) {
				System.out.println("Opponent ran out of Cards.\nCongrats you win!");
				player1.addWins(1);
			}
			else {
				System.out.println("You ran out of Cards.\nSorry you lose...");
				player1.addLost(1);
			}
			//give choice to continue another game of War
			System.out.println(player1);
			System.out.println("Do you wish to continue?\n'y' to continue:");
			Continue = in.nextLine();
		}
		in.close();
	}
}
