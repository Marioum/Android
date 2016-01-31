package com.odc.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends TracerActivity {
	// constant to determine which sub-activity returns
	  private static final int REQUEST_CODE = 10;
	Spinner sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.odc.activitylifecycle.R.layout.activity_main);
		sp = (Spinner) findViewById(com.odc.activitylifecycle.R.id.spinner1);
	}
//
	public void onClick(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("choix", sp.getSelectedItem().toString());
		//startActivity(intent);
		startActivityForResult(intent, REQUEST_CODE);
	}
	
	@Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
	      if (data.hasExtra("rating")) {
	        String result = data.getExtras().getString("rating");
	        if (result != null && result.length() > 0) {
	          Toast.makeText(this, "Niveau de satisfaction: "+result, Toast.LENGTH_LONG).show();
	        }
	      }
	    }
	  }

}