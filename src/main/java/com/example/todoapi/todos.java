package com.example.todoapi;

public class todos {
    private int userId;
    private int id;
    private String title;
    private Boolean completed;

    public todos(int userId, int id, String title, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public void  setId(int id) {
        this.id = id;
    }
    public void  setTitle(String title) {
        this.title = title;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getUserId() {
        return userId;
    }
    public Boolean getCompleted() {
        return completed;
    }
}
