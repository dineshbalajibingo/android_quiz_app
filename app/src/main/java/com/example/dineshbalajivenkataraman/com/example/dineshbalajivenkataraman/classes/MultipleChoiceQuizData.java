package com.example.dineshbalajivenkataraman.com.example.dineshbalajivenkataraman.classes;

/**
 * Created by dineshbalajivenkataraman on 8/23/17.
 */

public class MultipleChoiceQuizData {
    private String question;
    private String choice_one;
    private String choice_two;
    private String choice_three;
    private String choice_four;
    private int imageId;
    private int history_score;
    private int science_score;
    private int computer_score;
    public MultipleChoiceQuizData(int imageId, String question, String choice_one, String choice_two, String choice_three, String choice_four) {
        this.question = question;
        this.choice_one = choice_one;
        this.choice_two = choice_two;
        this.choice_three = choice_three;
        this.choice_four = choice_four;
        this.imageId = imageId;
    }
    public MultipleChoiceQuizData(String question, String choice_one, String choice_two, String choice_three, String choice_four) {
        this.question = question;
        this.choice_one = choice_one;
        this.choice_two = choice_two;
        this.choice_three = choice_three;
        this.choice_four = choice_four;
    }
    public MultipleChoiceQuizData(String question) {
        this.question = question;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getChoice_one() {
        return choice_one;
    }
    public void setChoice_one(String choice_one) {
        this.choice_one = choice_one;
    }
    public String getChoice_two() {
        return choice_two;
    }
    public void setChoice_two(String choice_two) {
        this.choice_two = choice_two;
    }
    public String getChoice_three() {
        return choice_three;
    }
    public void setChoice_three(String choice_three) {
        this.choice_three = choice_three;
    }
    public String getChoice_four() {
        return choice_four;
    }
    public void setChoice_four(String choice_four) {
        this.choice_four = choice_four;
    }
    public int getComputer_score() {
        return computer_score;
    }
    public void setComputer_score(int computer_score) {
        this.computer_score = computer_score;
    }
    public void setHistory_score(int history_score) {
        this.history_score = history_score;
    }
    public int getHistory_score() {
        return history_score;
    }
    public int getScience_score() {
        return science_score;
    }
    public void setScience_score(int science_score) {
        this.science_score = science_score;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }










}
