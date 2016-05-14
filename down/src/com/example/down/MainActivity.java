package com.example.down;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button go;
	TextView tv;
	EditText text;
	View.OnClickListener cl;
	MyThread mth;
	MyHandler mha;
	String page="";
	
	class MyThread extends Thread {

		@Override
		public void run() {
			HttpURLConnection conn = null;
			try {
				URL u = new URL(text.getText().toString());
				conn = (HttpURLConnection) u.openConnection();
				BufferedInputStream buf;
				buf = new BufferedInputStream(conn.getInputStream());
				BufferedReader reader;
				reader = new BufferedReader(new InputStreamReader(buf, "utf-8"));
				String line = null;
				page = "";
				while( (line = reader.readLine()) != null) {
					page = page + line + "/n";
				}
				mha.sendEmptyMessage(1);
			}catch( Exception e){
				Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
			}
		}
		
	}
	class MyHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch ( msg.what ) {
			case 1 :
				tv.setText(page);
				break;
			}
			super.handleMessage(msg);
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		go = (Button) findViewById(R.id.go);
		text = (EditText) findViewById(R.id.text);
		tv = (TextView) findViewById(R.id.tv);
		
		mha = new MyHandler();
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mth = new MyThread();
				mth.start();
				
			}
		};
		go.setOnClickListener(cl);
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
