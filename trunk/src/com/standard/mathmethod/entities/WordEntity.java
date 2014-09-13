package com.standard.mathmethod.entities;

public class WordEntity {

	private String word;
	private String translate;
	private int enjoy;
	private String catelogy;
	private String catelogyWord;
	private String phonetic;
	private String sound;
	
	public static final String WORD = "Word";
	public static final String TRANSLATE = "Translate";
	public static final String PHONETIC = "Phonetic";
	public static final String CATEGORY = "Category";
	public static final String CATEGORY_WORD = "CategoryWord";
	public static final String SOUND = "Sound";
	public static final String ENJOY = "Enjoy";
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getTranslate() {
		return translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}

	public int getEnjoy() {
		return enjoy;
	}

	public void setEnjoy(int enjoy) {
		this.enjoy = enjoy;
	}

	public String getCatelogy() {
		return catelogy;
	}

	public void setCatelogy(String catelogy) {
		this.catelogy = catelogy;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getPhonetic() {
		return phonetic;
	}

	public void setPhonetic(String phonetic) {
		this.phonetic = phonetic;
	}

	public String getCatelogyWord() {
		return catelogyWord;
	}

	public void setCatelogyWord(String catelogyWord) {
		this.catelogyWord = catelogyWord;
	}

}
