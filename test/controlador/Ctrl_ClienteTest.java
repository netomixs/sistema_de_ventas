/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controlador;

import java.util.Calendar;
import java.util.Date;
import modelo.Cliente;
import modelo.Direccion;
import modelo.Persona;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class Ctrl_ClienteTest {

    private Persona persona;
    Cliente cliente;

    public Ctrl_ClienteTest() {
        cliente = new Cliente();
        persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellidoP("Pérez");
        persona.setApellidoM("García");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, 5, 15);
        Date fechaNacimiento = calendar.getTime();
        persona.setNacimiento(fechaNacimiento);
        persona.setCurp("PEJG900615HDFXXX");
        Date fechaRegistro = new Date();
        persona.setFechaRegistro(fechaRegistro);
        Direccion direccion = new Direccion();
        direccion.setCalle("Av. Insurgentes Sur");
        direccion.setNumero("1234");
        direccion.setCP("03100");
        direccion.setLocalidad("Col. del Valle");
        direccion.setEstado(1745);
        persona.setDireccion(direccion);
        cliente.setPersona(persona);
        cliente.setPuntos(0);
        cliente.setTelefono("8312378273");
    }

    /**
     * Test of crear method, of class Ctrl_Cliente.
     */
    @Test
    public void testCrear() {
        assertTrue(Ctrl_Cliente.crear(cliente));
    }

    /**
     * Test of get method, of class Ctrl_Cliente.
     */
    @Test
    public void testGet() {
        cliente = Ctrl_Cliente.get(16);
        assertTrue(cliente.getID() != 0);
    }

    /**
     * Test of actualizar method, of class Ctrl_Cliente.
     */
    @Test
    public void testActualizar() {
        cliente = Ctrl_Cliente.get(16);
        assertTrue(Ctrl_Cliente.actualizar(cliente));
    }

    /**
     * Test of actualizarPuntos method, of class Ctrl_Cliente.
     */
    @Test
    public void testActualizarPuntos() {
        Ctrl_Cliente.actualizarPuntos(16, 40);
        cliente = Ctrl_Cliente.get(16);
        assertTrue(cliente.getPuntos() == 40);
    }

    /**
     * Test of getAll method, of class Ctrl_Cliente.
     */
    @Test
    public void testGetAll() {
        assertTrue(Ctrl_Cliente.getAll().size() != 0);
    }

    /**
     * Test of getTabla method, of class Ctrl_Cliente.
     */
    @Test
    public void testGetTabla() {
        assertNotNull(Ctrl_Cliente.getTabla());
    }

    /**
     * Test of clacularPuntos method, of class Ctrl_Cliente.
     */
    @Test
    public void testClacularPuntos() {
        ;
        assertTrue(Ctrl_Cliente.clacularPuntos(1, 1000) == 50);
    }

    /**
     * Test of getTabla_Reporte method, of class Ctrl_Cliente.
     */
    @Test
    public void testGetTabla_Reporte() {
        Date fecha3 = new Date(122, 4, 8); // 8 de mayo de 2022
        Date fecha4 = new Date(121, 3, 15); // 15 de abril de 2021
        assertNotNull(Ctrl_Cliente.getTabla_Reporte(fecha4, fecha4));
    }

    /**
     * Test of descuentoPorRango method, of class Ctrl_Cliente.
     */
    @Test
    public void testDescuentoPorRango() {
        assertTrue(Ctrl_Cliente.descuentoPorRango(2,2000)==140);
    }

    /**
     * Test of eliminar method, of class Ctrl_Cliente.
     * Cuando se ejecute esta prueb cambia el Id del cliente
     */
    @Test
    public void testEliminar() {
        cliente.setID(698);
        Ctrl_Cliente.eliminar(cliente);
    }
}
