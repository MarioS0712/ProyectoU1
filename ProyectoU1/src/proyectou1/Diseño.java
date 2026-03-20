package proyectou1;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Diseño extends JPanel {

    private int radio;
    private Color color1, color2;

    public Diseño(Color c1, Color c2, int radio){
        this.color1 = c1;
        this.color2 = c2;
        this.radio = radio;
        setOpaque(false);
    }

    public Diseño(int radio){
        this.radio = radio;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(color1 != null && color2 != null){
            GradientPaint gp = new GradientPaint(
                    0, 0, color1,
                    getWidth(), getHeight(), color2
            );
            g2.setPaint(gp);
        } else {
            g2.setColor(getBackground());
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
    }

    public static JLabel encabezado(String texto){
        JLabel lbl = new JLabel(texto, SwingConstants.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lbl.setForeground(new Color(40,40,40));
        return lbl;
    }
    public static JButton boton(String texto){
        JButton btn = new JButton(texto);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(255,177,51));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBorder(new EmptyBorder(8,15,8,15));

        btn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btn.setBackground(new Color(255,140,0));
            }
            public void mouseExited(MouseEvent e){
                btn.setBackground(new Color(255,177,51));
            }
        });
        return btn;
    }
    public static JButton boton1(String texto){
        JButton btn = new JButton(texto);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(135, 206, 235));
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBorder(new EmptyBorder(8,15,8,15));

        btn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                btn.setBackground(new Color(100, 180, 220));
            }
            public void mouseExited(MouseEvent e){
                btn.setBackground(new Color(135, 206, 235));
            }
        });

        return btn;
    }


    public static TitledBorder borde(String titulo){
        return BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                titulo,
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14)
        );
    }
}