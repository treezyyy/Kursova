package com.example.kursova;

public class User {
    private String firstName;
    private String userName;
    private String password;
    private String gendere;

    public User(String firstName, String userName, String password, String gendere) {
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.gendere = gendere;
    }

    public User() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGendere() {
        return gendere;
    }

    public void setGendere(String gendere) {
        this.gendere = gendere;
    }
}
