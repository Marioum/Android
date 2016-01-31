package com.odc.datastorage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.odc.datastorage.entities.Article;
import com.odc.datastorage.sqlite.ArticleBDD;
import com.odc.datastorage.utils.MyApp;
import com.odc.datastorage.utils.Utilities;


public class ActivityAddArticle extends Activity {

	static Bitmap bmp = null;
	String title = null;
	String desc = null;

	Button btnAdd = null;
	ArticleBDD articleBDD;
	
	MyApp app;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_article_activity);
		
		
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		
		app = (MyApp) getApplication();
		if (app.isConnected()) {
			getActionBar().setIcon(R.drawable.icon_reports_connected);
		}
		else {
			getActionBar().setIcon(R.drawable.icon_reports_notconnected);
		}
	}

	public void take(View v) {
		startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 37);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 37 && resultCode == Activity.RESULT_OK) {
			bmp = (Bitmap) data.getExtras().get("data");
			((ImageButton)findViewById(R.id.image)).setImageBitmap(bmp);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.article, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_add:
			title = ((EditText)findViewById(R.id.title)).getText().toString();
			desc = ((EditText)findViewById(R.id.desc)).getText().toString();
			if (bmp!=null && title!="" && desc!="") {
				articleBDD = new ArticleBDD(getApplicationContext());
				articleBDD.open();
				articleBDD.insertTop(new Article(title,desc,Utilities.getBytes(bmp)));
				articleBDD.close();
				Toast.makeText(getApplicationContext(), "Article Saved", Toast.LENGTH_LONG).show();
			}else {
				Toast.makeText(getApplicationContext(), "Empty field", Toast.LENGTH_LONG).show();
			}
			return true;
		case R.id.action_list:
			startActivity(new Intent(ActivityAddArticle.this,ActivityListArticle.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
