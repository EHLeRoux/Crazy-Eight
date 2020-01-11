import java.util.ArrayList;

public class Player {

	ArrayList<Card> hand = new ArrayList<Card>();

	/**
	 * 
	 * @param drawnCards takes in an arraylist of drawn cards and adds it to the
	 *                   player's hand
	 */
	Player(ArrayList<Card> drawnCards) {
		hand = drawnCards;
	}

	/**
	 * Prints out the current players hand
	 */
	public void print() {

		for (Card card : hand) {
			card.print();
		}
	}

	/**
	 * 
	 * @param n stipulates the position of the card in the players hand
	 * @return removes the card from the players hand, and returns the card chosen
	 */
	public Card playCard(int n) {
		Card playedCard = hand.get(n);
		hand.remove(playedCard);
		return playedCard;
	}

	/**
	 * @param n stipulates the position of the card in the players hand, shows it to
	 *          check whether the card is a valid play or not
	 * @return returns the chosen card
	 */
	public Card showCard(int n) {
		Card playedCard = hand.get(n);
		playedCard.print();
		return playedCard;
	}

	/**
	 * @param card simply adds a card to the players hand
	 */
	public void addCard(Card card) {
		hand.add(card);
	}

	public int handSize() {
		int size = hand.size();
		return size;
	}

}
