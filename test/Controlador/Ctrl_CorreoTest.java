/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import controlador.Ctrl_Admin;
import controlador.Ctrl_Correo;
import controlador.Ctrl_Correo;
import controlador.Ctrl_Persona;
import java.util.Date;
import junit.framework.TestCase;

/**
 *
 * @author netom
 */
public class Ctrl_CorreoTest extends TestCase{
  
    /**
     *
     */
    public void testenviarAdvertenciaSesionTest(){
      Ctrl_Correo.enviarAdvertenciaSesion(93);
  }
  
    /**
     *
     */
    public void testCrear(){
     
       assertTrue(Ctrl_Correo.Crear(108, "deleon.gallegos"));
  }

    /**
     *
     */
    public void testActualizarTest(){
      assertTrue(Ctrl_Correo.Actualizar(108, "netomixdeleon@gmail.com"));
  }

    /**
     *
     */
    public void testEliminarTest(){
      Ctrl_Correo.Eliminar(108);
  }

    /**
     *
     */
    public void testConsultartest(){
      assertEquals("netomixdeleon@gmail.com", Ctrl_Correo.Consultar(93));
  }
}
