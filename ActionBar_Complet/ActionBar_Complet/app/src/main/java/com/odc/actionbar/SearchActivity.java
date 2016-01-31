package com.odc.actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class SearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		 ActionBar actionBar = getActionBar();
		    actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
	    
		return true;
	}

}
