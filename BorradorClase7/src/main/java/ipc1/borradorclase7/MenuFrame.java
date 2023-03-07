package ipc1.borradorclase7;

import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author josed
 */
public class MenuFrame extends javax.swing.JFrame {

    /**
     * Creates new form MenuFrame
     */
    public MenuFrame() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Menu");
    }
    
    public String tablaHistorialHtml(Usuario usuario) {
        String html = "<body>\n";
        html += "<h1>" + usuario.nombreUsuario + "</h1>\n";
        html += "<table border=\"1\" cellspacing=\"0\">\n";
        
        // Se agregna los encabezados de la tabla
        html += "<tr>\n";
        html += "<th> Nombre Imagen </th>\n";
        html += "<th> Fecha de Carga </th>\n";
        html += "</tr>\n";
        
        // Se agregan las filas de la tabla
        for (ContenedorImagen ci : AppState.usuarioLogeado.imagenes) {
            html += "<tr>\n";
            html += "<td>" + ci.nombre + "</td>\n";
            html += "<td>" + ci.fecha + "</td>\n";
            html += "</tr>\n";
        }
        
        html += "</table>\n";
        html += "</body>";
        return html;
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportesButton = new javax.swing.JButton();
        subirImagenButton = new javax.swing.JButton();
        verImagenesButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reportesButton.setText("Generar Reportes de Registro");
        reportesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesButtonActionPerformed(evt);
            }
        });

        subirImagenButton.setText("Subir Imagen");
        subirImagenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirImagenButtonActionPerformed(evt);
            }
        });

        verImagenesButton.setText("Ver Imagenes");
        verImagenesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verImagenesButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(reportesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subirImagenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verImagenesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(reportesButton)
                .addGap(18, 18, 18)
                .addComponent(subirImagenButton)
                .addGap(18, 18, 18)
                .addComponent(verImagenesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reportesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesButtonActionPerformed
        String tablaHtml = tablaHistorialHtml(AppState.usuarioLogeado);
        
        
        String rutaCarpeta = "./reportes/" + AppState.usuarioLogeado.nombreUsuario;
        // Crea la carpeta de reportes si no esiste
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        
        // Escribe el archivo .html dentro de la carpeta
        String rutaArchivoHtml = rutaCarpeta + "/historialImagenes.html";
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(rutaArchivoHtml);
            fileWriter.write(tablaHtml);
            fileWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo generar html.", "Alerta", JOptionPane.WARNING_MESSAGE);
            System.out.println(e.getMessage());
            return;
        }
        
        // Generar reporte .pdf
        String rutaArchivoPdf = rutaCarpeta + "/historialImagenes.pdf";
        try{
            // Convertir Html a Pdf:
            convertHtmlToPdf(rutaArchivoHtml, rutaArchivoPdf);
        }   catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(this, "No se pudo generar pdf.", "Alerta", JOptionPane.WARNING_MESSAGE);
            System.out.println(e.getMessage());
        }
        
        JOptionPane.showMessageDialog(this, "Reportes Generados.", "Alerta", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_reportesButtonActionPerformed

    private void subirImagenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirImagenButtonActionPerformed
        SubirImagenFrame f = new SubirImagenFrame();
        dispose();
    }//GEN-LAST:event_subirImagenButtonActionPerformed

    private void verImagenesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verImagenesButtonActionPerformed
        VisorImagenesFrame f = new VisorImagenesFrame();
        dispose();
    }//GEN-LAST:event_verImagenesButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginFrame f = new LoginFrame();
        AppState.usuarioLogeado = null;
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton reportesButton;
    private javax.swing.JButton subirImagenButton;
    private javax.swing.JButton verImagenesButton;
    // End of variables declaration//GEN-END:variables
}