package com.example.gridview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	View.OnClickListener cl;

	GridView gv;
	int[] rid = { R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6
			,R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10, R.drawable.a11}; // 배열에 이미지 저장
	
	MyAdapter adap; // MyAdapter 선언
	
	class MyAdapter extends BaseAdapter { // base어댑터에서 상속받아옴
		Context cont;
		public MyAdapter(Context c) {
			cont = c;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return rid.length; // 배열의 길이 만큼
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
			iv.setLayoutParams(new GridView.LayoutParams(150,200));
			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
			iv.setPadding(5, 5, 5, 5);
			
			iv.setImageResource(rid[arg0]);
			
			final int pos = arg0;
			cl = new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "그림 번호는 = " + pos, Toast.LENGTH_LONG).show();
					
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
		
		gv = (GridView) findViewById(R.id.gridview);
		adap = new MyAdapter(this);
		gv.setAdapter(adap); // 그리드뷰에 어댑터를 보여줌
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
