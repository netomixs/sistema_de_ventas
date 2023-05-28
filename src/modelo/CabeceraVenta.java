package modelo;

/**
 * Clase en desuso
 * @author ediso
 */
public class CabeceraVenta {
    
    //Atributos
    private int idCabeceraventa;
    private int idCliente;
    private double valorPagar;
    private String fechaVenta;
    private int estado;
    
    //constructor

    /**
     *
     */
    public CabeceraVenta(){
        this.idCabeceraventa = 0;
        this.idCliente = 0;
        this.valorPagar = 0.0;
        this.fechaVenta = "";
        this.estado = 0;
    }
    
     //constructor sobrecargado

    /**
     *
     * @param idCabeceraventa
     * @param idCliente
     * @param valorPagar
     * @param fechaVenta
     * @param estado
     */

    public CabeceraVenta(int idCabeceraventa, int idCliente, double valorPagar, String fechaVenta, int estado) {
        this.idCabeceraventa = idCabeceraventa;
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }
    
    //get and set 

    /**
     *
     * @return
     */

    public int getIdCabeceraventa() {
        return idCabeceraventa;
    }

    /**
     *
     * @param idCabeceraventa
     */
    public void setIdCabeceraventa(int idCabeceraventa) {
        this.idCabeceraventa = idCabeceraventa;
    }

    /**
     *
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return
     */
    public double getValorPagar() {
        return valorPagar;
    }

    /**
     *
     * @param valorPagar
     */
    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    /**
     *
     * @return
     */
    public String getFechaVenta() {
        return fechaVenta;
    }

    /**
     *
     * @param fechaVenta
     */
    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     *
     * @return
     */
    public int getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //toString 

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "CabeceraVenta{" + "idCabeceraventa=" + idCabeceraventa + ", idCliente=" + idCliente + ", valorPagar=" + valorPagar + ", fechaVenta=" + fechaVenta + ", estado=" + estado + '}';
    }
    
    
    
}
