package com.example.ubhacks;

import java.util.ArrayList;

public class Game {
	ArrayList<Player> players;
	int current;
	int handNum;
	int smallBlind, largeBlind;
	
	Game(int smallBlind, int large){
		players = new ArrayList<Player>();
		this.smallBlind = smallBlind;
		this.largeBlind = large;
	}
	
	void testGame(){
		players.add(new Player("Paul"));
		players.add(new Player("Phil"));
	}
	
	void addPlayer(){
		players.add(new Player());
	}
	
	String getLog() {
		String ans = "";
		for(Player p:players)
			ans += p.getBets();
		return ans;
	}
	String getCurrentPlayerName(){
		return players.get(current).name;
	}
	
	void placeBet(int amount){
		players.get(current).placeBet(amount);
		if(current >= players.size() - 1)
			current = 0;
		else
			current++;
		//place the current bet in the machine
		//update on any data from the machine
		//go to the next player currentPlayer = nextplayer
	}
}
