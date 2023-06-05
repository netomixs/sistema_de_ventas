/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.Direccion;
import modelo.Persona;

/**
 *
 * @author Ernezto de Leon Gallegos
 *
 */
public class Ctrl_Admin {

    /**
     *
     * Comprueba si existe algun adminstrador
     *
     * @return
     */
    public static final boolean existe() {
        boolean respuesta = false;

        try {
            Connection cn = Conexion.conectar();

            CallableStatement consulta = cn.prepareCall("{CALL Existe_Admin()}");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error ocuriro algo: " + e);
        }

        return respuesta;
    }

    /**
     *
     * Registra un administrador en la base de datos Returna true si se creo y
     * false si ocurrio algun error
     *
     * @param admi
     * @return
     */
    public static final boolean crear(Administrador admi) {
        boolean respuesta = false;
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            admi.setPersona(p.Crear(admi.getPersona()));
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Admin(?,?)}");
            consulta.setString(1, admi.getUsuario());
            consulta.setString(2, admi.getPassword());

            consulta.execute();

            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                admi.setID(Integer.parseInt(rs.getString(1)));
                cn.close();
                return relacionPersonaAdmin(admi);
            }
            cn.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Código de error para registro duplicado
                JOptionPane.showMessageDialog(null, "El usuario con ese apodo ya existe ", "Usuario repetido", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error" + e.getErrorCode(), JOptionPane.ERROR_MESSAGE);

            }
            eliminar(admi);
            return false;
        }
        return false;
    }

    /**
     * Crea la relacion entre admin y persona
     *
     * @param admi
     * @return
     */
    private static boolean relacionPersonaAdmin(Administrador admi) {
        boolean respuesta = false;
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{ CALL Crear_RelacionAdminPersona(?,?)}");
            consulta.setInt(2, admi.getID());
            consulta.setInt(1, admi.getPersona().getID());

            System.out.println(admi.getPersona().getID() + " " + admi.getID());

            if (consulta.executeUpdate() > 0) {
                cn.close();
                return true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al crear relacion: " + e);
            eliminar(admi);
        }
        return false;
    }

    /**
     *
     * Elimina al administrador ingresado
     *
     * @param administrador
     */
    public static void eliminar(Administrador administrador) {
        Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Admin(?,?,?)}");

            consulta.setInt(1, administrador.getID());
            consulta.setInt(2, administrador.getPersona().getID());
            consulta.setInt(3, administrador.getPersona().getDireccion().getID());
            consulta.execute();

            cn.close();
        } catch (SQLException e) {

        }
    }

    /**
     * Actualiza los datos del administrador indicado en el objeto
     *
     * @param administrador
     * @return
     */
    public static boolean actualizar(Administrador administrador) {
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            p.Actualizar(administrador.getPersona());
            Connection cn = Conexion.conectar();

            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Admin(?,?,?)}");
            consulta.setInt(1, administrador.getID());
            consulta.setString(2, administrador.getUsuario());
            consulta.setString(3, administrador.getPassword());

            consulta.execute();

            ResultSet rs = consulta.getResultSet();
            cn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            if (e.getErrorCode() == 1062) { // Código de error para registro duplicado
                JOptionPane.showMessageDialog(null, "El usuario con ese apodo ya existe ", "Usuario repetido", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("Error al guardar usuario: " + e.getMessage());
            }

            return false;
        }

    }

    /**
     * Retorna los datos del administrador indicado en el ID del objeto
     *
     * @param administrador
     * @return
     */
    public static Administrador get(Administrador administrador) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Administradores_By_User_Password(?,?)}");
            consulta.setString(1, administrador.getUsuario());
            consulta.setString(2, administrador.getPassword());
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                Persona p = new Persona();
                Direccion d = new Direccion();
                p.setID(rs.getInt("ID_persona"));
                p.setNombre(rs.getString("Nombre"));
                p.setApellidoP(rs.getString("ApellidoP"));
                p.setApellidoM(rs.getString("ApellidoM"));
                p.setCurp(rs.getString("Curp"));
                p.setNacimiento(rs.getDate("Nacimiento"));
                d.setID(rs.getInt("ID_direccion"));
                System.out.println("fhubdisjokm" + rs.getInt("ID_direccion"));
                d.setCP(rs.getString("CP"));
                d.setCalle(rs.getString("Calle"));
                d.setEstado(rs.getInt("Estado"));
                d.setLocalidad(rs.getString("Localidad"));
                d.setNumero(rs.getString("Numero"));
                administrador.setID(rs.getInt("ID_Admin"));
                p.setDireccion(d);
                administrador.setPersona(p);
                administrador.setUsuario(rs.getString("Usuario"));
                cn.close();
                return administrador;
            }
   cn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
        return null;
    }

    /**
     * Eliminar al administrador indicado por ID Se debe de proporcionar ID
     * persona y direccion en el objeto
     *
     * @param admin
     */
    public static void eliminarAdministrador(Administrador admin) {
        // Pedir la confirmación de eliminación de cuenta al usuario
        int confirmacion1 = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar su cuenta?");

        // Si el usuario confirma la eliminación de cuenta, pedir la confirmación una segunda vez
        if (confirmacion1 == JOptionPane.YES_OPTION) {
            int confirmacion2 = JOptionPane.showConfirmDialog(null, "Por favor, confirme que desea eliminar su cuenta.", "Confirmación", JOptionPane.YES_NO_OPTION);

            // Si el usuario confirma la eliminación de cuenta por segunda vez, mostrar un mensaje de confirmación
            if (confirmacion2 == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Su cuenta ha sido eliminada correctamente.", "Cuenta eliminada", JOptionPane.INFORMATION_MESSAGE);
                eliminar(admin);
                System.exit(0);
            } else {
                // Si el usuario cancela la eliminación de cuenta por segunda vez, mostrar un mensaje de cancelación
                JOptionPane.showMessageDialog(null, "La eliminación de su cuenta ha sido cancelada.", "Cancelación", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Si el usuario cancela la eliminación de cuenta, mostrar un mensaje de cancelación
            JOptionPane.showMessageDialog(null, "La eliminación de su cuenta ha sido cancelada.", "Cancelación", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
