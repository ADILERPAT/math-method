package com.standard.mathmethod.data;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.standard.mathmethod.adapter.DatabaseAdapter;
import com.standard.mathmethod.common.Constants;
import com.standard.mathmethod.entities.WordEntity;

public class WordEnjoyDAO {
	private DatabaseAdapter mDbAdapter;

	public WordEnjoyDAO(Context context) {
		mDbAdapter = new DatabaseAdapter(context);
	}

	public long insertWord(WordEntity entity) {
		long result = -1;
		if (entity != null) {
			ContentValues values = new ContentValues();
			
			values.put(WordEntity.WORD, entity.getWord());
			values.put(WordEntity.TRANSLATE, entity.getTranslate());
			values.put(WordEntity.CATEGORY_WORD, entity.getCatelogyWord());
			values.put(WordEntity.PHONETIC, entity.getPhonetic());
			values.put(WordEntity.SOUND, entity.getSound());
			values.put(WordEntity.CATEGORY, entity.getCatelogy());
			values.put(WordEntity.ENJOY, entity.getEnjoy());
			result = mDbAdapter.insert(Constants.COMMONWORDS, null, values);

		}
		return result;
	}
	
	public void updateWord(WordEntity entity)
	{
		if(entity!=null)
		{
			String sql = "UPDATE " + Constants.COMMONWORDS + " SET  Word='" + entity.getWord() 
					+ "', Word ='" + entity.getWord()
					+ "', Translate ='" + entity.getTranslate() 
					+ "', CategoryWord ='" + entity.getCatelogyWord() 
					+ "', Phonetic ='" + entity.getPhonetic() 
					+ "', Sound ='" + entity.getSound() 
					+ "', Category ='" + entity.getCatelogy() 
					+ "', Enjoy ='" + entity.getEnjoy() 
					+ "' where " + WordEntity.WORD + " ='" + entity.getWord() + "'" 
					+ " AND " +  WordEntity.CATEGORY + " = '" + entity.getClass(); 
			mDbAdapter.execSQL(sql);
		}
	}

	public ArrayList<WordEntity> getWordsByWordAndCategory(String word,String category){
		ArrayList<WordEntity>  wordEntity = null;
		String sql = "SELECT * FROM "+ Constants.COMMONWORDS + " WHERE "
				+ WordEntity.WORD +" = '" + word + "' AND "
				+ WordEntity.CATEGORY + " = '" + category + "'";
		Cursor cur = mDbAdapter.rawQuery(sql, null);
		if (cur != null && cur.getCount() > 0) {
			wordEntity = new ArrayList<WordEntity>();
			while (!cur.isAfterLast()) {
				wordEntity.add(getWordEntity(cur));
				cur.moveToNext();
			}
		}
		if (cur != null) {
			cur.close();
		}
		return wordEntity;
	}
	
	public  ArrayList<WordEntity> getAllWordEnjoyByCategory(String category){
		 ArrayList<WordEntity> wordEntity = null;
		String sql = "SELECT * FROM "+ Constants.COMMONWORDS + " WHERE "
				+ WordEntity.CATEGORY + " = '" + category + "' AND "
				+ WordEntity.ENJOY + " = '" + 1 + "'";
		Cursor cur = mDbAdapter.rawQuery(sql, null);
		if (cur != null && cur.getCount() > 0) {
			wordEntity = new ArrayList<WordEntity>();
			while (!cur.isAfterLast()) {
				wordEntity.add(getWordEntity(cur));
				cur.moveToNext();
			}
		}
		if (cur != null) {
			cur.close();
		}
		return wordEntity;
	}
	public ArrayList<WordEntity> getAllWordsByCategory(String category){
		ArrayList<WordEntity>  wordEntity = null;
		String sql = "SELECT * FROM "+ Constants.COMMONWORDS + " WHERE "
				+ WordEntity.CATEGORY + " = '" + category + "'";
		Cursor cur = mDbAdapter.rawQuery(sql, null);
		if (cur != null && cur.getCount() > 0) {
			wordEntity = new ArrayList<WordEntity>();
			while (!cur.isAfterLast()) {
				wordEntity.add(getWordEntity(cur));
				cur.moveToNext();
			}
		}
		if (cur != null) {
			cur.close();
		}
		return wordEntity;
	}
	
