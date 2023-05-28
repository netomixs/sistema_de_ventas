/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *Modelo de datos de Cajero
 * @author netom
 */
public class Cajero {

    private int ID;
    private String Clave;
    private Persona Persona;

    /**
     *
     * @param ID
     * @param Clave
     * @param persona
     */
    public Cajero(int ID, String Clave, Persona persona) {
        this.ID = ID;
        this.Clave = Clave;
        this.Persona = persona;
    }

    /**
     *
     */
    public Cajero() {
        this.ID = 0;
        this.Clave = "";
        this.Persona = new Persona();
    }

    /**
     *
     * @return
     */
    public Persona getPersona() {
        return Persona;
    }

    /**
     *
     * @param persona
     */
    public void setPersona(Persona persona) {
        this.Persona = persona;
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
    public String getClave() {
        return Clave;
    }

    /**
     *
     * @param Clave
     */
    public void setClave(String Clave) {
        this.Clave = Clave;
    }

}
