package monopoly;

public class Utility implements Square {
	private final int COST = 150; //cost to purchase utility

	private final Dice dice;
	private final String name;
	private final int pos;
	private Player owner;     //stores utility owner
	private boolean owned;  //is utility owned?
	private int numOwned; //number of utilities owned by a player
	private boolean mortgaged; //is property mortgaged?
	private Utility other;

	//utility constructor
	public Utility(String name, int pos) {
		numOwned = 0;
		mortgaged = false;
		this.name = name;
		this.pos = pos;
		this.dice = new ProbDice();
	}

	public void setOther(Utility other) {
		this.other = other;
	}

	public int increasedRent() {
		return 10 * dice.roll().val;
	}

	public int position() {
		return pos;
	}

	public String name() {
		return name;
	}

	public boolean isOwnable() {
		return true;
	}

	//update status of property to owned
	public void purchase(Player player) {
		owned = true;
		owner = player;
		numOwned = 1;

		for (Square sq : player.properties())
			if (sq instanceof Utility)
				numOwned++;
	}

	//return rent on utility, given a roll
	public int rent(int roll) {
		if (roll == 0)
			roll = dice.roll().val;

		int TWO = 10;
		if (owner.equals(other.owner()))
			return TWO * roll;

		int ONE = 4;
		return ONE * roll;
	}

	//return total utilities owned by player owning this utility
	public boolean isOwned() {
		return owned;
	}

	//return player object of owner
	public Player owner() {
		return owner;
	}

	//return cost to purchase utility
	public int cost() {
		return COST;
	}

	//mortgage property
	public int mortgage() {
		if (mortgaged) {
			mortgaged = false;
			return (int) Math.round((COST / 2) * 1.1);
		} else {
			mortgaged = true;
			return COST / 2;
		}
	}

	public boolean isMortgaged() {
		return mortgaged;
	}

	public int mortgageCost() {
		return COST / 2;
	}

	public String toString() {
		return name;
	}
}