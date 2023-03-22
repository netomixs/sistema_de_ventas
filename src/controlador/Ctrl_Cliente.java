package controlador;

import conexion.Conexion;
import static controlador.Ctrl_Admin.eliminarPersona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.Cajero;
import modelo.Cliente;
import modelo.Direccion;
import modelo.Persona;

/**
 *
 * @author Edison Zambrano - © Programador Fantasma
 */
public class Ctrl_Cliente {

    public static final boolean Crear(Cliente cliente) {
        boolean respuesta = false;
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            cliente.setPersona(p.Crear(cliente.getPersona()));
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Cliente(?,?,?)}");
            consulta.setString(1, cliente.getTelefono());
            consulta.setInt(2, cliente.getPuntos());
            consulta.setInt(3, cliente.getRango());
            consulta.execute();

            ResultSet rs = consulta.getResultSet();
            if (rs.next()) {
                cliente.setID(Integer.parseInt(rs.getString(1)));

                return relacionPersonaCliente(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            eliminarPersona(cliente);
            return false;
        }
        return false;
    }

    private static boolean relacionPersonaCliente(Cliente cliente) {
        boolean respuesta = false;
        Ctrl_Persona p = new Ctrl_Persona();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{ CALL Relacion_ClientePersona(?,?)}");
            consulta.setInt(2, cliente.getID());
            consulta.setInt(1, cliente.getPersona().getID());

            System.out.println(cliente.getPersona().getID() + " " + cliente.getID());

            if (consulta.executeUpdate() > 0) {

                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al crear relacion: " + e);
            eliminarPersona(cliente);
        }
        return false;
    }

    public static void eliminarPersona(Cliente obj) {
        Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Cliente(?,?,?)}");

            consulta.setInt(1, obj.getID());
            consulta.setInt(2, obj.getPersona().getID());
            consulta.setInt(3, obj.getPersona().getDireccion().getID());
            consulta.execute();
            System.out.println("Eliminar Persona");
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Eliminar: " + e);
        }
    }

    public static Cliente getCliente(int ID) {
        boolean respuesta = false;

        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Cliente_By_ID(?)}");
            consulta.setInt(1, ID);
            Cliente cliente=new Cliente();
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
                cliente.setID(rs.getInt("ID_cliente"));
                p.setDireccion(d);
                cliente.setPersona(p);
                cliente.setPuntos(rs.getInt("Puntos"));
                cliente.setRango(rs.getInt("Rango"));
                cliente.setTelefono(rs.getString("Telefono"));
                return cliente;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
        return null;
    }
    public static boolean actualizarCliente(Cliente cliente){
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            p.Actualizar(cliente.getPersona());
            Connection cn = Conexion.conectar();
            
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Cliente(?,?,?)}");
             consulta.setInt(1, cliente.getID());
            consulta.setString(2, cliente.getTelefono());
            consulta.setInt(3, cliente.getRango());

            consulta.execute();

            ResultSet rs = consulta.getResultSet();
   
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);

           return false;
        }
       return true;
    }
      public static boolean actualizarPuntos(int ID,int puntos){
        try {

            Connection cn = Conexion.conectar();
            
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Cliente_Puntos(?,?)}");
             consulta.setInt(1, ID);
            consulta.setInt(2,puntos);
         

            consulta.execute();

            ResultSet rs = consulta.getResultSet();
   
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
                JOptionPane.showMessageDialog(null,"Ocurrio un error");
           return false;
        }
       return true;
    }
    private static List<Cliente> getAllClientes() {
        boolean respuesta = false;
        List<Cliente> lista = new ArrayList<>();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_Cajeros()}");

            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                Cliente cliente = new Cliente();
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
               cliente.setID(rs.getInt("ID_cliente"));
                p.setDireccion(d);
                cliente.setPersona(p);
                cliente.setPuntos(rs.getInt("Puntos"));
                cliente.setRango(rs.getInt("Rango"));
                cliente.setTelefono(rs.getString("Telefono"));
                lista.add(cliente);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showInputDialog(null, "Error de conexion");
        }
        return lista;
    }
   public static DefaultTableModel getTabla(){
     DefaultTableModel model=new DefaultTableModel();
     List<Cliente>lista=getAllClientes();
     String fila[]=new String[5];
     model.addColumn("Id");
     model.addColumn("Nombre");
     model.addColumn("Apelldios");
     model.addColumn("Rango");
     for(Cliente i:lista){
         fila[0]=i.getID()+"";
         fila[1]=i.getPersona().getNombre();
         fila[2]=i.getPersona().getApelldios();
         fila[3]=Ctrl_RangoCliente.getRango(i.getRango()).getNombre();
         model.addRow(fila);
     
     }
     
     return model;
 }  
}
