/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista.Componentes;

import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author netom
 * @param <T>
 */
public interface VistaFormInterfaz<T> {
          /**
     *
     * @param modelo
     */
    public void llenarCampos(T modelo);

    /**
     *
     */
    public void limpiarCampos();

    /**
     *
     */
    public void recuperarCampos();

    /**
     *
     * @return
     */
    public boolean camposVacios();

    /**
     *
     * @param campo
     * @param maxChars
     */
    public void limitarLongitudCampo(JTextField campo, int maxChars);

    /**
     *
     */
    public void cargarTabla();

    /**
     *
     */
    public void actualizarTabla();

    /**
     *
     * @param tabla
     */
    public void addEventoTabla(JTable tabla);

    /**
     *
     */
    public void recupararIndexDeTabla();

    /**
     *
     */
    public void actualizar();

    /**
     *
     */
    public void eliminar();

    /**
     *
     */
    public void activarBoton();

    /**
     *
     */
    public void bloquerCampos();

    /**
     *
     */
    public void desBloquerCampos();
}
