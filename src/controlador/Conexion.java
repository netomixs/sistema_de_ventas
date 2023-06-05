package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
             try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://mysql-diarioisc.alwaysdata.net/diarioisc_saleswear", "diarioisc", "pokemondiamanteyperla");
            return cn;
        } catch (SQLException b) {
            System.out.println("Error en la conexion local " + b);
        }
        }
        return null;
    }
      public static Connection Desconectar(Connection cn) {
        
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
