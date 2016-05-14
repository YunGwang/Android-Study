package com.example.color;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText r, g, b; // int i와 같은 의미
	Button re, gr, bl, ye, an;
	View.OnClickListener cl; //위 3줄은 다 선언문임

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		r = (EditText) findViewById(R.id.n_red); //c언어에서 int를 float로 바꾸는 역할과 비슷 (연결시켜주는 것)
		g = (EditText) findViewById(R.id.n_green);
		b = (EditText) findViewById(R.id.n_blue);
		re = (Button) findViewById(R.id.red);
		gr = (Button) findViewById(R.id.green);
		bl = (Button) findViewById(R.id.blue);
		ye = (Button) findViewById(R.id.yellow);
		an = (Button) findViewById(R.id.any);
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId())  {
				case R.id.red : //red버튼을 눌러서 들어왔느냐?
					r.setBackgroundColor(Color.RED); //레드버튼을 누르면 te의 백그라운드 컬러를 레드로 바꿔라
					break;
					
				case R.id.green : //green버튼을 눌러서 들어왔느냐?
					r.setBackgroundColor(Color.GREEN); //그린버튼을 누르면 te의 백그라운드 컬러를 그린으로 바꿔라
					break;
					
				case R.id.blue : //green버튼을 눌러서 들어왔느냐?
					r.setBackgroundColor(Color.BLUE); //블루버튼을 누르면 te의 백그라운드 컬러를 블루로 바꿔라
					break;
					
				case R.id.yellow : //yellow버튼을 눌러서 들어왔느냐?
					r.setBackgroundColor(Color.YELLOW); //옐로우버튼을 누르면 te의 백그라운드 컬러를 블루로 바꿔라
					break;
					
				case R.id.any : //yellow버튼을 눌러서 들어왔느냐?
					int ir, ig, ib;
					ir = Integer.parseInt(r.getText().toString());
					ig = Integer.parseInt(g.getText().toString());
					ib = Integer.parseInt(b.getText().toString());
					r.setBackgroundColor(Color.rgb(ir, ig, ib));
					break;
				}
				
				
				
			}
		};
		
		re.setOnClickListener(cl); //red버튼 누르면 cl함수를 호출해달라
		gr.setOnClickListener(cl);
		bl.setOnClickListener(cl);
		ye.setOnClickListener(cl);
		an.setOnClickListener(cl);
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
