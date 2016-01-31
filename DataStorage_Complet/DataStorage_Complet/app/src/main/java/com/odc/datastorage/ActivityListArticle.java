package com.odc.datastorage;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.odc.datastorage.adapter.ArticleAdapter;
import com.odc.datastorage.entities.Article;
import com.odc.datastorage.sqlite.ArticleBDD;
import com.odc.datastorage.utils.MyApp;

public class ActivityListArticle extends Activity {
	ArticleBDD articleBDD;
	List<Article> articleList;
	ListView listViewArticle;
	ArticleAdapter adapter;
	
	MyApp app;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_article_activity);
		
		app = (MyApp) getApplication();
		if (app.isConnected()) {
			getActionBar().setIcon(R.drawable.icon_reports_connected);
		}
		else {
			getActionBar().setIcon(R.drawable.icon_reports_notconnected);
		}
		getActionBar().setDisplayHomeAsUpEnabled(true);
		articleBDD = new ArticleBDD(getApplicationContext());
		articleBDD.open();

		articleList = articleBDD.selectAll();
		listViewArticle = (ListView) findViewById(R.id.listArticle);

		listViewArticle.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int arg2, long arg3) {
				// TODO Auto-generated method stub

				AlertDialog.Builder alertDialog = new AlertDialog.Builder(ActivityListArticle.this);

				alertDialog.setTitle("Confirm Delete...");
				alertDialog.setMessage("Are you sure you want delete this?");
				alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int which) {
						articleBDD.open();

						articleBDD.removeArticle(articleList.get(arg2).getId());
						articleList = articleBDD.selectAll();
						listViewArticle.setAdapter(new ArticleAdapter(getBaseContext(), R.layout.item_article, articleList));
						articleBDD.close();
					}
				});
				alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				alertDialog.show();

				return false;
			}
		});
		listViewArticle.setAdapter(new ArticleAdapter(getBaseContext(), R.layout.item_article, articleList));
		articleBDD.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_remove_all:
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(ActivityListArticle.this);

			alertDialog.setTitle("Confirm Delete...");
			alertDialog.setMessage("Are you sure you want delete all the list?");
			alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int which) {
					articleBDD.open();
					articleBDD.removeAllArticles();
					articleList = articleBDD.selectAll();
					listViewArticle.setAdapter(new ArticleAdapter(getBaseContext(), R.layout.item_article, articleList));
					articleBDD.close();
				}
			});
			alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			alertDialog.show();
			return true;

		}
		return super.onOptionsItemSelected(item);
	}


}