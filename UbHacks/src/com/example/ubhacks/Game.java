package com.example.ubhacks;

import java.util.ArrayList;

public class Game {
	ArrayList<Player> players;
	int current;
	int handNum;
	int smallBlind, largeBlind;
	int turn;
	int currentBet;
	
	Game(int smallBlind, int large){
		players = new ArrayList<Player>();
		this.smallBlind = smallBlind;
		this.largeBlind = large;
		turn = 0;
		currentBet = smallBlind;
	}
	
	void testGame(){
		players.add(new Player("Paul"));
		players.add(new Player("Phil"));
		players.add(new Player("Bob"));
		
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
	
	void endTurn() {
		turn++;
		currentBet = smallBlind;
		for(Player p:players)
			p.nextHand();
	}
	
	void placeBet(int amount){
		players.get(current).placeBet(amount);
		nextPlayer();
		if(currentBet == smallBlind)
			currentBet = amount;
		else
			currentBet += amount;
		//place the current bet in the machine
		//update on any data from the machine
		//go to the next player currentPlayer = nextplayer
	}
	
	void fold() {
		players.get(current).fold();
		int active = 0;
		nextPlayer();
		for(Player p:players)
			active += (p.active)? 1:0;
		if(active <= 1)
			endTurn();
	}
	void check(){
		players.get(current).check(currentBet);
		Boolean done = false;
		for(Player p:players){
			if(p.checked||!p.active)
				done = true;
			else
			{
				done = false;
				break;
			}
		}
		if(done)
			endTurn();
		else
			nextPlayer();
	}
	
	private void nextPlayer(){
		if(current >= players.size() - 1)
			current = 0;
		else
			current++;
		if(!players.get(current).active)
				nextPlayer();
	}
}
