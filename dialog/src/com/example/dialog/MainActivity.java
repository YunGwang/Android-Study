package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	AlertDialog.Builder db, db1;
	View vw;
	Button sh, id;
	EditText te, i,p;
	View.OnClickListener cl;
	DialogInterface.OnClickListener ycl, ncl, vcl;
	String[] st = new String[] { "�����", "���̽�ũ�� ������ġ", "������", "ŶĹ", "�Ѹ���", "���ø�ο�" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sh = (Button) findViewById(R.id.show);
		te = (EditText) findViewById(R.id.Text);
		id = (Button) findViewById(R.id.idpw);
	

		ycl = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				i = (EditText) vw.findViewById(R.id.id);
				p = (EditText) vw.findViewById(R.id.pw);
				te.setText("ID = " + i.getText().toString() + " PW =" + p.getText().toString()); 
			}
		};

		ncl = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				te.setText("");

			}
		};

		vcl = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				te.setText("����� �ڵ��� ������ " + st[which] + "�Դϴ�");

			}
		};
		cl = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
			
				db = new AlertDialog.Builder(MainActivity.this);
				switch (v.getId()) {
				case R.id.show:
					// db.setTitle("���� �Է�");
					db.setTitle("�ڵ��� ������ ��� �ǳ���???");
					// db.setMessage("����� �����Դϱ�?");
					// db.setItems(st, vcl);
					db.setSingleChoiceItems(st, 3, vcl);
					db.setIcon(R.drawable.ic_launcher);
					db.setPositiveButton("��", null);
					db.setNegativeButton("�ƴϿ�", ncl);
					db.show();
					break;
				case R.id.idpw:
					db1 = new AlertDialog.Builder(MainActivity.this);
					vw = (View) View.inflate(MainActivity.this, R.layout.idpw, null);
					db1.setView(vw);
					db1.setPositiveButton("���ư���", ycl);
					db1.setNegativeButton("����ϱ�", null);
					db1.show();
					break;

				}
			}
		};

		sh.setOnClickListener(cl);
		id.setOnClickListener(cl);
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
