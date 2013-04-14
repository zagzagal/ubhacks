package com.example.ubhacks;

import java.util.ArrayList;

public class Player {
	static final int FOLD = -1;
	
	String name;
	ArrayList<Bet> bets;
	
	Player(){
		bets = new ArrayList<Bet>();
	}
	
	Player(String n){
		bets = new ArrayList<Bet>();
		name = n;
	}
	
	void placeBet(int amount){
		bets.add(new Bet(amount,0));
		//tell the machine the amount that the player bet
	}
	
	String getBets(){
		String ans = "";
		boolean first = true;
		ans += name + ":" + "   ";
		for(Bet b: bets){
			if(first) {
				ans += b.amount+"\n";
				first = false;
			}
			else
				ans += getSpaces(name.length() + 4) + b.amount + "\n";
		}
		return ans;
	}
	
	private String getSpaces(int num){
		String ans ="";
		for(int i = 0; i<num; i++)
			ans += " ";
		return ans;
	}
}
