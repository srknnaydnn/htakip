package com.example.acer.hasta_takp.Model;

public class İlacModel {

    private String ilac_adı;
    private  String tarih;
    private String gun;
    private String toplam;

    public İlacModel(String ilac_adı, String tarih, String gun, String toplam) {
        this.ilac_adı = ilac_adı;
        this.tarih = tarih;
        this.gun = gun;
        this.toplam = toplam;
    }

    public String getIlac_adı() {
        return ilac_adı;
    }

    public void setIlac_adı(String ilac_adı) {
        this.ilac_adı = ilac_adı;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getToplam() {
        return toplam;
    }

    public void setToplam(String toplam) {
        this.toplam = toplam;
    }




}
