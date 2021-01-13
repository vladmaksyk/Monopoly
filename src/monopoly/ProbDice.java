package monopoly;

import java.util.Random;
import java.util.Scanner;

public class ProbDice implements Dice {
	private final int N; //number of dice
	private final int SIDES; //number of sides per die
	private final Random rand;

	//single six-sided die
	public ProbDice() {
		N = 2;
		SIDES = 6;
		rand = new Random();
	}

	//return number of dice
	public int numDice() {
		return N;
	}

	//return sides per die
	public int sides() {
		return SIDES;
	}

	public Roll roll() {
		Scanner scanner = new Scanner(System.in);
		Roll roll = new Roll();
		System.out.println("Enter two dice rolls");
		int randA = Integer.parseInt(scanner.nextLine());//rand.nextInt(6) + 1;

		int randB = Integer.parseInt(scanner.nextLine());//rand.nextInt(6) + 1;
		roll.is_double = randA == randB;

		roll.val = randA + randB;

		return roll;
	}
}