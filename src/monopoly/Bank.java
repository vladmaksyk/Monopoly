package monopoly;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Bank {
	
	private int totalMoney;
	private HashMap<HumanPlayer, Double> loanRegister;
	private double interestRate;
	
	public Bank(int tm, double ir, Queue<HumanPlayer> players) {
		totalMoney = tm;
		interestRate = ir;
		this.loanRegister = new HashMap<HumanPlayer,Double>(players.size());
		
		//Register players in the bank system 
		for(HumanPlayer pl: players) {
			loanRegister.put(pl, 0.0);
		}
		
	}
	
	public int requestMoneyFromBank(int amount) {
		if (totalMoney>=amount) {
			totalMoney = totalMoney - amount;
		}
		return amount;
		
	}
	
	public boolean payMoneyToBank(int amount) {
		totalMoney = totalMoney + amount;
		return true;
	}
	
	public static void main(String[] args) {
		HumanPlayer max = new HumanPlayer("Max");
		HumanPlayer rony = new HumanPlayer("Rony");
		HumanPlayer vlad = new HumanPlayer("Vlad");
		Queue<HumanPlayer> q = new LinkedList<>();
		q.add(max);
		q.add(rony);
		q.add(vlad);
		
		Bank bk = new Bank(100000, 0.3, q);
		
	}
		
		
}


