
public class Card {
	private int currentNumber;
	private Suit currentSuit;

	/**
	 * 
	 * @param suit   determines the suit of the card
	 * @param number determines the number of the card
	 */
	public Card(Suit suit, int number) {
		currentSuit = suit;
		if ((number < 2) || (number > 14)) {
			System.out.println("Invalid number");
		}

		currentNumber = number;
	}

	/**
	 * Function that prints out all the cards of the deck
	 */
	public void print() {

		switch (currentNumber) {

		case 11:
			System.out.println("Jack");
			break;
		case 12:
			System.out.println("Queen");
			break;
		case 13:
			System.out.println("King");
			break;
		case 14:
			System.out.println("Ace");
			break;
		default:
			System.out.println(currentNumber);
			break;
		}
		System.out.println("   OF   ");

		switch (currentSuit) {
		case HEARTS:
			System.out.println("HEARTS\n");
			break;
		case SPADES:
			System.out.println("SPADES\n");
			break;
		case DIAMONDS:
			System.out.println("DIAMONDS\n");
			break;
		case CLUBS:
			System.out.println("CLUBS\n");
			break;
		}

	}

	/**
	 * Getters and setters for the card number and the suit
	 */

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	public Suit getCurrentSuit() {
		return currentSuit;
	}

	public void setCurrentSuit(Suit currentSuit) {
		this.currentSuit = currentSuit;
	}

}
