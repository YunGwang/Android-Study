package com.example.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText t1, t2, t3;
	Button start, stop;
	View.OnClickListener cl;
	int i = 0, j = 0, k = 0;
	boolean con = false;
	MyTh1 mt1;
	MyTh2 mt2;
	MyTh3 mt3;
	MyHandle mh;

	class MyTh1 extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				SystemClock.sleep(500);
				i++;
				mh.sendEmptyMessage(1); //MyHandler 호출 메인쓰레드에서 얘네를 엑세스 할 수가 있다.
				
				// t1.setText("i=" + i); 이것은 공유자원이라 문제가 된다.
			}

		}

	}

	class MyTh2 extends Thread {
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				SystemClock.sleep(700);
				j++;
				mh.sendEmptyMessage(2);
				//t2.setText("j=" + j);
			}

		}
	}
	
	class MyTh3 extends Thread {
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				SystemClock.sleep(1000);
				k++;
				mh.sendEmptyMessage(3);
				//t3.setText("k=" + k);
			}

		}
	}

	class MyHandle extends Handler {//여기서 t1, t2 setText를 대신해서 표시해준다.

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch ( msg.what ) {
			case 1 : 
				t1.setText("i=" + i);
				break;
			case 2 : 
				t2.setText("j=" + j);
				break;
			case 3 : 
				t3.setText("k=" + k);
				break;
			}
			super.handleMessage(msg);
		} 
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mt1 = new MyTh1();
		mt2 = new MyTh2();
		mt3 = new MyTh3();
		mh = new MyHandle();

		t1 = (EditText) findViewById(R.id.t1);
		t2 = (EditText) findViewById(R.id.t2);
		t3 = (EditText) findViewById(R.id.t3);
		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);

		cl = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.start:
					mt1.start();
					mt2.start();
					mt3.start();
					break;
				case R.id.stop:
					mt1.stop();
					mt2.stop();
					mt3.stop();
					break;
				}

			}
		};

		start.setOnClickListener(cl);
		stop.setOnClickListener(cl);

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
