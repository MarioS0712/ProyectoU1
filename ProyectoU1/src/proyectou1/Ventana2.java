package proyectou1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author mariosolis
 */
public class Ventana2 extends JFrame {

    int contador = 0;
    private JButton btnAnt, btnSig, btnSalir;
    private Font fuente = new Font("Arial", Font.BOLD, 24);
    private Font fuente2 = new Font("Arial", Font.BOLD, 18);
    private String equipo[] = {"mario.jpg", "wendy.png", "ximena.jpeg", "johan.png"};
    private String nombres[] = {
        "Mario Alberto Solis Birruete",
        "Wendy Naomi Ramírez Romero",
        "Ximena Garcia Cervantes",
        "Johan Gael Baños Romero"};
    private String numControl[] = {
        "S24030165", "S24030111", "S24030103", "S24030095"
    };
    private String semestre = "4";
    private Icon icons[] = {
        new ImageIcon(getClass().getResource(equipo[0])),
        new ImageIcon(getClass().getResource(equipo[1])),
        new ImageIcon(getClass().getResource(equipo[2])),
        new ImageIcon(getClass().getResource(equipo[3]))
    };

    public Ventana2() {

        super("Datos de Desarrolladores");
        JPanel panelCentro = new JPanel(new GridLayout(1, 1));
        panelCentro.setBorder(BorderFactory.createTitledBorder(""));
        JLabel etiqueta = new JLabel(icons[0]);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 28));
        panelCentro.setBackground(Color.WHITE);
        etiqueta.setForeground(Color.PINK);
        panelCentro.add(etiqueta);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelEste = new JPanel(new GridLayout(3, 1));
        panelEste.setBorder(BorderFactory.createTitledBorder(""));
        panelEste.setBackground(Color.WHITE);
        panelEste.setPreferredSize(new Dimension(400, 0));
        JLabel nombre = new JLabel("Nombre: " + nombres[0], SwingConstants.CENTER);
        JLabel control = new JLabel("Número de Control: " + numControl[0], SwingConstants.CENTER);
        JLabel sem = new JLabel("Semestre : " + semestre, SwingConstants.CENTER);
        panelEste.add(nombre);
        panelEste.add(control);
        panelEste.add(sem);
        add(panelEste, BorderLayout.EAST);

        JPanel panelSur = new JPanel(new FlowLayout());
        btnAnt = new JButton("←");
        btnAnt.setFont(fuente);
        btnSig = new JButton("→");
        btnSig.setFont(fuente);
        btnSalir = new JButton("Cerrar");
        btnSalir.setFont(fuente2);
        panelSur.add(btnAnt);
        panelSur.add(btnSig);
        panelSur.add(btnSalir);
        add(panelSur, BorderLayout.SOUTH);

        btnAnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador += -1;
                if (contador < 0) {
                    contador = 3;
                    nombre.setText("Nombre: " + nombres[contador]);
                    control.setText("Número de Control: " + numControl[contador]);
                    etiqueta.setIcon(icons[contador]);
                } else {
                    nombre.setText("Nombre: " + nombres[contador]);
                    control.setText("Número de Control: " + numControl[contador]);
                    etiqueta.setIcon(icons[contador]);
                }
            }

        });

        btnSig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador += 1;
                if (contador > 3) {
                    contador = 0;
                    nombre.setText("Nombre: " + nombres[contador]);
                    control.setText("Número de Control: " + numControl[contador]);
                    etiqueta.setIcon(icons[contador]);
                } else {
                    nombre.setText("Nombre: " + nombres[contador]);
                    control.setText("Número de Control: " + numControl[contador]);
                    etiqueta.setIcon(icons[contador]);
                }
            }

        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
    }
}
