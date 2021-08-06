package com.example.appsqlite.complemento;

public class MascotaVO {

    private int Id;
    private String Nombre;
    private String Raza;
    private String Color;
    private String Edad;

    public MascotaVO() {

    }

    public MascotaVO(int id, String nombre, String raza, String color, String edad) {
        Id = id;
        Nombre = nombre;
        Raza = raza;
        Color = color;
        Edad = edad;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }
}
