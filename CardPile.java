import java.util.ArrayList;

import java.util.Scanner;



public class CardPile {
	ArrayList<Card> cardPile = new ArrayList<Card>();
	Scanner userSuitChange = new Scanner(System.in);

	/**
	 * 
	 * @param drawnCard takes in a card that has been played and adds it to the
	 *                  cardpile
	 */
	public void addCard(Card drawnCard) {

		cardPile.add(drawnCard);
	}

	/**
	 * Shows the card, instead of playing the card to determine whether the card
	 * will be a valid move
	 */
	public void show() {
		for (Card card : cardPile) {
			card.print();
		}

		// Removing cards from the cardPile to keep it small on the screen
		while (cardPile.size() >= 3) {
			cardPile.remove(0);
		}

	}

	/**
	 * 
	 * @param playedCard Checks the card that the player wants to play to the last
	 *                   card of the cardPile list
	 * @return
	 */
	public boolean check(Card playedCard) {

		if (playedCard.getCurrentNumber() == 8) {
			crazyEight(playedCard);
		}

		if (playedCard.getCurrentSuit() == cardPile.get(1).getCurrentSuit()
				|| playedCard.getCurrentNumber() == cardPile.get(1).getCurrentNumber()) {
			return true;
		} else {
			return false;
		}

	}

	public void crazyEight(Card crazyEight) {
		System.out.println("To what suit do you want to change? H | D | C | S");
		String choice = userSuitChange.next();

		if (choice.equals("H")) {
			cardPile.get(1).setCurrentSuit(Suit.HEARTS);
			crazyEight.setCurrentSuit(Suit.HEARTS);

		}
		if (choice.equals("D")) {
			cardPile.get(1).setCurrentSuit(Suit.DIAMONDS);
			crazyEight.setCurrentSuit(Suit.DIAMONDS);
		}
		if (choice.equals("C")) {
			cardPile.get(1).setCurrentSuit(Suit.CLUBS);
			crazyEight.setCurrentSuit(Suit.CLUBS);
		}
		if (choice.equals("S")) {
			cardPile.get(1).setCurrentSuit(Suit.SPADES);
			crazyEight.setCurrentSuit(Suit.SPADES);
		}

	}

}
