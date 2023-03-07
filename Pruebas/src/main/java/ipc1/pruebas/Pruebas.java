package ipc1.pruebas;
import java.io.*;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;


public class Pruebas {
    public static void main(String[] args) {
        String[][] filas = {{"1", "José", "Daniel"}, {"2", "Alvarado", "Fajardo"}};
        String[] encbezados = {"No.", "Columna1", "Columna2"};
        String tablaHtml = generatetablaHtml(encbezados, filas);
        
        // Crea la carpeta de reportes si no esiste
        File carpeta = new File("./reportes");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        // Escribe el archivo .html dentro de la carpeta
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter("./reportes/table.html");
            fileWriter.write(tablaHtml);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("No se ha podido genar html.");
        }
        
        // Generar reporte .pdf
        try{
            // Convertir Html a Pdf:
            convertHtmlToPdf("./reportes/table.html", "./reportes/tablePdf.pdf");
        }   catch (DocumentException | IOException e) {
            System.out.println("No se ha podido generar pdf");
        }
        

    }

    public static String generatetablaHtml(String[] encbezados, String[][] filas) {
        StringBuilder sb = new StringBuilder();

        // Se abre etiqueta de inciio de la tabla
        sb.append("<table border=\"1\" cellspacing=\"0\">\n");


        // Se agregan los encabezados de la tabla
        sb.append("<tr>");
        for (String encabezado : encbezados) {
            sb.append("<th>").append(encabezado).append("</th>");
        }
        sb.append("</tr>\n");

        // Se agregan las fialas a la tabla
        for (String[] fila : filas) {
            sb.append("<tr>");
            for (String casilla : fila) {
                sb.append("<td>").append(casilla).append("</td>");
            }
            sb.append("</tr>\n");
        }

        // Se cierra la etiqueta d ela tabla
        sb.append("</table>\n");

        return sb.toString();
    }
    
    
    public static void convertHtmlToPdf(String inputFile, String outputFile) throws IOException, DocumentException {
        // Crea un objeto ITextRenderer
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(new File(inputFile));
        renderer.layout();
        // Renderiza el documento a PDF
        try ( 
            // Crea el archivo de salida
            FileOutputStream fos = new FileOutputStream(outputFile)) {
            // Renderiza el documento a PDF
            renderer.createPDF(fos);
        }
    }
}