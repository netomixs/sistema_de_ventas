/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import javax.activation.DataSource;
import javax.swing.JFrame;
import modelo.Lote;

/**
 *
 * @author netom
 */
public class Ctrl_Correo {

    final static String username = "diarioisc@alwaysdata.net";
    final static String password = "pokemonDiamenteyPerla";

    /**
     * Prepara un mensaje sobre el inicio de sesion Si el usuario tienen un
     * correo registrado llama a la funcion nde enviar correo En caso de que no
     * se pide que ingrese uno y se envia el correo
     *
     * @param id
     */
    public static final void enviarAdvertenciaSesion(int id) {
        String correo = Consultar(id);
        System.out.println(correo);
        if (!correo.isEmpty()) {
            LocalDate tiempo = LocalDate.now();
            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaActualConFormato = tiempo.format(formato);

            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("hh:mm:ss a");
            String horaFormateada = horaActual.format(formatoHora);
            enviar(correo, "Alerta de inicio se sesión", "Se a detectado un inicio de sesión el " + fechaActualConFormato + " a las " + horaFormateada);
        } else {
            String respuesta = JOptionPane.showInputDialog(null, "No ha configurado las alertas de inicio se sesion\nPor favor ingrese un correo para enviar notificaciones de seguridad.");
            if (respuesta != null) {
                Crear(id, respuesta);
                enviarAdvertenciaSesion(id);
            } else {

            }

        }

    }

    /**
     * Inserta un correo a un usuario que no tenia
     *
     * @param id
     * @param correo
     * @return
     */
    public static final boolean Crear(int id, String correo) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL NuevoCorreo(?,?)}");
            consulta.setInt(1, id);
            consulta.setString(2, correo);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear correo: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }

    /**
     * Actualiza el correo del usuario
     *
     * @param id
     * @param correo
     * @return
     */
    public static final boolean Actualizar(int id, String correo) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Actualizar_Correo(?,?)}");
            consulta.setInt(1, id);
            consulta.setString(2, correo);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear correo: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }

    /**
     * Elimina el correo del usuario
     *
     * @param id
     * @return
     */
    public static final boolean Eliminar(int id) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Eliminar_Correo(?)}");
            consulta.setInt(1, id);
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear correo: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }

    /**
     * Recupera el correo del usuario
     *
     * @param id
     * @return
     */
    public static final String Consultar(int id) {
        String correo = "";
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL 	Consultar_Correo(?)}");
            consulta.setInt(1, id);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                return rs.getString("Correo");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return correo;
        }
        return correo;
    }

    /**
     * Se envia un correo a la direccion indicada usando el contenido indicado
     *
     * @param correoDestino
     * @param asutno
     * @param contenido
     * @return
     */
    public static final boolean enviar(String correoDestino, String asutno, String contenido) {
        String servidor = "smtp-diarioisc.alwaysdata.net";//Servidor smtp
        String puerto = "587";//puerto del servidor
        System.out.println("iniciando configuracion");
        //Se prepara la configuracion
        Properties props = new Properties();
        props.put("mail.smtp.host", servidor);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", puerto);
        props.put("mail.smtp.socketFactory.port", puerto);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.println("iniciando AUth");
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            System.out.println("Configurando envio");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(correoDestino));
            message.setSubject(asutno);
            message.setText(contenido);
            System.out.println("Enviando");
            Transport.send(message);

            System.out.println("Correo enviado!");
            return true;
        } catch (Exception e) {
            System.out.println("Error!" + e);
            return false;
        }
    }

    /**
     *Actualiz el correo del cliente indicado
     * @param id
     */
    public static void actualizarORegistrarCorreo(int id) {
        // Comprobar si el correo ya existe
        String correo = Consultar(id);
        String mensaje;
        boolean correoExiste = false; // Variable temporal, deberías reemplazar esto con tu lógica real
        if (!correo.isEmpty()) {
            mensaje = "Actualizar correo actual: ";
            correo = JOptionPane.showInputDialog(null, mensaje, "Correo actual " + correo, 1);
            if(correo!=null   ){
                if(!correo.isEmpty()){
                     Actualizar(id, correo); 
                }
              
            }
            

        } else {
            mensaje = "Por favor, registre su correo electrónico: ";
            correo = JOptionPane.showInputDialog(null, mensaje, "Agregar nuevo correo ", 1);
             if(correo!=null ){
                 if(!correo.isEmpty()){
                 Crear(id, correo);}
                 
            }
        }

    }
}
