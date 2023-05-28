
package modelo;

/**
 *Modelo de datos de la usado para guardar prodcutos vendidos
 * @author netom
 */
public class ProductosVendidos {
    int ID;
    int Prodcuto;
    int Cantidad;
    int Factura;
    float subTotal;
    float descuento;

    /**
     *
     * @param ID
     * @param Prodcuto
     * @param Cantidad
     * @param Factura
     * @param subTotal
     */
    public ProductosVendidos(int ID, int Prodcuto, int Cantidad, int Factura, float subTotal) {
        this.ID = ID;
        this.Prodcuto = Prodcuto;
        this.Cantidad = Cantidad;
        this.Factura = Factura;
        this.subTotal = subTotal;
    }

    /**
     *
     */
    public ProductosVendidos( ) {
        this.ID = 0;
        this.Prodcuto = 0;
        this.Cantidad = 0;
        this.Factura = 0;
        this.subTotal = 0.0f;
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
    public int getProdcuto() {
        return Prodcuto;
    }

    /**
     *
     * @param Prodcuto
     */
    public void setProdcuto(int Prodcuto) {
        this.Prodcuto = Prodcuto;
    }

    /**
     *
     * @return
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     *
     * @param Cantidad
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     *
     * @return
     */
    public int getFactura() {
        return Factura;
    }

    /**
     *
     * @param Factura
     */
    public void setFactura(int Factura) {
        this.Factura = Factura;
    }

    /**
     *
     * @return
     */
    public float getSubTotal() {
        return subTotal;
    }

    /**
     *
     * @param subTotal
     */
    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    /**
     *
     * @return
     */
    public float getDescuento() {
        return descuento;
    }

    /**
     *
     * @param descuento
     */
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
        
}
