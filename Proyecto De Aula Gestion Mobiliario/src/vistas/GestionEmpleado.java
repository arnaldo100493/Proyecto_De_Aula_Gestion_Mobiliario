package vistas;

import modelo.Empleado;
import control.AdminEmpleado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

public class GestionEmpleado extends javax.swing.JFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();

    public GestionEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void registrar() {
        if (txtNombre_Registrar.getText().equals("") || txtCorreo_Registrar.getText().equals("")
                || txtDireccion_Registrar.getText().equals("")
                | txtIdentificacion_Registrar.getText().equals("")
                || txtTelefono_Registrar.getText().equals("")
                || comboSexo.getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        }
        if (!txtNombre_Registrar.getText().equals("") && !txtCorreo_Registrar.getText().equals("")
                && !txtDireccion_Registrar.getText().equals("")
                && !txtIdentificacion_Registrar.getText().equals("")
                && !txtTelefono_Registrar.getText().equals("")
                && comboSexo.getSelectedItem().equals("M")) {
            Usuario registrar = new Empleado();
            registrar.Nombre = this.txtNombre_Registrar.getText();
            registrar.Num_Identi = this.txtIdentificacion_Registrar.getText();
            registrar.Direccion = this.txtDireccion_Registrar.getText();
            registrar.Correo = this.txtCorreo_Registrar.getText();
            registrar.Telefono = this.txtTelefono_Registrar.getText();
            registrar.Sexo = (String) this.comboSexo.getSelectedItem();
            AdminEmpleado.registrar(registrar);

            txtNombre_Registrar.setText(null);
            txtIdentificacion_Registrar.setText(null);
            txtDireccion_Registrar.setText(null);
            txtCorreo_Registrar.setText(null);
            txtTelefono_Registrar.setText(null);
            comboSexo.setSelectedIndex(0);
            txtNombre_Registrar.requestFocus();
        }

        if (!txtNombre_Registrar.getText().equals("") && !txtCorreo_Registrar.getText().equals("")
                && !txtDireccion_Registrar.getText().equals("")
                && !txtIdentificacion_Registrar.getText().equals("")
                && !txtTelefono_Registrar.getText().equals("")
                && comboSexo.getSelectedItem().equals("F")) {
            Usuario registrar = new Empleado();
            registrar.Nombre = this.txtNombre_Registrar.getText();
            registrar.Num_Identi = this.txtIdentificacion_Registrar.getText();
            registrar.Direccion = this.txtDireccion_Registrar.getText();
            registrar.Correo = this.txtCorreo_Registrar.getText();
            registrar.Telefono = this.txtTelefono_Registrar.getText();
            registrar.Sexo = (String) this.comboSexo.getSelectedItem();
            AdminEmpleado.registrar(registrar);

            txtNombre_Registrar.setText(null);
            txtIdentificacion_Registrar.setText(null);
            txtDireccion_Registrar.setText(null);
            txtCorreo_Registrar.setText(null);
            txtTelefono_Registrar.setText(null);
            comboSexo.setSelectedIndex(0);
            txtNombre_Registrar.requestFocus();
        }
    }

    private void consultar() {
        if (txtIdentificacion_Consultar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha escrito ninguna identificación", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            AdminEmpleado.listar(txtIdentificacion_Consultar.getText(), Empleado_Consultar);
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
        AdminEmpleado.listar(table_ListadoEmpleado);
    }

    private void consultarModificar() {
        String codigo = txtIdentificacion_Modificar.getText();
        Empleado consultaEmpleado = AdminEmpleado.consultar(codigo);
        if (consultaEmpleado != null) {
            txtNombre_Modificar.setText(consultaEmpleado.getNombre());
            txtDireccion_Modificar.setText(consultaEmpleado.getDireccion());
            txtCorreo_Modificar.setText(consultaEmpleado.getCorreo());
            txtTelefono_Modificar.setText(consultaEmpleado.getTelefono());

        }
        txtIdentificacion_Modificar.setEditable(false);

    }

    private void modificar() {
        if (txtNombre_Modificar.getText().isEmpty() || txtDireccion_Modificar.getText().isEmpty() || txtCorreo_Modificar.getText().isEmpty() || txtTelefono_Modificar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha consultado el empleado");
        } else {
            String codigo = txtIdentificacion_Modificar.getText();
            Empleado e = AdminEmpleado.consultar(codigo);
            if (e != null) {

                e.Nombre = this.txtNombre_Modificar.getText();
                e.Direccion = this.txtDireccion_Modificar.getText();
                e.Correo = this.txtCorreo_Modificar.getText();
                e.Telefono = this.txtTelefono_Modificar.getText();

                AdminEmpleado.modificar(e);
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

        AdminEmpleado.eliminar(codigo);
        txtIdentificacion_Consultar.setText(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        registrar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono_Registrar = new javax.swing.JTextField();
        txtCorreo_Registrar = new javax.swing.JTextField();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre_Registrar = new javax.swing.JTextField();
        txtDireccion_Registrar = new javax.swing.JTextField();
        txtIdentificacion_Registrar = new javax.swing.JTextField();
        btnGuardar_Registrar = new javax.swing.JButton();
        btnAtras_Registrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        consultar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtIdentificacion_Consultar = new javax.swing.JTextField();
        btnConsultar_Consultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        btnAtras_Consultar = new javax.swing.JButton();
        btnEliminar_Consultar = new javax.swing.JButton();
        modificar = new javax.swing.JPanel();
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
        listar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel15 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnListar_Consultar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Empleado");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel4.setText("Direccion: ");
        registrar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 87, -1, -1));
        registrar.add(txtTelefono_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 100, -1));
        registrar.add(txtCorreo_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 100, -1));

        comboSexo.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione---", "M", "F" }));
        registrar.add(comboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 117, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel1.setText("Sexo:");
        registrar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 177, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Registrar.png"))); // NOI18N
        registrar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 53, 110, 172));

        txtNombre_Registrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre_RegistrarKeyTyped(evt);
            }
        });
        registrar.add(txtNombre_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 100, -1));
        registrar.add(txtDireccion_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 100, -1));

        txtIdentificacion_Registrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacion_RegistrarKeyTyped(evt);
            }
        });
        registrar.add(txtIdentificacion_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 100, -1));

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
        registrar.add(btnGuardar_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 225, 50, 40));

        btnAtras_Registrar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btnAtras_Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        btnAtras_Registrar.setText("Atras");
        btnAtras_Registrar.setBorder(null);
        btnAtras_Registrar.setBorderPainted(false);
        btnAtras_Registrar.setContentAreaFilled(false);
        btnAtras_Registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtras_Registrar.setIconTextGap(-4);
        btnAtras_Registrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAtras_Registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtras_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras_RegistrarActionPerformed(evt);
            }
        });
        registrar.add(btnAtras_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 40, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel6.setText("Telefono:");
        registrar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 149, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel5.setText("E-mail:");
        registrar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 118, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel2.setText("Nombre: ");
        registrar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel3.setText("Identificacion: ");
        registrar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 56, -1, -1));

        jTabbedPane1.addTab("REGISTRAR", registrar);

        consultar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel8.setText("Identificacion: ");
        consultar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        txtIdentificacion_Consultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacion_ConsultarKeyTyped(evt);
            }
        });
        consultar.add(txtIdentificacion_Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 80, -1));

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
        consultar.add(btnConsultar_Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 50, 40));

        Empleado_Consultar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Empleado_Consultar.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        Empleado_Consultar.setModel(new javax.swing.table.DefaultTableModel(
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
        Empleado_Consultar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(Empleado_Consultar);

        consultar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 590, 60));

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
        consultar.add(btnAtras_Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

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
        consultar.add(btnEliminar_Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        jTabbedPane1.addTab("CONSULTAR", consultar);

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

        btnModificar_Modificar.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        btnModificar_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnModificar_Modificar.setBorder(null);
        btnModificar_Modificar.setBorderPainted(false);
        btnModificar_Modificar.setContentAreaFilled(false);
        btnModificar_Modificar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnModificar_Modificar.setIconTextGap(-1);
        btnModificar_Modificar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnModificar_Modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar_ModificarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel9.setText("Identificacion");

        btnAtras_Modificar.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
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

        javax.swing.GroupLayout modificarLayout = new javax.swing.GroupLayout(modificar);
        modificar.setLayout(modificarLayout);
        modificarLayout.setHorizontalGroup(
            modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
            .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(modificarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel9)
                            .addGap(26, 26, 26)
                            .addComponent(txtIdentificacion_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(btnConsultar_Modificar))
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGap(8, 8, 8)
                            .addComponent(btnAtras_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDireccion_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCorreo_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefono_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addComponent(btnModificar_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        modificarLayout.setVerticalGroup(
            modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
            .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(modificarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnConsultar_Modificar)
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(txtIdentificacion_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(16, 16, 16)
                    .addGroup(modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel10)
                            .addGap(24, 24, 24)
                            .addComponent(jLabel11)
                            .addGap(24, 24, 24)
                            .addComponent(jLabel12)
                            .addGap(24, 24, 24)
                            .addComponent(jLabel13))
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addGap(151, 151, 151)
                            .addComponent(btnAtras_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addComponent(txtNombre_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtDireccion_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtCorreo_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTelefono_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(modificarLayout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addComponent(btnModificar_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("MODIFICAR", modificar);

        table_ListadoEmpleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_ListadoEmpleado);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel15.setText("LISTADO EMPLEADO");

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

        javax.swing.GroupLayout listarLayout = new javax.swing.GroupLayout(listar);
        listar.setLayout(listarLayout);
        listarLayout.setHorizontalGroup(
            listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
            .addGroup(listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listarLayout.createSequentialGroup()
                            .addGap(206, 206, 206)
                            .addComponent(jLabel15))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(listarLayout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(btnListar_Consultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        listarLayout.setVerticalGroup(
            listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
            .addGroup(listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(listarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnListar_Consultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("LISTAR", listar);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombre_RegistrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_RegistrarKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A') | (c > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombre_RegistrarKeyTyped

    private void txtIdentificacion_RegistrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacion_RegistrarKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdentificacion_RegistrarKeyTyped

    private void btnAtras_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras_RegistrarActionPerformed
        VentanaAdministrador VA = new VentanaAdministrador();
        VA.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtras_RegistrarActionPerformed

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
        VentanaAdministrador VA = new VentanaAdministrador();
        VA.setVisible(true);
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
        VentanaAdministrador VA = new VentanaAdministrador();
        VA.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtras_ModificarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaAdministrador VA = new VentanaAdministrador();
        VA.setVisible(true);
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
            java.util.logging.Logger.getLogger(GestionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public final javax.swing.JTable Empleado_Consultar = new javax.swing.JTable();
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnAtras_Consultar;
    private javax.swing.JButton btnAtras_Modificar;
    private javax.swing.JButton btnAtras_Registrar;
    private javax.swing.JButton btnConsultar_Consultar;
    private javax.swing.JButton btnConsultar_Modificar;
    private javax.swing.JButton btnEliminar_Consultar;
    private javax.swing.JButton btnGuardar_Registrar;
    private javax.swing.JButton btnListar_Consultar1;
    private javax.swing.JButton btnModificar_Modificar;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JPanel consultar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel listar;
    private javax.swing.JPanel modificar;
    private javax.swing.JPanel registrar;
    public final javax.swing.JTable table_ListadoEmpleado = new javax.swing.JTable();
    public final javax.swing.JTextField txtCorreo_Modificar = new javax.swing.JTextField();
    private javax.swing.JTextField txtCorreo_Registrar;
    public final javax.swing.JTextField txtDireccion_Modificar = new javax.swing.JTextField();
    private javax.swing.JTextField txtDireccion_Registrar;
    private javax.swing.JTextField txtIdentificacion_Consultar;
    public static javax.swing.JTextField txtIdentificacion_Modificar;
    private javax.swing.JTextField txtIdentificacion_Registrar;
    public final javax.swing.JTextField txtNombre_Modificar = new javax.swing.JTextField();
    private javax.swing.JTextField txtNombre_Registrar;
    public final javax.swing.JTextField txtTelefono_Modificar = new javax.swing.JTextField();
    private javax.swing.JTextField txtTelefono_Registrar;
    // End of variables declaration//GEN-END:variables
}
