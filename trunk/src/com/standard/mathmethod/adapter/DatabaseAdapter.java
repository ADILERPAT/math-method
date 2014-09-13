package com.standard.mathmethod.adapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.standard.mathmethod.common.Constants;

public class DatabaseAdapter {
	
	private static final String DATABASE_EXTERNAL_FILE_PATH = Environment.getExternalStorageDirectory().toString() + "/EnglishConversation/Database";
	private static final String DATABASE_INTERNAL_FILE_PATH = "/data/data/" + Constants.PACKAGE_NAME + "/databases/";
	private static final String DATABASE_NAME = "data.db";
	private static SQLiteDatabase mDatabase;
	
	private static final String CREATE_WORDS_TABLE = "CREATE TABLE IF NOT EXISTS WordEnjoy( Description TEXT, Word TEXT,Translate TEXT, PRIMARY KEY(Word))";
	
	private Context context;
	public DatabaseAdapter(Context context) {
		this.context = context;
		File appDbDir = new File(DATABASE_INTERNAL_FILE_PATH);

		if (!appDbDir.exists()) {
			appDbDir.mkdirs();
		}
		try {
				createDataBase();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (mDatabase == null) {
			mDatabase = getReadableWritableDatabase();
		}

	}
	
	public void createDataBase() throws IOException 
	{ 
	   boolean mDataBaseExist = checkDataBase(); 
	   if(!mDataBaseExist) 
	   { 
	      try  
	      { 
	        copyDataBase(); 
	      }  
	      catch (IOException mIOException)  
	      { 
	         throw new Error("ErrorCopyingDataBase"); 
	     } 
	  } 
	} 
	
	private boolean checkDataBase() 
	{ 
	    File dbFile = new File(DATABASE_INTERNAL_FILE_PATH + DATABASE_NAME); 
	    return dbFile.exists(); 
	} 
	
	private void copyDataBase() throws IOException 
	  { 
	    InputStream mInput = context.getAssets().open(DATABASE_NAME); 
	    String outFileName = DATABASE_INTERNAL_FILE_PATH + DATABASE_NAME; 
	    OutputStream mOutput = new FileOutputStream(outFileName); 
	    byte[] mBuffer = new byte[1024]; 
	    int mLength; 
	    while ((mLength = mInput.read(mBuffer))>0) 
	    { 
	        mOutput.write(mBuffer, 0, mLength); 
	    } 
	    mOutput.flush(); 
	    mOutput.close(); 
	    mInput.close(); 
	}
		
	public SQLiteDatabase getReadableWritableDatabase() {
		SQLiteDatabase database = null;
		try {
			//SQLiteDatabase db = SQLiteDatabase.openDatabase(DATABASE_FILE_PATH + File.separator + DATABASE_NAME, null, SQLiteDatabase.OPEN_READWRITE|SQLiteDatabase.NO_LOCALIZED_COLLATORS + SQLiteDatabase.CREATE_IF_NECESSARY);
			//Context mainContext = EnglishApplication.getBaseApplicationContext();
	        database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_WORLD_WRITEABLE | Context.MODE_WORLD_READABLE, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return database;
	}
	
	public void onCreate() {		
		mDatabase.execSQL(CREATE_WORDS_TABLE);
	}
	
	public void onUpgrade() {
		mDatabase.execSQL("DROP TABLE IF EXISTS WordEnjoy");
		onCreate();
	}
	
	public long insert(String table, String nullColumnHack, ContentValues values) {
		long result = mDatabase.insert(table, nullColumnHack, values);
		return result;
	}
	
	public void execSQL(String sql) throws SQLException {
		mDatabase.execSQL(sql);
	}
	
	public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		Cursor cur = mDatabase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
		if (cur != null) {
			cur.moveToFirst();
		}
		return cur;
	}
	
	public Cursor rawQuery(String sql, String[] selectionArgs) {
		Cursor cur = mDatabase.rawQuery(sql, selectionArgs);
		if (cur != null) {
			cur.moveToFirst();
		}
		return cur;
	}
}
