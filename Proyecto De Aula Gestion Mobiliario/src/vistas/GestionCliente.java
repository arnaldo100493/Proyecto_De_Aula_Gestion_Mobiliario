/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.AdminCliente;
import static control.AdminUsuario.listadoCliente;
import static control.AdminUsuario.listadoEmpleado;
import modelo.Usuario;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

/**
 *
 * @author CARLOS MEDINA
 */
public class GestionCliente extends javax.swing.JFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();

    public GestionCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void registrar() {
        if (txtNombre_Registrar1.getText().equals("") || txtCorreo_Registrar1.getText().equals("")
                || txtDireccion_Registrar1.getText().equals("")
                | txtIdentificacion_Registrar1.getText().equals("")
                || txtTelefono_Registrar1.getText().equals("")
                || comboSexo_Registrar1.getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        }
        if (!txtNombre_Registrar1.getText().equals("") && !txtCorreo_Registrar1.getText().equals("")
                && !txtDireccion_Registrar1.getText().equals("")
                && !txtIdentificacion_Registrar1.getText().equals("")
                && !txtTelefono_Registrar1.getText().equals("")
                && comboSexo_Registrar1.getSelectedItem().equals("M")) {
            Usuario registrar = new Cliente();
            registrar.Nombre = this.txtNombre_Registrar1.getText();
            registrar.Num_Identi = this.txtIdentificacion_Registrar1.getText();
            registrar.Direccion = this.txtDireccion_Registrar1.getText();
            registrar.Correo = this.txtCorreo_Registrar1.getText();
            registrar.Telefono = this.txtTelefono_Registrar1.getText();
            registrar.Sexo = (String) this.comboSexo_Registrar1.getSelectedItem();
            AdminCliente.registrar(registrar);

            txtNombre_Registrar1.setText(null);
            txtIdentificacion_Registrar1.setText(null);
            txtDireccion_Registrar1.setText(null);
            txtCorreo_Registrar1.setText(null);
            txtTelefono_Registrar1.setText(null);
            comboSexo_Registrar1.setSelectedIndex(0);
            txtNombre_Registrar1.requestFocus();
        }

        if (!txtNombre_Registrar1.getText().equals("") && !txtCorreo_Registrar1.getText().equals("")
                && !txtDireccion_Registrar1.getText().equals("")
                && !txtIdentificacion_Registrar1.getText().equals("")
                && !txtTelefono_Registrar1.getText().equals("")
                && comboSexo_Registrar1.getSelectedItem().equals("F")) {
            Usuario registrar = new Cliente();
            registrar.Nombre = this.txtNombre_Registrar1.getText();
            registrar.Num_Identi = this.txtIdentificacion_Registrar1.getText();
            registrar.Direccion = this.txtDireccion_Registrar1.getText();
            registrar.Correo = this.txtCorreo_Registrar1.getText();
            registrar.Telefono = this.txtTelefono_Registrar1.getText();
            registrar.Sexo = (String) this.comboSexo_Registrar1.getSelectedItem();
            AdminCliente.registrar(registrar);

            txtNombre_Registrar1.setText(null);
            txtIdentificacion_Registrar1.setText(null);
            txtDireccion_Registrar1.setText(null);
            txtCorreo_Registrar1.setText(null);
            txtTelefono_Registrar1.setText(null);
            comboSexo_Registrar1.setSelectedIndex(0);
            txtNombre_Registrar1.requestFocus();
        }
    }

    private void consultar() {
        if (txtIdentificacion_Consultar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha escrito ninguna identificación", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            AdminCliente.listar(txtIdentificacion_Consultar.getText(), Cliente_Consultar);
        }
        txtIdentificacion_Consultar.setText(null);
    }

    private void listar() {
        this.modeloTabla.addColumn("Identificación");
        this.modeloTabla.addColumn("Nombre");
        this.modeloTabla.addColumn("Dirección");
        this.modeloTabla.addColumn("Teléfono");
        this.modeloTabla.addColumn("Correo");
        this.modeloTabla.addColumn("Sexo");
        AdminCliente.listar(table_ListadoCliente);
    }

    private void consultarModificar() {
        String codigo = txtIdentificacion_Modificar.getText();
        Cliente consultaCliente = AdminCliente.consultar(codigo);
        if (consultaCliente != null) {
            txtNombre_Modificar.setText(consultaCliente.getNombre());
            txtDireccion_Modificar.setText(consultaCliente.getDireccion());
            txtCorreo_Modificar.setText(consultaCliente.getCorreo());
            txtTelefono_Modificar.setText(consultaCliente.getTelefono());

        }
        txtIdentificacion_Modificar.setEditable(false);

    }

    private void modificar() {
        if (txtNombre_Modificar.getText().isEmpty() || txtDireccion_Modificar.getText().isEmpty() || txtCorreo_Modificar.getText().isEmpty() || txtTelefono_Modificar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha consultado el cliente");
        } else {
            String codigo = txtIdentificacion_Modificar.getText();
            Cliente c = AdminCliente.consultar(codigo);
            if (c != null) {

                c.Nombre = this.txtNombre_Modificar.getText();
                c.Direccion = this.txtDireccion_Modificar.getText();
                c.Correo = this.txtCorreo_Modificar.getText();
                c.Telefono = this.txtTelefono_Modificar.getText();

                AdminCliente.modificar(c);
                txtIdentificacion_Modificar.setText(null);
                txtNombre_Modificar.setText(null);
                txtDireccion_Modificar.setText(null);
                txtCorreo_Modificar.setText(null);
                txtTelefono_Modificar.setText(null);
                txtIdentificacion_Modificar.setEditable(true);
            }
        }

    }

    private void eliminar() {
        String codigo = txtIdentificacion_Consultar.getText();

        AdminCliente.eliminar(codigo);
        txtIdentificacion_Consultar.setText(null);

    }

    public void listarMobiliario_listar() {

        ((DefaultTableModel) table_ListadoCliente.getModel()).setNumRows(0);
        for (Usuario user : listadoCliente) {
            Iterator recorrido = listadoEmpleado.iterator();
            ((DefaultTableModel) table_ListadoCliente.getModel()).addRow(new Object[]{recorrido.next(),
                user.getNombre(), user.getDireccion(),
                user.getCorreo(), user.getTelefono(), user.getSexo()});

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre_Registrar1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdentificacion_Registrar1 = new javax.swing.JTextField();
        txtDireccion_Registrar1 = new javax.swing.JTextField();
        txtCorreo_Registrar1 = new javax.swing.JTextField();
        txtTelefono_Registrar1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboSexo_Registrar1 = new javax.swing.JComboBox<>();
        btnAtras_registrar = new javax.swing.JButton();
        btnGuardar_Registrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtIdentificacion_Consultar = new javax.swing.JTextField();
        btnConsultar_Consultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        btnAtras_Consultar = new javax.swing.JButton();
        btnEliminar_Consultar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtIdentificacion_Modificar = new javax.swing.JTextField();
        btnConsultar_Modificar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnModificar_Modificar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnAtras_Modificar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        btnListar_Consultar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel2.setText("Nombre: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel3.setText("Identificacion: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 86, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel4.setText("Direccion: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 117, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel5.setText("E-mail:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 148, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel6.setText("Telefono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 179, -1, -1));

        txtNombre_Registrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_Registrar1ActionPerformed(evt);
            }
        });
        txtNombre_Registrar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre_Registrar1KeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre_Registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 60, 100, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registrar.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 110, 172));

        txtIdentificacion_Registrar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacion_Registrar1KeyTyped(evt);
            }
        });
        jPanel1.add(txtIdentificacion_Registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 90, 100, -1));
        jPanel1.add(txtDireccion_Registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 120, 100, -1));
        jPanel1.add(txtCorreo_Registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 150, 100, -1));

        txtTelefono_Registrar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono_Registrar1KeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono_Registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 180, 100, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel1.setText("Sexo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 207, -1, -1));

        comboSexo_Registrar1.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        comboSexo_Registrar1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione---", "M", "F" }));
        jPanel1.add(comboSexo_Registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 210, 117, -1));

        btnAtras_registrar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnAtras_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        btnAtras_registrar.setText("Atras");
        btnAtras_registrar.setBorder(null);
        btnAtras_registrar.setBorderPainted(false);
        btnAtras_registrar.setContentAreaFilled(false);
        btnAtras_registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtras_registrar.setIconTextGap(-4);
        btnAtras_registrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAtras_registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtras_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras_registrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 255, 40, 40));

        btnGuardar_Registrar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnGuardar_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar_Registrar.setText("Guardar");
        btnGuardar_Registrar.setBorder(null);
        btnGuardar_Registrar.setBorderPainted(false);
        btnGuardar_Registrar.setContentAreaFilled(false);
        btnGuardar_Registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar_Registrar.setIconTextGap(-4);
        btnGuardar_Registrar.setMaximumSize(new java.awt.Dimension(27, 35));
        btnGuardar_Registrar.setMinimumSize(new java.awt.Dimension(27, 35));
        btnGuardar_Registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar_RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 255, 50, 40));

        jTabbedPane1.addTab("REGISTRAR", jPanel1);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel8.setText("Identificacion: ");

        txtIdentificacion_Consultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacion_ConsultarKeyTyped(evt);
            }
        });

        btnConsultar_Consultar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnConsultar_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnConsultar_Consultar.setText("Consultar");
        btnConsultar_Consultar.setBorder(null);
        btnConsultar_Consultar.setBorderPainted(false);
        btnConsultar_Consultar.setContentAreaFilled(false);
        btnConsultar_Consultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar_Consultar.setIconTextGap(-4);
        btnConsultar_Consultar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultar_Consultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultar_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar_ConsultarActionPerformed(evt);
            }
        });

        Cliente_Consultar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Cliente_Consultar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        Cliente_Consultar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identificacion", "Nombre", "Direccion", "Telefono", "E-mail", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Cliente_Consultar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(Cliente_Consultar);

        btnAtras_Consultar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnAtras_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        btnAtras_Consultar.setText("Atras");
        btnAtras_Consultar.setBorder(null);
        btnAtras_Consultar.setBorderPainted(false);
        btnAtras_Consultar.setContentAreaFilled(false);
        btnAtras_Consultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtras_Consultar.setIconTextGap(-1);
        btnAtras_Consultar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAtras_Consultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtras_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras_ConsultarActionPerformed(evt);
            }
        });

        btnEliminar_Consultar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnEliminar_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar_Consultar.setText("Eliminar");
        btnEliminar_Consultar.setBorder(null);
        btnEliminar_Consultar.setBorderPainted(false);
        btnEliminar_Consultar.setContentAreaFilled(false);
        btnEliminar_Consultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar_Consultar.setIconTextGap(-1);
        btnEliminar_Consultar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEliminar_Consultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar_ConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel8)
                            .addGap(39, 39, 39)
                            .addComponent(txtIdentificacion_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnConsultar_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(btnAtras_Consultar)
                            .addGap(183, 183, 183)
                            .addComponent(btnEliminar_Consultar)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnConsultar_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(txtIdentificacion_Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAtras_Consultar)
                        .addComponent(btnEliminar_Consultar))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("CONSULTAR", jPanel2);

        txtIdentificacion_Modificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacion_ModificarKeyTyped(evt);
            }
        });

        btnConsultar_Modificar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnConsultar_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnConsultar_Modificar.setText("Consultar");
        btnConsultar_Modificar.setBorder(null);
        btnConsultar_Modificar.setBorderPainted(false);
        btnConsultar_Modificar.setContentAreaFilled(false);
        btnConsultar_Modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultar_Modificar.setIconTextGap(-1);
        btnConsultar_Modificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnConsultar_Modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsultar_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar_ModificarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel10.setText("Nombre");

        txtNombre_Modificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre_ModificarKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel11.setText("Direccion");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel12.setText("E-mail");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel13.setText("Telefono");

        txtTelefono_Modificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono_ModificarKeyTyped(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registrar.png"))); // NOI18N

        btnModificar_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnModificar_Modificar.setBorder(null);
        btnModificar_Modificar.setBorderPainted(false);
        btnModificar_Modificar.setContentAreaFilled(false);
        btnModificar_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_ModificarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel9.setText("Identificacion");

        btnAtras_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        btnAtras_Modificar.setText("Atras");
        btnAtras_Modificar.setBorder(null);
        btnAtras_Modificar.setBorderPainted(false);
        btnAtras_Modificar.setContentAreaFilled(false);
        btnAtras_Modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtras_Modificar.setIconTextGap(-1);
        btnAtras_Modificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAtras_Modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtras_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras_ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26)
                        .addComponent(txtIdentificacion_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnConsultar_Modificar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnAtras_Modificar)))
                        .addGap(6, 6, 6)
                        .addComponent(btnModificar_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultar_Modificar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtIdentificacion_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNombre_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccion_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCorreo_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefono_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel10)
                            .addGap(24, 24, 24)
                            .addComponent(jLabel11)
                            .addGap(24, 24, 24)
                            .addComponent(jLabel12)
                            .addGap(24, 24, 24)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAtras_Modificar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(btnModificar_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MODIFICAR", jPanel3);

        btnAtras.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtras.setIconTextGap(-4);
        btnAtras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAtras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnListar_Consultar1.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnListar_Consultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listar.png"))); // NOI18N
        btnListar_Consultar1.setText("Listar");
        btnListar_Consultar1.setBorder(null);
        btnListar_Consultar1.setBorderPainted(false);
        btnListar_Consultar1.setContentAreaFilled(false);
        btnListar_Consultar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListar_Consultar1.setIconTextGap(-1);
        btnListar_Consultar1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnListar_Consultar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListar_Consultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar_Consultar1ActionPerformed(evt);
            }
        });

        table_ListadoCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identificacion", "Nombre", "Direccion", "Telefono", "E-mail", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_ListadoCliente);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel15.setText("LISTADO CLIENTE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(206, 206, 206)
                            .addComponent(jLabel15))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(btnListar_Consultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel15)
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnListar_Consultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(69, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("LISTAR", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombre_Registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_Registrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_Registrar1ActionPerformed

    private void txtNombre_Registrar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_Registrar1KeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A') | (c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombre_Registrar1KeyTyped

    private void txtIdentificacion_Registrar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacion_Registrar1KeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdentificacion_Registrar1KeyTyped

    private void txtTelefono_Registrar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono_Registrar1KeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefono_Registrar1KeyTyped

    private void btnAtras_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras_registrarActionPerformed
        VentanaAdministrador va = new VentanaAdministrador();
        va.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtras_registrarActionPerformed

    private void btnGuardar_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar_RegistrarActionPerformed

        registrar();

    }//GEN-LAST:event_btnGuardar_RegistrarActionPerformed

    private void txtIdentificacion_ConsultarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacion_ConsultarKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdentificacion_ConsultarKeyTyped

    private void btnConsultar_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar_ConsultarActionPerformed
        consultar();

    }//GEN-LAST:event_btnConsultar_ConsultarActionPerformed

    private void btnAtras_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras_ConsultarActionPerformed
        VentanaAdministrador va = new VentanaAdministrador();
        va.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtras_ConsultarActionPerformed

    private void btnEliminar_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar_ConsultarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminar_ConsultarActionPerformed

    private void txtIdentificacion_ModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacion_ModificarKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdentificacion_ModificarKeyTyped

    private void btnConsultar_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar_ModificarActionPerformed
        consultarModificar();

    }//GEN-LAST:event_btnConsultar_ModificarActionPerformed

    private void txtNombre_ModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_ModificarKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A') | (c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombre_ModificarKeyTyped

    private void txtTelefono_ModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono_ModificarKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefono_ModificarKeyTyped

    private void btnModificar_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar_ModificarActionPerformed
        modificar();
    }//GEN-LAST:event_btnModificar_ModificarActionPerformed

    private void btnAtras_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras_ModificarActionPerformed
        VentanaAdministrador va = new VentanaAdministrador();
        va.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtras_ModificarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaAdministrador va = new VentanaAdministrador();
        va.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnListar_Consultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar_Consultar1ActionPerformed
        listar();

    }//GEN-LAST:event_btnListar_Consultar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public final javax.swing.JTable Cliente_Consultar = new javax.swing.JTable();
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnAtras_Consultar;
    private javax.swing.JButton btnAtras_Modificar;
    private javax.swing.JButton btnAtras_registrar;
    private javax.swing.JButton btnConsultar_Consultar;
    private javax.swing.JButton btnConsultar_Modificar;
    private javax.swing.JButton btnEliminar_Consultar;
    private javax.swing.JButton btnGuardar_Registrar;
    private javax.swing.JButton btnListar_Consultar1;
    private javax.swing.JButton btnModificar_Modificar;
    private javax.swing.JComboBox<String> comboSexo_Registrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public final javax.swing.JTable table_ListadoCliente = new javax.swing.JTable();
    public final javax.swing.JTextField txtCorreo_Modificar = new javax.swing.JTextField();
    private javax.swing.JTextField txtCorreo_Registrar1;
    public final javax.swing.JTextField txtDireccion_Modificar = new javax.swing.JTextField();
    private javax.swing.JTextField txtDireccion_Registrar1;
    private javax.swing.JTextField txtIdentificacion_Consultar;
    private javax.swing.JTextField txtIdentificacion_Modificar;
    private javax.swing.JTextField txtIdentificacion_Registrar1;
    public final javax.swing.JTextField txtNombre_Modificar = new javax.swing.JTextField();
    public javax.swing.JTextField txtNombre_Registrar1;
    public final javax.swing.JTextField txtTelefono_Modificar = new javax.swing.JTextField();
    private javax.swing.JTextField txtTelefono_Registrar1;
    // End of variables declaration//GEN-END:variables
}
