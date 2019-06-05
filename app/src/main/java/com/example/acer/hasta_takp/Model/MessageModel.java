package com.example.acer.hasta_takp.Model;

public class MessageModel {

    String tarih;
    String mesaj;

    public MessageModel(String tarih, String mesaj) {
        this.tarih = tarih;
        this.mesaj = mesaj;
    }
    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }




}
