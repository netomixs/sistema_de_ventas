package modelo;

/**
 * Modelo de datos para cliente
 * @author Ernesto
 */
public class Cliente {

   private int ID;
   private String Telefono;
   private int Puntos;
   private int Rango;
   private Persona Persona;

    /**
     *
     */
    public Cliente() {
        this.ID = 0;
        this.Telefono = "";
        this.Puntos = 0;
        this.Rango = 0;
        this.Persona = new Persona();
    }

    /**
     *
     * @param ID
     * @param Telefono
     * @param Puntos
     * @param Rango
     * @param Persona
     */
    public Cliente(int ID, String Telefono, int Puntos, int Rango, Persona Persona) {
        this.ID = ID;
        this.Telefono = Telefono;
        this.Puntos = Puntos;
        this.Rango = Rango;
        this.Persona = Persona;
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
    public String getTelefono() {
        return Telefono;
    }

    /**
     *
     * @param Telefono
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     *
     * @return
     */
    public int getPuntos() {
        return Puntos;
    }

    /**
     *
     * @param Puntos
     */
    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    /**
     *
     * @return
     */
    public int getRango() {
        return Rango;
    }

    /**
     *
     * @param Rango
     */
    public void setRango(int Rango) {
        this.Rango = Rango;
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
     * @param Persona
     */
    public void setPersona(Persona Persona) {
        this.Persona = Persona;
    }
   
}
