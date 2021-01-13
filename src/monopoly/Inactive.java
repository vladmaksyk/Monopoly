package monopoly;

public class Inactive implements Square {
	private final int pos;
	private final String name;

	public Inactive(String name, int pos) {
		this.name = name;
		this.pos = pos;
	}

	public int position() {
		return pos;
	}

	public String name() {
		return name;
	}

	public boolean isOwnable() {
		return false;
	}

	public boolean isOwned() {
		return false;
	}

	public int mortgage() {
		return 0;
	}

	public boolean isMortgaged() {
		return false;
	}

	public int mortgageCost() {
		return 0;
	}

	public int cost() {
		return 0;
	}

	public void purchase(Player player) {
	}

	public int rent(int val) {
		return 0;
	}

	public Player owner() {
		return null;
	}

	public String toString() {
		return name;
	}
}