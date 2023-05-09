/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.Producto;
import modelo.TIpo_Producto;
import static controlador.Ctrl_Admin.eliminar;

/**
 *Clase que controla las interacciones de la base de datos
 * @author netom
 */
public class Ctrl_TipoProducto {

    /**
     *Crea un tipo de de prodcuto y lo registra de la base de datos
     * @param tipo
     * @return
     */
    public static final boolean Crear(String tipo) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_TipoProductos(?)}");
            consulta.setString(1, tipo);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear Tipo prodcutos: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }

    }

    /**
     *Actualiza el nombre del tipo de productos
     * @param id
     * @param tipo
     * @return
     */
    public static final boolean Actualizar(int id, String tipo) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_TipoProductos(?,?)}");
            consulta.setInt(1, id);
            consulta.setString(2, tipo);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }

    }

    /**
     *Elimina el tipo de prodcuto de la base de datos
     * @param id
     * @return
     */
    public static final boolean Elimniar(int id) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_TipoProductos(?)}");
            consulta.setInt(1, id);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }

    }

    /**
     *Recupera una lista de la tipos de prodcutos de la base de datos
     * @return
     */
    public static final List<TIpo_Producto> getAll() {
        List<TIpo_Producto> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_Tipo_Producto()}");
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                TIpo_Producto tipo = new TIpo_Producto();
                tipo.setID(rs.getInt("ID"));
                tipo.setTipo(rs.getString("Tipo"));
                lista.add(tipo);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return lista;
    }

    /**
     *Recupera el tipo de prodcuto indicado por ID
     * @param id
     * @return
     */
    public static final TIpo_Producto getTipo(int id) {
        List<TIpo_Producto> lista = getAll();
        for (TIpo_Producto i : lista) {
            if (i.getID() == id) {
                return i;
            }
        }
        return new TIpo_Producto(0, "Error");

    }

    /**
     *Recupera el tipo de prodcuto indicado por Nombre
     * @param nombre
     * @return
     */
    public static final TIpo_Producto getTipo(String nombre) {
        List<TIpo_Producto> lista = getAll();
        for (TIpo_Producto i : lista) {
            if (i.getTipo().equals(nombre)) {
                return i;
            }
        }
        return new TIpo_Producto(0, "Error");
    }

    /**
     *Recupera el index del tipo del producto buiscado por el ID
     * @param id
     * @return
     */
    public static final int getIndex(int id) {
        List<TIpo_Producto> lista = getAll();
        int index = 0;
        for (TIpo_Producto i : lista) {
            if (i.getID() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     *Consulta si un tipo de prodcuto existe
     * @param nombre
     * @return
     */
    public static final boolean existe(String nombre) {
        List<TIpo_Producto> lista = getAll();
        for (TIpo_Producto i : lista) {
            if (i.getTipo().equals(nombre)) {
                return true;
            }
        }
        return false;

    }

    /**
     *Recupera una tabla de los tipos de prodcutos
     * @return
     */
    public static DefaultTableModel getTabla() {
    
        List<TIpo_Producto> lista = getAll();
            DefaultTableModel model = new DefaultTableModel();
        String fila[] = new String[2];
        model.addColumn("Id");
        model.addColumn("Nombre");
        for (TIpo_Producto i : lista) {
            fila[0] = i.getID() + "";
            fila[1] = i.getTipo();

            model.addRow(fila);
        }

        return model;
    }
}
