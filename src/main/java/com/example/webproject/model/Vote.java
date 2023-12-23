package com.example.webproject.model;

import java.sql.Timestamp;

public class Vote {
    private int PollId;
    private int CanteenID;
    private String title;
    private String Question;
    private Timestamp createDate;

    public int getPollId() {
        return PollId;
    }

    public void setPollId(int pollId) {
        PollId = pollId;
    }

    public int getCanteenID() {
        return CanteenID;
    }

    public void setCanteenID(int canteenID) {
        CanteenID = canteenID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }


    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
