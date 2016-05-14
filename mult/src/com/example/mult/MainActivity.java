package com.example.mult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText result_multi;
	Button stop;
	View.OnClickListener cl;
	Intent i;
	int a, b, c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		result_multi = (EditText) findViewById(R.id.result_multi);
		stop = (Button)findViewById(R.id.stop);
		i = getIntent(); // 받아 오고
		a = i.getIntExtra("n1", 10);
		b = i.getIntExtra("n2", 20);
		c = a * b;
		result_multi.setText("곱셈은 = " + c);
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				i = new Intent();
				i.putExtra("mult", c);
				setResult(5, i);
				finish();
				
			}
		};
		stop.setOnClickListener(cl);
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
