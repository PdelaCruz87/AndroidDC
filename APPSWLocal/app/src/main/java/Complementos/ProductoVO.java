package Complementos;

public class ProductoVO {


    private int idProducto;
    private String nombreProducto;
    private String fechaPproducto;
    private int precioProducto;
    private String ubicacionProducto;

    public ProductoVO() {
    }

    public ProductoVO(int idProducto, String nombreProducto, String fechaPproducto, int precioProducto, String ubicacionProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.fechaPproducto = fechaPproducto;
        this.precioProducto = precioProducto;
        this.ubicacionProducto = ubicacionProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaPproducto() {
        return fechaPproducto;
    }

    public void setFechaPproducto(String fechaPproducto) {
        this.fechaPproducto = fechaPproducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getUbicacionProducto() {
        return ubicacionProducto;
    }

    public void setUbicacionProducto(String ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }
}

