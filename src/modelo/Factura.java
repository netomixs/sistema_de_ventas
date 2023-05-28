
package modelo;

import java.sql.Time;
import java.util.Date;

/**
 *Modelo de datos de una factura
 * @author netom
 */
public class Factura {
    private int ID;
    private int cliente;
    private Date Fecha;
    private float total;
    private Time hora;

    /**
     *
     * @param ID
     * @param cliente
     * @param Fecha
     */
    public Factura(int ID, int cliente, Date Fecha) {
        this.ID = ID;
        this.cliente = cliente;
        this.Fecha = Fecha;
    }

    /**
     *
     */
    public Factura() {
        this.ID = 0;
        this.cliente = 0;
        this.Fecha = new Date();
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
    public int getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     *
     * @param Fecha
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     *
     * @return
     */
    public float getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public Time getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }
        
}
