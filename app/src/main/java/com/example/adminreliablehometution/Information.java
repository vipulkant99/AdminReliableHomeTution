package com.example.adminreliablehometution;

public class Information {
    public String mail;
    public String phoneNo;
    public String myName;

    public Information(String mail, String phoneNo, String myName) {
        this.mail = mail;
        this.phoneNo = phoneNo;
        this.myName = myName;
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

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
