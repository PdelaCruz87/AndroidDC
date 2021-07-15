package com.example.app_gui_telefono;

public class DatosVO {
    private String nombre;
    private String numT;
    private int imaNom;

    public DatosVO() {
    }

    public DatosVO(String nombre, String numT, int imaNom) {
        this.nombre = nombre;
        this.numT = numT;
        this.imaNom = imaNom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumT() {
        return numT;
    }

    public void setNumT(String numT) {
        this.numT = numT;
    }

    public int getImaNom() {
        return imaNom;
    }

    public void setImaNom(int imaNom) {
        this.imaNom = imaNom;
    }
}
