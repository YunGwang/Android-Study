package com.example.intent10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sub extends Activity {
	
	Button end;
	EditText res;
	View.OnClickListener cl;
	int a, b, c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add); // add.xml이 뜨게하기 
		
		end = (Button)findViewById(R.id.end);
		res = (EditText)findViewById(R.id.result);
		Intent i;
		i = getIntent();// 자기를 누가 호출해주는지 알 수 있다.

		a = i.getIntExtra("num1",0); // 합계를 못 받았을 떄 10을 이용해라 지금 버전은 메니페스트에서 add를 첫 번쨰로 열리게 했을 때 바로 합계 25가 뜬다.
		b = i.getIntExtra("num2",0);
		c = a - b;
		res.setText("결과 = " + c);
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()){
				case R.id.end :
					Intent r;
					r = new Intent(getApplicationContext(), MainActivity.class);
					r.putExtra("sum", c);
					setResult(RESULT_OK, r); 
					finish();
					break;
				
			}
			}
		};
		end.setOnClickListener(cl);
	}

}
