package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ediso
 */
public class Conexion {

    //conexion local

    /**
     *Conexion con la base de datos
     * @return
     */
    public static Connection conectar() {
        
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/saleswearv1", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexion local " + e);
        }
        return null;
    }
}
