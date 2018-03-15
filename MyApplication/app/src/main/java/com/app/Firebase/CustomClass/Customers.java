package com.app.Firebase.CustomClass;

/**
 * Created by nextbrain on 3/2/18.
 */

public class Customers {

    public String id;
    public String Firstname;
    public String Lastname;
    public String mobile_no;
    public String country_code;
    public String country;
    public String state;
    public String city;

    public Customers() {

    }


    public Customers(String id, String firstname, String lastname, String mobile_no, String country_code, String country, String state, String city) {
        Firstname = firstname;
        id = id;
        Lastname = lastname;
        this.mobile_no = mobile_no;
        this.country_code = country_code;
        this.country = country;
        this.state = state;
        this.city = city;
    }
}
