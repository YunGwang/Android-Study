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
	
	EditText inp; //������ ���� ����
	Button sqr, tri; //xml���� �����ѰŶ��� �ٸ�����!
	TextView res;
	View.OnClickListener cl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inp = (EditText) findViewById(R.id.numa); //aa�� numa�� ���������� ���� ����
		res = (TextView)findViewById(R.id.result);
		sqr = (Button) findViewById(R.id.plus1);
		tri= (Button) findViewById(R.id.minus);
		cl = new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int a, b;
				a = Integer.parseInt(inp.getText().toString());// ���ڽ����� �ٲ���� �ϱ� ������  ex) "10" + "20" = "1020"
			
				switch (v.getId()){ //���� ��ư�� ������ ���Գ�..
				
				case R.id.plus1:
					res.setText("������" + String.valueOf(a * a));
					break;
				case R.id.minus :
				
					res.setText("��������" + String.valueOf(a * a * a));
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
