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
		registerForContextMenu(re); // re ��ư���ٰ� ���� �������.
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
		menu.add(0, 101, 0, "����");
		menu.add(0, 102, 0, "����");
		SubMenu sm;
		sm = menu.addSubMenu("��Ÿ2");
		sm.add(0, 103, 0, "���� ȸ��");
		sm.add(0, 104, 0, "£�� ȸ��");

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
		if (v == re) { // re ��ư���� 3�ʵ��� ���������� ���� ���
			getMenuInflater().inflate(R.menu.mycolor, menu);

		} // main�� �ƴϰ� mycolor��
		if (v == te || v == gr)
			getMenuInflater().inflate(R.menu.city, menu);
		menu.add(0, 201, 0, "�뱸");
		menu.add(0, 202, 0, "�λ�");
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
			te.setText("����");
			break;
		case R.id.seongnam:
			te.setText("����");
			break;
		case R.id.yongin:
			te.setText("����");
			break;
		case R.id.suwon:
			te.setText("����");
			break;
		case R.id.gwangju:
			te.setText("����");
			break;
		case R.id.etc:
			te.setText("��Ÿ");
			break;
		case 201 :
			te.setText("�뱸");
			break;
		case 202:
			te.setText("�λ�");
			break;
		}
		return super.onContextItemSelected(item);
	}

}
