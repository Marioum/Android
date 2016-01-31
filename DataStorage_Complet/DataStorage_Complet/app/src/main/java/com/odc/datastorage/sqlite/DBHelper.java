package com.odc.datastorage.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	
	public static final String TABLE_ARTICLE = "article";
	
	public static final String ID_ARTICLE = "id";
	public static final String TITLE_ARTICLE = "title";
	public static final String DESC_ARTICLE = "desc";
	public static final String LOGO_ARTICLE = "logo";
	
	
	private static final String CREATE_ARTICLE = "CREATE TABLE " + TABLE_ARTICLE + " ("+ 
								ID_ARTICLE + " INTEGER, "+
								TITLE_ARTICLE + " TEXT, "+
								DESC_ARTICLE + " TEXT, "+
								LOGO_ARTICLE + " BLOB);";

	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_ARTICLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int old, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLE + ";");
		onCreate(db);
	}

}
