package com.example.smartinfusion.controller;

public class DataUrine {
    String id;
    String tanggal;
    String jam;
    int volume;

    public DataUrine(){}

    public DataUrine(String id, String tanggal, String jam, int volume) {
        this.id = id;
        this.tanggal = tanggal;
        this.jam = jam;
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
