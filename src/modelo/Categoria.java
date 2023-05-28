package modelo;

/**
 *Clase en desuso
 * @author Ernesto
 */
public class Categoria {
    
    private int idCategoria;
    private String descripcion;
    private int estado;
    
    /**
     *
     */
    public Categoria(){
        this.idCategoria = 0;
        this.descripcion = "";
        this.estado = 0;
    }

    /**
     *
     * @param idCategoria
     * @param descripcion
     * @param estado
     */
    public Categoria(int idCategoria, String descripcion, int estado) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     *
     * @param idCategoria
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     
    
}
