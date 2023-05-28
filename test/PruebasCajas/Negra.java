/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebasCajas;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import controlador.Ctrl_Producto;
import java.util.Date;

/**
 *Prueba de caja negra de calculo de tiempo en dias entre dos fechas
 * @author netom
 */
public class Negra {

    /**
     *Prueba para un dia de diferencia
     */
    @Test
    public void testUndia() {
Date start = new Date(2023 - 1900, 0, 1);
        Date end = new Date(2023 - 1900, 0, 2);
        int dias = (int) Ctrl_Producto.diasEntreDosFechas(start, end);
        assertEquals(1, dias);
    }

    /**
     *Prueba para do dia de diferencia
     */
    @Test
    public void testDosDias() {

        Date start = new Date(2023 - 1900, 0, 1);
        Date end = new Date(2023 - 1900, 0, 3);
        int dias = (int) Ctrl_Producto.diasEntreDosFechas(start, end);
        assertEquals(2, dias);
    }

    /**
     *Prueba para 30 dias de diferencia
     */
    public void test30Dias() {
        Date start = new Date(2023 - 1900, 0, 1);
        Date end = new Date(2023 - 1900, 0, 31);
        int dias = (int) Ctrl_Producto.diasEntreDosFechas(start, end);
        assertEquals(30, dias);

    }

    /**
     *Prueba para un año de diferencia
     */
    public void test365Dias() {
Date start = new Date(2023 - 1900, 0, 1);
        Date end = new Date(2024 - 1900, 0, 3);
        int dias = (int) Ctrl_Producto.diasEntreDosFechas(start, end);
        assertEquals(365, dias);
    }
}
