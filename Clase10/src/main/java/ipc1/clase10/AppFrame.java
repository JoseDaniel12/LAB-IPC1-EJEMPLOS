/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ipc1.clase10;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author josed
 */
public class AppFrame extends javax.swing.JFrame {

    /**
     * Creates new form AppFrame
     */
    public AppFrame() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("App");
        setVisible(true);
        
        // Recuperar usuarios serializados (deserializacion)
        AppState.deserializar();
        String usuariosRegistrados  = "";
        for (Usuario u : AppState.usuarios) {
            usuariosRegistrados += u.toString() + "\n";
        }
        usuariosRegistradosTextArea.setText(usuariosRegistrados);
        
        // Serializar la lista de usuarios al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AppState.serilizar();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cargarUsuariosButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuariosRegistradosTextArea = new javax.swing.JTextArea();
        exportarUsuariosButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cargarUsuariosButton.setText("Cargar Usuarios");
        cargarUsuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarUsuariosButtonActionPerformed(evt);
            }
        });

        usuariosRegistradosTextArea.setEditable(false);
        usuariosRegistradosTextArea.setColumns(20);
        usuariosRegistradosTextArea.setRows(5);
        jScrollPane1.setViewportView(usuariosRegistradosTextArea);

        exportarUsuariosButton.setText("Exportar Usuarios");
        exportarUsuariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarUsuariosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportarUsuariosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargarUsuariosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cargarUsuariosButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exportarUsuariosButton)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cargarUsuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarUsuariosButtonActionPerformed
        JFileChooser fileChoseer = new JFileChooser();
        fileChoseer.setMultiSelectionEnabled(true);
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChoseer.setFileFilter(extensionFilter);
        File[] files = {};
        if (fileChoseer.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            files = fileChoseer.getSelectedFiles();
        }
        
        String usuariosRegistraos = "";
        for (File file: files) {
            try {
                BufferedReader lector = new BufferedReader(new FileReader(file));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] datos = linea.split(",");
                    String nombre = datos[0];
                    String contrasenia = datos[1];
                    Usuario usuario = new Usuario(nombre, contrasenia);
                    AppState.usuarios.add(usuario);
                    usuariosRegistraos += usuario.toString() + "\n";
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        usuariosRegistradosTextArea.setText(usuariosRegistraos);
    }//GEN-LAST:event_cargarUsuariosButtonActionPerformed

    private void exportarUsuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarUsuariosButtonActionPerformed
        String rutaReportes = "./reportes/reporteUsuarios.txt";
        File file = new File(rutaReportes);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        String reporte = "";
        for (Usuario u : AppState.usuarios) {
            reporte += u.nombre + "\n";
        }
        
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(file));
            escritor.write(reporte);
            escritor.close();
        } catch (IOException ex) {
            Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportarUsuariosButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarUsuariosButton;
    private javax.swing.JButton exportarUsuariosButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea usuariosRegistradosTextArea;
    // End of variables declaration//GEN-END:variables
}