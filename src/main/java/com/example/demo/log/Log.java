package com.example.demo.log;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table
public class Log {
    @Id
    private String content;
    private LocalDateTime timestamp;

    public Log() {
    }

    public Log(String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
