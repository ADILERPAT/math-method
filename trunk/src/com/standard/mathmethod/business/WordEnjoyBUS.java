package com.standard.mathmethod.business;

import java.util.ArrayList;

import android.content.Context;

import com.standard.mathmethod.data.WordEnjoyDAO;
import com.standard.mathmethod.entities.WordEntity;

public class WordEnjoyBUS {
	private WordEnjoyDAO mAdapter;

	public WordEnjoyBUS(Context context) {
		mAdapter = new WordEnjoyDAO(context);
	}
	
	public long insertWord(WordEntity wordEntity) {
		return mAdapter.insertWord(wordEntity);
	}
	
	public ArrayList<WordEntity> getAllWordEnjoy(){
		return mAdapter.getAllWordEnjoy();
	}
	
	public ArrayList<WordEntity> getWordsByWordAndCategory(String word,String category){
		return mAdapter.getWordsByWordAndCategory(word,category);
	}
	
	public ArrayList<WordEntity> getWordEnjoyByWordAndCategory(String word,String category){
		return mAdapter.getWordEnjoyByWordAndCategory(word,category);
	}
	
	public ArrayList<WordEntity> getAllWordsByCategory(String category){
		return mAdapter.getAllWordsByCategory(category);
	}
	
	public ArrayList<WordEntity> getAllWordEnjoyByCategory(String category){
		return mAdapter.getAllWordEnjoyByCategory(category);
	}
}
