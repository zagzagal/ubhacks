package com.example.ubhacks;

import java.util.ArrayList;

public class Player {
	static final int FOLD = -1;
	
	Boolean active;
	Boolean checked;
	String name;
	ArrayList<Bet> bets;
	int currentBet;
	int hand;
	
	Player(){
		bets = new ArrayList<Bet>();
		active = true;
		hand = 1;
		currentBet = 0;
		checked = false;
	}
	
	Player(String n){
		bets = new ArrayList<Bet>();
		name = n;
		active = true;
		hand = 1;
		currentBet = 0;
		checked = false;
	}
	
	void placeBet(int amount){
		bets.add(new Bet(amount,0, hand));
		currentBet += amount;
		checked = false;
		//tell the machine the amount that the player bet
	}
	
	String getBets(){
		String ans = "";
		boolean first = true;
		ans += name + ":" + "   ";
		for(Bet b: bets){
			if (b.hand == hand) {
				if (first) {
					ans += b.amount + "\n";
					first = false;
				} else
					ans += getSpaces(name.length() + 4) + b.amount + "\n";
			}
		}
		return ans;
	}
	
	String getAllBets() {
		String ans = "";
		boolean first = true;
		
		for(Bet b: bets){
			if(first) {
				ans += name + ":" + "   " + b.amount+"\n";
				first = false;
			}
			else
				ans += getSpaces(name.length() + 4) + b.amount + "\n";
		}
		return ans;
	}
	
	public void nextHand()	{
		hand++;
		currentBet = 0;
		checked = false;
		active = true;
	}
	private String getSpaces(int num){
		String ans ="";
		for(int i = 0; i<num; i++)
			ans += " ";
		return ans;
	}
	
	void fold(){
		active = false;
	}
	
	public void check(int currentBet){
		placeBet(currentBet - this.currentBet);
		checked = true;
	}
}

