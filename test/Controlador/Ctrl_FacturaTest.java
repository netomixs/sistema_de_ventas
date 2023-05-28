/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import controlador.Ctrl_Factura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.ProductosVendidos;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class Ctrl_FacturaTest {

    /**
     *
     */
    public Ctrl_FacturaTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     * Test of Crear method, of class Ctrl_Factura.
     */
    @Test
    public void testCrear() {
        List<ProductosVendidos> list = new ArrayList<>();
        assertTrue(Ctrl_Factura.Crear(16, list) != 0);
    }

    /**
     * Test of InsertarTotal method, of class Ctrl_Factura.
     */
    @Test
    public void testInsertarTotal() {
        Ctrl_Factura.InsertarTotal(63, 1000);

    }

    /**
     * Test of getTabla method, of class Ctrl_Factura.
     */
    @Test
    public void testGetTabla() {
        assertNotNull(Ctrl_Factura.getTabla());
    }

    /**
     * Test of corteCaja method, of class Ctrl_Factura.
     */
    @Test
    public void testCorteCaja() {
        System.out.println(Ctrl_Factura.corteCaja());
        assertTrue(Ctrl_Factura.corteCaja() >= 1000);
    }

    /**
     * Test of getTabla_ReporteVnetas method, of class Ctrl_Factura.
     */
    @Test
    public void testGetTabla_ReporteVnetas() {
        Date fecha3 = new Date(122, 4, 8); // 8 de mayo de 2022
        Date fecha4 = new Date(121, 3, 15); // 15 de abril de 2021
        assertNotNull(Ctrl_Factura.getTabla_ReporteVnetas(fecha3, fecha4));
    }

}
