package com.example.web;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	Button go, back, forward;
	EditText te;
	WebView wv;
	View.OnClickListener cl;
	
	class myWeb extends WebViewClient{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			return super.shouldOverrideUrlLoading(view, url);
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		go = (Button) findViewById(R.id.go);
		back = (Button) findViewById(R.id.back);
		forward = (Button)findViewById(R.id.forward);
		wv = (WebView) findViewById(R.id.web);
		te = (EditText) findViewById(R.id.Text);
		myWeb mw;
		mw = new myWeb();
		wv.setWebViewClient(mw);
		
		
		
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch ( v.getId()){
				case R.id.go :
					wv.loadUrl(te.getText().toString());
					break;
				case R.id.back :
					wv.goBack();
					break;
				case R.id.forward :
					wv.goForward();
					break;
					
				}
				
			}
		};
		
		go.setOnClickListener(cl);
		back.setOnClickListener(cl);
		forward.setOnClickListener(cl);
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
