package controlador;

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
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import vista.InterFacturacion;

/**
 *Clase que genera pdf indicado
 * @author Jesus Ernesto De Leon Galleggos
 */
public class VentaPDF {

    private static String nombreCliente;
    private static String cedulaCliente;
    private static String telefonoCliente;
    private static String direccionCliente;

    private static String fechaActual = "";
    private static String nombreArchivoPDFVenta = "";

    private void generarFacturaPDF() {
      
        try {

            //cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }

            nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/img/ventas.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            fecha.add("Factura: 001" + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar el borde de la tabla
            //tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            Encabezado.addCell(img);

            String ruc = "0987654321001";
            String nombre = "Fantasma Cooporation";
            String telefono = "0987654321";
            String direccion = "Tamarindo City";
            String razon = "La magia de la programacion, esta en el poder de tu imaginacion";

            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);//nueva linea
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            //DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);//quitar bordes
            //tamaño de las celdas
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Cedula/RUC: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Direccion: ", negrita));
            //quitar bordes 
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            //agg celda a la tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(cedulaCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(direccionCliente);
            //agregar al documento
            doc.add(tablaCliente);

            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //AGREGAR LOS PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //tamaño de celdas
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));
            //quitar bordes
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            //agregar color al encabezadi del producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //agg celda a la tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);

            for (int i = 0; i < InterFacturacion.jTable_productos.getRowCount(); i++) {
                String producto = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String cantidad = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String precio = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_productos.getValueAt(i, 7).toString();

                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(producto);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }

            //agregar al documento
            doc.add(tablaProducto);

            //Total pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + InterFacturacion.txt_total_pagar.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por su compra!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            //cerrar el documento y el archivo
            doc.close();
            archivo.close();

            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

