package monopoly;
import java.util.ArrayList;
/**Created by Vladyslav Maksyk */
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class HumanPlayer implements Player {
	private final String playerName;
	
	private final Input input;
	private final Queue<Square> properties;
	private final ArrayList<Card> cards;
	
	private final int TO_JAIL = 30;
	private final int IN_JAIL = 10;

	private int money;
	private int position;
	private int jailTurn;
	private int numJailFree;
	public int firstDiceRoll;
	
	private boolean inJail;
	private boolean chanceFree;
	public boolean lost;

	public HumanPlayer(String Name) {
		playerName = Name;
		
		input = new Input();
		properties = new LinkedList<>();
		cards = new ArrayList<>();
		
		money = 1500;
		position = 0;
		jailTurn = 0;
		numJailFree = 0;
		
		inJail = false;
		chanceFree = false;
		lost = false;		
	}

	public void addProperty(Square square) {
		if (!square.isOwnable())
			throw new IllegalArgumentException("This property cannot be purchased!");
		properties.add(square);
		square.purchase(this);
	}

	public void move(int numSpaces) {
		position += numSpaces;
		int BOARD_SIZE = 40;
		if (position >= BOARD_SIZE) {
			position -= BOARD_SIZE;
			depositMoney(200);
		}

		if (position == TO_JAIL) {
			position = IN_JAIL;
			toJail();
		}
	}

	public void moveTo(int pos) {
		if (pos < position && !inJail)
			depositMoney(200);
		position = pos;

		if (position == TO_JAIL) {
			position = IN_JAIL;
			toJail();
		}
	}

	public int position() {
		return position;
	}

	public Queue<Square> properties() {
		return properties.stream().collect(Collectors.toCollection(LinkedList::new));
	}

	public String name() {
		return playerName;
	}

	public int getMoney() {
		return money;
	}

	
	public void withdrawMoney(int amount) {
		if(money>=amount) {
			money -=amount;
		}
	}
	
	public void depositMoney(int amount) {
		this.money +=amount;
	}

	public void toJail() {
		inJail = true;
		//move(40);
		jailTurn = 0;
	}

	public boolean stayJail() {
		jailTurn++;
		if (jailTurn == 3) {
			inJail = false;
			return false;
		}
		return true;
	}
	

	public void sellProp(Square sq) {
		properties.remove(sq);
	}

	public void leaveJail() {
		inJail = false;
		//moveTo(10);
	}

	public boolean inJail() {
		return inJail;
	}

	public void addJailFree(boolean chance) {
		numJailFree++;
		chanceFree = chance;
	}

	public void useJailFree() {
		numJailFree--;
	}

	public int numJailFree() {
		return numJailFree;
	}

	public int getAssets() {
		int assets = this.money;
		for (Square s : properties) {
			assets += s.cost();
			if (s instanceof Property)
				assets += getHouseVal((Property) s);
		}
		return assets;
	}

	private int getHouseVal(Property prop) {
		int numHouses = prop.numHouses();
		int houseCost = prop.houseCost();

		return numHouses * houseCost;
	}

	public boolean inputBool() {
		return input.inputBool();
	}

	public int inputInt(Monopoly.State state) {
		return input.inputInt();
	}

	public int inputDecision(Monopoly.State state, String[] choices) {
		return input.inputDecision(choices);
	}

	public Player inputPlayer(Monopoly.State state, Player notAllowed) {
		return input.inputPlayer(state.players, notAllowed);
	}
	
	public boolean lost() {
		return lost;
	}
	
	public void setLost(boolean status) {
		lost = status;
	}


}