	public  ArrayList<WordEntity> getWordEnjoyByWordAndCategory(String word,String category){
		 ArrayList<WordEntity> wordEntity = null;
		String sql = "SELECT * FROM "+ Constants.COMMONWORDS + " WHERE "
				+ WordEntity.WORD +" = '" + word + "' AND "
				+ WordEntity.CATEGORY + " = '" + category + "' AND "
				+ WordEntity.ENJOY + " = '" + 1 + "'";
		Cursor cur = mDbAdapter.rawQuery(sql, null);
		if (cur != null && cur.getCount() > 0) {
			wordEntity = new ArrayList<WordEntity>();
			while (!cur.isAfterLast()) {
				wordEntity.add(getWordEntity(cur));
				cur.moveToNext();
			}
		}
		if (cur != null) {
			cur.close();
		}
		return wordEntity;
	}
	public ArrayList<WordEntity> getAllWordEnjoy() {
		ArrayList<WordEntity> wordEntity = null;
		Cursor cur = mDbAdapter.query(Constants.COMMONWORDS, null, null, null,
				null, null, null);
		if (cur != null && cur.getCount() > 0) {
			wordEntity = new ArrayList<WordEntity>();
			while (!cur.isAfterLast()) {
				wordEntity.add(getWordEntity(cur));
				cur.moveToNext();
			}
		}
		if (cur != null) {
			cur.close();
		}
		return wordEntity;
	}

	private WordEntity getWordEntity(Cursor cur) {
		
		if (cur != null) {
			WordEntity wordEntity = new WordEntity();
			if (cur.isNull(cur.getColumnIndex(WordEntity.WORD))) {
				wordEntity.setWord("");
			} else {
				wordEntity.setWord(cur.getString(cur.getColumnIndex(WordEntity.WORD)));
			}

			if (cur.isNull(cur.getColumnIndex(WordEntity.TRANSLATE))) {
				wordEntity.setTranslate("");
			} else {
				wordEntity.setTranslate(cur.getString(cur.getColumnIndex(WordEntity.TRANSLATE)));
			}
			
			if (cur.isNull(cur.getColumnIndex(WordEntity.CATEGORY_WORD))) {
				wordEntity.setCatelogyWord("");
			} else {
				wordEntity.setCatelogyWord(cur.getString(cur.getColumnIndex(WordEntity.CATEGORY_WORD)));
			}
			
			if (cur.isNull(cur.getColumnIndex(WordEntity.PHONETIC))) {
				wordEntity.setPhonetic("");
			} else {
				wordEntity.setPhonetic(cur.getString(cur.getColumnIndex(WordEntity.PHONETIC)));
			}
			
			if (cur.isNull(cur.getColumnIndex(WordEntity.SOUND))) {
				wordEntity.setSound("");
			} else {
				wordEntity.setSound(cur.getString(cur.getColumnIndex(WordEntity.SOUND)));
			}
			
			if (cur.isNull(cur.getColumnIndex(WordEntity.CATEGORY))) {
				wordEntity.setCatelogy("");
			} else {
				wordEntity.setCatelogy(cur.getString(cur.getColumnIndex(WordEntity.CATEGORY)));
			}
			
			if (cur.isNull(cur.getColumnIndex(WordEntity.ENJOY))) {
				wordEntity.setEnjoy(0);
			} else {
				wordEntity.setEnjoy(cur.getInt(cur.getColumnIndex(WordEntity.ENJOY)));
			}
			
			return wordEntity;
		}
		return null;
	}
}
