package com.odc.actionbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_dial:
			openDialPad();
			return true;
		case R.id.action_message:
			sendNewMessage();
			return true;
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}


	private void sendNewMessage() {
		// TODO Auto-generated method stub
		Intent intentsms = new Intent( Intent.ACTION_VIEW, Uri.parse( "sms:" + "" ) );
        intentsms.putExtra( "sms_body", "Test text..." );
        startActivity( intentsms );
	}


	private void openDialPad() {
		// TODO Auto-generated method stub
		Intent dial = new Intent();
		dial.setAction("android.intent.action.DIAL");
		dial.setData(Uri.parse("tel: 197"));
		startActivity(dial);
	}


	private void openSettings() {
		// TODO Auto-generated method stub
		startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
	}


	public void search(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this , SearchActivity.class);
		startActivity(intent);
	}
	
	public void share(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this , ShareActivity.class);
		startActivity(intent);
	}
	
	public void tabs(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this , TabsActivity.class);
		startActivity(intent);
	}
	
	public void dropdown(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this , DropDownActivity.class);
		startActivity(intent);
	}
	
	public void myactionbar(View view) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this , CustomActivity.class);
		startActivity(intent);
	}
}
