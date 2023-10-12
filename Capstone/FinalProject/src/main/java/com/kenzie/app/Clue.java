package com.kenzie.app;

public class Clue {
    private String answer;
    private String question;
    private String category;
  
    public Clue(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
  }