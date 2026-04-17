/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou1;

/**
 *
 * @author joaqu
 */
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class RBoton extends JRadioButton {

    public RBoton(String texto, String off, String on) {
        super(texto);

        URL offURL = getClass().getResource(off);
        URL onURL = getClass().getResource(on);

        if (offURL != null) {
            ImageIcon iconOff = new ImageIcon(offURL);
            setIcon(new ImageIcon(iconOff.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
        }

        if (onURL != null) {
            ImageIcon iconOn = new ImageIcon(onURL);
            setSelectedIcon(new ImageIcon(iconOn.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH)));
        }

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
}
