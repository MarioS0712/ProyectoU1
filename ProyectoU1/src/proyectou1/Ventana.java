/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica102;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Diego
 */
public class Ventana extends JFrame{
    private JButton btnRestaurar,btnRojo,btnAmarillo;
    private JButton btnIncrementar, btnDecrementar;
    private JLabel txtContador;
    private int contador=0;
    private JPanel panelTexto, panelBotones;
    
    public Ventana(){
            super("Practica 102");
   setLayout (new BorderLayout());
   
   panelTexto = new JPanel();
   panelTexto.setBackground(Color.BLACK);
   panelTexto.setLayout(new BorderLayout());
   txtContador = new JLabel("Contador: "+contador,SwingConstants.CENTER);
   txtContador.setFont(new Font("Arial",Font.BOLD,49));
   txtContador.setForeground(Color.PINK);
   panelTexto.add(txtContador);
   add(panelTexto,BorderLayout.CENTER);
   
   panelBotones = new JPanel();
   panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
   panelBotones.setBackground(Color.LIGHT_GRAY);
   
   btnRestaurar = new JButton("Restaurar");
   btnRojo = new JButton("Rojo");
   btnAmarillo = new JButton("Amarillo");
   btnIncrementar = new JButton("Mas");
   btnDecrementar = new JButton("Menos");
   
   panelBotones.add(btnRestaurar);
    panelBotones.add(btnRojo);
     panelBotones.add(btnAmarillo);
      panelBotones.add(btnIncrementar);
       panelBotones.add(btnDecrementar);
     
   add(panelBotones,BorderLayout.SOUTH);
   
   btnRestaurar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 contador = 0;
                 panelTexto.setBackground(Color.BLACK);
                 txtContador.setForeground(Color.PINK);
                 txtContador.setText("Contador: " +contador);
                 
                }
   });
    btnRojo.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                 panelTexto.setBackground(Color.RED);
                 txtContador.setForeground(Color.CYAN);
                 txtContador.setText("Contador: " +contador);
                 
                }
   });
    btnAmarillo.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                
                 panelTexto.setBackground(Color.YELLOW);
                 txtContador.setForeground(Color.MAGENTA);
                 txtContador.setText("Contador: " +contador);
      }
   });
 
 btnIncrementar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                contador ++;
                txtContador.setText("Contador: " +contador);
    }
   });
  btnDecrementar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                contador --;
                txtContador.setText("Contador: " +contador);
    }
   });
 
    }
}
