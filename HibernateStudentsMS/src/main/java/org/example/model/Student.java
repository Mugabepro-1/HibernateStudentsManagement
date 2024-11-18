package org.example.model;

import jakarta.persistence.Entity;

@Entity
public class Student extends Person {

    private String school;
    private String level;
    private String combination;

    // Getters and Setters
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getCombination() {
        return combination;
    }
    public void setCombination(String combination) {
        this.combination = combination;
    }
}

