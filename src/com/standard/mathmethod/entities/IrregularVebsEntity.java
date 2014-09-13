package com.standard.mathmethod.entities;

public class IrregularVebsEntity {

	private String present;
	private String translate;
	private String past;
	private String pastParticiple;
	
	
	public static final String PRESENT = "Present";
	public static final String TRANSLATE = "Translate";
	public static final String PAST = "Past";
	public static final String PAST_PARTICIPLE= "PastParticiple";
	public static final String TABLE_NAME = "IrregularVebs";
	
	public String getPresent() {
		return present;
	}
	public void setPresent(String present) {
		this.present = present;
	}
	public String getTranslate() {
		return translate;
	}
	public void setTranslate(String translate) {
		this.translate = translate;
	}
	public String getPast() {
		return past;
	}
	public void setPast(String past) {
		this.past = past;
	}
	public String getPastParticiple() {
		return pastParticiple;
	}
	public void setPastParticiple(String pastParticiple) {
		this.pastParticiple = pastParticiple;
	}
}
