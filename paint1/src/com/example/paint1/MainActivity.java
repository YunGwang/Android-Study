package com.example.paint1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	int cc = Color.RED;
	int type = 1;
	int width = 1;
	EditText wid;
	Button rec,lin, cir, tri, set;
	LinearLayout myll ;
	ImageButton blu,yel,gre;
	View.OnClickListener cl;
	
	
	class MyView extends View{
		float x1=0, y1=0, x2=0, y2=0;
		MyView(Context c) {
			super(c);
		}
		protected void onDraw(Canvas canvas){
			Paint p = new Paint();
			p.setColor(cc);
			p.setStrokeWidth(width);
			p.setStyle(Style.STROKE); //바깥선 그려짐
			if (type == 1)
			canvas.drawRect(x1, y1, x2, y2, p);
			else if (type == 2)
				canvas.drawLine(x1, y1, x2, y2, p);
			else if (type == 3){
				float r;
				r = (float) Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
				canvas.drawCircle(x1, y1, r, p); //반지름
			}
			else if (type ==4 ) {
				canvas.drawLine(x1, y2, x2, y2, p);
				canvas.drawLine(x2, y2, (x1+x2)/2, y1, p);
				canvas.drawLine((x1+x2)/2, y1, x1, y2, p);
			}
		}
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			switch(event.getAction()){
			case MotionEvent.ACTION_DOWN :
				x1 = event.getX() ;
				y1 = event.getY() ;
				break;
			case MotionEvent.ACTION_UP :
			case MotionEvent.ACTION_MOVE :
				x2 = event.getX() ;
				y2 = event.getY() ;
				this.invalidate() ;
				break;
			}
			return true;
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView mv = new MyView(this);
		setContentView(R.layout.activity_main);
		//기존것을 없애고  mv를 뜨게함
		
		myll = (LinearLayout) findViewById(R.id.pict);
		myll.addView(mv); // 해당하는 레이아웃에 mv가 들어감
		
		wid = (EditText) findViewById(R.id.wid);
		rec = (Button) findViewById(R.id.rect);
		lin = (Button) findViewById(R.id.line);
		cir = (Button) findViewById(R.id.circ);
		tri = (Button) findViewById(R.id.tri);
		set = (Button) findViewById(R.id.set);
		blu = (ImageButton) findViewById(R.id.Blue);
		yel = (ImageButton) findViewById(R.id.Yellow);
		gre = (ImageButton) findViewById(R.id.green);
		
		
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			switch(v.getId()) {
			case R.id.set:
				width = Integer.parseInt(wid.getText().toString());
				break;
			case R.id.rect :
				type = 1;
				break;
			case R.id.line :
				type = 2;
				break;
			case R.id.circ :
				type = 3;
				break;
			case R.id.tri :
				type = 4;
				break;
			case R.id.Blue :
				cc = Color.BLUE;
				break;
			case R.id.green :
				cc = Color.GREEN;
				break;
			case R.id.Yellow :
				cc=  Color.YELLOW;
				break;
			}
			}
		};
		rec.setOnClickListener(cl);   // 누르면 실행됨
		lin.setOnClickListener(cl);
		cir.setOnClickListener(cl);
		tri.setOnClickListener(cl);
		set.setOnClickListener(cl);
		blu.setOnClickListener(cl);
		gre.setOnClickListener(cl);
		yel.setOnClickListener(cl);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		SubMenu sm1, sm2, sm3;
		sm1 = menu.addSubMenu("COLOR");
		sm1.add(0, 201, 0, "red");
		sm1.add(0, 202, 0, "blue");
		sm1.add(0, 203, 0, "green");
		sm2 = menu.addSubMenu("TYPE");
		sm2.add(0, 301, 0, "rectangle");
		sm2.add(0, 302, 0, "line");
		sm2.add(0, 303, 0, "circle");
		sm2.add(0, 304, 0, "triangle");
		sm3 = menu.addSubMenu("WIDTH");
		sm3.add(0, 401, 0, "1");
		sm3.add(0, 402, 0, "2");
		sm3.add(0, 403, 0, "3");
		sm3.add(0, 404, 0, "4");
		sm3.add(0, 405, 0, "5");
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
		switch (id) {
		case 201 : 
			cc = Color.RED;
			break;
		case 202 :
			cc = Color.BLUE;
			break;
		case 203 :
			cc = Color.GREEN;
			break;
		case 301 :
			type = 1;
			break;
		case 302 :
			type = 2;
			break;
		case 303 :
			type = 3;
			break;
		case 304 :
			type = 4;
			break;
		case 401 :
			width = 1;
			break;
		case 402 :
			width = 2;
			break;
		case 403 :
			width = 3;
			break;
		case 404 :
			width = 4;
			break;
		case 405 :
			width = 5;
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
