package com.example.acer.hasta_takp.Model;

public class ProfileModel {

    private int tc;
    private String name;
    private String surname;
    private String cinsiyet;
    private String blood_group;
    private String telephone;

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public ProfileModel(int tc, String name, String surname, String cinsiyet, String blood_group, String telephone) {
        this.tc = tc;
        this.name = name;
        this.surname = surname;
        this.cinsiyet = cinsiyet;
        this.blood_group = blood_group;
        this.telephone = telephone;
    }
    @Override
    public String toString() {
        return "ProfileModel{" +
                "tc=" + tc +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", blood_group='" + blood_group + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
