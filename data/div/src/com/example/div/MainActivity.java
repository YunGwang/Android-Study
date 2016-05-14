package com.example.div;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText result_div;
	Button div;
	View.OnClickListener cl;
	Intent i;
	Double a, b, c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		result_div = (EditText) findViewById(R.id.result_div);
		div = (Button)findViewById(R.id.div);
		i = getIntent(); // 받아 오고
		a = i.getDoubleExtra("nn1", 10);
		b = i.getDoubleExtra("nn2", 20);
		c = a / b;
		result_div.setText("나눗셈은 = " + c);
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i = new Intent();
				i.putExtra("div", c);
				setResult(6, i);
				finish();
				
			}
		};
		div.setOnClickListener(cl);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
