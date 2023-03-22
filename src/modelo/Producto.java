package modelo;

/**
 *
 * @author ediso
 */
public class Producto {
     private int ID;
     private int Tipo;
     private float Precio ;
     private String Nombre;
     private String Descripcion;
     private int stock;
     private int Lote;
     private String imgSrc;
     private String C_Barras;

    public Producto(int ID, int Tipo, float Precio, String Nombre, String Descripcion, int stock, int Lote, String imgSrc, String C_Barras) {
        this.ID = ID;
        this.Tipo = Tipo;
        this.Precio = Precio;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.stock = stock;
        this.Lote = Lote;
        this.imgSrc = imgSrc;
        this.C_Barras = C_Barras;
    }

   
        public Producto() {
        this.ID = 0;
        this.Tipo = 0;
        this.Precio = 0;
        this.Nombre = "";
        this.Descripcion = "";
        this.Lote = 0;
        this.imgSrc = "";
        this.C_Barras = "";
        this.stock=0;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getLote() {
        return Lote;
    }

    public void setLote(int Lote) {
        this.Lote = Lote;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getC_Barras() {
        return C_Barras;
    }

    public void setC_Barras(String C_Barras) {
        this.C_Barras = C_Barras;
    }
    
}
