package com.example.mywb;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText url;
	Button go, back, forward;
	WebView wv;
	View.OnClickListener cl;

	class myClient extends WebViewClient {

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

		url = (EditText) findViewById(R.id.url1);
		go = (Button) findViewById(R.id.move);
		back = (Button) findViewById(R.id.back);
		forward = (Button) findViewById(R.id.forward1);
		wv = (WebView) findViewById(R.id.webView1);
		wv.setWebViewClient(new myClient());
		WebSettings webset;
		webset = wv.getSettings();
		webset.setBuiltInZoomControls(true);

		cl = new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				switch (v.getId()) {
				case R.id.move:
					String s;
					s = url.getText().toString();
					if (s.startsWith("http")) //s가 http로 시작하느냐?
						wv.loadUrl(s);
					else
						wv.loadUrl("http://" + s);
						break;
				case R.id.back:
					wv.goBack();
					break;
				case R.id.forward1:
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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
