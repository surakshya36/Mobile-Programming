package com.example.crudapp;
public class Student {
    private String id, name, roll;

    public Student(String id,String name, String roll) {
        this.id= id;
        this.name = name;
        this.roll = roll;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRoll() {
        return roll;
    }
    public void setRoll(String roll) {
        this.roll = roll;
    }
}
