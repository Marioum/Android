package com.odc.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class SecondActivity extends TracerActivity {
	TextView tv_choix;
	RatingBar rating;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.odc.activitylifecycle.R.layout.activity_second);
		// Recevoir les donn�es
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		// R�cup�rer le choix
		String value1 = extras.getString(Intent.EXTRA_TEXT);
		if (value1 != null) {
			// Afficher le choix
		}

		tv_choix = (TextView) findViewById(com.odc.activitylifecycle.R.id.tv_choix);
		tv_choix.setText(extras.getCharSequence("choix"));

		rating = (RatingBar) findViewById(com.odc.activitylifecycle.R.id.ratingBar1);
	}

	@Override
	public void finish() {

		// TODO 1 create new data Intent
		Intent data = new Intent();
		// Activity finished ok, return the data
		
		// TODO 2 put the data with the id returnValue
		data.putExtra("rating", ""+rating.getProgress());
		
		// TODO 3 use setResult(RESULT_OK, intent);
		// to return the Intent to the application
		setResult(RESULT_OK, data);

		super.finish();
	}

}