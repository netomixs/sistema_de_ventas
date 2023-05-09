
package modelo;

public class ProductosVendidos {
    int ID;
    int Prodcuto;
    int Cantidad;
    int Factura;
    float subTotal;
    float descuento;

    public ProductosVendidos(int ID, int Prodcuto, int Cantidad, int Factura, float subTotal) {
        this.ID = ID;
        this.Prodcuto = Prodcuto;
        this.Cantidad = Cantidad;
        this.Factura = Factura;
        this.subTotal = subTotal;
    }
        public ProductosVendidos( ) {
        this.ID = 0;
        this.Prodcuto = 0;
        this.Cantidad = 0;
        this.Factura = 0;
        this.subTotal = 0.0f;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProdcuto() {
        return Prodcuto;
    }

    public void setProdcuto(int Prodcuto) {
        this.Prodcuto = Prodcuto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getFactura() {
        return Factura;
    }

    public void setFactura(int Factura) {
        this.Factura = Factura;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
        
}
