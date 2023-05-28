/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import controlador.Ctrl_RangoCliente;
import modelo.RangoCliente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class Ctrl_RangoClienteTest {
    
    /**
     *
     */
    public Ctrl_RangoClienteTest() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     * Test of getAllRangos method, of class Ctrl_RangoCliente.
     */
    @Test
    public void testGetAllRangos() {
        assertNotNull(Ctrl_RangoCliente.getAllRangos());
    }

    /**
     * Test of getRango method, of class Ctrl_RangoCliente.
     */
    @Test
    public void testGetRango() {
          assertTrue(Ctrl_RangoCliente.getRango(1).getId()>0);
    }
    
}
