 
package controlador;

import controlador.Ctrl_TipoProducto;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;

 
public class Ctrl_TipoProductoTest extends TestCase{

    @Test
    public void testCrear() {
    Ctrl_TipoProducto ctrl = new Ctrl_TipoProducto();
        String[] tipos = {"Camisas", "Pantalones", "Vestidos", "Faldas", "Shorts", "Trajes de baño", "Ropa interior", "Chaquetas", "Abrigos", "Sudaderas", "Jerseys", "Blazers", "Chalecos", "Calzado deportivo", "Zapatos", "Botas", "Sandalias", "Zapatillas", "Gorros", "Bufandas", "Guantes", "Sombreros", "Joyas", "Bolsos", "Lentes de sol", "Relojes", "Ropa para bebés y niños", "Ropa de maternidad"};
        for (String tipo : tipos) {
            boolean resultado = Ctrl_TipoProducto.Crear(tipo);
            assertTrue(resultado);
        }
    }

    @Test
    public void testActualizar() {
        Ctrl_TipoProducto ctrl = new Ctrl_TipoProducto();
        int id = 1;
        String[] tipos = {"Camisas", "Pantalones", "Vestidos", "Faldas", "Shorts", "Trajes de baño", "Ropa interior", "Chaquetas", "Abrigos", "Sudaderas", "Jerseys", "Blazers", "Chalecos", "Calzado deportivo", "Zapatos", "Botas", "Sandalias", "Zapatillas", "Gorros", "Bufandas", "Guantes", "Sombreros", "Joyas", "Bolsos", "Lentes de sol", "Relojes", "Ropa para bebés y niños", "Ropa de maternidad"};
        for (String tipo : tipos) {
            boolean resultado = Ctrl_TipoProducto.Actualizar(id, tipo);
            assertTrue(resultado);
            id++;
        }
    }

    @Test
    public void testEliminar() {
        int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,31,32};
        for (int id : ids) {
            boolean resultado = Ctrl_TipoProducto.Elimniar(id);
            assertTrue(resultado);
        }
    }
}




