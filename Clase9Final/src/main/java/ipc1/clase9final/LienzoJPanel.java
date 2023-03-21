package ipc1.clase9final;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josed
 */
public class LienzoJPanel extends javax.swing.JPanel implements Runnable {

    private int x;
    Thread hilo;
    boolean direccionDercha = true;
    
    public LienzoJPanel() {
        initComponents();
        hilo = new Thread(this);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.red);
        g.fillOval(x, (getHeight() / 2) - 15, 30, 30);
    }
    
    public void iniciar() {
        hilo.start();
    }
    
    public void parar() {
        hilo.suspend();
    }
    
    public void continuar() {
        hilo.resume();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(70);
            } catch (InterruptedException ex) {
                Logger.getLogger(LienzoJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if ((direccionDercha && x >= getWidth()) || (!direccionDercha && x <= 0)) {
                direccionDercha = !direccionDercha;
            }
            
            if (direccionDercha) {
                x += 10;
            } else {
                x -= 10;
            }
            

            repaint();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
