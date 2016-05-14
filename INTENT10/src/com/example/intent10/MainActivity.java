package com.example.intent10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {	
	
	Button call_ex, call_minus;
	EditText n1, n2;
	View.OnClickListener cl;
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if ( resultCode == RESULT_OK) {
			int s;
			s = data.getIntExtra("sum", 0);
			n1.setText("결과값은 " + s);
		}
		super.onActivityResult(requestCode, resultCode, data);
		
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		call_ex = (Button)findViewById(R.id.call_ex);
		call_minus = (Button)findViewById(R.id.call_minus);
		n1 = (EditText) findViewById(R.id.num1);
		n2 = (EditText) findViewById(R.id.num2);
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i;
				switch (v.getId()){
				case R.id.call_ex :
					i = new Intent(getApplicationContext(), add.class);
					i.putExtra("num1", Integer.parseInt(n1.getText().toString())); // n1에 있는거 삽입 
					i.putExtra("num2", Integer.parseInt(n2.getText().toString()));
					startActivityForResult(i, 100); // 결과값을 받아 볼 수 있도록
					//startActivity(i); // add란 클래스가 호출
					break;
					
				case R.id.call_minus :
					i = new Intent(getApplicationContext(), sub.class);
					i.putExtra("num1", Integer.parseInt(n1.getText().toString())); // n1에 있는거 삽입 
					i.putExtra("num2", Integer.parseInt(n2.getText().toString()));
					startActivityForResult(i, 100); // 결과값을 받아 볼 수 있도록
					break;
					
				}
				
			}
		};
		
		call_ex.setOnClickListener(cl);
		call_minus.setOnClickListener(cl);
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
