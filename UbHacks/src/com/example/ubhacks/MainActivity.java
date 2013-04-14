package com.example.ubhacks;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		TextView log = (TextView)findViewById(R.id.txtLog);
		EditText bet = (EditText)findViewById(R.id.currentBet);
		Button btnCheck = (Button)findViewById(R.id.checkBtn);
		Button btnFold = (Button)findViewById(R.id.btnFold);
		Button btnEnd = (Button)findViewById(R.id.endBet);
		return true;
	}

}
