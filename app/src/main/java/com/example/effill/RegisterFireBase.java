package com.example.effill;

public class RegisterFireBase {
    private  String full_name;
    private String email;
    private String identity;
    private String phone;
    private String nationality;
    private String address;
    private String password;

    public RegisterFireBase() {
    }

    public RegisterFireBase(String full_name, String email, String identity, String phone, String nationality, String address, String password) {
        this.full_name = full_name;
        this.email = email;
        this.identity = identity;
        this.phone = phone;
        this.nationality = nationality;
        this.address = address;
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
