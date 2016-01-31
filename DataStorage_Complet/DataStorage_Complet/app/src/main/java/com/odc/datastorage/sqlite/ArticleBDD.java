package com.odc.datastorage.sqlite;

import java.util.ArrayList;
import java.util.List;

import com.odc.datastorage.entities.Article;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ArticleBDD {
	
	private static final int VERSION_BDD = 1;
	private static final String NAME_BDD = "article.db";
	
	private SQLiteDatabase bdd;
	
	private DBHelper dbHelper;
	
	public ArticleBDD(Context context) {
		super();
		dbHelper = new DBHelper(context, NAME_BDD, null, VERSION_BDD);
	}
	
	public void open(){
		//on ouvre la BDD en �criture
		bdd = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		//on ferme l'acc�s � la BDD
		bdd.close();
	}
	
	public SQLiteDatabase getBDD(){
		return bdd;
	}
	
	public long insertTop(Article partis){
		Cursor cursor = bdd.rawQuery("select max("+DBHelper.ID_ARTICLE+") from "+DBHelper.TABLE_ARTICLE, null);
		if (cursor.moveToFirst()) partis.setId(cursor.getInt(0)+1);
		else partis.setId(1);
		
		ContentValues values = new ContentValues();
		values.put(DBHelper.ID_ARTICLE, partis.getId());
		values.put(DBHelper.TITLE_ARTICLE, partis.getTitle());
		values.put(DBHelper.DESC_ARTICLE, partis.getDesc());
		values.put(DBHelper.LOGO_ARTICLE, partis.getLogo());
		return bdd.insert(DBHelper.TABLE_ARTICLE, null, values);
	}
	
	public int removeAllArticles(){
		return bdd.delete(DBHelper.TABLE_ARTICLE, null, null);
	}
	public int removeArticle(int index){
		return bdd.delete(DBHelper.TABLE_ARTICLE, "`"+DBHelper.ID_ARTICLE+"`=?", new String[] {String.valueOf(index)});
	}
	
	public List<Article> selectAll() {
	      List<Article> list = new ArrayList<Article>();
	      Cursor cursor = this.bdd.query(DBHelper.TABLE_ARTICLE,new String[] {"*"},
	        null, null, null, null, null);
	      if (cursor.moveToFirst()) {
	         do {
	        	 Article article = new Article();
	        	 article.setId(cursor.getInt(0));
	        	 article.setTitle(cursor.getString(1));
	        	 article.setDesc(cursor.getString(2));
	        	 article.setLogo(cursor.getBlob(3));
	        	 list.add(article);
	         } while (cursor.moveToNext());
	      }
	      if (cursor != null && !cursor.isClosed()) {
	         cursor.close();
	      }
	      return list;
	   }
}
