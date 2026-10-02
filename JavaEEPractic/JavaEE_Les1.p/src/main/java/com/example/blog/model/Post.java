package com.example.blog.model;

import java.time.LocalDateTime;

public class Post {
    private final int id;
    private final String headline;
    private final String text;
    private final LocalDateTime dateTime = LocalDateTime.now();

    public Post(int id, String headline, String text) {
        this.id = id;
        this.headline = headline;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return String.format("ID %d: %s\n%s\nDate: %s", id, headline, text, dateTime);
    }
}
