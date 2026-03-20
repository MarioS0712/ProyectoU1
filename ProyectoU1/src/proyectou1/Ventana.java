package proyectou1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mariosolis
 */
public class Ventana extends JFrame {

    private JPanel panelNorte, panelOeste, panelCentro, panelEste, panelSur;
    private JPanel panelOeste2, panelCentro2, panelEste2, panelSur2, subPanel1, subPanel2;
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

    //private String productosImg[] = {"shampoo.jpg"};
    //private Icon products[] = {new ImageIcon(getClass().getResource(productosImg[0])),};
    JTable servicios = new JTable();

    DefaultTableModel modelo = new DefaultTableModel();
    private Object[] o = new Object[5];

    private final String nombreProductos[] = {
        "Shampoo", "Correa", "Sueter", "Collar Personalizado", "Hueso"
    };

    private JComboBox listaProductos;
    private JLabel inventario, nom, proveedor, importado;
    private int cShampoo = 5, cCorrea = 7, cSueter = 4, cCollar = 10, cHueso = 15;
    private Font txtTitulo = new Font("Segoe UI", Font.BOLD, 14);
    private Font txtTextos = new Font("Segoe UI", Font.BOLD, 12);

    public Ventana() {
        super("Proyecto U1");
        setLayout(new BorderLayout(10, 10));

        Diseño fondo = new Diseño(
                new Color(255,177,51),
                new Color(255,196,102),
                0
        );
        fondo.setLayout(new BorderLayout(10,10));
        setContentPane(fondo);

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
        //titulo
        JLabel titulo = Diseño.encabezado("Servicio para Mascotas y PetShop MANAGER");

        //Panel1
        JButton btnPest1 =Diseño.boton("Servicios");
        Dimension dimension = new Dimension(100, 40);
        btnPest1.setPreferredSize(dimension);

        //Panel2
        JButton btnPest2 =Diseño.boton("Tienda");
        btnPest2.setPreferredSize(dimension);
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botones.setBackground(Color.ORANGE);
        botones.add(btnPest1);
        botones.add(btnPest2);
        panelNorte.add(titulo, BorderLayout.NORTH);
        panelNorte.add(botones, BorderLayout.SOUTH);
        add(panelNorte, BorderLayout.NORTH);

        //funciones(PANELES)
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
        panelOeste.setBorder(Diseño.borde("Registro de Servicios"));
        panelOeste.setPreferredSize(new Dimension(220, 50));
        //SubPaneles
        JPanel panelMas1 = new JPanel(new GridBagLayout());
        panelMas1.setBackground(Color.ORANGE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);
        panelMas1.setBorder(new EmptyBorder(30, 30, 30, 30));

        JPanel panelMas2 = new JPanel();
        panelMas2.setLayout(new BoxLayout(panelMas2, BoxLayout.Y_AXIS));
        panelMas2.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMas2.setBackground(Color.ORANGE);

        JPanel panelMas3 = new JPanel(new GridLayout(4, 1));
        panelMas3.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMas3.setBackground(Color.ORANGE);

        JPanel panelMas4 = new JPanel(new GridLayout(4, 1));
        panelMas4.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMas4.setBackground(Color.ORANGE);

        panelMas1.setBorder(BorderFactory.createTitledBorder(""));
        panelMas1.add(new JLabel("Nombre:"), gbc);
        txtNombre = new JTextField(15);
        gbc.gridy = 1;
        panelMas1.add(txtNombre, gbc);

        panelMas2.add(new JLabel("Tipo de Mascota:", SwingConstants.CENTER), BorderLayout.NORTH);
        panelMas2.add(Box.createVerticalStrut(13));
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
            rbMascotas[i].setMargin(new Insets(0, 0, 0, 0));
            rbMascotas[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            rbMascotas[i].setHorizontalAlignment(SwingConstants.LEFT);
            grupo.add(rbMascotas[i]);
            panelMas2.add(rbMascotas[i]);
            panelMas2.add(Box.createVerticalStrut(13));
        }
        rbPerro = rbMascotas[0];
        rbGato = rbMascotas[1];
        rbAve = rbMascotas[2];
        rbPerro.setSelected(true);
        JRadioButton Masc[] = {rbPerro, rbGato, rbAve};
        //Tipo de letra
        for (int i = 0; i < Masc.length; i++) {
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
        JCheckBox Producto[] = {cbBaño, cbCorte, cbVacunas};
        for (int i = 0; i < Producto.length; i++) {
            Producto[i].setFont(txtTextos);
            Producto[i].setHorizontalAlignment(SwingConstants.LEFT);
            Producto[i].setForeground(Color.BLACK);
        }

        panelMas4.add(new JLabel("Extras", SwingConstants.CENTER), BorderLayout.NORTH);
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
        JCheckBox etiquetas[] = {cbShampoo, cbUñas, cbCollar};
        for (int i = 0; i < etiquetas.length; i++) {
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
        panelCentro.setBorder(Diseño.borde("Servicio Actual"));
        Mascota = new JLabel("Mascota: ");
        Tipo = new JLabel("Tipo: ");
        Servicio = new JLabel("Servicios: ");
        Extras = new JLabel("Extras: ");
        Costo = new JLabel("Costos: ");
        mascotaImg = new JLabel(icons[0]);
        //Tipo de letras
        JLabel etiquetas[] = {Mascota, Tipo, Servicio, Extras, Costo};
        for (int i = 0; i < etiquetas.length; i++) {
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

    private void initEste() {
        panelEste = new JPanel(new BorderLayout());
        panelEste.setBackground(Color.ORANGE);
        panelEste.setBorder(Diseño.borde("Lista de Servicios en Espera"));
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

        JButton btnAñadir = Diseño.boton1("Añadir Mascota");
        JButton btnAtender = Diseño.boton1("Atender Mascota");
        JButton btnFinSer = Diseño.boton1("Finalizar servicio");
        JButton btnSalir = Diseño.boton1("Salir");
        JButton btnInfo = Diseño.boton1("Info.D");

        btnAñadir.setPreferredSize(new Dimension(150, 35));
        btnAtender.setPreferredSize(new Dimension(150, 35));
        btnFinSer.setPreferredSize(new Dimension(150, 35));
        btnInfo.setPreferredSize(new Dimension(150, 35));
        btnSalir.setPreferredSize(new Dimension(100, 35));
        panelSur.add(btnAñadir);
        panelSur.add(btnAtender);
        panelSur.add(btnFinSer);
        panelSur.add(btnInfo);
        panelSur.add(btnSalir);

        //Comando para funcionar como btnGuardar CTRL+S
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        Action guardarAction = new AbstractAction() {
            @Override
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
                if (!cbBaño.isSelected() && !cbCorte.isSelected() && !cbVacunas.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un servicio minimo para agregar");
                    return;
                } else {
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
        };
        panelSur.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "Guardar");
        panelSur.getActionMap().put("Guardar", guardarAction);

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
                if (!cbBaño.isSelected() && !cbCorte.isSelected() && !cbVacunas.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Seleccione un servicio minimo para agregar");
                    return;
                } else {
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

        //Comando de bntAtender CRTL+A
        KeyStroke keyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        Action guardarAction2 = new AbstractAction() {
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

        };
        panelSur.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke2, "Atender");
        panelSur.getActionMap().put("Atender", guardarAction2);
        //btnAtender
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

        //Comando de bntFinSer CRTL+F
        KeyStroke keyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        Action guardarAction3 = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Tipo.getText().equals("Tipo: ")) {
                    JOptionPane.showMessageDialog(null, "No hay mascotas en el servicio");
                } else {
                    Mascota.setText("Mascota: ");
                    Tipo.setText("Tipo: ");
                    Servicio.setText("Servicios: ");
                    Extras.setText("Extras: ");
                    Costo.setText("Precio: ");
                    mascotaImg.setIcon(icons[0]);
                }
            }
        };
        panelSur.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke3, "FinServicio");
        panelSur.getActionMap().put("FinServicio", guardarAction3);

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
                    Costo.setText("Precio: ");
                    mascotaImg.setIcon(icons[0]);
                }
            }

        });

        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInfo();
            }

        });
        add(panelSur, BorderLayout.SOUTH);

    }

    private void mostrarInfo() {
        Ventana2 ventana2 = new Ventana2();
        ventana2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ventana2.setSize(600, 350);
        ventana2.setResizable(false);
        ventana2.setLocationRelativeTo(null);
        ventana2.setVisible(true);
    }

    //Segunda Pestaña
    private void initCentro2() {
       if (panelCentro2 != null) {
        remove(panelCentro2); 
    }

    panelCentro2 = new Diseño(30);
    panelCentro2.setLayout(new BorderLayout(15,15));
    Color fondo = new Color(255, 204, 0);
    panelCentro2.setBackground(fondo);

    DefaultTableModel modeloTienda = new DefaultTableModel();
    modeloTienda.addColumn("Producto");
    modeloTienda.addColumn("Stock");
    modeloTienda.addColumn("Precio");
    modeloTienda.addColumn("Categoria");

    modeloTienda.addRow(new Object[]{"Croquetas Premium para perro", 20, "$800","Alimento"});
    modeloTienda.addRow(new Object[]{"Croquetas Normales para perro", 20, "$300","Alimento"});
    modeloTienda.addRow(new Object[]{"Croquetas Economicas para perro", 20, "$100","Alimento"});
    modeloTienda.addRow(new Object[]{"Semillas para ave", 20, "$300","Alimento"});
    modeloTienda.addRow(new Object[]{"Comida Humeda para gato", 20, "$100","Alimento"});
    modeloTienda.addRow(new Object[]{"Churu", 20, "$20","Alimento"});
    modeloTienda.addRow(new Object[]{"Juguete para gato", 15, "$40","Accesorios"});
    modeloTienda.addRow(new Object[]{"Juguete para perro", 15, "$50","Accesorios"});
    modeloTienda.addRow(new Object[]{"kit de baño", 10, "$220","Higiene"});
    modeloTienda.addRow(new Object[]{"Collar antipulgas", 25, "$10","Higiene"});
    modeloTienda.addRow(new Object[]{"Perfume para pelaje", 10, "$90","Higiene"});
    modeloTienda.addRow(new Object[]{"Toallas humedas para mascotas", 5, "$150","Higiene"});
    modeloTienda.addRow(new Object[]{"Rascador para gato", 5, "$150","Accesorios"});
    modeloTienda.addRow(new Object[]{"Cortauñas", 5, "$35","Higiene"});

        JTable tablaTienda = new JTable(modeloTienda);
        tablaTienda.setFont(txtTextos);
        tablaTienda.setRowHeight(25);
        tablaTienda.setDefaultEditor(Object.class, null);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTienda);
    tablaTienda.setRowSorter(sorter);
    tablaTienda.setBackground(new Color(255,177,51));
    tablaTienda.setForeground(Color.BLACK);
    tablaTienda.setGridColor(Color.DARK_GRAY);
    tablaTienda.setSelectionBackground(new Color(255,140,0));

    JScrollPane scrollInventario = new JScrollPane(tablaTienda);
    scrollInventario.setPreferredSize(new Dimension(700, 250));
    scrollInventario.getViewport().setBackground(new Color(255,177,51));
    scrollInventario.setBackground(new Color(255,177,51));
    scrollInventario.setBorder(null);

    String[] categorias = {"Todos", "Alimento", "Accesorios", "Higiene"};
    JComboBox<String> comboCategorias = new JComboBox<>(categorias);
    comboCategorias.setFont(txtTextos);
    comboCategorias.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String seleccion = (String) comboCategorias.getSelectedItem();
            if (seleccion.equals("Todos")) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter(seleccion, 3));
            }
        }
    });

    JPanel panelFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panelFiltro.setOpaque(false);
    panelFiltro.setBackground(new Color(255, 165, 0));
    panelFiltro.add(new JLabel("Filtrar:"));
    panelFiltro.add(comboCategorias);

    DefaultTableModel modeloCarrito = new DefaultTableModel();
    modeloCarrito.addColumn("Producto");
    modeloCarrito.addColumn("Cantidad");
    modeloCarrito.addColumn("Subtotal");

    JTable tablaCarrito = new JTable(modeloCarrito);
    tablaCarrito.setFont(txtTextos);
    tablaCarrito.setRowHeight(25);
    tablaCarrito.setBackground(new Color(255,177,51));
    tablaCarrito.setForeground(Color.BLACK);
    tablaCarrito.setGridColor(Color.DARK_GRAY);

    JScrollPane scrollCarrito = new JScrollPane(tablaCarrito);
    scrollCarrito.setPreferredSize(new Dimension(700, 200));
    scrollCarrito.getViewport().setBackground(new Color(255,177,51));
    scrollCarrito.setBackground(new Color(255,177,51));
    scrollCarrito.setBorder(null);

    JLabel etiquetaTotal = new JLabel("Total: $0");
    etiquetaTotal.setFont(txtTextos);
    etiquetaTotal.setHorizontalAlignment(SwingConstants.RIGHT);


        JButton botonCobrar = Diseño.boton1("Cobrar");
    botonCobrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Cobro realizado\n" + etiquetaTotal.getText());
            modeloCarrito.setRowCount(0);
            etiquetaTotal.setText("Total: $0");
        }
    });

    JPanel panelCobro = new JPanel(new BorderLayout());
    panelCobro.setOpaque(false);
    panelCobro.add(etiquetaTotal, BorderLayout.CENTER);
    panelCobro.add(botonCobrar, BorderLayout.EAST);

        JPanel panelCarrito = new Diseño(25);
        panelCarrito.setOpaque(false);
        panelCarrito.setLayout(new BorderLayout(10,10));
        panelCarrito.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.BLACK, 2),
        "Carrito de Compras",
        TitledBorder.CENTER,
        TitledBorder.TOP,
        new Font("Arial", Font.BOLD, 16),
        Color.BLACK));
    panelCarrito.add(scrollCarrito, BorderLayout.CENTER);
    panelCarrito.add(panelCobro, BorderLayout.SOUTH);

        JButton botonAgregar = Diseño.boton1("Agregar al carrito");
        JButton botonSalirTienda = Diseño.boton1("Salir");
    botonSalirTienda.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

    botonAgregar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int fila = tablaTienda.getSelectedRow();
            if (fila != -1) {
                String producto = (String) tablaTienda.getValueAt(fila, 0);
                String precioStr = (String) tablaTienda.getValueAt(fila, 2);
                double precio = Double.parseDouble(precioStr.replace("$", ""));
                int stock = (int) tablaTienda.getValueAt(fila, 1);

                if (stock > 0) {
                    tablaTienda.setValueAt(stock - 1, fila, 1);

                    boolean encontrado = false;
                    for (int i = 0; i < modeloCarrito.getRowCount(); i++) {
                        String prodExistente = (String) modeloCarrito.getValueAt(i, 0);
                        if (prodExistente.equals(producto)) {
                            int cantidad = (int) modeloCarrito.getValueAt(i, 1);
                            cantidad++;
                            modeloCarrito.setValueAt(cantidad, i, 1);
                            modeloCarrito.setValueAt("$" + (cantidad * precio), i, 2);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        modeloCarrito.addRow(new Object[]{producto, 1, "$" + precio});
                    }

                    double total = 0;
                    for (int i = 0; i < modeloCarrito.getRowCount(); i++) {
                        String subtotalStr = (String) modeloCarrito.getValueAt(i, 2);
                        total += Double.parseDouble(subtotalStr.replace("$", ""));
                    }
                    etiquetaTotal.setText("Total: $" + total);

                } else {
                    JOptionPane.showMessageDialog(null, "No hay stock de " + producto);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un producto primero");
            }
        }
    });

    JPanel panelBotonesTienda = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
    panelBotonesTienda.setOpaque(false);
    panelBotonesTienda.add(botonAgregar);
    panelBotonesTienda.add(botonSalirTienda);

    JPanel panelInventario = new Diseño(25);
    panelInventario.setOpaque(false);
    panelInventario.setLayout(new BorderLayout(10,10));
    panelInventario.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            "Inventario",
        TitledBorder.CENTER,
        TitledBorder.TOP,
        new Font("Arial", Font.BOLD, 16),
        Color.BLACK));
    panelInventario.add(panelFiltro, BorderLayout.NORTH);
    panelInventario.add(scrollInventario, BorderLayout.CENTER);
    panelInventario.add(panelBotonesTienda, BorderLayout.SOUTH);

    panelCentro2.add(panelInventario, BorderLayout.NORTH);
    panelCentro2.add(panelCarrito, BorderLayout.CENTER);

    add(panelCentro2, BorderLayout.CENTER);
    revalidate();
}
 


    private void initEste2() {
        panelEste2 = new JPanel(new GridLayout(2, 1));
        panelEste2.setBorder(BorderFactory.createTitledBorder("Lista de Servicios en espera"));
        panelEste2.setPreferredSize(new Dimension(450, 0));
        subPanel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);
        subPanel2 = new JPanel(new GridLayout(4, 1));

        listaProductos = new JComboBox(nombreProductos);
        listaProductos.setMaximumRowCount(5);

        subPanel1.add(listaProductos, gbc);

        inventario = new JLabel("Cantidad en inventario: " + cShampoo);
        nom = new JLabel("Nombre del Producto: Shampoo Campeón");
        proveedor = new JLabel("Proveedor: SCI Products");
        importado = new JLabel("Importado: SI");

        subPanel2.add(inventario);
        subPanel2.add(nom);
        subPanel2.add(proveedor);
        subPanel2.add(importado);
        panelEste2.add(subPanel1, SwingConstants.CENTER);
        panelEste2.add(subPanel2);
        add(panelEste2, BorderLayout.EAST);

    }

    private void initSur2() {
        panelSur2 = new JPanel(new FlowLayout());
        panelSur2.setBackground(Color.ORANGE);
        panelSur2.setBorder(BorderFactory.createTitledBorder("Opciones"));

        JButton btnAgregar = new JButton("Agregar 1 a Inventario");
        JButton btnQuitar = new JButton("Quitar 1 a Inventario");
        JButton btnSalir = new JButton("Salir");

        panelSur2.add(btnAgregar);
        panelSur2.add(btnQuitar);
        panelSur2.add(btnSalir);

        add(panelSur2, BorderLayout.SOUTH);
    }
}
