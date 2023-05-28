package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Direccion;
import modelo.Persona;

/**
 * Clase que controla la clase de cliente y todas la interacciones del modelo
 * con la base de datos
 *
 * @author netom
 */
public class Ctrl_Cliente {

    /**
     * Registra un Cliente en la base de datos
     *
     * @param cliente
     * @return
     */
    public static final boolean crear(Cliente cliente) {
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
            eliminar(cliente);
            return false;
        }
        return false;
    }

    /**
     *
     * crear la relacion entre cliente y persona false si ocurrio algun error
     *
     * @param cliente
     * @return
     */
    private static boolean relacionPersonaCliente(Cliente cliente) {
        Ctrl_Persona p = new Ctrl_Persona();
        try {

            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{ CALL Relacion_ClientePersona(?,?)}");
            consulta.setInt(1, cliente.getID());
            consulta.setInt(2, cliente.getPersona().getID());

            System.out.println(cliente.getPersona().getID() + " " + cliente.getID());

            if (consulta.executeUpdate() > 0) {

                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al crear relacion: " + e);
            eliminar(cliente);
        }
        return false;
    }

    /**
     * Eliminar un cliente en la base de datos
     *
     * @param cliente
     */
    public static void eliminar(Cliente cliente) {
        Connection cn = Conexion.conectar();
        try {
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Cliente(?,?,?)}");
            consulta.setInt(1, cliente.getID());
            consulta.setInt(2, cliente.getPersona().getID());
            consulta.setInt(3, cliente.getPersona().getDireccion().getID());
            consulta.execute();
            System.out.println("Eliminar Persona");
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Eliminar: " + e);
        }
    }

    /**
     * Obtiene un Cliente en la base de datos
     *
     * @param ID
     * @return
     */
    public static Cliente get(int ID) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Cliente_By_ID(?)}");
            consulta.setInt(1, ID);
            Cliente cliente = new Cliente();
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

    /**
     * actualizar un Cliente en la base de datos
     *
     * @param cliente
     * @return
     */
    public static boolean actualizar(Cliente cliente) {
        Ctrl_Persona p = new Ctrl_Persona();
        try {
            p.Actualizar(cliente.getPersona());
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Cliente(?,?,?)}");
            consulta.setInt(1, cliente.getID());
            consulta.setString(2, cliente.getTelefono());
            consulta.setInt(3, cliente.getRango());
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);

            return false;
        }

    }

    /**
     * Aumenta la canidad de puntos indicados al cliente indicado
     *
     * @param ID
     * @param puntos
     * @return
     */
    public static boolean actualizarPuntos(int ID, int puntos) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Cliente_Puntos(?,?)}");
            consulta.setInt(1, ID);
            consulta.setInt(2, puntos);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
             return true;
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
       
    }

    /**
     * Recupera todos los clientes y los retorna en forma de lista
     *
     * @return
     */
    public static List<Cliente> getAll() {
        List<Cliente> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_All_Clientes()}");
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                Persona p = new Persona();
                Direccion d = new Direccion();

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

    /**
     * Obtienen un tabla de todos los clientes
     *
     * @return
     */
    public static DefaultTableModel getTabla() {
        DefaultTableModel model = new DefaultTableModel();
        List<Cliente> lista = getAll();
        String fila[] = new String[5];
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Apelldios");
        model.addColumn("Rango");
        for (Cliente i : lista) {
            fila[0] = i.getID() + "";
            fila[1] = i.getPersona().getNombre();
            fila[2] = i.getPersona().getApelldios();
            fila[3] = Ctrl_RangoCliente.getRango(i.getRango()).getNombre();
            model.addRow(fila);
        }
        return model;
    }

    /**
     * Se calculas los puntos obtenidos por el cliente dependiendo su compra y y
     * rango
     *
     * @param rango
     * @param total
     * @return
     */
    public static int clacularPuntos(int rango, float total) {
        int puntos = 0;
        switch (rango) {
            case 0:
                puntos = (int) (total * .02);
                break;
            case 1:
                puntos = (int) (total * .05);
                break;
            case 2:
                puntos = (int) (total * .07);
                break;
            default:

        }
        return puntos;
    }

    /**
     * Se recupera los clientes registrados dentro de un periodo
     *
     * @param inicio
     * @param fin
     * @return
     */
    public static DefaultTableModel getTabla_Reporte(Date inicio, Date fin) {
        DefaultTableModel model = new DefaultTableModel();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Clientes_By_Periodo(?,?)}");
            consulta.setDate(1, new java.sql.Date(inicio.getTime()));
            consulta.setDate(2, new java.sql.Date(fin.getTime()));
            consulta.execute();
            ResultSet rs = consulta.getResultSet();

            String fila[] = new String[6];
            model.addColumn("Id");
            model.addColumn("Nombre");
            model.addColumn("Apelldios");
            model.addColumn("Rango");
            model.addColumn("Direccion");
            model.addColumn("Fecha de registro");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                Cliente c = get(rs.getInt("ID_cliente"));
                fila[0] = c.getID() + " ";
                fila[1] = c.getPersona().getNombre() + " ";
                fila[2] = c.getPersona().getApelldios() + " ";
                fila[3] = Ctrl_RangoCliente.getRango(c.getRango()).getNombre() + " ";
                fila[4] = c.getPersona().getDireccion().getDireccionCompleta() + " ";
                fila[5] = c.getPersona().getFechaRegistro() + " ";
                model.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");

        }
        return model;
    }

    /**
     *Calcula el descuento dependiendo del rango indicado
     * @param rango
     * @param total
     * @return
     */
    public  static float descuentoPorRango(int rango,float total){
        float descuento=0;
        switch (rango) {
                 case 1:
                descuento=.05f;
                break;
                 case 2:
                descuento=.07f;
                break;
            default:
                
        }
        return total*descuento;
    }
}
