/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.security.SecureRandom;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.Cajero;
import modelo.Direccion;
import modelo.Persona;

/**
 *
 * @author netom
 */
public class Ctrl_Cajero {

    public static final boolean Crear(Cajero cajero) {
        boolean respuesta = false;
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            cajero.setPersona(p.Crear(cajero.getPersona()));
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Cajero(?)}");
            cajero.setClave(generateRandomPassword(8));
            System.out.println(cajero.getClave());
            consulta.setString(1, cajero.getClave());

            consulta.execute();

            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                cajero.setID(Integer.parseInt(rs.getString(1)));

                return relacionPersonaCajero(cajero);
            }
        } catch (SQLException e) {
            System.out.println("Error al crear usuario333: " + e);
            eliminarPersona(cajero);
          //  Ctrl_Persona.eliminarPersona(cajero.getPersona());
            return false;
        }
        return false;
    }

    private static boolean relacionPersonaCajero(Cajero cajero) {
        boolean respuesta = false;
        Ctrl_Persona p = new Ctrl_Persona();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{ CALL Relacion_CajeroPersona(?,?)}");
            consulta.setInt(1, cajero.getPersona().getID());
            consulta.setInt(2, cajero.getID());
            System.out.println(cajero.getPersona().getID() + " " + cajero.getID());

            if (consulta.executeUpdate() > 0) {

                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al crear relacion: " + e);
            eliminarPersona(cajero);
            // Ctrl_Persona.eliminarPersona(cajero.getPersona());
        }
        return false;
    }

    public static void eliminarPersona(Cajero obj) {
        Connection cn = Conexion.conectar();
       
        try {
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Cajero(?,?,?)}");
            Ctrl_Persona.eliminarPersona(obj.getPersona());
            consulta.setInt(1, obj.getID());
            consulta.setInt(2, obj.getPersona().getID());
            consulta.setInt(3, obj.getPersona().getDireccion().getID());
            consulta.execute();

            cn.close();
        } catch (SQLException e) {

        }
    }

    public static boolean actualizarCajero(Cajero cajero) {
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            p.Actualizar(cajero.getPersona());

        } catch (Exception e) {
            System.out.println("Error: " + e);

            return false;
        }
        return true;
    }

    public static Cajero getCajer(Cajero cajero) {
        boolean respuesta = false;

        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Cajero_By_Clave(?)}");
            consulta.setString(1, cajero.getClave());
         
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
                cajero.setID(rs.getInt("ID_Cajero"));
                p.setDireccion(d);
                cajero.setPersona(p);
                cajero.setClave(rs.getString("ClaveAcceso"));
                return cajero;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
        return null;
    }
        private static List<Cajero> getAllCajeros() {
        boolean respuesta = false;
         List<Cajero>lista=new ArrayList<>();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_Cajeros()}");
            
           
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
           while (rs.next()) {
                Cajero cajero=new Cajero();
                Persona p = new Persona();
                Direccion d = new Direccion();
                p.setID(rs.getInt("ID_cajero"));
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
                cajero.setID(rs.getInt("ID_Cajero"));
                p.setDireccion(d);
                cajero.setPersona(p);
                cajero.setClave(rs.getString("ClaveAcceso"));
               lista.add(cajero);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
       return lista;
    }
    private static String generateRandomPassword(int len)
    {
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`
 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
 public static DefaultTableModel getTablaCajeros(){
     DefaultTableModel model=new DefaultTableModel();
     List<Cajero>lista=getAllCajeros();
     String fila[]=new String[5];
     model.addColumn("Id");
     model.addColumn("Nombre");
     model.addColumn("Apelldios");
     model.addColumn("Clave");
     for(Cajero i:lista){
         fila[0]=i.getID()+"";
         fila[1]=i.getPersona().getNombre();
         fila[2]=i.getPersona().getApelldios();
         fila[3]=i.getClave();
         model.addRow(fila);
     }
     
     return model;
 }
}
