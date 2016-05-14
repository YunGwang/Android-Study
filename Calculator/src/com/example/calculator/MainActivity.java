package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	EditText inp; //임의의 변수 지정
	Button sqr, tri; //xml에서 지정한거랑은 다른거임!
	TextView res;
	View.OnClickListener cl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inp = (EditText) findViewById(R.id.numa); //aa에 numa를 연결시켜줘라 이하 동일
		res = (TextView)findViewById(R.id.result);
		sqr = (Button) findViewById(R.id.plus1);
		tri= (Button) findViewById(R.id.minus);
		cl = new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int a, b;
				a = Integer.parseInt(inp.getText().toString());// 숫자식으로 바꿔줘야 하기 때문에  ex) "10" + "20" = "1020"
			
				switch (v.getId()){ //무슨 버튼을 누르고 들어왔나..
				
				case R.id.plus1:
					res.setText("제곱은" + String.valueOf(a * a));
					break;
				case R.id.minus :
				
					res.setText("세제곱은" + String.valueOf(a * a * a));
					break;	
				}
				
			}
		};
		sqr.setOnClickListener(cl);
		tri.setOnClickListener(cl);
	
		
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
