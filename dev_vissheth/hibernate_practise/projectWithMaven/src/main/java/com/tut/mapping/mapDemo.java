package com.tut.mapping;

public class mapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProjectMappingConfig projConfig = new ProjectMappingConfig();
		
		Question q1 = new Question();
		q1.setQuestionId(1213);
		q1.setQuestion("what is Java");
		
		Answer answer = new Answer();
		answer.setAnswerId(344);
		answer.setAnswer("Java Is programming Language");
		
		projConfig.saveObject(q1);
		projConfig.saveObject(answer);
		

	}

}
