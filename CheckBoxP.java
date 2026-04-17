/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou1;

import javax.swing.JCheckBox;

/**
 *
 * @author joaqu
 */
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class CheckBoxP extends JCheckBox {

    public CheckBoxP(String texto, String iconOff, String iconOn) {
        super(texto);

        // Cargar icono OFF
        URL offURL = getClass().getResource(iconOff);
        if (offURL != null) {
            ImageIcon offIcon = new ImageIcon(offURL);
            Image imgOff = offIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(imgOff));
        } else {
            System.out.println("No se encontró: " + iconOff);
        }

        // Cargar icono ON
        URL onURL = getClass().getResource(iconOn);
        if (onURL != null) {
            ImageIcon onIcon = new ImageIcon(onURL);
            Image imgOn = onIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            setSelectedIcon(new ImageIcon(imgOn));
        } else {
            System.out.println("No se encontró: " + iconOn);
        }

        // Estilo
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFont(new Font("Segoe UI", Font.BOLD, 12));
        setForeground(Color.BLACK);
    }
}
