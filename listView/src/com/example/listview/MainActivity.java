package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] ver = { "�����극��", "�����", "���̽�ũ��������ġ", "������", "ŶĹ", "�Ѹ���", "������ο�" };
	ListView lv;
	ArrayAdapter<String> adap;
	AdapterView.OnItemClickListener cl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView) findViewById(R.id.listview);
		adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,ver); //layout.simple_list_item_1 �۾������ٳ�����
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lv.setAdapter(adap);
		
		cl = new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "i=" + arg2 + " ����� ������" + ver[arg2] + "�Դϴ�.", Toast.LENGTH_LONG).show();
			}
			
		};
		lv.setOnItemClickListener(cl);
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
