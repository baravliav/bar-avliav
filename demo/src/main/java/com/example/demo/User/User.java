package com.example.demo.User;

public class User {
    private long user_id;
    private String first_name;
    private String last_name;
    private String email;
    private int age;
    private String address;
    private String joining_date;

    public User(long user_id, String first_name, String last_name, String email, int age, String address, String joining_date) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.joining_date = joining_date;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getJoining_date() {
        return joining_date;
    }
}
