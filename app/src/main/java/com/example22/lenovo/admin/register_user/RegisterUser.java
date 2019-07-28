package com.example22.lenovo.admin.register_user;

public class RegisterUser {
    private String userid;
    private String username;
    private String useremail;
    private String usermobileno;
    private String levelUser;

    public RegisterUser() {

    }

    public RegisterUser(String username,String useremail,String usermobileno, String levelUser)
    {

        this.username = username;
        this.useremail = useremail;
        this.usermobileno = usermobileno;
        this.levelUser = levelUser;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUseremail() {
        return useremail;
    }
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getLevelUser() {
        return levelUser;
    }

    public void setLevelUser(String levelUser) {
        this.levelUser = levelUser;
    }

    public String getUsermobileno() {
        return usermobileno;
    }
    public void setUsermobileno(String usermobileno) {
        this.usermobileno = usermobileno;
    }
}