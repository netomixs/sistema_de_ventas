/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *Modelo de datos de tipo dé productos
 * @author netom
 */
public class TIpo_Producto {
    private int ID;
    private String Tipo;

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
    public String getTipo() {
        return Tipo;
    }

    /**
     *
     * @param Tipo
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    /**
     *
     * @param ID
     * @param Tipo
     */
    public TIpo_Producto(int ID, String Tipo) {
        this.ID = ID;
        this.Tipo = Tipo;
    }

    /**
     *
     */
    public TIpo_Producto() {
        this.ID = 0;
        this.Tipo = "";
    }
}
