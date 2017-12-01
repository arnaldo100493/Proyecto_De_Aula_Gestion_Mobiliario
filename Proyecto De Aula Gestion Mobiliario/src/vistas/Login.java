/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;



import control.AdminUsuario;
import javax.swing.JOptionPane;
import modelo.Empleado;


/**
 *

 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Lgin
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
         this.setResizable(false);
    }
        
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        campoContra = new javax.swing.JPasswordField();
        btnSalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboPrivilegio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesion");
        setMinimumSize(new java.awt.Dimension(650, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 22)); // NOI18N
        jLabel1.setText("REGISTRO Y CONTROL DE RESERVA DE MOBILIARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 590, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        lblContraseña.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lblContraseña.setText("Contraseña");
        getContentPane().add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        btnIngresar.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciosesion.png"))); // NOI18N
        btnIngresar.setText("INICIAR SESION");
        btnIngresar.setBorder(null);
        btnIngresar.setBorderPainted(false);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 170, 40));
        getContentPane().add(campoContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 110, 30));

        btnSalir.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 130, 40));

        jLabel5.setBackground(new java.awt.Color(0, 245, 234));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 245, 234));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/principal1.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 330, 360));

        jLabel6.setBackground(new java.awt.Color(0, 245, 234));
        jLabel6.setForeground(new java.awt.Color(0, 245, 234));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tira1.PNG"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tira1.PNG"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 640, 30));

        comboPrivilegio.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        comboPrivilegio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar--", "Administrador", "Empleado" }));
        getContentPane().add(comboPrivilegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 110, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        int i =JOptionPane.showConfirmDialog(this,"¿Realmente Desea Salir ?",
                "Confirmar Salida",JOptionPane.YES_NO_OPTION);
                    if(i==0){
                     Principal pr = new Principal();
                     pr.setVisible(true);
                     dispose();
                    }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String pass = campoContra.getText();
        String password = "1234";
       
        if (comboPrivilegio.getSelectedItem().equals("Administrador") && pass.equals(password))
       {    
   
           VentanaAdministrador va =  new VentanaAdministrador();
           va.setVisible(true);
           campoContra.setText(null);
           this.setVisible(false);
       }
        else if((campoContra.getText().equals("") || comboPrivilegio.getSelectedItem().equals("Seleccionar"))
               &&(campoContra.getText().equals("") || comboPrivilegio.getSelectedItem().equals("Administrador"))
                &&(campoContra.getText().equals("") || comboPrivilegio.getSelectedItem().equals("Empleado")))
       {
           JOptionPane.showMessageDialog(null,"Hay campos vacios");
       }
       else if( comboPrivilegio.getSelectedItem().equals("Administrador") 
                &&(campoContra.getText() != password))
        {
            JOptionPane.showMessageDialog(null,"Contraseña invalida..Intente nuevamente");
        }
       
     
       
       
       if(comboPrivilegio.getSelectedItem().equals("Empleado"))
       { 
           AdminUsuario.iniciarSesionEmpleado(pass);
       } 
    }//GEN-LAST:event_btnIngresarActionPerformed
    
   

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    public javax.swing.JPasswordField campoContra;
    public javax.swing.JComboBox<String> comboPrivilegio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public final javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblContraseña;
    // End of variables declaration//GEN-END:variables

}
