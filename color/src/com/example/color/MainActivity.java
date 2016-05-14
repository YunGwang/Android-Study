package com.example.color;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	EditText r, g, b; // int i�� ���� �ǹ�
	Button re, gr, bl, ye, an;
	View.OnClickListener cl; //�� 3���� �� ������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		r = (EditText) findViewById(R.id.n_red); //c���� int�� float�� �ٲٴ� ���Ұ� ��� (��������ִ� ��)
		g = (EditText) findViewById(R.id.n_green);
		b = (EditText) findViewById(R.id.n_blue);
		re = (Button) findViewById(R.id.red);
		gr = (Button) findViewById(R.id.green);
		bl = (Button) findViewById(R.id.blue);
		ye = (Button) findViewById(R.id.yellow);
		an = (Button) findViewById(R.id.any);
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId())  {
				case R.id.red : //red��ư�� ������ ���Դ���?
					r.setBackgroundColor(Color.RED); //�����ư�� ������ te�� ��׶��� �÷��� ����� �ٲ��
					break;
					
				case R.id.green : //green��ư�� ������ ���Դ���?
					r.setBackgroundColor(Color.GREEN); //�׸���ư�� ������ te�� ��׶��� �÷��� �׸����� �ٲ��
					break;
					
				case R.id.blue : //green��ư�� ������ ���Դ���?
					r.setBackgroundColor(Color.BLUE); //����ư�� ������ te�� ��׶��� �÷��� ���� �ٲ��
					break;
					
				case R.id.yellow : //yellow��ư�� ������ ���Դ���?
					r.setBackgroundColor(Color.YELLOW); //���ο��ư�� ������ te�� ��׶��� �÷��� ���� �ٲ��
					break;
					
				case R.id.any : //yellow��ư�� ������ ���Դ���?
					int ir, ig, ib;
					ir = Integer.parseInt(r.getText().toString());
					ig = Integer.parseInt(g.getText().toString());
					ib = Integer.parseInt(b.getText().toString());
					r.setBackgroundColor(Color.rgb(ir, ig, ib));
					break;
				}
				
				
				
			}
		};
		
		re.setOnClickListener(cl); //red��ư ������ cl�Լ��� ȣ���ش޶�
		gr.setOnClickListener(cl);
		bl.setOnClickListener(cl);
		ye.setOnClickListener(cl);
		an.setOnClickListener(cl);
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
