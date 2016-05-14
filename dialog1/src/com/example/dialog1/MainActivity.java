package com.example.dialog1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button sh, re, gr, bl;
	EditText te, id, pw;
	AlertDialog.Builder ad;
	View dview;
	View.OnClickListener cl;
	DialogInterface.OnClickListener ycl, ncl;

	//���⼭ ���̵�� �н����带 �������� �� �ȴ�.
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // ����ȭ��

		sh = (Button) findViewById(R.id.show);
		te = (EditText) findViewById(R.id.Text);

		ycl = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				te.setText("����� ���̵��  " + id.getText().toString() + "�̸� �н������ " + pw.getText().toString() + "�Դϴ�");
			}
		};

		ncl = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				te.setText("����ϼ̳׿�");
			}
		};

		cl = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.show:
					ad = new AlertDialog.Builder(MainActivity.this);
					ad.setTitle("��ȭ���� ����");
					dview = (View) View.inflate(MainActivity.this, R.layout.mydialog, null);
					ad.setView(dview); // dview�� ����� ������.
					ad.setPositiveButton("OK", ycl);
					ad.setNegativeButton("CANCEL", ncl);
					ad.show();
					id = (EditText) dview.findViewById(R.id.id);
					pw = (EditText) dview.findViewById(R.id.pw);
					re = (Button) dview.findViewById(R.id.red);
					gr = (Button) dview.findViewById(R.id.GREEN);
					bl = (Button) dview.findViewById(R.id.BLUE);
					re.setOnClickListener(cl); //ó���� ��׸� �����Ѵ�.
					gr.setOnClickListener(cl);
					bl.setOnClickListener(cl);
					break;
				case R.id.red :
					id.setBackgroundColor(Color.RED);
					pw.setBackgroundColor(Color.RED);
					te.setBackgroundColor(Color.RED);
					break;
				case R.id.GREEN :
					id.setBackgroundColor(Color.GREEN);
					pw.setBackgroundColor(Color.GREEN);
					te.setBackgroundColor(Color.GREEN);
					break;
				case R.id.BLUE :
					id.setBackgroundColor(Color.BLUE);
					pw.setBackgroundColor(Color.BLUE);
					te.setBackgroundColor(Color.BLUE);
					break;

				}

			}
		};
		sh.setOnClickListener(cl);
		/* re.setOnClickListener(cl); //ó���� ��׸� �����Ѵ�.
		gr.setOnClickListener(cl);
		bl.setOnClickListener(cl);  ��׸� ���⿡ ������ ������ �� �Ǿ� �ִµ� ������ �Ǿ������ ������ ���.*/
		
		
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
