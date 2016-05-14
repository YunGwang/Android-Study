package com.example.intent4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText n1, n2;
	Button add, multi, div;
	View.OnClickListener cl;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 777 ){
			n1.setText("뺄셈은 =  " + data.getIntExtra("sub", 0));		
			n2.setText("");
		}	else if ( resultCode == 5){
			n1.setText("곱셈은 =  " + data.getIntExtra("mult", 0));	
			n2.setText("");	
			}
		else if ( resultCode == 6){
			n1.setText("나눗셈은 =  " + data.getDoubleExtra("div", 0));	
			n2.setText("");
		}
		}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		n1 = (EditText) findViewById(R.id.text1);
		n2 = (EditText) findViewById(R.id.text2);
		add = (Button) findViewById(R.id.add);
		multi = (Button) findViewById(R.id.mult);
		div = (Button) findViewById(R.id.div);
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i;
				switch (v.getId()){
				case R.id.add :
					i = new Intent(getApplicationContext(), add.class); //add클래스를 호출하라
					i.putExtra("num1", n1.getText().toString());
					i.putExtra("num2", n2.getText().toString());
					startActivityForResult(i, 11); // 호출
					break;
				case R.id.mult :
					i = new Intent(); //메모리 확보
					i.setClassName("com.example.mult", "com.example.mult.MainActivity"); // 패키지 이름쓰고 멀티 프로젝트의 메인액티비티 호출
					i.putExtra("n1", Integer.parseInt(n1.getText().toString())); // Integer로 넘김
					i.putExtra("n2", Integer.parseInt(n2.getText().toString())); 
					startActivityForResult(i, 12); // 멀티 호출
					break;
				case R.id.div :
					i = new Intent(); //메모리 확보
					i.setClassName("com.example.div", "com.example.div.MainActivity"); // 패키지 이름쓰고 멀티 프로젝트의 메인액티비티 호출
					i.putExtra("nn1", Double.parseDouble(n1.getText().toString())); // Integer로 넘김
					i.putExtra("nn2", Double.parseDouble(n2.getText().toString())); 
					startActivityForResult(i, 13); // 멀티 호출
					break;
	
				}
				
			}
		};
		
		add.setOnClickListener(cl);
		multi.setOnClickListener(cl);
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
