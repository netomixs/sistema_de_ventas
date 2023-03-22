/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author netom
 */
public class RangoCliente {
    private int Id;
    private String Nombre;
    private String Color;

    public RangoCliente(int Id, String Nombre, String Color) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Color = Color;
    }
      public RangoCliente() {
        this.Id = 0;
        this.Nombre = "";
        this.Color = "";
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
}
