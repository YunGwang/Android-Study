package com.example.intent;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends Activity {
	
	EditText u;
	Button g, tel ,hp, ct, sms, map, mail, exit;
	View.OnClickListener cl;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		u = ( EditText ) findViewById(R.id.uri);
		g = ( Button ) findViewById(R.id.go);
		tel = ( Button ) findViewById(R.id.tel);
		hp = ( Button ) findViewById(R.id.homepage);
		ct = ( Button ) findViewById(R.id.contact);
		sms = ( Button ) findViewById(R.id.Sms);
		mail = ( Button ) findViewById(R.id.mail);
		exit = ( Button ) findViewById(R.id.exit);
		map = ( Button ) findViewById(R.id.map);
		cl = new OnClickListener() {
			
			public void onClick(View v) {
		
				Uri uu; //Uri타입의 변수를 만든다.
				Intent i; //intent타입의 변수를 만든다.
				i = new Intent();
				switch ( v.getId()){
				case R.id.go :
				uu = Uri.parse(u.getText().toString()); //u를 URI타입으로 바꾼다.
				i.setAction(Intent.ACTION_VIEW); //보고싶다
				i.setData(uu); // u를 받아와서
				startActivity(i); //i를 시작해라
				break;	
				case R.id.tel :
					uu = Uri.parse("tel:" + u.getText().toString()); //u를 URI타입으로 바꾼다.
					i.setAction(Intent.ACTION_VIEW); //보고싶다
					i.setData(uu); // u를 받아와서
					startActivity(i); //i를 시작해라
					break;	
				case R.id.homepage :
					uu = Uri.parse("http://" + u.getText().toString()); //u를 URI타입으로 바꾼다.
					i.setAction(Intent.ACTION_VIEW); //보고싶다
					i.setData(uu); // u를 받아와서
					startActivity(i); //i를 시작해라
					break;	
				case R.id.Sms :
					uu = Uri.parse("smsto:" + u.getText().toString()); //u를 URI타입으로 바꾼다.
					i.setAction(Intent.ACTION_VIEW); //보고싶다
					i.setData(uu); // u를 받아와서
					startActivity(i); //i를 시작해라
					break;	
				case R.id.map :
					uu = Uri.parse("geo:"+ u.getText().toString()); //u를 URI타입으로 바꾼다.
					i.setAction(Intent.ACTION_VIEW); //보고싶다
					i.setData(uu); // u를 받아와서
					startActivity(i); //i를 시작해라
					break;	
				case R.id.contact :
					uu = Uri.parse("content://contacts/people" + u.getText().toString()); //u를 URI타입으로 바꾼다.
					i.setAction(Intent.ACTION_VIEW); //보고싶다
					i.setData(uu); // u를 받아와서
					startActivity(i); //i를 시작해라
					break;	
				case R.id.mail :
					uu = Uri.parse("mailto:" + u.getText().toString()); //u를 URI타입으로 바꾼다.
					i.setAction(Intent.ACTION_VIEW); //보고싶다
					i.setData(uu); // u를 받아와서
					startActivity(i); //i를 시작해라
					break;	
				case R.id.exit :
					finish();
					break;	
					
				}
			}
		};
		g.setOnClickListener(cl);
		u.setOnClickListener(cl);
		tel.setOnClickListener(cl);
		hp.setOnClickListener(cl);
		sms.setOnClickListener(cl);
		mail.setOnClickListener(cl);
		ct.setOnClickListener(cl);
		map.setOnClickListener(cl);
		exit.setOnClickListener(cl);
	}
	
}