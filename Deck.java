import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Deck {
	private List<Card> cards;
	private static Deck deck = new Deck();

	/**
	 * Creating of a new deck, using the suit enum and running through all the
	 * possible combinations Filling the deck with 52 cards
	 */
	Deck() {
		cards = new ArrayList<Card>();

		Suit[] suits = { Suit.CLUBS, Suit.HEARTS, Suit.DIAMONDS, Suit.SPADES };
		for (Suit suit : suits) {
			for (int i = 2; i < 15; i++) {
				cards.add(new Card(suit, i));
			}
		}

		// Randomizing the deck of cards
		Collections.shuffle(cards, new Random());

	}

	public static Deck getDeck() {
		return deck;
	}

	/**
	 * Method that prints the current deck
	 */
	public void print() {
		System.out.println("Current Deck size:" + cards.size());
		for (Card card : cards) {
			card.print();
		}
	}

	/**
	 * 
	 * @param cardsDrawn takes in amount of cards drawn and draws that amount from
	 *                   the deck
	 * @return returns an arrayList of the cards drawn
	 */
	public ArrayList<Card> draw(int cardsDrawn) {

		ArrayList<Card> drawn = new ArrayList<Card>();
		for (int i = 0; i < cardsDrawn; i++) {
			Card removedCard = cards.remove(i);

			drawn.add(removedCard);
		}
		return drawn;

	}

	/**
	 * Draws one card from the deck
	 * 
	 * @return returns the drawn card
	 */
	public Card draw() {

		Card removedCard = cards.remove(0);

		return removedCard;

	}

	public void size() {
		System.out.println(cards.size());
	}

}
