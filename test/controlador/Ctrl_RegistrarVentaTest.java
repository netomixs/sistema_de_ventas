/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class Ctrl_RegistrarVentaTest {
    
    public Ctrl_RegistrarVentaTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getAll method, of class Ctrl_RegistrarVenta.
     */
    @Test
    public void testGetAll() {
        assertNotNull(Ctrl_RegistrarVenta.getAll(18));
    }

    /**
     * Test of getTabla method, of class Ctrl_RegistrarVenta.
     */
    @Test
    public void testGetTabla() {
         assertNotNull(Ctrl_RegistrarVenta.getTabla(18));
    }


    
}
