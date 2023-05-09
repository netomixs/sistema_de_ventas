/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

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

    public boolean Actualizar(T t);

    public boolean Eliminar(int i);

    public DefaultTableModel getTabla();

    public List<T> getAll();
}
