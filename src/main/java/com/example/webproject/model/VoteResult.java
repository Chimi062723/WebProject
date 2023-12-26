package com.example.webproject.model;

public class VoteResult {
    private int pollID;
    private int userID;
    private String answer;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public VoteResult() {
    }

    public VoteResult(int pollID, int userID, String answer) {
        this.pollID = pollID;
        this.userID = userID;
        this.answer = answer;
    }

    public int getPollID() {
        return pollID;
    }

    public void setPollID(int pollID) {
        this.pollID = pollID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
