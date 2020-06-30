package edu.escuelaing.arsw.streambox.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
public class Message implements Serializable {
    private String message;
    private String username;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}