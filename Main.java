import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: Eduard Le Roux
 */

public class Main {

	/**
	 * Main method where the deck is created, players draw cards and a new card pile
	 * is created
	 */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Deck deck = Deck.getDeck();
		int currentPlayer = 0;
		// deck.print();
		System.out.println("Drawing phase player 1");
		Player player1 = new Player(deck.draw(5));

		System.out.println("Drawing phase player 2");
		Player player2 = new Player(deck.draw(5));

		System.out.println("Drawing phase player 3");
		Player player3 = new Player(deck.draw(5));

		System.out.println("Drawing phase player 4");
		Player player4 = new Player(deck.draw(5));

		deck = Deck.getDeck();

		System.out.println("Players playing their cards");

		// Creating a card pile and drawing from the deck
		CardPile cardPile = new CardPile();
		cardPile.addCard(deck.draw());
		cardPile.addCard(deck.draw());
		cardPile.addCard(deck.draw());

		// Creating of players and adding them to the playerlist
		// With more players create more players and change the game loop to x amount of
		// players
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		int i = 0;
		while (true) {
			for (i = currentPlayer; i < players.size(); i++) {

				// If the loop gets to the last player, the loop starts again at the first
				// player
				if (i >= 3) {
					currentPlayer = 0;
				}
				System.out.println("-----CardPile-----");
				cardPile.show();
				System.out.println("^^^^^Last card that was played^^^^^^");
				System.out.println("------------------");
				players.get(i).print();

				System.out.println("-------------------------------------------------");
				System.out.println("Please choose a card to play: Player " + (i + 1));
				System.out.println("0 - first card, 1 - second card, 2 - third card");
				System.out.println("-------------------------------------------------");
				System.out.println("Enter 15 to draw a card");
				System.out.println("-------------------------------------------------");
				System.out.println("Please press enter twice after entering choice");
				System.out.println("-------------------------------------------------");
				System.out.println("Current size of the deck");
				deck.size();
				System.out.println("-------------------------------------------------");

				int playerChoice = userInput.nextInt();
				try {
					// if the player wants to draw a card
					if (playerChoice == 15) {
						players.get(i).addCard(deck.draw());
						currentPlayer = i;
						break;
					}

					// Checks whether the card is playable, checking the card suit and number
					else if ((cardPile.check(players.get(i).showCard(playerChoice)))) {
						cardPile.addCard(players.get(i).playCard(playerChoice));
					} else {
						// the currentPlayer = i is to avoid the loop to continue to the next player
						System.out.println("Invalid play");
						currentPlayer = i;
						break;
					}
					// Check whether player has 0 cards and prints out the winner, closes
					// application afterwards
					if (players.get(i).handSize() == 0) {
						System.out.println("Congratulaions! player" + (i + 1) + " has won!");
						System.exit(0);
						userInput.close();
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}

}
