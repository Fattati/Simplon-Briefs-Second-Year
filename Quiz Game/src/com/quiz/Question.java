package com.quiz;

public class Question {
	  String qestion, response1, response2, response3;
	  int right,niveau;
	  boolean question_been_answered;


	public String getQestion() {
			return qestion;
		}

		public void setQestion(String qestion) {
			this.qestion = qestion;
		}

		public String getResponse1() {
			return response1;
		}

		public void setResponse1(String response1) {
			this.response1 = response1;
		}

		public String getResponse2() {
			return response2;
		}

		public void setResponse2(String response2) {
			this.response2 = response2;
		}

		public String getResponse3() {
			return response3;
		}

		public Question(String qestion, String response1, String response2, String response3,int right,int niveau) {
			super();
			this.qestion = qestion;
			this.response1 = response1;
			this.response2 = response2;
			this.response3 = response3;
			this.right = right;
			this.niveau = niveau;
			setQuestion_been_answered(false);
		}

		public Question(String qestion, String response1, String response2, int right, int niveau) {
			super();
			this.qestion = qestion;
			this.response1 = response1;
			this.response2 = response2;
			this.right = right;
			this.niveau = niveau;
			setQuestion_been_answered(false);
		}

		public int getNiveau() {
			return niveau;
		}

		public void setNiveau(int niveau) {
			this.niveau = niveau;
		}

		public void setResponse3(String response3) {
			this.response3 = response3;
		}

		public int getRight() {
			return right;
		}

		public void setRight(int right) {
			this.right = right;
		}
		public boolean checkAnswer(int userAnswer) {
			
			if (userAnswer == this.right) {
				return true;
			}
			else {
				return false;
			}
			
		}
		public boolean getIsQuestion_been_answered() {
			return question_been_answered;
		}

		public void setQuestion_been_answered(boolean question_been_answered) {
			this.question_been_answered = question_been_answered;
		}

	}
