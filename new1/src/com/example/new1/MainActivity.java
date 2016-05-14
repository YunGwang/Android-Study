package com.example.new1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	Button back, forw;
	ViewFlipper vf;
	View.OnClickListener cl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		back = (Button) findViewById(R.id.back);
		forw = (Button) findViewById(R.id.forward);
		vf = (ViewFlipper) findViewById(R.id.vf);
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch ( v.getId()){
				case R.id.back :
					vf.showPrevious();
					break;
				case R.id.forward :
					vf.showNext();
					break;
				}
				
			}
		};
		
		back.setOnClickListener(cl);
		forw.setOnClickListener(cl);
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
