package com.example.rxjava.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee {

    private String firstName , mail ;
    private int age;
    private Address address;
    private List<FamilyMember> familyMember;

    public Employee(String firstName, String mail, int age ,Address address,List<FamilyMember> familyMember) {
        this.firstName = firstName;
        this.mail = mail;
        this.age = age;
        this.address = address;
        this.familyMember=familyMember;
    }
}
