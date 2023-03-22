
package modelo;

import java.util.Date;


public class Factura {
    private int ID;
    private int cliente;
    private Date Fecha;
    private float total;

    public Factura(int ID, int cliente, Date Fecha) {
        this.ID = ID;
        this.cliente = cliente;
        this.Fecha = Fecha;
    }
        public Factura() {
        this.ID = 0;
        this.cliente = 0;
        this.Fecha = new Date();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
        
}
