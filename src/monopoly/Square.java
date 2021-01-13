package monopoly;
 
public interface Square {
	int position();

	String name();

	boolean isOwnable();

	boolean isOwned();

	boolean isMortgaged();

	int cost();

	void purchase(Player player);

	int rent(int val);

	int mortgageCost();

	int mortgage();

	Player owner();

	String toString();
}
