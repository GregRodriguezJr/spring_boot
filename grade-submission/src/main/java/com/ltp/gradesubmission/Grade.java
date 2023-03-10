package com.ltp.gradesubmission;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Grade {
    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotBlank(message = "Subject can't be blank")
    private String subject;
    @NotBlank(message = "Score can't be blank")
    private String score;
    private String id;


//    public Grade(String name, String subject, String score) {
//        this.name = name;
//        this.subject = subject;
//        this.score = score;
//    }

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
