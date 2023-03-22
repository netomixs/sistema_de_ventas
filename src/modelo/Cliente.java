package modelo;

/**
 *
 * @author ediso
 */
public class Cliente {

   private int ID;
   private String Telefono;
   private int Puntos;
   private int Rango;
   private Persona Persona;
   public Cliente() {
        this.ID = 0;
        this.Telefono = "";
        this.Puntos = 0;
        this.Rango = 0;
        this.Persona = new Persona();
    }
    public Cliente(int ID, String Telefono, int Puntos, int Rango, Persona Persona) {
        this.ID = ID;
        this.Telefono = Telefono;
        this.Puntos = Puntos;
        this.Rango = Rango;
        this.Persona = Persona;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public int getRango() {
        return Rango;
    }

    public void setRango(int Rango) {
        this.Rango = Rango;
    }

    public Persona getPersona() {
        return Persona;
    }

    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }
   
}
