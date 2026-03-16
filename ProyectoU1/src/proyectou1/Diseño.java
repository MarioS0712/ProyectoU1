package proyectou1;
import javax.swing.*;
import java.awt.*;

public class Diseño extends JPanel {

    private int radio;

    public Diseño(int radio){
        this.radio = radio;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();

        // sombra suave (no mueve el panel)
        g2.setColor(new Color(0,0,0,30));
        g2.fillRoundRect(3,3,ancho-3,alto-3,radio,radio);

        // degradado
        float[] posiciones = {0.0f, 0.3f, 1.0f};

        Color[] colores = {
                new Color(255,177,51),   // #ffb133
                new Color(255,186,77),   // #ffba4d
                new Color(255,196,102)   // #ffc466
        };

        LinearGradientPaint degradado = new LinearGradientPaint(
                0,0,
                ancho,alto,
                posiciones,
                colores
        );

        g2.setPaint(degradado);

        // panel principal
        g2.fillRoundRect(0,0,ancho,alto,radio,radio);
    }

    // encabezado bonito
    public static JLabel encabezado(String texto){

        JLabel titulo = new JLabel(texto, SwingConstants.CENTER);

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titulo.setForeground(Color.WHITE);

        return titulo;
    }

}