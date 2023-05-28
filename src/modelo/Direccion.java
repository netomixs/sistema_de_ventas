/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *Modelo de datos de direccion
 * @author netom
 */
public class Direccion {
    private int Estado;
    private int ID;
    private String Localidad;
    private String CP;
    private String Calle;
    private String Numero;

    /**
     *
     * @param Estado
     * @param Localidad
     * @param CP
     * @param Calle
     * @param Numero
     */
    public Direccion(int Estado, String Localidad, String CP, String Calle, String Numero) {
        this.Estado = Estado;
        this.Localidad = Localidad;
        this.CP = CP;
        this.Calle = Calle;
        this.Numero = Numero;
    }

    /**
     *
     * @param ID
     * @param Estado
     * @param Localidad
     * @param CP
     * @param Calle
     * @param Numero
     */
    public Direccion(int ID,int Estado, String Localidad, String CP, String Calle, String Numero) {
        this.ID=ID;
           this.Estado = Estado;
        this.Localidad = Localidad;
        this.CP = CP;
        this.Calle = Calle;
        this.Numero = Numero;
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
     */
    public Direccion(){
        this.ID=0;
        this.Estado = 0;
        this.Localidad = "'";
        this.CP = "";
        this.Calle = "";
        this.Numero = "";
    }

    /**
     *
     * @return
     */
    public int getEstado() {
        return Estado;
    }

    /**
     *
     * @param Estado
     */
    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    /**
     *
     * @return
     */
    public String getLocalidad() {
        return Localidad;
    }

    /**
     *
     * @param Localidad
     */
    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    /**
     *
     * @return
     */
    public String getCP() {
        return CP;
    }

    /**
     *
     * @param CP
     */
    public void setCP(String CP) {
        this.CP = CP;
    }

    /**
     *
     * @return
     */
    public String getCalle() {
        return Calle;
    }

    /**
     *
     * @param Calle
     */
    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    /**
     *
     * @return
     */
    public String getNumero() {
        return Numero;
    }

    /**
     *
     * @param Numero
     */
    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    /**
     *
     * @return
     */
    public String getDireccionCompleta(){
        return this.getLocalidad()+",Calle: "+this.getCalle()+"Numero: "+getNumero();
    }
}
