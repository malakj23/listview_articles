package com.example.user.test.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 10/04/2018.
 */
public class Client {
    @SerializedName("idt")
    @Expose
    private Integer idt;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("namee")
    @Expose
    private String namee;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("mdp")
    @Expose
    private String mdp;
    @SerializedName("phone")
    @Expose
    private Integer phone;

    public Integer getIdt() {
        return idt;
    }

    public void setIdt(Integer idt) {
        this.idt = idt;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

}




