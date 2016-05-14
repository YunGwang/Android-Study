package com.example.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class info1 extends Activity {
	
	EditText num, name, age, sex;
	Button ins, gos;
	View.OnClickListener cl;
	MyHelper mh;
	SQLiteDatabase database;
	
	class MyHelper extends SQLiteOpenHelper {
		public MyHelper(Context c) {
			super(c, "student.db", null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("create table score (num char(20), kor int, eng int, math int, total int, avg double);"); 
			db.execSQL("create table info (num char(20), name char(20), age int, sex char(10));"); //평균,최고,최저를 구해야할땐 int"
			
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("drop table if exists score;");
			db.execSQL("drop table if exists info1;");
			onCreate(db);
			
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info1);
		mh = new MyHelper(this);
		
		num = (EditText) findViewById(R.id.num1);
		name = (EditText) findViewById(R.id.name);
		age = (EditText) findViewById(R.id.age);
		sex = (EditText) findViewById(R.id.sex);
		ins = (Button) findViewById(R.id.insert1);
		gos = (Button) findViewById(R.id.goscore);
		
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String sql ;
				switch(v.getId()){
				case R.id.insert1:
					database = mh.getWritableDatabase();
					Cursor cur;
					sql = "insert into info values ('" + num.getText().toString() + "','";
					sql = sql+ name.getText().toString() + "'," + age.getText().toString();
					sql = sql+ ",'"+sex.getText().toString() +"');";
					database.execSQL(sql);
					database.close();
					Toast.makeText(getApplicationContext(), sql,
							Toast.LENGTH_LONG).show();
					break;
					
				case R.id.goscore:
					Intent i = new Intent(getApplication(), MainActivity.class);
					startActivity(i);
					break;
					
				}
				
			}
		};
		
		ins.setOnClickListener(cl);
		gos.setOnClickListener(cl);
		
	}

}
