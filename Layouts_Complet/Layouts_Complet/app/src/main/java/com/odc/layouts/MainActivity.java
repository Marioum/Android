package com.odc.layouts;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.odc.layouts.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_linear);
		getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#ffffff")));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_linear:
			setContentView(R.layout.activity_linear);
			break;
		case R.id.action_relative:
			setContentView(R.layout.activity_relative);
			break;
		default:

			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
