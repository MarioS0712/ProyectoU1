package proyectou1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author mariosolis
 */
public class Ventana extends JFrame {

    private JPanel panelNorte, panelOeste, panelCentro, panelEste, panelSur;
    private JPanel panelOeste2, panelCentro2, panelEste2, panelSur2;
    private JTextField txtNombre;
    private JRadioButton rbPerro, rbGato, rbAve;
    private JCheckBox cbBaño, cbCorte, cbVacunas, cbShampoo, cbUñas, cbCollar;
    private JLabel Mascota, Tipo, Servicio, Extras, Costo, mascotaImg;
    private String mascotasImg[] = {"care.png", "dog.png", "cat.png", "bird.png"};
    private Icon icons[] = {
        new ImageIcon(getClass().getResource(mascotasImg[0])),
        new ImageIcon(getClass().getResource(mascotasImg[1])),
        new ImageIcon(getClass().getResource(mascotasImg[2])),
        new ImageIcon(getClass().getResource(mascotasImg[3]))
    };
    private JList listaServicios;
    String registro = "";
    String opcionRadio = "";
    String opcionCBox = "";
    JTable servicios = new JTable();

    DefaultTableModel modelo = new DefaultTableModel();
    private Object[] o = new Object[5];

    private String datos[] = new String[100];
    private int contador = 0;
    private Font txtTitulo = new Font("Segoe UI", Font.BOLD, 14);
    private Font txtEncabezados = new Font("Segoe UI", Font.BOLD, 16);
    private Font txtTextos = new Font("Segoe UI", Font.BOLD, 12);

    public Ventana() {
        super("Proyecto U1");
        setLayout(new BorderLayout(10, 10));

        initNorte();
        initOeste();
        initCentro();
        initEste();
        initSur();
    }

