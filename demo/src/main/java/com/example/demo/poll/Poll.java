package com.example.demo.poll;

public class Poll {
    private int question_id;
    private String title;
    private String first_ans;
    private String second_ans;
    private String third_ans;
    private String fourth_ans;

    public Poll(int question_id, String title, String first_ans, String second_ans, String third_ans, String fourth_ans) {
        this.question_id = question_id;
        this.title = title;
        this.first_ans = first_ans;
        this.second_ans = second_ans;
        this.third_ans = third_ans;
        this.fourth_ans = fourth_ans;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirst_ans() {
        return first_ans;
    }

    public String getSecond_ans() {
        return second_ans;
    }

    public String getThird_ans() {
        return third_ans;
    }

    public String getFourth_ans() {
        return fourth_ans;
    }
}
