/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import controlador.Ctrl_Admin;
import java.util.Calendar;
import java.util.Date;
import modelo.Administrador;
import modelo.Direccion;
import modelo.Persona;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author netom
 */
public class Ctrl_AdminTest {

    Persona persona = new Persona();
    Administrador admin;

    /**
     *Prueba del controlador de administrador
     * El constructur crea un objeto que se usara para probar los metodos
     */
    public Ctrl_AdminTest() {
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
        admin = new Administrador();
        admin.setUsuario("admin");
        admin.setPassword("1234");
        admin.setPersona(persona);
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     * Test of crear method, of class Ctrl_Admin.
     */
    @Test
    public void testCrear() {
        assertTrue(Ctrl_Admin.crear(admin));
    }

    /**
     * Test of existe method, of class Ctrl_Admin.
     */
    @Test
    public void testExiste() {
        assertTrue(Ctrl_Admin.existe());
    }
  /**
     * Test of get method, of class Ctrl_Admin.
     */
    @Test
    public void testGet() {
        admin.setPassword("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        admin.setUsuario("netomix");
        admin=Ctrl_Admin.get(admin);
        assertTrue(admin.getID()!=0);
    }
    
    /**
     * Test of actualizar method, of class Ctrl_Admin.
     */
    @Test
    public void testActualizar() {
        assertTrue(Ctrl_Admin.actualizar(admin));
    }
    /**
     * Test of eliminar method, of class Ctrl_Admin.
     */
    @Test
    public void testEliminar() {
        admin=Ctrl_Admin.get(admin);
         System.out.println(admin.getID());
       Ctrl_Admin.eliminar(admin);
        
    }


  


}
