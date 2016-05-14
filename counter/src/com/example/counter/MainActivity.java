package com.example.counter;

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

	Button start1, start2, stop1, stop2, start3, stop3, start4, stop4;
	EditText t1, t2;
	View.OnClickListener cl;
	int i = 0, j = 0;
	MyThread1 mt1;
	MyThread2 mt2;
	MyHandler mh;
	boolean bt1, bt2, hb1 = true, hb2 = true;

	class MyThread1 extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			bt1 = true;
			i = 0;
			while ( bt1 ) {
				SystemClock.sleep(500);
				i++;
				mh.sendEmptyMessage(10); // 핸들러에 요청
				// t1.setText("i=" + i); //쓰레드는 t1을액세스하지 못한다.
			}
		}

	}
	
	class MyThread2 extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			bt2= true;
			j = 0; //시작버튼 누를때마다 0으로 시작
			while ( bt2 ) {
				SystemClock.sleep(700);
				j++;
				mh.sendEmptyMessage(11); // 핸들러에 요청
				// t1.setText("j=" + j); //쓰레드는 t1을액세스하지 못한다.
			}
		}

	}
	

	class MyHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case 10:
				t1.setText("Thread i=" + i); //요청을 받은 핸들러가 수행
				break;
				
			case 11:
				t2.setText("Thread j=" + j);
				break;
				
			case 100:
				if ( hb1 ){
				i++;
				t1.setText("handler i = " + i);
				mh.sendEmptyMessageDelayed(100, 500);//나한테 100번 주는데 0.5초 딜레이로줘라
				}
				break;
				
			case 101: 
			if ( hb2 ){
				j++;
				t2.setText("handler j = " + j);
				mh.sendEmptyMessageDelayed(101, 700);//나한테 100번 주는데 0.5초 딜레이로줘라
			}
				break;	
		
	
			}
			super.handleMessage(msg);
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		start1 = (Button) findViewById(R.id.start1);
		stop1 = (Button) findViewById(R.id.stop1);
		start2 = (Button) findViewById(R.id.start2);
		stop2 = (Button) findViewById(R.id.stop2);
		start3 = (Button) findViewById(R.id.start3);
		stop3 = (Button) findViewById(R.id.stop3);
		start4 = (Button) findViewById(R.id.start4);
		stop4 = (Button) findViewById(R.id.stop4);
		t1 = (EditText) findViewById(R.id.t1);
		t2 = (EditText) findViewById(R.id.t2);

		mh = new MyHandler();
		

		cl = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.start1:
					//mt1 = new MyThread1();
					//mt1.start();
					hb1 = true;
					i = 0;
					mh.sendEmptyMessage(100);
					break;
					
				case R.id.start2:
					hb2 = true;
					j = 0;
					mh.sendEmptyMessage(101);
					break;
				case R.id.start3:
					mt1 = new MyThread1();
					mt1.start();
					/*hb1 = true;
					i = 0;
					mh.sendEmptyMessage(100); */
					break;
				case R.id.start4:
					mt2 = new MyThread2();
					mt2.start();
					/* hb1 = true;
					i = 0;
					mh.sendEmptyMessage(100); */
					break;

				case R.id.stop1:	
					hb1 = false;
					break;	
				case R.id.stop2:
					hb2 = false;
					break;
				case R.id.stop3:	
					bt1 = false;
					break;	
				case R.id.stop4:
					bt2 = false;
					break;
					
				}

			}
		};

		start1.setOnClickListener(cl);
		start2.setOnClickListener(cl);
		stop1.setOnClickListener(cl);
		stop2.setOnClickListener(cl);
		start3.setOnClickListener(cl);
		stop3.setOnClickListener(cl);
		start4.setOnClickListener(cl);
		stop4.setOnClickListener(cl);
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
