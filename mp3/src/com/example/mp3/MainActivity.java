package com.example.mp3;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
	
	Button pl, pa, st;
	View.OnClickListener cl;
	MediaPlayer mp;
	MediaController mc1;
	VideoView vv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mp = null;
		vv = null;
		pl = (Button) findViewById(R.id.play);
		pa = (Button) findViewById(R.id.pause);
		st = (Button) findViewById(R.id.stop);
		mc1  = (MediaController) findViewById(R.id.mc2);
		vv = (VideoView) findViewById(R.id.video);
		cl = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch( v.getId()){
				case R.id.play :
					//if( vv == null){
						
					//}
					/*if ( mp == null){
					mp = MediaPlayer.create(getApplicationContext(), R.raw.aigo);
					
					/*try{
					mp = new MediaPlayer();
					mp.setDataSource("/storage/sdcard/sound.mp3");
					mp.prepare();
					} catch (Exception e){
					}  //
					mp.start();
					}*/
					//mp.start();
					 MediaController mc = new MediaController(getApplicationContext());
					vv.setMediaController(mc); 
					Uri u = Uri.parse("android.resource://com.example.mp3/"+ R.raw.aigo);
					vv.setVideoURI(u);
					vv.start();
					break;
				case R.id.pause :
					if( vv.isPlaying())
						vv.pause();
					/*if ( mp.isPlaying())
						mp.pause(); */
					break;
				case R.id.stop :
					vv.stopPlayback();
	
					/*
					mp.stop();
					mp.release();
					mp = null;*/
					break;
				}
				
			}
		};
		
		pl.setOnClickListener(cl);
		pa.setOnClickListener(cl);
		st.setOnClickListener(cl);
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
