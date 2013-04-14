package com.example.ubhacks;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView log, currentPlayer;
	EditText bet;
	Button btnCheck, btnFold, btnEnd, btnBet;
	Game game;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		game = new Game(5, 10);
		game.testGame();
		log = (TextView)findViewById(R.id.txtLog);
		currentPlayer = (TextView)findViewById(R.id.txtCurrentPlayer);
		bet = (EditText)findViewById(R.id.currentBet);
		btnCheck = (Button)findViewById(R.id.checkBtn);
		btnFold = (Button)findViewById(R.id.btnFold);
		btnEnd = (Button)findViewById(R.id.endBet);
		btnBet = (Button)findViewById(R.id.btnBet);
	
		currentPlayer.setText(game.getCurrentPlayerName());
		
		return true;
	}
	
	public void btnBetClick(View v){
		game.placeBet(Integer.parseInt(bet.getText().toString()));
		updateFields();
	}
	
	public void btnEndClick(View v){
		game.endTurn();
	}
	
	public void btnCheckClick(View v){
		game.check();
		updateFields();
	}
	
	public void btnFoldClick(View v) {
		game.fold();
		updateFields();
	}
	
	private void updateFields(){
		log.setText(game.getLog());
		currentPlayer.setText(game.getCurrentPlayerName());
	}
}
