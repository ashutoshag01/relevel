package com.relevel.backend.olx.model;

import javax.persistence.*;
@Entity
public class User {

    @Id
    private long user_id;

    public User(long user_id, String name, String password, String emailID, String gender, int age, String phoneNumber) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.emailID = emailID;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
    private String name, password, emailID, gender;
    private int age;
    private String phoneNumber;
    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmailID() {
        return emailID;
    }
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}