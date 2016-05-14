package com.example.preference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity {

	int i,j,k;
	String a,b;
	Button iplus,jplus,kplus;
	EditText num1,num2,num3,id,pw;
	View.OnClickListener cl;
	SharedPreferences pref;
	CheckBox save;
	Boolean cb;
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		pref = getSharedPreferences("int_data", Activity.MODE_PRIVATE);
		SharedPreferences.Editor edit;
		edit= pref.edit();
		edit.putInt("jjj", j);
		edit.putInt("kkk", k);
		edit.putBoolean("save", save.isChecked());
		if(save.isChecked()) {
			edit.putString("id", id.getText().toString());
			edit.putString("pw", pw.getText().toString());
		}
		edit.commit();
		super.onPause();
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {    //pause는 껏을때 이거는 앱 실행중에 전화가 오거나 다른 앱 실행될때??
		// TODO Auto-generated method stub
		outState.putInt("iii", i);
		super.onSaveInstanceState(outState);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//i=0;
		
		if ( savedInstanceState == null) {
			i = 0;
		} else {
			i = savedInstanceState.getInt("iii");
		}
		pref = getSharedPreferences("int_data", Activity.MODE_PRIVATE);
		j = pref.getInt("jjj", 0);
		k = pref.getInt("kkk", 0);
		a = pref.getString("id", "");
		b = pref.getString("pw", "");
		cb = pref.getBoolean("save", false); //체크를 안하면 펄스시킨다
		
		iplus = (Button) findViewById(R.id.iplus);
		jplus = (Button) findViewById(R.id.jplus);
		kplus = (Button) findViewById(R.id.kplus);
		num1 = (EditText) findViewById(R.id.num1);
		num2 = (EditText) findViewById(R.id.num2);
		num3 = (EditText) findViewById(R.id.num3);
		save = (CheckBox) findViewById(R.id.save);
		id = (EditText) findViewById(R.id.id);
		pw = (EditText) findViewById(R.id.pw);
		num1.setText("i= " + i);
		num2.setText("j= " + j);
		num3.setText("k= " + k);
		if ( cb == true){
			
			save.setChecked(true);
			id.setText(a);
			pw.setText(b);
		}
		
		cl = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch ( v.getId() ) {
				case R.id.iplus :
					i++;
					num1.setText("i= " + i);
					break;
				case R.id.jplus :
					j++;
					num2.setText("j= " + j);
					break;
				case R.id.kplus :
					k++;
					num3.setText("k= " + k);
					break;
				}
			}
		};
		iplus.setOnClickListener(cl);
		jplus.setOnClickListener(cl);
		kplus.setOnClickListener(cl);
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
