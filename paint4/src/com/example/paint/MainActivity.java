package com.example.paint;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	
	class MyView extends View { //View��� ������ ����� �޴´�
		float x1=0, y1=0, x2=0 ,y2=0;
		MyView(Context c){
			super(c);
		}
		
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			
			if( event.getAction() == MotionEvent.ACTION_DOWN){
				
				x1 = event.getX();
				y1 = event.getY();
				
			} else if ( event.getAction() == MotionEvent.ACTION_UP){
				
				x2 = event.getX();
				y2 = event.getY();
				
			} else if ( event.getAction() == MotionEvent.ACTION_MOVE){ //�����̶� �����̸�
				
				x2 = event.getX();
				y2 = event.getY();
			}
			this.invalidate(); //on draw�� ȣ���ض�
			
			return true; //���� ó���ҰŴ� return super.onTouchEvent(event);
			
			
		}


		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			//super.onDraw(canvas);
			
			Paint p; 
			p = new Paint();
			p.setColor(Color.CYAN);
			p.setStrokeWidth(10); //���� ����
			canvas.drawRect(x1, y1, x2, y2, p); //�׻� ���μ��� 50�ȼ��� ����� ���������
			
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView mv;
		mv = new MyView(this);
		setContentView(mv);//���� �׸��� �ߵ���
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
