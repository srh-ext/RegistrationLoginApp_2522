package de.srh.beck.dao;

import java.sql.Date;

public class User {
    public enum Gender {
        MR,
        MRS
    }

    private int userId;
    private Gender gender;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Date birthdate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return userId
                + "\n"
                + gender.toString()
                + "\n"
                + firstname
                + "\n"
                + lastname
                + "\n"
                + email
                + "\n"
                + password
                + "\n"
                + birthdate.toString();
    }
}
