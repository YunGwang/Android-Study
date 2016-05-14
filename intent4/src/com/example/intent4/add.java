package com.example.intent4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class add extends Activity {
	
	Button end;
	EditText result;
	View.OnClickListener cl;

	Intent i;
	int a,b,c,d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		
		end = (Button) findViewById(R.id.end);
		result = (EditText) findViewById(R.id.result);
		
		i = getIntent(); //파라미터를 받아오기 위해서
		a = Integer.parseInt(i.getStringExtra("num1"));
		b = Integer.parseInt(i.getStringExtra("num2"));
		c = a + b;
		d = a - b;
		result.setText("결과 = " + c );
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId()){
				case R.id.end:
				i = new Intent(getApplicationContext(), MainActivity.class); // 메인액티비티 호출
				d = a - b;
				i.putExtra("sub", d);
				setResult(777, i); //StartActivity(i); 이거는 새로 뜨는거고, setResult는 결과값만 보낸다. 
				finish();
				break;
			}}
		};
		end.setOnClickListener(cl);
	}
	
	

}
