package com.example.bdatosnm;

public class View {
    private int id;
    private String latlngstart,latlngdest, date;

    public View(int id, String latlngstart, String latlngdest, String date) {
        this.id = id;
        this.latlngstart = latlngstart;
        this.latlngdest = latlngdest;
        this.date = date;
    }

    public View() {
    }

    @Override
    public String toString() {
        return "View{" +
                "id=" + id +
                ", latlngstart='" + latlngstart + '\'' +
                ", latlngdest='" + latlngdest + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatlngstart() {
        return latlngstart;
    }

    public void setLatlngstart(String latlngstart) {
        this.latlngstart = latlngstart;
    }

    public String getLatlngdest() {
        return latlngdest;
    }

    public void setLatlngdest(String latlngdest) {
        this.latlngdest = latlngdest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
