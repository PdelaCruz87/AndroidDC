package Complementos;

public class DiccionarioVO {
    private int id_diccionario;
    private String palabra_diccionario;
    private String significado_diccionario;

    public DiccionarioVO() {
    }

    public DiccionarioVO(int id_diccionario, String palabra_diccionario, String significado_diccionario) {
        this.id_diccionario = id_diccionario;
        this.palabra_diccionario = palabra_diccionario;
        this.significado_diccionario = significado_diccionario;
    }

    public int getId_diccionario() {
        return id_diccionario;
    }

    public void setId_diccionario(int id_diccionario) {
        this.id_diccionario = id_diccionario;
    }

    public String getPalabra_diccionario() {
        return palabra_diccionario;
    }

    public void setPalabra_diccionario(String palabra_diccionario) {
        this.palabra_diccionario = palabra_diccionario;
    }

    public String getSignificado_diccionario() {
        return significado_diccionario;
    }

    public void setSignificado_diccionario(String significado_diccionario) {
        this.significado_diccionario = significado_diccionario;
    }
}