    /**
     *Genera un pdf y lo muestra en pantalla de las ventas
     * @param inicio
     * @param fin
     */
    public static void generarRoporteVentas(Date inicio, Date fin) {
        try {

            //cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }

            nombreArchivoPDFVenta = "Reporte_Clintes" + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Recursos/img/LogoSalesWear.png");//Se agarra una imagen
            img.scaleAbsolute(100, 100);//escala la imagen
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fecha.add("\nFecha: " + fechaActual + "\n" + "Periodo:\n" + formato.format(inicio) + " - " + formato.format(fin));

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar el borde de la tabla
            //tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            Encabezado.addCell(img);

            String ruc = "12433556678";
            String nombre = "Nombre de empresa";
            String telefono = "0987654321";
            String direccion = "Direccion de la empresa";
            String razon = "Razon social de la empresa";

            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("RFC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //AGREGAR LOS PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(2);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //tamaño de celdas
            float[] ColumnaProducto = new float[]{15f, 20f,};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Fecha: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Ventas: ", negrita));

            //quitar bordes
            producto1.setBorder(0);
            producto2.setBorder(0);

            //agregar color al encabezadi del producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //agg celda a la tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            float total = 0;
            JTable tabla = new JTable(Ctrl_Factura.getTabla_ReporteVnetas(inicio, fin));
            for (int i = 0; i < tabla.getRowCount(); i++) {
                String fechaVenta = tabla.getValueAt(i, 0).toString();
                String VentaReportada = tabla.getValueAt(i, 1).toString();
                float subtotal = Float.parseFloat(VentaReportada);
                total = total + subtotal;
                tablaProducto.addCell(fechaVenta);
                tablaProducto.addCell("$ " + VentaReportada);
            }

            //agregar al documento
            doc.add(tablaProducto);

            //Total pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Venta generada: $" + total);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //cerrar el documento y el archivo
            doc.close();
            archivo.close();

            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

    /**
     *Genera un pdf y lo muestra en pantalla de los clientes
     * @param inicio
     * @param fin
     */
    public static void generarRoporteClientes(Date inicio, Date fin) {
        try {

            //cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }

            nombreArchivoPDFVenta = "Reporte" + nombreCliente + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Recursos/img/LogoSalesWear.png");//Se agarra una imagen
            img.scaleAbsolute(100, 100);//escala la imagen
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fecha.add("\nFecha: " + fechaActual + "\n" + "Periodo:\n" + formato.format(inicio) + " - " + formato.format(fin));

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar el borde de la tabla
            //tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            Encabezado.addCell(img);

            String ruc = "12433556678";
            String nombre = "Nombre de empresa";
            String telefono = "0987654321";
            String direccion = "Direccion de la empresa";
            String razon = "Razon social de la empresa";

            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("RFC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //AGREGAR LOS PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(5);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //tamaño de celdas
            float[] ColumnaProducto = new float[]{5f, 20f, 40f, 10f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Id ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Nombre ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Apelldios ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Rango", negrita));
            PdfPCell producto5 = new PdfPCell(new Phrase("Direccion ", negrita));

            //quitar bordes
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto5.setBorder(0);
            //agregar color al encabezadi del producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto5.setBackgroundColor(BaseColor.LIGHT_GRAY);

            //agg celda a la tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            tablaProducto.addCell(producto5);

            float total = 0;
            JTable tabla = new JTable(Ctrl_Cliente.getTabla_Reporte(inicio, fin));
            for (int i = 0; i < tabla.getRowCount(); i++) {
                tablaProducto.addCell(tabla.getValueAt(i, 0).toString());
                tablaProducto.addCell(tabla.getValueAt(i, 1).toString());
                tablaProducto.addCell(tabla.getValueAt(i, 2).toString());
                tablaProducto.addCell(tabla.getValueAt(i, 3).toString());
                tablaProducto.addCell(tabla.getValueAt(i, 4).toString());
            }

            //agregar al documento
            doc.add(tablaProducto);

            //Total pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Clientes registrados en el periodo: " + tabla.getRowCount());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //cerrar el documento y el archivo
            doc.close();
            archivo.close();

            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

    /**
     *Genera un pdf y lo muestra en pantalla de los prodcutos mas vendidos
     * @param inicio
     * @param fin
     */
    public static void generarRoporteProdcutosMasVendidso(Date inicio, Date fin) {
        try {

            //cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }

            nombreArchivoPDFVenta = "Reporte Porducto mas vendidos" + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Recursos/img/LogoSalesWear.png");//Se agarra una imagen
            img.scaleAbsolute(100, 100);//escala la imagen
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fecha.add("\nFecha: " + fechaActual + "\n" + "Periodo:\n" + formato.format(inicio) + " - " + formato.format(fin));

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar el borde de la tabla
            //tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            Encabezado.addCell(img);

            String ruc = "12433556678";
            String nombre = "Nombre de empresa";
            String telefono = "0987654321";
            String direccion = "Direccion de la empresa";
            String razon = "Razon social de la empresa";

            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("RFC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //AGREGAR LOS PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(5);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //tamaño de celdas
            float[] ColumnaProducto = new float[]{5f, 20f, 7f, 7f, 15f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Id ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Nombre ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Cantidad ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Disponibles", negrita));
            PdfPCell producto5 = new PdfPCell(new Phrase("Codigo ", negrita));

            //quitar bordes
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto5.setBorder(0);
            //agregar color al encabezadi del producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto5.setBackgroundColor(BaseColor.LIGHT_GRAY);

            //agg celda a la tabla
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            tablaProducto.addCell(producto5);

            int total = 0;
            Ctrl_Producto ctr = new Ctrl_Producto();
            JTable tabla = new JTable(ctr.getTabla_Reporte(inicio, fin));
            for (int i = 0; i < tabla.getRowCount(); i++) {
                tablaProducto.addCell(tabla.getValueAt(i, 0).toString());
                tablaProducto.addCell(tabla.getValueAt(i, 1).toString());
                tablaProducto.addCell(tabla.getValueAt(i, 2).toString());
                tablaProducto.addCell(tabla.getValueAt(i, 3).toString());
                tablaProducto.addCell(tabla.getValueAt(i, 4).toString());
                total = total + Integer.parseInt(tabla.getValueAt(i, 2).toString());
            }

            //agregar al documento
            doc.add(tablaProducto);

            //Total pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Productos vendidos periodo: " + total);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //cerrar el documento y el archivo
            doc.close();
            archivo.close();

            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

    /**
     *Metodo universal para generar un Pdf de la empresa
     * @param inicio:Fecha de inincio del reporte
     * @param fin:Fecha de final del reporte
     * @param tabla:Tabla de los datos a mostrar
     * @param name:Nombre del archivo
     * @param anchoColumnas:Arreglo de los anchos de columna
     * @param leyenda:Texto mostrado inmediato despues d3 finalizar la tabla mostrada el el lado deerecho
     * @param encabezado:Texto membrete
     */
    public static void generarPDf(Date inicio, Date fin, JTable tabla, String name, float[] anchoColumnas, String leyenda,String encabezado) {
        try {

            //cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }
            nombreArchivoPDFVenta = name + "_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);
            ///Encabezado
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/Recursos/img/LogoSalesWear.png");//Se agarra una imagen
            img.scaleAbsolute(100, 100);//escala la imagen

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fecha.add("\nFecha: " + fechaActual + "\n" + "Periodo:\n" + formato.format(inicio) + " - " + formato.format(fin));

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar el borde de la tabla
            //tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            Encabezado.addCell(img);
            //Membrete de la empresa
            Encabezado.addCell("");//celda vacia
            Encabezado.addCell(encabezado);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            //AGREGAR LOS PRODUCTOS
            PdfPTable tablapdf = new PdfPTable(tabla.getColumnCount());
            tablapdf.setWidthPercentage(100);
            tablapdf.getDefaultCell().setBorder(0);
            //tamaño de celdas
            //Encabezado Tabla
            tablapdf.setWidths(anchoColumnas);
            tablapdf.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell[] encabezadotabla = new PdfPCell[tabla.getColumnCount()];
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                encabezadotabla[i] = new PdfPCell(new Phrase(tabla.getColumnName(i), negrita));
                //quitar bordes
                encabezadotabla[i].setBorder(0);
                //agregar color al encabezadi del producto
                encabezadotabla[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                //agg celda a la tabla
                tablapdf.addCell(encabezadotabla[i]);
            }
            for (int i = 0; i < tabla.getRowCount(); i++) {
                tablapdf.addCell(tabla.getValueAt(i, 0).toString());
                tablapdf.addCell(tabla.getValueAt(i, 1).toString());
                tablapdf.addCell(tabla.getValueAt(i, 2).toString());
                tablapdf.addCell(tabla.getValueAt(i, 3).toString());
                tablapdf.addCell(tabla.getValueAt(i, 4).toString());
            }

            //agregar al documento
            doc.add(tablapdf);

            //Info
            //Texto que se muestra terminando la tabla del lado izquierdo
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add(leyenda);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //cerrar el documento y el archivo
            doc.close();
            archivo.close();

            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }
}
