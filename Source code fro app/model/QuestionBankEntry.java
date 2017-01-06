package com.exam2.model;

import java.io.Serializable;

import android.content.ContentValues;

@SuppressWarnings("serial")
/**
 * 
 * get doesnt work?
 */
public class QuestionBankEntry implements Serializable {
	private int _id;
	private String question="";
	private String opt1="";
	private String opt2="";
	private String opt3="";
	private String opt4="";
	private String answer="";
	private String explain="";
	private int answeredTime;
	private int rightTime;
	private int wrongTime;
	private int collectedFlag;
	private int inWrongFlag;
	public int get_id() {
		return _id;
	}


	public String getQuestion() {
		return question;
	}
	
	public String getOpt1() {
		return opt1;
	}
	
	public String getOpt2() {
		return opt2;
	}
	
	public String getOpt3() {
		return opt3;
	}
	
	public String getOpt4() {
		return opt4;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public String getExplain() {
		return explain;
	}
	
	public int getAnsweredTime() {
		return answeredTime;
	}
	
	public int getRightTime() {
		return rightTime;
	}
	
	public int getWrongTime() {
		return wrongTime;
	}
	
	public int getCollectedFlag() {
		return collectedFlag;
	}
	
	
	public void set_id(int _id) {
		this._id = _id;
	}


	public void setQuestion(String question) {
		this.question = question;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public void setAnsweredTime(int answeredTime) {
		this.answeredTime = answeredTime;
	}

	public void setRightTime(int rightTime) {
		this.rightTime = rightTime;
	}

	public void setWrongTime(int wrongTime) {
		this.wrongTime = wrongTime;
	}

	public void setCollectedFlag(int collectedFlag) {
		this.collectedFlag = collectedFlag;
	}

	
	public int getInWrongFlag() {
		return inWrongFlag;
	}

	public void setInWrongFlag(int inWrongFlag) {
		this.inWrongFlag = inWrongFlag;
	}

	public QuestionBankEntry(String question, String opt1, String opt2,
			String opt3, String opt4, String answer, String explain,
			int answeredTime, int rightTime, int wrongTime, int collectedFlag,
			int inWrongFlag) {
		super();

		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.answer = answer;
		this.explain = explain;
		this.answeredTime = answeredTime;
		this.rightTime = rightTime;
		this.wrongTime = wrongTime;
		this.collectedFlag = collectedFlag;
		this.inWrongFlag = inWrongFlag;
	}

	public QuestionBankEntry() {
		
	}
	
	public ContentValues getContentValuesByEntry(){
		ContentValues values=new ContentValues();
		//values.put("_id", _id);

		values.put("question", question);
		values.put("opt1", opt1);
		values.put("opt2", opt2);
		values.put("opt3", opt3);
		values.put("opt4", opt4);
		values.put("answer", answer);
		values.put("explain", explain);
		values.put("answeredTime", answeredTime);
		values.put("rightTime", rightTime);
		values.put("wrongTime", wrongTime);
		values.put("collectedFlag", collectedFlag);
		values.put("inWrongFlag", inWrongFlag);
		return values;
	}
}
