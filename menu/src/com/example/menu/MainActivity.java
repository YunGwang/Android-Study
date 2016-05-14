package com.example.menu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button re, gr;
	EditText te;
	View.OnClickListener cl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		re = (Button) findViewById(R.id.red);
		registerForContextMenu(re); // re 버튼에다가 내가 만들었다.
		gr = (Button) findViewById(R.id.green);
		te = (EditText) findViewById(R.id.text);
		registerForContextMenu(te);
		registerForContextMenu(gr);
		cl = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.red:
					te.setBackgroundColor(Color.RED);
					break;
				case R.id.green:
					te.setBackgroundColor(Color.GREEN);
					break;
				}

			}
		};

		re.setOnClickListener(cl);
		gr.setOnClickListener(cl);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add(0, 101, 0, "자주");
		menu.add(0, 102, 0, "검정");
		SubMenu sm;
		sm = menu.addSubMenu("기타2");
		sm.add(0, 103, 0, "밝은 회색");
		sm.add(0, 104, 0, "짙은 회색");

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
		switch (id) {
		case R.id.blue:
			te.setBackgroundColor(Color.BLUE);
			break;
		case R.id.yellow:
			te.setBackgroundColor(Color.YELLOW);
			break;
		case R.id.cyan:
			te.setBackgroundColor(Color.CYAN);
			break;
		case R.id.gray:
			te.setBackgroundColor(Color.GRAY);
			break;
		case 101:
			te.setBackgroundColor(Color.MAGENTA);
			break;
		case 102:
			te.setBackgroundColor(Color.BLACK);
			break;
		case 103:
			te.setBackgroundColor(Color.LTGRAY);
			break;
		case 104:
			te.setBackgroundColor(Color.DKGRAY);
			break;

		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		if (v == re) { // re 버튼에서 3초동안 눌러야지만 저게 뜬다
			getMenuInflater().inflate(R.menu.mycolor, menu);

		} // main이 아니고 mycolor다
		if (v == te || v == gr)
			getMenuInflater().inflate(R.menu.city, menu);
		menu.add(0, 201, 0, "대구");
		menu.add(0, 202, 0, "부산");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		switch (id) {
		case R.id.red1:
			te.setBackgroundColor(Color.RED);
			break;
		case R.id.blue1:
			te.setBackgroundColor(Color.BLUE);
			break;
		case R.id.green1:
			te.setBackgroundColor(Color.GREEN);
			break;
		case R.id.seoul:
			te.setText("서울");
			break;
		case R.id.seongnam:
			te.setText("성남");
			break;
		case R.id.yongin:
			te.setText("용인");
			break;
		case R.id.suwon:
			te.setText("수원");
			break;
		case R.id.gwangju:
			te.setText("광주");
			break;
		case R.id.etc:
			te.setText("기타");
			break;
		case 201 :
			te.setText("대구");
			break;
		case 202:
			te.setText("부산");
			break;
		}
		return super.onContextItemSelected(item);
	}

}
