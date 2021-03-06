package com.lapizza.questions;

import java.io.Serializable;

public class Questions implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5295625780929697633L;
	
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String question5;
	private String question6;
	
	
	public Questions(String question1, String question2, String question3, String question4, String question5, String question6) {
		super();
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
	}

	
	public String getQuestion1() {
		return question1;
	}
	
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	
	public String getQuestion2() {
		return question2;
	}
	
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	
	public String getQuestion3() {
		return question3;
	}
	
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	
	public String getQuestion4() {
		return question4;
	}
	
	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	
	public String getQuestion5() {
		return question5;
	}
	
	public void setQuestion5(String question5) {
		this.question5 = question5;
	}
	
	public String getQuestion6() {
		return question6;
	}
	
	public void setQuestion6(String question6) {
		this.question6 = question6;
	}
	

}
