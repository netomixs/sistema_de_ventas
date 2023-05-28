/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import controlador.VentaPDF;
import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class VentaPDFTest {

   
    Date fechaFin;
Date fechaInicio;

    /**
     *
     */
    public VentaPDFTest() {
        Date fechaActual = new Date();

// Crear un objeto Calendar y restar 1 año
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        calendar.add(Calendar.YEAR, -1);

// Guardar la fecha de inicio
         fechaInicio = calendar.getTime();

// Crear otro objeto Calendar y restar 6 meses
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(fechaActual);
        calendar2.add(Calendar.MONTH, -6);

// Guardar la fecha de fin
         fechaFin = calendar2.getTime();
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     * Test of generarRoporteVentas method, of class VentaPDF.
     */
    @Test
    public void testGenerarRoporteVentas() {

        VentaPDF.generarRoporteVentas(fechaInicio, fechaFin);
    }

    /**
     * Test of generarRoporteClientes method, of class VentaPDF.
     */
    @Test
    public void testGenerarRoporteClientes() {
        VentaPDF.generarRoporteClientes(fechaInicio, fechaFin);
    }

    /**
     * Test of generarRoporteProdcutosMasVendidso method, of class VentaPDF.
     */
    @Test
    public void testGenerarRoporteProdcutosMasVendidso() {
        VentaPDF.generarRoporteProdcutosMasVendidso(fechaInicio, fechaFin);
    }

    /**
     * Test of generarPDf method, of class VentaPDF.
     */
    @Test
    public void testGenerarPDf() {
    }

}
