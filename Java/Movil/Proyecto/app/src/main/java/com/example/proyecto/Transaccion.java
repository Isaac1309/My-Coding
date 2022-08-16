package com.example.proyecto;

public class Transaccion {
    private  int id;
    private int tipo;
    private int retidoDeposito;
    private String categoria;
    private String monto;
    private String plazo;
    private String latlng;

    public int getRetidoDeposito() {
        return retidoDeposito;
    }

    public void setRetidoDeposito(int retidoDeposito) {
        this.retidoDeposito = retidoDeposito;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;


}
