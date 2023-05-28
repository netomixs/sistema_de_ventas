/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author netom
 * @param <T>
 */
public interface Crud<T> {

    /**
     *Registrar en la base de datos
     * @param t
     * @return 
     */
    public boolean Crear(T t);

    /**
     *
     * @param t
     * @return
     */
    public boolean Actualizar(T t);

    /**
     *
     * @param i
     * @return
     */
    public boolean Eliminar(int i);

    /**
     *
     * @return
     */
    public DefaultTableModel getTabla();

    /**
     *
     * @return
     */
    public List<T> getAll();
}
