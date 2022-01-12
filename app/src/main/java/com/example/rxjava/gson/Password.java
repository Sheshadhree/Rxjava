package com.example.rxjava.gson;

import com.google.gson.annotations.Expose;

public class Password {

    private String firstName,mail;
    @Expose
    private transient String  password;
    private int age;

    public Password(String firstName, int age, String mail, String password) {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
        this.password = password;
    }
}
