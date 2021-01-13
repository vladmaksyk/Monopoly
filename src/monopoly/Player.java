package monopoly;


interface Player {
	/* Player stuff */
	void addProperty(Square square);

	void move(int numSpaces);

	void moveTo(int pos);

	int position();

	Iterable<Square> properties();

	String name();

	int getMoney();

	void toJail();

	boolean stayJail();

	void sellProp(Square sq);

	void leaveJail();

	boolean inJail();

	void addJailFree(boolean chance);

	void useJailFree();
	
	
	int numJailFree();

	int getAssets();

	/* Input stuff */
	boolean inputBool();

	int inputInt(Monopoly.State state);

	int inputDecision(Monopoly.State state, String[] choices);

	Player inputPlayer(Monopoly.State state, Player notAllowed);

	boolean lost();

	void setLost(boolean b);

	void withdrawMoney(int amount);

	void depositMoney(int amount);

	

	
}
