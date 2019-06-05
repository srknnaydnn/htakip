package com.example.acer.hasta_takp.Model;

public class panelModel {


    private int room;
    private int tc;
    private String name;
    private String surname;
    private  String department;

    public panelModel(int room, int tc, String name, String surname,String department) {
        this.room = room;
        this.tc = tc;
        this.name = name;
        this.surname = surname;
        this.department=department;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "panelModel{" +
                "room=" + room +
                ", tc=" + tc +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
