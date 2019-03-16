package com.example.woodlee.mt_1_u3031423;

/**
 * Created by Woodlee on 1/4/17.
 */

public class BusinessCard {
    long id;
    String name;
    int imageResource;
    String jobTitle;
    String company;
    String email;
    String phone;
    String website;

    public BusinessCard(String name, int imageResource, String jobTitle, String company, String email, String phone, String website){
        this.name = name;
        this.imageResource = imageResource;
        this.jobTitle = jobTitle;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }
    public BusinessCard(long id, String name, int imageResource, String jobTitle, String company, String email, String phone, String website){
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
        this.jobTitle = jobTitle;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }
public BusinessCard(String name, int imageResource){
    this.name = name;
    this.imageResource = imageResource;
}
    public BusinessCard(String title, int imageResource, String email, String phone){
        this.name = title;
        this.imageResource = imageResource;
        this.email = email;
        this.phone = phone;

    }

    public String getName(){ return this.name; }
    public int getImageResource() { return this.imageResource; }
    public String getJobTitle(){ return this.jobTitle; }
    public String getCompany(){ return this.company; }
    public String getEmail(){ return this.email; }
    public String getPhone(){ return this.phone;}
    public String getWebsite(){ return this.website; }
    public long getId() { return this.id; }
}
