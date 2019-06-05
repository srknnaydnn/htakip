package com.example.acer.hasta_takp.Model;

public class HastaModel {


    private String ates;
    private String nabız;
    private String solunum;
    private String tansiyon;
    private String kan_sekeri;
    private String idrar;
    private String beslenme;
    private String saat;

    public HastaModel(String ates, String nabız, String solunum, String tansiyon, String kan_sekeri, String idrar, String beslenme,String saat) {
        this.ates = ates;
        this.nabız = nabız;
        this.solunum = solunum;
        this.tansiyon = tansiyon;
        this.kan_sekeri = kan_sekeri;
        this.idrar = idrar;
        this.beslenme = beslenme;
        this.saat = saat;
    }

    public String getAtes() {
        return ates;
    }

    public void setAtes(String ates) {
        this.ates = ates;
    }

    public String getNabız() {
        return nabız;
    }

    public void setNabız(String nabız) {
        this.nabız = nabız;
    }

    public String getSolunum() {
        return solunum;
    }

    public void setSolunum(String solunum) {
        this.solunum = solunum;
    }

    public String getTansiyon() {
        return tansiyon;
    }

    public void setTansiyon(String tansiyon) {
        this.tansiyon = tansiyon;
    }

    public String getKan_sekeri() {
        return kan_sekeri;
    }

    public void setKan_sekeri(String kan_sekeri) {
        this.kan_sekeri = kan_sekeri;
    }

    public String getIdrar() {
        return idrar;
    }

    public void setIdrar(String idrar) {
        this.idrar = idrar;
    }

    public String getBeslenme() {
        return beslenme;
    }

    public void setBeslenme(String beslenme) {
        this.beslenme = beslenme;
    }
    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }
}
