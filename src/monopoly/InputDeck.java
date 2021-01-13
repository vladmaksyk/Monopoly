package monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InputDeck implements Deck {
	private final ArrayList<Card> deck; //store array of cards
	private final Input input;  //store current card
	private int SIZE; //store number of cards

	//create shuffled deck of cards
	public InputDeck() {
		deck = new ArrayList<>();
		input = new Input();
	}

	public void initialize(Card[] cards) {
		if (!deck.isEmpty())
			return;

		SIZE = cards.length;
		deck.addAll(Arrays.asList(cards));
		Collections.shuffle(deck);
	}

	//draw next card from deck
	public Card drawCard() {
		System.out.println("Please select appropriate card.");
		for (int i = 0; i < SIZE; i++) {
			Card card = deck.get(i);
			System.out.println(i + ") " + card.textA());
		}

		int card = -1;
		while (card < 0) {
			card = input.inputInt();
			if (card < 0 || card >= SIZE) {
				System.out.println("Invalid decision. Enter a valid number.");
				card = -1;
			}
		}

		return deck.get(card);
	}

	public void returnOutOfJail() {
	}

	public Iterable<Card> cards() {
		return new ArrayList<>(deck);
	}
}
