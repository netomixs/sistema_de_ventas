/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.util.Calendar;
import java.util.Date;
import modelo.Lote;
import modelo.Producto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class Ctrl_ProductoTest {

    Producto producto;
    Ctrl_Producto ctrl;

    public Ctrl_ProductoTest() {
        ctrl = new Ctrl_Producto();
        //Lote lote = new Lote(1, new Date(), new Date(), "Serie1");
        producto = new Producto();
        producto.setID(1);
        producto.setTipo(2);
        producto.setPrecio(25.50f);
        producto.setNombre("Producto A");
        producto.setDescripcion("Descripción del Producto A");
        producto.setStock(50);
        producto.setLoteID(5);
        producto.setImgSrc("/ruta/imagen_producto_a.jpg");
        producto.setC_Barras("1234567890");

    }

    @Before
    public void setUp() {
    }

    /**
     * Test of Crear method, of class Ctrl_Producto.
     */
    @Test
    public void testCrear() {
        assertTrue(ctrl.Crear(producto));
    }

    /**
     * Test of Actualizar method, of class Ctrl_Producto.
     */
    @Test
    public void testActualizar() {
        assertTrue(ctrl.Actualizar(producto));
    }

    /**
     * Test of Eliminar method, of class Ctrl_Producto.
     */
    @Test
    public void testEliminar_int() {
        assertTrue(ctrl.Eliminar(0));
    }

    /**
     * Test of Eliminar method, of class Ctrl_Producto.
     */
    @Test
    public void testEliminar_String() {
        assertTrue(ctrl.Eliminar("lssl"));
    }

    /**
     * Test of getAll method, of class Ctrl_Producto.
     */
    @Test
    public void testGetAll() {
        assertNotNull(ctrl.getAll());
    }

    /**
     * Test of getProducto method, of class Ctrl_Producto.
     */
    @Test
    public void testGetProducto_int() {
        assertNotNull(ctrl.getProducto(12));
        assertTrue(ctrl.getProducto(12).getID() > 0);
    }

    /**
     * Test of getProducto method, of class Ctrl_Producto.
     */
    @Test
    public void testGetProducto_String() {
        assertNotNull(ctrl.getProducto("849231257986"));
        assertTrue(ctrl.getProducto("849231257986").getID() > 0);
    }

    /**
     * Test of existe method, of class Ctrl_Producto.
     */
    @Test
    public void testExiste() {
        assertTrue(ctrl.existe("849231257986"));
    }

    /**
     * Test of getTabla method, of class Ctrl_Producto.
     */
    @Test
    public void testGetTabla() {
        assertNotNull(ctrl.getTabla());
    }

    /**
     * Test of descuentoPorFecha method, of class Ctrl_Producto.
     */
    @Test
    public void testDescuentoPorFecha() {
        producto = ctrl.getProducto("NOP012");
        assertTrue(ctrl.descuentoPorFecha(producto) > 0);
    }

    /**
     * Test of diasEntreDosFechas method, of class Ctrl_Producto.
     */
    @Test
    public void testDiasEntreDosFechas() {
        Calendar calendar = Calendar.getInstance();
        Date fechaActual = calendar.getTime();

// Agregar 10 días a la fecha actual
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date fechaFutura = calendar.getTime();
        System.out.println(Ctrl_Producto.diasEntreDosFechas(fechaFutura, fechaActual));
        assertTrue(Ctrl_Producto.diasEntreDosFechas(fechaFutura, fechaActual)==-10);
    }

    /**
     * Test of getTabla_Reporte method, of class Ctrl_Producto.
     */
    @Test
    public void testGetTabla_Reporte() {
        Calendar calendar = Calendar.getInstance();
        Date fechaActual = calendar.getTime();

// Agregar 10 días a la fecha actual
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date fechaFutura = calendar.getTime();
        assertNotNull(ctrl.getTabla_Reporte(fechaActual, fechaFutura));
   }

}
