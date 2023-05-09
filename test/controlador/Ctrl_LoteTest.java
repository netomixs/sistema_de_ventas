/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.util.Date;
import modelo.Lote;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class Ctrl_LoteTest {

    Ctrl_Lote Ctrl_lote;
    Lote lote;

    public Ctrl_LoteTest() {
        Ctrl_lote = new Ctrl_Lote();
        lote = new Lote();
        lote.setFechaLLegada(new Date());
        lote.setFechaRetiro(new Date());
        lote.setSerie("ABCD");
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of Crear method, of class Ctrl_Lote.
     */
    @Test
    public void testCrear() {
        assertTrue(Ctrl_lote.Crear(lote));

    }

    /**
     * Test of Actualizar method, of class Ctrl_Lote.
     */
    @Test
    public void testActualizar() {
        assertTrue(Ctrl_lote.Actualizar(lote));
    }

    /**
     * Test of Eliminar method, of class Ctrl_Lote.
     */
    @Test
    public void testEliminar() {
        lote = Ctrl_lote.get("ABCD");
        assertTrue(Ctrl_lote.Eliminar(lote.getID()));
    }

    /**
     * Test of getAll method, of class Ctrl_Lote.
     */
    @Test
    public void testGetAll() {
        assertTrue(Ctrl_lote.getAll().size() > 0);
    }

    /**
     * Test of get method, of class Ctrl_Lote.
     */
    @Test
    public void testGet_int() {
        assertNotNull(Ctrl_lote.get(5));
    }

    /**
     * Test of get method, of class Ctrl_Lote.
     */
    @Test
    public void testGet_String() {
        assertNotNull(Ctrl_lote.get("1WE5F6H9"));
    }

    /**
     * Test of existe method, of class Ctrl_Lote.
     */
    @Test
    public void testExiste() {
        assertTrue(Ctrl_lote.existe("1WE5F6H9"));
    }

    /**
     * Test of getTabla method, of class Ctrl_Lote.
     */
    @Test
    public void testGetTabla() {
        assertNotNull(Ctrl_lote.getTabla());
    }

}
