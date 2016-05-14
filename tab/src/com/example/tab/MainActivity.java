package com.example.tab;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	TabHost th ;
	TabSpec ts ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		th = getTabHost() ;
		
		
		ts = th.newTabSpec("123").setIndicator("개") ;
		ts.setContent(R.id.textView1) ;
		th.addTab(ts) ;
		
		ts = th.newTabSpec("ca21").setIndicator("고양이") ;
		ts.setContent(R.id.textView2) ;
		th.addTab(ts) ;
		
		ts = th.newTabSpec("y123e").setIndicator("말") ;
		ts.setContent(R.id.textView3) ;
		th.addTab(ts);
		
		th.setCurrentTab(0);
		
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
