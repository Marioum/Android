package com.odc.actionbar;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class DropDownActivity extends Activity implements ActionBar.OnNavigationListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drop_down);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add("Section 1");
		itemList.add("Section 2");
		itemList.add("Section 3");
		ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList);
		actionBar.setListNavigationCallbacks(aAdpt, this); 
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drop_down, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



	@Override
	public boolean onNavigationItemSelected(int arg0, long arg1) {
		switch (arg0) {
		case 0:
			ImageView img1 = (ImageView)findViewById(R.id.image_drop);
			img1.setBackgroundResource(R.drawable.img1);
			break;
		case 1:
			ImageView img2 = (ImageView)findViewById(R.id.image_drop);
			img2.setBackgroundResource(R.drawable.img2);
			break;
		case 2:
			ImageView img3 = (ImageView)findViewById(R.id.image_drop);
			img3.setBackgroundResource(R.drawable.img3);
			break;
		default:
			break;
		}
		return false;
	}

}
