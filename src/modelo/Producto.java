package modelo;

/**
 *Modelo de datos de producto
 * @author Ernesto
 */
public class Producto {
     private int ID;
     private int Tipo;
     private float Precio ;
     private String Nombre;
     private String Descripcion;
     private int stock;
     private int LoteID;
     private String imgSrc;
     private String C_Barras;
     private String nameLots;
     private Lote Lotes;

    /**
     *
     * @return
     */
    public String getNameLots() {
        return nameLots;
    }

    /**
     *
     * @param nameLots
     */
    public void setNameLots(String nameLots) {
        this.nameLots = nameLots;
    }

    /**
     *
     * @param ID
     * @param Tipo
     * @param Precio
     * @param Nombre
     * @param Descripcion
     * @param stock
     * @param Lote
     * @param imgSrc
     * @param C_Barras
     */
    public Producto(int ID, int Tipo, float Precio, String Nombre, String Descripcion, int stock, int Lote, String imgSrc, String C_Barras) {
        this.ID = ID;
        this.Tipo = Tipo;
        this.Precio = Precio;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.stock = stock;
        this.LoteID = Lote;
        this.imgSrc = imgSrc;
        this.C_Barras = C_Barras;
    }

    /**
     *
     */
    public Producto() {
        this.ID = 0;
        this.Tipo = 0;
        this.Precio = 0;
        this.Nombre = "";
        this.Descripcion = "";
        this.LoteID = 0;
        this.imgSrc = "";
        this.C_Barras = "";
        this.stock=0;
    }

    /**
     *
     * @return
     */
    public int getStock() {
        return stock;
    }

    /**
     *
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return
     */
    public int getTipo() {
        return Tipo;
    }

    /**
     *
     * @param Tipo
     */
    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    /**
     *
     * @return
     */
    public float getPrecio() {
        return Precio;
    }

    /**
     *
     * @param Precio
     */
    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     *
     * @param Nombre
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     *
     * @param Descripcion
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     *
     * @return
     */
    public int getLoteID() {
        return LoteID;
    }

    /**
     *
     * @param LoteID
     */
    public void setLoteID(int LoteID) {
        this.LoteID = LoteID;
    }

    /**
     *
     * @return
     */
    public String getImgSrc() {
        return imgSrc;
    }

    /**
     *
     * @param imgSrc
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    /**
     *
     * @return
     */
    public String getC_Barras() {
        return C_Barras;
    }

    /**
     *
     * @param C_Barras
     */
    public void setC_Barras(String C_Barras) {
        this.C_Barras = C_Barras;
    }

    /**
     *
     * @return
     */
    public Lote getLotes() {
        return Lotes;
    }

    /**
     *
     * @param Lotes
     */
    public void setLotes(Lote Lotes) {
        this.Lotes = Lotes;
    }
    
}
