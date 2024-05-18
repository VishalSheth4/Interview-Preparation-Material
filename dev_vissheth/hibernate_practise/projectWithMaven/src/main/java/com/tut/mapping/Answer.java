package com.tut.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {
	
	@Id
	@Column(name="answer_id")
	private int answerId;
	private String ans;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return ans;
	}
	public void setAnswer(String answer) {
		this.ans = answer;
	}
	public Answer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.ans = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
