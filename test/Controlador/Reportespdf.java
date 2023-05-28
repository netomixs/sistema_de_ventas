/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import controlador.Ctrl_Correo;
import controlador.VentaPDF;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertTrue;

/**
 *
 * @author netom
 */
public class Reportespdf extends TestCase {

    /* public void testReporteVentas() {
        String fechaTexto = "2023-01-01"; // Cadena de fecha en formato "yyyy-MM-dd"
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTexto2 = "2023-04-018"; // Cadena de fecha en formato "yyyy-MM-dd"
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
     
        Date inico = null;
        Date fin = null;
        try {
            inico = formato.parse(fechaTexto);
            fin = formato2.parse(fechaTexto2);
               System.out.println(inico);
        } catch (Exception e) {
            e.printStackTrace();
        }
        VentaPDF.generarRoporteVentas(inico, fin);
    }*/

    /**
     *
     */

    public void testReporteClientes() {
        String fechaTexto = "2023-01-01"; // Cadena de fecha en formato "yyyy-MM-dd"
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTexto2 = "2023-04-018"; // Cadena de fecha en formato "yyyy-MM-dd"
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date inico = null;
        Date fin = null;
        try {
            inico = formato.parse(fechaTexto);
            fin = formato2.parse(fechaTexto2);
            System.out.println(inico);
        } catch (Exception e) {
            e.printStackTrace();
        }
        VentaPDF.generarRoporteClientes(inico, fin);
    }

    /**
     *
     */
    public void testReporteprodcutosVendidos() {
        String fechaTexto = "2023-01-01"; // Cadena de fecha en formato "yyyy-MM-dd"
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTexto2 = "2023-04-018"; // Cadena de fecha en formato "yyyy-MM-dd"
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");

        Date inico = null;
        Date fin = null;
        try {
            inico = formato.parse(fechaTexto);
            fin = formato2.parse(fechaTexto2);
            System.out.println(inico);
        } catch (Exception e) {
            e.printStackTrace();
        }
        VentaPDF.generarRoporteProdcutosMasVendidso(inico, fin);
    }
}
