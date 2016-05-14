package com.example.resource;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {

	Button r;
	CheckBox ba, gr, st;
	CompoundButton.OnCheckedChangeListener bl;
	View.OnClickListener cl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ba = (CheckBox) findViewById(R.id.banana);
		gr = (CheckBox) findViewById(R.id.grape);
		st = (CheckBox) findViewById(R.id.strawberry);
		r = (Button) findViewById(R.id.red);
		cl = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.red:
					r.setBackgroundColor(Color.RED);
					break;

				}

			}
		};
		bl = new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				switch (buttonView.getId()) {
				case R.id.banana:
					if (isChecked == true)
						r.setText("당신은 바나나를 좋아하시네요");
					else
						r.setText("당신은 바나나를 좋아하시네요");
					break;
				}

			}
		};
			
		
		
		ba.setOnCheckedChangeListener(bl);
		r.setOnClickListener(cl);
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
