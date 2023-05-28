/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Direccion;
import modelo.Persona;

/**
 *
 * @author netom
 */
public class Ctrl_Persona {

    /**
     * Crea una persona
     *
     * @param objeto
     * @return
     */
    public Persona Crear(Persona objeto) {

        Connection cn = Conexion.conectar();
        try {
            objeto.getDireccion().setID(crearDireccion(objeto.getDireccion()));
            CallableStatement consulta = cn.prepareCall("{ CALL Crear_Persona(?,?,?,?,?,?,?)}");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellidoP());
            consulta.setString(3, objeto.getApellidoM());
            consulta.setDate(4, new java.sql.Date(objeto.getNacimiento().getTime()));
            consulta.setInt(5, objeto.getDireccion().getID());
            consulta.setString(6, objeto.getCurp());
            consulta.setDate(7, new java.sql.Date(objeto.getFechaRegistro().getTime()));
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                objeto.setID(Integer.parseInt(rs.getString(1)));
                return objeto;
            }
            cn.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Código de error para registro duplicado
                JOptionPane.showMessageDialog(null, "La CURP ya se encuentra registrada", "Usuario repetido", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,e.getMessage(), "Error"+ e.getErrorCode(), JOptionPane.ERROR_MESSAGE);
            }
            eliminarPersona(objeto);
        }
        return new Persona();
    }

    /**
     * Actualiza los datos de una persona
     *
     * @param objeto
     */
    public void Actualizar(Persona objeto) {
        System.out.println("Direccion en personas" + objeto.getDireccion().getID());
        Connection cn = Conexion.conectar();
        try {

            ActualizarDireccion(objeto.getDireccion());
            CallableStatement consulta = cn.prepareCall("{ CALL Actualizar_Personas(?,?,?,?,?,?)}");
            consulta.setInt(1, objeto.getID());
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellidoP());
            consulta.setString(4, objeto.getApellidoM());
            consulta.setDate(5, new java.sql.Date(objeto.getNacimiento().getTime()));
            consulta.setString(6, objeto.getCurp());
            System.out.println("Actulizar direccion");
            consulta.execute();

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
            if (e.getErrorCode() == 1062) { // Código de error para registro duplicado

                JOptionPane.showMessageDialog(null, "La CURP ya se encuentra registrada", "Usuario repetido", JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showMessageDialog(null, "No se gaurdo la CURP", "Registro no guardado", JOptionPane.ERROR_MESSAGE);

            } else {
                System.out.println("Error al guardar usuario: " + e.getMessage());
            }
        }

    }

    /**
     * Agrega lka direccion a una persona
     *
     * @param obj
     * @return
     */
    public int crearDireccion(Direccion obj) {
        Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{ CALL Crear_Direccion(?, ?, ?,?, ?)}");

            consulta.setInt(1, obj.getEstado());
            consulta.setString(2, obj.getLocalidad());
            consulta.setString(3, obj.getCP());
            consulta.setString(4, obj.getCalle());
            consulta.setString(5, obj.getNumero());
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                return Integer.parseInt(rs.getString(1));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);

        }
        return 0;

    }

    /**
     * Actuliza la direccion nde la persona indicada
     *
     * @param obj
     */
    public void ActualizarDireccion(Direccion obj) {
        Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{ CALL Actualizar_Direccion(?,?, ?, ?,?, ?)}");
            System.out.println("D" + obj.getID());
            consulta.setInt(1, obj.getID());
            consulta.setInt(2, obj.getEstado());
            consulta.setString(3, obj.getLocalidad());
            consulta.setString(4, obj.getCP());
            consulta.setString(5, obj.getCalle());
            consulta.setString(6, obj.getNumero());
            consulta.execute();

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);

        }

    }

    /**
     * Elimina la persona indicada
     *
     * @param obj
     */
    public static void eliminarPersona(Persona obj) {
        Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{ CALL Eliminar_Persona(?, ?)}");

            consulta.setInt(1, obj.getID());
            consulta.setInt(2, obj.getDireccion().getID());
            consulta.execute();

            cn.close();
        } catch (SQLException e) {

        }
    }

    /**
     * Codifica la contraseña
     *
     * @param password
     * @return
     */
    public static String hashPassword(String password) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }

    /**
     * Verifica si la contraseña indicada es segura
     *
     * @param contrasena
     * @return
     */
    public static boolean esContrasenaSegura(String contrasena) {
        int longitudMinima = 5; // longitud mínima requerida
        String caracteresEspeciales = "!@#$%&*()_+-=[]|,./?><"; // caracteres especiales permitidos
        boolean tieneCaracteresEspeciales = false; // indica si la contraseña contiene caracteres especiales

        // verificar longitud mínima
        if (contrasena.length() < longitudMinima) {
            return false;
        }

        // verificar si contiene al menos un caracter especial
        for (char c : contrasena.toCharArray()) {
            if (caracteresEspeciales.indexOf(c) != -1) {
                tieneCaracteresEspeciales = true;
                break;
            }
        }

        return tieneCaracteresEspeciales;
    }

    /**
     * Valida si el formato de curp es indicado
     *
     * @param curp
     * @return
     */
    public static final boolean validarCurp(String curp) {
        // Validar longitud
        if (curp.length() != 18) {
            return false;
        }
        String replace = curp.replaceAll(" ", curp);
        // Validar formato
        String regex = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$";
        if (!curp.matches(regex)) {
            return false;
        }

        // Validar mayúsculas
        if (!curp.equals(curp.toUpperCase())) {
            return false;
        }

        // Si se han pasado todas las validaciones, la CURP es válida
        return true;

    }

    /**
     *Retorna True si la fecha indicada es mayor a 18 años
     * @param fechaNacimiento
     * @return
     */
    public static boolean esMayor(Date fechaNacimiento) {
        Date fechaActual = new Date();
        long edadMilisegundos = fechaActual.getTime() - fechaNacimiento.getTime();
        int edadAnos = (int) (edadMilisegundos / 1000 / 60 / 60 / 24 / 365);
        System.out.println(edadAnos);
        if (edadAnos >= 18) {
            return true;
        } else {
            return false;
        }
    }
}
