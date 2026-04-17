/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author joaqu
 */
public class Boton1 extends JButton {
    public Boton1(String texto, String rutaIcono) {
        super(texto);

        ImageIcon icon = new ImageIcon(getClass().getResource(rutaIcono));
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(img));

        setBackground(new Color(255,140,0));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        setHorizontalTextPosition(SwingConstants.RIGHT);
        setVerticalTextPosition(SwingConstants.CENTER);
    }
}
