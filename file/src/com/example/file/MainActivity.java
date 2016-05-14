package com.example.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText fn, text;
	Button ri, wi, re, we;
	View.OnClickListener cl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		fn = (EditText) findViewById(R.id.filename);
		text = (EditText) findViewById(R.id.text);
		ri = (Button) findViewById(R.id.read_int);
		wi = (Button) findViewById(R.id.write_int);
		re = (Button) findViewById(R.id.read_ext);
		we = (Button) findViewById(R.id.write_ext);

		cl = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				switch (v.getId()) {

				case R.id.read_int:

					try {
						FileInputStream is;
						is = openFileInput(fn.getText().toString());
						byte[] b = new byte[1000]; // 1000����Ʈ ũ��� ����
						is.read(b); // is ���� �о b �޸𸮿� �־��
						String s;
						s = new String(b); // s�� b�� �ʱ�ȭ
						text.setText(s); // s�� ������
						is.close();

					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
					}
					break;

				case R.id.write_int:
					try {
						FileOutputStream os;
						os = openFileOutput(fn.getText().toString(), Context.MODE_WORLD_WRITEABLE);
						os.write(text.getText().toString().getBytes());
						os.close();
						Toast.makeText(getApplicationContext(), "Internal write OK!", Toast.LENGTH_LONG).show();

					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
					}
					break;
					
				case R.id.read_ext:
					try {
						FileInputStream is;
						is = new FileInputStream(fn.getText().toString()); //new�� ����鼭 �˾Ƽ� byte���ڸ� �˾Ƴ���
						byte[] b = new byte[is.available()]; // byte���ڸ� �˾Ƴ� �� �ִ�.
						is.read(b); // is ���� �о b �޸𸮿� �־��
						String s;
						s = new String(b); // s�� b�� �ʱ�ȭ
						text.setText(s); // s�� ������
						is.close();
						
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
					}
					break;
				case R.id.write_ext:
					try {
						FileOutputStream os;
						os = new FileOutputStream(fn.getText().toString(), false); // ��������	 false�Ѵ�.
						os.write(text.getText().toString().getBytes());
						os.close();
						Toast.makeText(getApplicationContext(), "External write OK!", Toast.LENGTH_LONG).show();
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
					}
				}
			}
		};

		ri.setOnClickListener(cl);
		wi.setOnClickListener(cl);
		re.setOnClickListener(cl);
		we.setOnClickListener(cl);

	}

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
