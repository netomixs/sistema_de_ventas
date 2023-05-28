/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *Modelo de datos de rango de cliente
 * @author netom
 */
public class RangoCliente {
    private int Id;
    private String Nombre;
    private String Color;

    /**
     *
     * @param Id
     * @param Nombre
     * @param Color
     */
    public RangoCliente(int Id, String Nombre, String Color) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Color = Color;
    }

    /**
     *
     */
    public RangoCliente() {
        this.Id = 0;
        this.Nombre = "";
        this.Color = "";
    }

    /**
     *
     * @return
     */
    public int getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(int Id) {
        this.Id = Id;
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
    public String getColor() {
        return Color;
    }

    /**
     *
     * @param Color
     */
    public void setColor(String Color) {
        this.Color = Color;
    }
    
}
