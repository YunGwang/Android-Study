package com.example.gallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	Gallery gal;
	ImageView img;
	int [] rid = { R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6,
			R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11
			};
	
	MyAdapter adap;
	View.OnClickListener cl;
	class MyAdapter extends BaseAdapter {
		Context cont;
		public MyAdapter(Context c){
			cont = c;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return rid.length;
		}
		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			ImageView iv;
			iv = new ImageView(cont);
			iv.setLayoutParams(new Gallery.LayoutParams(500,400));
			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
			iv.setPadding(5, 5, 5, 5);
			
			iv.setImageResource(rid[arg0]);
			
			final int pos = arg0;
			cl = new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					img = (ImageView) findViewById(R.id.imageView);
					img.setScaleType(ImageView.ScaleType.FIT_CENTER);
					img.setImageResource(rid[pos]);
				}
			};
			iv.setOnClickListener(cl);
			return iv;
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gal = (Gallery) findViewById(R.id.gallery);
		adap = new MyAdapter(this);
		gal.setAdapter(adap);
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
