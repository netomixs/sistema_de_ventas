package controlador;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ProductosVendidos;

/**
 * Clase que registra los pordutos vendidos en la base de datos
 *
 * @author netom
 */
public class Ctrl_RegistrarVenta {

    static String nombre = "Tienda de ropa";
    static String info = "Calle: Calle de la Rosa. Numero: 123. Zone centro. El Mante Tamaulipas";

    /**
     * Crea un registro de venta
     */
    private static boolean Crear(ProductosVendidos venta) {
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Crear_Productosvendidos(?,?,?,?)}");
            consulta.setInt(1, venta.getProdcuto());
            consulta.setInt(2, venta.getCantidad());
            consulta.setInt(3, venta.getFactura());
            consulta.setFloat(4, venta.getSubTotal());
            consulta.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            return false;
        }
    }

    /**
     * Registra todos los registro de ventas
     *
     * @param lista
     * @param idFactura
     * @return
     */
    protected static final List<ProductosVendidos> registarVenta(List<ProductosVendidos> lista, int idFactura) {
        float total = 0;
        List<ProductosVendidos> noProcesados = new ArrayList<>();
        for (ProductosVendidos i : lista) {
            i.setFactura(idFactura);
            total += i.getSubTotal();
            if (Crear(i)) {

            } else {
                noProcesados.add(i);
            }
        }

        return noProcesados;

    }

    /**
     * CRecup[era los regsitro de una factura
     *
     * @param facturaId
     * @return
     */
    public static final List<ProductosVendidos> getAll(int facturaId) {
        List<ProductosVendidos> lista = new ArrayList<>();
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Productos_Vendidos_By_Factura(?)}");
            consulta.setInt(1, facturaId);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                ProductosVendidos p = new ProductosVendidos();
                p.setID(rs.getInt("ID"));
                p.setProdcuto(rs.getInt("Producto"));
                p.setFactura(rs.getInt("Factura"));
                p.setSubTotal(rs.getFloat("Subtotal"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Error al recuperar datos: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return lista;
    }

    /**
     * Recupera los registro en forma de tabla
     *
     * @param factura
     * @return
     */
    public static DefaultTableModel getTabla(int factura) {
        DefaultTableModel model = new DefaultTableModel();
        String fila[] = new String[2];
        model.addColumn("Nombre");
        model.addColumn("Subtotal");
        try {
            Connection cn = Conexion.conectar();
            CallableStatement consulta = cn.prepareCall("{CALL Consultar_Productos_Vendidos_By_Factura(?)}");
            consulta.setInt(1, factura);
            consulta.execute();
            ResultSet rs = consulta.getResultSet();
            while (rs.next()) {
                ProductosVendidos p = new ProductosVendidos();
                fila[0] = rs.getString("Nombre");
                fila[1] = rs.getFloat("Subtotal") + "";
                model.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar datos: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return model;
    }

    /**
     * genera un ticke listo para imprimir
     *
     * @param id
     * @param model
     * @param total
     * @param subtotoal
     * @param descuento
     * @param iva
     * @param clienteId
     * @throws java.io.FileNotFoundException
     * @throws com.itextpdf.text.BadElementException
     */
    public static void generarTicket(int id, DefaultTableModel model, float total, float subtotoal, float descuento, float iva, String clienteId) throws FileNotFoundException, BadElementException, IOException {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaActual = fecha.format(formatter);
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaActual = hora.format(formatterHora);

        // Se crea un objeto File con la ruta y nombre del archivo PDF que se va a generar
        File file = new File("src/pdf/venta" + id + ".pdf");
        try ( FileOutputStream archivo = new FileOutputStream(file) // Se crea un objeto FileOutputStream con el archivo anteriormente creado para escribir en él
                ) {
            Document doc = new Document();// Se crea un objeto Document que representa el documento PDF
            PdfWriter.getInstance(doc, archivo);// Se crea un objeto PdfWriter con el Document y el FileOutputStream para escribir en el documento PDF
            doc.open();//Se abre el documento para empezar a escribir en el
            Image img = Image.getInstance("src/Recursos/img/LogoSalesWear.png");//Se agarra una imagen
            img.scaleAbsolute(100, 100);//escala la imagen
            img.setAlignment(Element.ALIGN_CENTER);//alinea la imagen al centro
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);//Se establece una fuente en negrita

            Paragraph encabezado = new Paragraph();//Se crea una seccion para el encabezado del documento
            //Se agrega la informacion de la empresa en el encabezado
            encabezado.add(img);//Se agrega la imagen al encabezado
            encabezado.add(nombre + "\n" + info + "\n");
            encabezado.add(fechaActual + "  " + horaActual + "\n\n");//Se agrega la fecha y hora actual al encabezado
            encabezado.setAlignment(Element.ALIGN_CENTER);

            //encabezado.add("________________________________________________________________________________________________________________________");
            doc.add(encabezado);//Se agrega el encabezado al documento

            //Productos
            PdfPTable tablaProd = new PdfPTable(4);//Se crea una seccion para los productos en el ticket, el cual será de 4 columnas
            tablaProd.setWidthPercentage(100);//Se crea un porcentaje de ancho para los productos
            tablaProd.getDefaultCell().setBorder(0);// Se establece el borde por defecto de las celdas en 0
//Se estabblece el ancho de las columnas y la alineación de la seccion
            float[] columnProd = new float[]{10f, 25f, 10f, 10f};
            tablaProd.setWidths(columnProd);
            tablaProd.setHorizontalAlignment(Element.ALIGN_LEFT);//Se alinea la seccion de productos a la izquierda
//Se establece la informacion de los productos en el encabezado de la seccion de productos y se le establece la fuente en negrita
            PdfPCell prod1 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell prod2 = new PdfPCell(new Phrase("Producto", negrita));
            PdfPCell prod3 = new PdfPCell(new Phrase("Precio unitario", negrita));
            PdfPCell prod4 = new PdfPCell(new Phrase("Total", negrita));
            prod1.setBorder(0);
            prod2.setBorder(0);
            prod3.setBorder(0);
            prod4.setBorder(0);

//Se agrega la informacion a la seccion de los productos
            tablaProd.addCell(prod1);
            tablaProd.addCell(prod2);
            tablaProd.addCell(prod3);
            tablaProd.addCell(prod4);
            //Estas cuatro celdas son simplemente para agregar un salto de linea inmediatamente despues de la informacion de seccion,
            // deben ser forsozamente 4, por que la tabla de productos se establecio de 4 columnas
            tablaProd.addCell("");
            tablaProd.addCell("");
            tablaProd.addCell("");
            tablaProd.addCell("");
//Se recorren todos los elementos que se compraron para agregarlos al ticket
            for (int i = 0; i < model.getRowCount(); i++) {
                String descripcion = model.getValueAt(i, 1).toString();
                String cantidad = model.getValueAt(i, 2).toString();
                 String precioUnitario = model.getValueAt(i, 3).toString();
                String precio = "$" + model.getValueAt(i, 5).toString();
                tablaProd.addCell(cantidad);
                tablaProd.addCell(descripcion);
                tablaProd.addCell(precioUnitario);
                tablaProd.addCell(precio);
            }
            doc.add(tablaProd);//Se agregan todos los productos al ticket
//Se crea una seccion para escribir el total en el ticket
            Paragraph pararfo = new Paragraph();
            pararfo.add(Chunk.NEWLINE);//Salto de linea

            pararfo.add("Subtotal :" + subtotoal + "\n");
            pararfo.add("Iva: " + iva + "\n");
            pararfo.add("Descuento: " + descuento + "\n");
            pararfo.add("Subtotal :" + total);
            pararfo.setAlignment(Element.ALIGN_RIGHT);
            doc.add(pararfo);//Se agrega la seccion al ticket
//Se crea una seccion para la informacion del cliente
            Paragraph Cliente = new Paragraph();
            Cliente.setAlignment(Element.ALIGN_CENTER);
            String cliente = "Cliente";
            if (clienteId.isEmpty()) {
                cliente = clienteId;
            }
            //Cliente.add("Apreciable: " + cliente + "\n");
            Cliente.add("Que tenga un excelente día");
            doc.add(Cliente);//Se agrega la informacon del cliente al ticket

            Paragraph mensaje = new Paragraph();
            mensaje.setAlignment(Element.ALIGN_CENTER);
            mensaje.add(Chunk.NEWLINE);//Salto de linea
            mensaje.add("Gracias por su compra" + "\n");
            doc.add(mensaje);
            doc.close();//Se cierra el documento, indicando que ya se dejo de escribir en el
        } catch (DocumentException ex) {
            Logger.getLogger(Ctrl_RegistrarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Desktop.getDesktop().open(file);
    }
}
