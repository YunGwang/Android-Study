package com.example.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText num, kor, eng, math, text;
	Button ins, sel, del, upd, go, exec, goin;
	TextView res;
	MyHelper mh;
	SQLiteDatabase database;
	View.OnClickListener cl;

	class MyHelper extends SQLiteOpenHelper {
		public MyHelper(Context c) {
			super(c, "student.db", null, 1);
		}
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("create table score (num char(20), kor int, eng int, math int, total int, avg double);"); 
			db.execSQL("create table info (num char(20), name char(20), age int, sex char(10));"); //평균,최고,최저를 구해야할땐 int"
		}
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("drop table if exists score;");
			db.execSQL("drop table if exists info1;");
			onCreate(db);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mh = new MyHelper(this);
		num = (EditText) findViewById(R.id.num);
		kor = (EditText) findViewById(R.id.kor);
		eng = (EditText) findViewById(R.id.eng);
		math = (EditText) findViewById(R.id.math);
		text = (EditText) findViewById(R.id.text);
		ins = (Button) findViewById(R.id.insert);
		sel = (Button) findViewById(R.id.select);
		del = (Button) findViewById(R.id.delete);
		upd = (Button) findViewById(R.id.update);
		go = (Button) findViewById(R.id.go);
		exec = (Button) findViewById(R.id.exec);
		goin = (Button) findViewById(R.id.goinfo);
		res = (TextView) findViewById(R.id.result);

		cl = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String sql;
				switch (v.getId()) {
				case R.id.insert:
					database = mh.getWritableDatabase();
					sql = "insert into score values ('"
							+ num.getText().toString() + "',";
					sql = sql + kor.getText().toString() + ","
							+ eng.getText().toString();
					sql = sql + "," + math.getText().toString() + ",0,0);";
					database.execSQL(sql);
					database.close();
					Toast.makeText(getApplicationContext(), sql,
							Toast.LENGTH_LONG).show();
					break;

				// 가져오는거

				case R.id.select:
					database = mh.getWritableDatabase();
					Cursor cur;
					sql = "select * from score where num = '"
							+ num.getText().toString() + "';";
					cur = database.rawQuery(sql, null);
					cur.moveToFirst();
					kor.setText(cur.getString(1));
					eng.setText(cur.getString(2));
					math.setText(cur.getString(3));
					cur.close();
					database.close();
					Toast.makeText(getApplicationContext(), sql,
							Toast.LENGTH_LONG).show();
					break;

				case R.id.delete:
					database = mh.getWritableDatabase();
					sql = "delete from score where num='"
							+ num.getText().toString() + "';";
					database.execSQL(sql);
					database.close();
					Toast.makeText(getApplicationContext(), sql,
							Toast.LENGTH_LONG).show();
					break;

				case R.id.update:
					database = mh.getWritableDatabase();
					sql = "update score set kor =" + kor.getText().toString()
							+ ",";
					sql = sql + "eng=" + eng.getText().toString() + ",";
					sql = sql + "math=" + math.getText().toString()
							+ " where num='";
					sql = sql + num.getText().toString() + "';";
					database.execSQL(sql);
					database.close();
					Toast.makeText(getApplicationContext(), sql,
							Toast.LENGTH_LONG).show();
					break;

				case R.id.go:
					database = mh.getWritableDatabase();
					sql = text.getText().toString();
					cur = database.rawQuery(sql, null);
					String r = "";
					while (cur.moveToNext()) {
						r = r + cur.getString(0) + " " + cur.getString(1) + " ";
						r = r + cur.getString(2) + " " + cur.getString(3) + " ";
						r = r + cur.getString(4) + " " + cur.getString(5)+ "\n";
					}
					res.setText(r);
					cur.close();
					database.close();
					Toast.makeText(getApplicationContext(), sql,
							Toast.LENGTH_LONG).show();
					break;

				case R.id.exec:
					database = mh.getWritableDatabase();
					sql = text.getText().toString();
					database.execSQL(sql);
					database.close();
					Toast.makeText(getApplicationContext(), sql,
							Toast.LENGTH_LONG).show();
					break;
					
				case R.id.goinfo:
					Intent i = new Intent(getApplication(), info1.class);
					startActivity(i);
					break;
				}
			}
		};

		ins.setOnClickListener(cl);
		sel.setOnClickListener(cl);
		del.setOnClickListener(cl);
		upd.setOnClickListener(cl);
		go.setOnClickListener(cl);
		exec.setOnClickListener(cl);
		goin.setOnClickListener(cl);

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