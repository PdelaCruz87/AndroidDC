package com.example.appsqlite.complemento;

import android.os.Build;

public class ConstantesSQL {

    //Constantes para la utilización de las consultas SQL principales DDL
    //Base de datos
    public static final String BD_Mascota = "bd_mascota";
    //Tablas
    public static final String TABLA_Mascota = "tbl_mascota";
    //Campos de las tablas
    public static final String CAMPO_ID = "id_mascota";
    public static final String CAMPO_Nombre = "Nombre_mascota";
    public static final String CAMPO_Raza = "Raza_mascota";
    public static final String CAMPO_Color = "Color_mascota";
    public static final String CAMPO_Edad = "Edad_mascota";
    //Consultas con CREATE
    public static final String CREAR_TABLA_MASCOTA = "CREATE TABLE " + TABLA_Mascota +
            " (" + CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CAMPO_Nombre + " TEXT NOT NULL, " +
            CAMPO_Raza + " TEXT NOT NULL, " +
            CAMPO_Color + " TEXT NOT NULL, " +
            CAMPO_Edad + " TEXT NOT NULL); ";
    //Consulta CON DROP
    public static final String BORRAR_TABLA = "DROP TABLE IF EXISTS " + TABLA_Mascota;

       public static final int VERSION = 1;
}
