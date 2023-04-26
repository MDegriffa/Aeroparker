package com.aeroparker.aeroparkertest;


public class Customer {
    
    int id;
    String date_time, email_address, title, first_name, last_name, 
    address_line_1, address_line_2, city, postcode, phone_number;
    
    public int getId() {
        return id;
    }
    public String getDate_time() {
        return date_time;
    }
    public String getEmail_address() {
        return email_address;
    }
    public String getTitle() {
        return title;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getAddress_line_1() {
        return address_line_1;
    }
    public String getAddress_line_2() {
        return address_line_2;
    }
    public String getCity() {
        return city;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }
    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }  
}