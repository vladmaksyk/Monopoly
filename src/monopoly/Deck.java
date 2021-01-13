package monopoly;


interface Deck {
	Card drawCard();

	void initialize(Card[] cards);

	void returnOutOfJail();

	Iterable<Card> cards();
}
