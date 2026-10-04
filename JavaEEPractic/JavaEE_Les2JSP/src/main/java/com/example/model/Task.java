package com.example.model;

import java.time.LocalDateTime;

public class Task {

    private final int id;
    private final String title;
    private boolean done;
    private final LocalDateTime createdAt;

    public Task (int id, String title) {
        this.id = id;
        this.title = title;
        this.done = false;
        this.createdAt = LocalDateTime.now();
    }

    public Task(int id, String title, LocalDateTime createAt) {
        this.id = id;
        this.title = title;
        this.done = false;
        this.createdAt = createAt;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
