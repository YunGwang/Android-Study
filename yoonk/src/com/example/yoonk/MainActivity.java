package com.example.yoonk;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	float x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	int color = Color.RED;
	int type = 1;
	int width = 1;
	ArrayList<Shape> arr; // shape라는 타입을 계속 누적

	class Shape {
		float x1, y1, x2, y2;
		int ty, co, wi;

		public Shape(float a1, float a2, float a3, float a4, int a5, int a6, int a7) {
			x1 = a1;
			y1 = a2;
			x2 = a3;
			y2 = a4;
			ty = a5;
			co = a6;
			wi = a7;
		}
	}

	class MyView extends View {

		Paint p;

		MyView(Context c) {
			super(c);
		}

		protected void onDraw(Canvas canvas) {
			Paint p = new Paint();
			p.setStyle(Style.STROKE); // 바깥선 그려짐
			for (int i = 0; i < arr.size(); i++) {

				p.setColor(arr.get(i).co);
				p.setStrokeWidth(arr.get(i).wi);

				switch (arr.get(i).ty) {
				case 1:
					canvas.drawRect(arr.get(i).x1, arr.get(i).y1, arr.get(i).x2, arr.get(i).y2, p);
					break;
				case 2:
					canvas.drawLine(arr.get(i).x1, arr.get(i).x2, arr.get(i).y1, arr.get(i).y2, p);
					break;
				case 3:
					float r;
					r = (float) Math.sqrt((arr.get(i).x2 - arr.get(i).x1) * (arr.get(i).x2 - arr.get(i).x1)
							+ (arr.get(i).y2 - arr.get(i).y1) * (arr.get(i).y2 - arr.get(i).y1));
					canvas.drawCircle(arr.get(i).x1, arr.get(i).y1, r, p); // 반지름
					break;
				case 4:
					canvas.drawLine(arr.get(i).x1, arr.get(i).y2, arr.get(i).x2, arr.get(i).y2, p);
					canvas.drawLine(arr.get(i).x2, arr.get(i).y2, (arr.get(i).x1 + arr.get(i).x2) / 2, arr.get(i).y1,
							p);
					canvas.drawLine((arr.get(i).x1 + arr.get(i).x2) / 2, arr.get(i).y1, arr.get(i).x1, arr.get(i).y2,
							p);
					break;
				}
			}

			p.setColor(color);
			p.setStrokeWidth(width);
			switch (type) {
			case 1:
				canvas.drawRect(x1, y1, x2, y2, p);
				break;
			case 2:
				canvas.drawLine(x1, y1, x2, y2, p);
				break;
			case 3:
				float r;
				r = (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
				canvas.drawCircle(x1, y1, r, p); // 반지름
				break;
			case 4:
				canvas.drawLine(x1, y2, x2, y2, p);
				canvas.drawLine(x2, y2, (x1 + x2) / 2, y1, p);
				canvas.drawLine((x1 + x2) / 2, y1, x1, y2, p);
				break;
			}
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				x1 = event.getX();
				y1 = event.getY();
				break;
			case MotionEvent.ACTION_MOVE:
				x2 = event.getX();
				y2 = event.getY();
				this.invalidate();
				break;
			case MotionEvent.ACTION_UP:
				x2 = event.getX();
				y2 = event.getY();
				arr.add(new Shape(x1, y1, x2, y2, type, color, width));
				this.invalidate();
				break;
			}
			return true;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView mv = new MyView(this);
		arr = new ArrayList<Shape>(); // 초기화
		setContentView(mv);
		// 기존것을 없애고 mv를 뜨게함

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		/*
		 * SubMenu sm1, sm2, sm3; sm1 = menu.addSubMenu("COLOR"); sm1.add(0,
		 * 201, 0, "red"); sm1.add(0, 202, 0, "blue"); sm1.add(0, 203, 0,
		 * "green"); /*sm2 = menu.addSubMenu("TYPE"); sm2.add(0, 301, 0,
		 * "rectangle"); sm2.add(0, 302, 0, "line"); sm2.add(0, 303, 0,
		 * "circle"); sm2.add(0, 304, 0, "triangle"); /*sm3 =
		 * menu.addSubMenu("WIDTH"); sm3.add(0, 401, 0, "1"); sm3.add(0, 402, 0,
		 * "2"); sm3.add(0, 403, 0, "3"); sm3.add(0, 404, 0, "4"); sm3.add(0,
		 * 405, 0, "5");
		 */
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
		case R.id.RED:
			color = Color.RED;
			break;
		case R.id.BLUE:
			color = Color.BLUE;
			break;
		case R.id.GREEN:
			color = Color.GREEN;
			break;
		case R.id.line:
			type = 1;
			break;
		case R.id.rect:
			type = 2;
			break;
		case R.id.circle:
			type = 3;
			break;
		case R.id.triangle:
			type = 4;
			break;
		case R.id.w1:
			width = 1;
			break;
		case R.id.w2:
			width = 2;
			break;
		case R.id.w3:
			width = 3;
			break;
		case R.id.w4:
			width = 4;
			break;
		case R.id.w5:
			width = 5;
			break;
		case R.id.dial:
			AlertDialog.Builder dlg;
			dlg = new AlertDialog.Builder(MainActivity.this);
			dlg.setTitle("제목입니다");
			final String[] ver = new String[] { "Honeycomb", "Icecream Sandwitch", "jelly bean", "kitkat",
					"marshmallow" };
			// dlg.setMessage("남자면 YES 여자면 NO");
			dlg.setItems(ver, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "당신의 스마트폰 버전은 " + ver[which],Toast.LENGTH_LONG).show();
					
				}
			});
			dlg.setIcon(R.drawable.ic_launcher);
			dlg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "당신은 남자군요!", Toast.LENGTH_LONG).show();
				}
			});
			dlg.setNegativeButton("No", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "당신은 여자군요!", Toast.LENGTH_LONG).show();
				}
			});
			dlg.show();
			break;

		}
		return super.onOptionsItemSelected(item);
	}
}
