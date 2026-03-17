package proyectou1;

import javax.swing.JFrame;

/**
 *
 * @author mariosolis
 */
public class ProyectoU1 {
    public static void main(String[] args) {
         Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ventana.setSize(800,800);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
}
