package com.example.adminreliablehometution;

public class TeacherModel {
    private String name, mail, phoneNo, purl;

    TeacherModel()
    {

    }

    public TeacherModel(String name, String mail, String phoneNo, String purl) {
        this.name = name;
        this.mail = mail;
        this.phoneNo = phoneNo;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}


