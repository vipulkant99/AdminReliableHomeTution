package com.example.adminreliablehometution;

public class TeacherModel {
    private String name , memail , mphn , purl ;


//    public TeacherModel(String name, String email, String phn, String purl) {
//        this.name = name;
//        this.email = email;
//        this.phn = phn;
//        this.purl = purl;
//    }
//
//    public String getPurl() {
//        return purl;
//    }
//
//    public void setPurl(String purl) {
//        this.purl = purl;
//    }
//
//    public String getPhn() {
//        return phn;
//    }
//
//    public void setPhn(String phn) {
//        this.phn = phn;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    TeacherModel()
    {

    }

    public TeacherModel(String name, String memail, String mphn, String purl) {
        this.name = name;
        this.memail = memail;
        this.mphn = mphn;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getMphn() {
        return mphn;
    }

    public void setMphn(String mphn) {
        this.mphn = mphn;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