    private void initNorte() {
        panelNorte = new JPanel(new BorderLayout());
        Color fondo = new Color(255, 204, 0);
        panelNorte.setBackground(fondo);
        panelNorte.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Sistema", TitledBorder.CENTER, TitledBorder.TOP));

        JLabel titulo = Diseño.encabezado("Servicio para Mascotas y PetShop MANAGER");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        JButton btnPest1 = new JButton("Servicios");
        Dimension dimension = new Dimension(100, 40);
        btnPest1.setPreferredSize(dimension);
        JButton btnPest2 = new JButton("Tienda");
        btnPest2.setPreferredSize(dimension);
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botones.setBackground(Color.ORANGE);
        botones.add(btnPest1);
        botones.add(btnPest2);
        panelNorte.add(titulo, BorderLayout.NORTH);
        panelNorte.add(botones, BorderLayout.SOUTH);
        add(panelNorte, BorderLayout.NORTH);

        btnPest1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelCentro.isVisible()) {
                    repaint();
                } else {
                    panelCentro2.setVisible(false);
                    panelEste.setVisible(true);
                    panelOeste.setVisible(true);
                    panelSur.setVisible(true);
                    panelCentro.setVisible(true);
                }
            }
        });

        btnPest2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEste.setVisible(false);
                panelOeste.setVisible(false);
                panelSur.setVisible(false);
                panelCentro.setVisible(false);
                initCentro2();
            }
        });

    }

    private void initOeste() {
        //Panel Principal
        panelOeste = new JPanel(new GridLayout(4, 1));
        panelOeste.setBackground(Color.ORANGE);
        panelOeste.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Registro de Servicio", TitledBorder.CENTER, TitledBorder.TOP));
        panelOeste.setPreferredSize(new Dimension(220, 50));
        //SubPaneles
        JPanel panelMas1 = new JPanel(new GridBagLayout());
        panelMas1.setBackground(Color.ORANGE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);
        panelMas1.setBorder(new EmptyBorder(5,5,5,5));
        JPanel panelMas2 = new JPanel();
        panelMas2.setLayout(new BoxLayout(panelMas2, BoxLayout.Y_AXIS));
        panelMas2.setBorder(new EmptyBorder(2,2,2,2));
        panelMas2.setBackground(Color.ORANGE);
        JPanel panelMas3 = new JPanel(new GridLayout(4, 1));
        panelMas3.setBorder(new EmptyBorder(2,2,2,2));
        panelMas3.setBackground(Color.ORANGE);
        JPanel panelMas4 = new JPanel(new GridLayout(4, 1));
        panelMas4.setBorder(new EmptyBorder(2,2,2,2));
        panelMas4.setBackground(Color.ORANGE);

        panelMas1.setBorder(BorderFactory.createTitledBorder(""));
        panelMas1.add(new JLabel("Nombre:"), gbc);
        txtNombre = new JTextField(15);
        gbc.gridy = 1;
        panelMas1.add(txtNombre, gbc);

        panelMas2.add(new JLabel("Tipo de Mascota", SwingConstants.CENTER));
        panelMas2.setBorder(BorderFactory.createTitledBorder(""));

        String tiposMascota[] = {"Perro", "Gato", "Ave"};
        JRadioButton rbMascotas[] = new JRadioButton[3];
        ButtonGroup grupo = new ButtonGroup();

        for (int i = 0; i < tiposMascota.length; i++) {
            rbMascotas[i] = new JRadioButton(tiposMascota[i] + " $5");

            rbMascotas[i].setBackground(Color.ORANGE);
            rbMascotas[i].setOpaque(true);
            rbMascotas[i].setFocusPainted(false);
            rbMascotas[i].setBorderPainted(false);
            rbMascotas[i].setMargin(new Insets(0,0,0,0));
            rbMascotas[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            rbMascotas[i].setHorizontalAlignment(SwingConstants.LEFT);

            grupo.add(rbMascotas[i]);
            panelMas2.add(Box.createVerticalStrut(12));
            panelMas2.add(rbMascotas[i]);
        }

        rbPerro = rbMascotas[0];
        rbGato = rbMascotas[1];
        rbAve = rbMascotas[2];
        rbPerro.setSelected(true);
        JRadioButton Masc[] = {rbPerro, rbGato, rbAve};
        //Tipo de letra
        for(int i=0;i<Masc.length;i++){
            Masc[i].setFont(txtTextos);
            Masc[i].setHorizontalAlignment(SwingConstants.LEFT);
            Masc[i].setForeground(Color.BLACK);
        }

        panelMas3.add(new JLabel("Servicios", SwingConstants.CENTER));
        panelMas3.setBorder(BorderFactory.createTitledBorder(""));
        String servicios[] = {"Baño", "Corte", "Vacunas"};
        JCheckBox cbServicios[] = new JCheckBox[3];

        for (int i = 0; i < servicios.length; i++) {
            cbServicios[i] = new JCheckBox(servicios[i] + " $5");
            cbServicios[i].setBackground(Color.ORANGE);
            cbServicios[i].setFocusPainted(false);
            panelMas3.add(cbServicios[i]);
        }
        cbBaño = cbServicios[0];
        cbCorte = cbServicios[1];
        cbVacunas = cbServicios[2];
        //Tipo de letras
        JCheckBox Producto[] = {cbBaño, cbCorte,cbVacunas};
        for(int i=0;i<Producto.length;i++){
            Producto[i].setFont(txtTextos);
            Producto[i].setHorizontalAlignment(SwingConstants.LEFT);
            Producto[i].setForeground(Color.BLACK);
        }

        panelMas4.add(new JLabel("Extras",SwingConstants.CENTER));
        panelMas4.setBorder(BorderFactory.createTitledBorder(""));

        String extras[] = {"Shampoo Especial", "Corte de Uñas", "Collar Antipulgas"};
        JCheckBox cbExtras[] = new JCheckBox[3];

        for (int i = 0; i < extras.length; i++) {
            cbExtras[i] = new JCheckBox(extras[i] + " $10");
            cbExtras[i].setBackground(Color.ORANGE);
            cbExtras[i].setFocusPainted(false);
            cbExtras[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            cbExtras[i].setHorizontalAlignment(SwingConstants.LEFT);
            panelMas4.add(cbExtras[i], BorderLayout.SOUTH);
        }
        cbShampoo = cbExtras[0];
        cbUñas = cbExtras[1];
        cbCollar = cbExtras[2];
        //Tipo de letras
        JCheckBox etiquetas[] = {cbShampoo, cbUñas,cbCollar};
        for(int i=0;i<etiquetas.length;i++){
            etiquetas[i].setFont(txtTextos);
            etiquetas[i].setHorizontalAlignment(SwingConstants.LEFT);
            etiquetas[i].setForeground(Color.BLACK);
        }

        panelOeste.add(panelMas1);
        panelOeste.add(panelMas2);
        panelOeste.add(panelMas3);
        panelOeste.add(panelMas4);
        add(panelOeste, BorderLayout.WEST);
    }

    private void initCentro() {
        panelCentro = new JPanel(new GridLayout(6, 1));
        panelCentro.setBackground(Color.ORANGE);
        panelCentro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Servicio Actual", TitledBorder.CENTER, TitledBorder.TOP));

        Mascota = new JLabel("Mascota: ");
        Tipo = new JLabel("Tipo: ");
        Servicio = new JLabel("Servicios: ");
        Extras = new JLabel("Extras: ");
        Costo = new JLabel("Costos: ");
        mascotaImg = new JLabel(icons[0]);
        //Tipo de letras
        JLabel etiquetas[] = {Mascota, Tipo, Servicio, Extras, Costo};
        for(int i=0;i<etiquetas.length;i++){
            etiquetas[i].setFont(txtTitulo);
            etiquetas[i].setHorizontalAlignment(SwingConstants.LEFT);
            etiquetas[i].setForeground(Color.BLACK);
        }

        panelCentro.add(Mascota);
        panelCentro.add(Tipo);
        panelCentro.add(Servicio);
        panelCentro.add(Extras);
        panelCentro.add(Costo);
        panelCentro.add(mascotaImg);
        add(panelCentro, BorderLayout.CENTER);
    }

    private void initCentro2() {
        panelCentro2 = new JPanel(new GridLayout(5, 1));
        panelCentro2.setBackground(Color.ORANGE);
        panelCentro2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Funciones Proximas", TitledBorder.CENTER, TitledBorder.TOP));

        JLabel Mensaje = new JLabel("Pestaña 2 ", SwingConstants.CENTER);
        panelCentro2.add(Mensaje, BorderLayout.CENTER);
        add(panelCentro2, BorderLayout.CENTER);
    }

    private void initEste() {
        panelEste = new JPanel(new BorderLayout());
        panelEste.setBackground(Color.ORANGE);
        panelEste.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Lista de Servicios en espera", TitledBorder.CENTER, TitledBorder.TOP));
        panelEste.setPreferredSize(new Dimension(300, 0));

        modelo.addColumn("Nombre");
        modelo.addColumn("Animal");
        modelo.addColumn("Servicio");
        modelo.addColumn("Extras");
        modelo.addColumn("Costo");
        servicios.setModel(modelo);
        servicios.setRowHeight(25);
        servicios.getTableHeader().setFont(txtTextos);
        servicios.setFont(txtTextos);

        JScrollPane scrollPane = new JScrollPane(servicios);
        panelEste.add(scrollPane, BorderLayout.CENTER);

        add(panelEste, BorderLayout.EAST);
    }

    private void initSur() {
        panelSur = new JPanel(new FlowLayout());
        panelSur.setBackground(Color.ORANGE);
        panelSur.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Opciones", TitledBorder.CENTER, TitledBorder.TOP));

        JButton btnGuardar = new JButton("Guardar");
        JButton btnAñadir = new JButton("Añadir Mascota");
        JButton btnSalir = new JButton("Salir");
        JButton btnAtender = new JButton("Atender Mascota");
        JButton btnFinSer = new JButton("Finalizar servicio");

        btnAñadir.setPreferredSize(new Dimension(150,35));
        btnAtender.setPreferredSize(new Dimension(150,35));
        btnFinSer.setPreferredSize(new Dimension(150,35));
        btnSalir.setPreferredSize(new Dimension(100,35));

        panelSur.add(btnAñadir);
        panelSur.add(btnAtender);
        panelSur.add(btnFinSer);
        panelSur.add(btnSalir);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = "";
                if (txtNombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la Mascota");
                    txtNombre.requestFocus();
                    return;
                } else {
                    nombre = txtNombre.getText();
                }

                String tipo = "";
                if (rbPerro.isSelected()) {
                    tipo = "Perro";
                    mascotaImg.setIcon(icons[1]);
                }
                if (rbGato.isSelected()) {
                    tipo = "Gato";
                    mascotaImg.setIcon(icons[2]);
                }
                if (rbAve.isSelected()) {
                    tipo = "Ave";
                    mascotaImg.setIcon(icons[3]);
                }

                String servicios = "";
                if (cbBaño.isSelected()) {
                    servicios += "Baño ";
                }
                if (cbCorte.isSelected()) {
                    servicios += "Corte ";
                }
                if (cbVacunas.isSelected()) {
                    servicios += "Vacunas ";
                }

                String extras = "";
                if (cbShampoo.isSelected()) {
                    extras += "Shampoo ";
                }
                if (cbUñas.isSelected()) {
                    extras += "Corte de Uñas ";
                }
                if (cbCollar.isSelected()) {
                    extras += "Collar Antipulgas ";
                }

                Mascota.setText("Mascota: " + nombre);
                Tipo.setText("Tipo: " + tipo);
                Servicio.setText("Servicios: " + servicios);
                Extras.setText("Extras: " + extras);
            }
        });

        btnAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int precio = 0;
                if (txtNombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la Mascota");
                    txtNombre.requestFocus();
                    return;
                } else {
                    o[0] = txtNombre.getText();
                }

                if (rbPerro.isSelected()) {
                    o[1] = "Perro ";
                    precio += 5;
                }

                if (rbGato.isSelected()) {
                    o[1] = "Gato ";
                    precio += 5;
                }

                if (rbAve.isSelected()) {
                    o[1] = "Ave ";
                    precio += 5;
                }

                if (cbBaño.isSelected()) {
                    o[2] = "Baño ";
                    precio += 5;
                }

                if (cbCorte.isSelected()) {
                    o[2] = "Corte ";
                    precio += 5;
                }

                if (cbVacunas.isSelected()) {
                    o[2] = "Vacunas ";
                    precio += 5;
                }
                if (cbBaño.isSelected() & cbCorte.isSelected()) {
                    o[2] = "Baño, Corte";
                }

                if (cbBaño.isSelected() & cbVacunas.isSelected()) {
                    o[2] = "Baño, Vacunas";
                }

                if (cbCorte.isSelected() & cbVacunas.isSelected()) {
                    o[2] = "Corte, Vacunas";
                }
                if (cbBaño.isSelected() & cbCorte.isSelected() & cbVacunas.isSelected()) {
                    o[2] = "Baño, Corte, Vacunas";
                }

                if (cbShampoo.isSelected()) {
                    o[3] = "Shampoo ";
                    precio += 10;
                }

                if (cbUñas.isSelected()) {
                    o[3] = "Corte de Uñas ";
                    precio += 10;
                }

                if (cbCollar.isSelected()) {
                    o[3] = "Collar Antipulgas ";
                    precio += 10;
                }
                if (cbShampoo.isSelected() & cbUñas.isSelected()) {
                    o[3] = "Shampoo, Uñas";
                }

                if (cbShampoo.isSelected() & cbCollar.isSelected()) {
                    o[3] = "Shampoo, Collar";
                }

                if (cbUñas.isSelected() & cbCollar.isSelected()) {
                    o[3] = "Uñas, Collar";
                }
                if (cbShampoo.isSelected() & cbUñas.isSelected() & cbCollar.isSelected()) {
                    o[3] = "Shampoo, Uñas, Collar";
                }
                o[4] = Integer.toString(precio);
                precio = 0;
                modelo.addRow(o);
                txtNombre.setText("");
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Tipo.getText().equals("Tipo: ")) {
                    int filas = servicios.getRowCount();
                    if (filas > 0) {

                        String dato1 = String.valueOf(servicios.getValueAt(0, 0));
                        String dato2 = String.valueOf(servicios.getValueAt(0, 1));
                        String dato3 = String.valueOf(servicios.getValueAt(0, 2));
                        String dato4 = String.valueOf(servicios.getValueAt(0, 3));
                        String dato5 = String.valueOf(servicios.getValueAt(0, 4));

                        Mascota.setText("Mascota: " + dato1);
                        Tipo.setText("Tipo: " + dato2);
                        Servicio.setText("Servicios: " + dato3);
                        Extras.setText("Extras: " + dato4);
                        Costo.setText("Precio: $" + dato5);
                        if (dato2.equals("Perro ")) {
                            mascotaImg.setIcon(icons[1]);
                        }
                        if (dato2.equals("Gato ")) {
                            mascotaImg.setIcon(icons[2]);
                        }
                        if (dato2.equals("Ave ")) {
                            mascotaImg.setIcon(icons[3]);
                        }
                        modelo.removeRow(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay ningún animal en espera");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ya hay una mascota en servicio");
                }

            }

        });

        btnFinSer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Tipo.getText().equals("Tipo: ")) {
                    JOptionPane.showMessageDialog(null, "No hay mascotas en el servicio");
                } else {
                    Mascota.setText("Mascota: ");
                    Tipo.setText("Tipo: ");
                    Servicio.setText("Servicios: ");
                    Extras.setText("Extras: ");
                    Costo.setText("Costo: ");
                    mascotaImg.setIcon(icons[0]);
                }
            }

        });
        add(panelSur, BorderLayout.SOUTH);

    }
}
