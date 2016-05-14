package com.example.time;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	Button gt, sta, sto;
	EditText text;
	TimePicker tp;
	Chronometer ch;
	View.OnClickListener cl;
	TimePicker.OnTimeChangedListener tl;
	CalendarView cv;
	CalendarView.OnDateChangeListener cl2;
	Chronometer.OnChronometerTickListener cl3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ch = (Chronometer) findViewById(R.id.chr);
		gt = (Button) findViewById(R.id.gettime);
		sta = (Button) findViewById(R.id.start);
		sto = (Button) findViewById(R.id.stop);
		text = (EditText) findViewById(R.id.text);
		tp = (TimePicker) findViewById(R.id.tp);
		cv = (CalendarView) findViewById(R.id.cv);

		cl = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				switch (v.getId()) {
				case R.id.gettime:

					/*
					 * long t = System.currentTimeMillis();
					 * 
					 * for ( long i = 0; i < 10000000 ; i ++); long t1 =
					 * System.currentTimeMillis(); long et = t1 - t;
					 * text.setText(et + ""); break; Calendar cal; cal = new
					 * GregorianCalendar(); text.setText(cal.get(Calendar.YEAR)
					 * + "년" + (cal.get(Calendar.MONTH)+1) + "월" +
					 * cal.get(Calendar.DAY_OF_MONTH) + "일"
					 * +cal.get(Calendar.HOUR) + "시" + cal.get(Calendar.MINUTE)
					 * + "분" + cal.get(Calendar.SECOND) + "초"); break;
					 *  */
					Calendar cal;
					cal = Calendar.getInstance();
					cal.setTimeInMillis(cv.getDate());
					text.setText(cal.get(Calendar.YEAR) + "년" + (cal.get(Calendar.MONTH) + 1) + "월");
					break;
					 
				case R.id.start :
					ch.setBase(SystemClock.elapsedRealtime());
					ch.start();
					break;
				case R.id.stop :
					ch.stop();
					break;
				}

			}
		};

		cl2 = new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
				// TODO Auto-generated method stub

				text.setText("현재 날짜는 : " + year + "년" + ((month) + 1) + "월" + dayOfMonth + "일");

			}
		};


		cv.setOnDateChangeListener(cl2);
		gt.setOnClickListener(cl);
		tp.setOnTimeChangedListener(tl);
		sta.setOnClickListener(cl);
		sto.setOnClickListener(cl);
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
