package com.example.vatsal.model;

import java.io.Serializable;

public class Resume implements Serializable {

    private String name;
    private String email;
    private String linkedIn;
    private String skills;
    private String education;

    public Resume(String name, String email, String linkedIn, String skills, String education) {
        this.name = name;
        this.email = email;
        this.linkedIn = linkedIn;
        this.skills = skills;
        this.education = education;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public String getSkills() {
        return skills;
    }

    public String getEducation() {
        return education;
    }
}


