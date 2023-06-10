/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Bbdd.Conexion;
import Bbdd.Operaciones;
import Modelo.Personal;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Marta
 */
public class VtnLogin extends javax.swing.JFrame {

    Conexion conexion;
    Operaciones operaciones;
    VtnOperAbog ventanaOperAbog;
    VtnOperAdmin ventanaOperAdmin;

    public VtnLogin() {
        initComponents();
        Color col = new Color(66, 76, 86); // Creamos un color y lo especificamos
        getContentPane().setBackground(col); // Aplicamos el color al fondo de la ventana
        setTitle("Gestión de abogados");  // Ponemos de título el nombre del usuario que ha iniciado sesión
        // Si queremos el mismo nombre en todos los paneles, se pone en propiedades de JFrame
        //setSize(300, 300); // Cambiame el tamaño de la ventana del JFrame
        conexion = new Conexion();

        if (conexion.establecer("jdbc:mysql://localhost:3306/bufeteOrcajoA") == -1) {
            JOptionPane.showMessageDialog(null, "Errores en la base de datos");
            System.exit(-1);
        } else {
            operaciones = new Operaciones(conexion);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pwdContra = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/umagenLogin2.jpg"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("LOGIN");

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("CONTRASEÑA");

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addGap(35, 35, 35)
                                .addComponent(btnCancelar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pwdContra)
                            .addComponent(txtAlias))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(pwdContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        String contra = new String(pwdContra.getPassword());

        if (txtAlias.getText().isEmpty() || contra.isBlank()) {

            JOptionPane.showMessageDialog(this, "No existe ningún usuario con ese login y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            txtAlias.setText("");
            pwdContra.setText("");
            txtAlias.requestFocus();

        } else {

            contra = utilidades.Encriptar.getMD5(contra);
            Personal p = operaciones.existeUsuario2(txtAlias.getText(), contra);
            if (p != null) {

                if (p.getPerfil().equals("admin")) {

                    new VtnOperAdmin(p).setVisible(true);// muestrame la ventana siguiente
                    dispose(); // libera el espacio de memoria de la ventana anterior (VtnLogin)
                    pack(); //Reorganízamelo

                } else {

                    new VtnOperAbog(p).setVisible(true);// muestrame la ventana siguiente
                    dispose(); // libera el espacio de memoria de la ventana anterior (VtnLogin)
                    pack(); //Reorganízamelo

                }
            } else {
                JOptionPane.showMessageDialog(this, "No existe ningún usuario con ese login y contraseña", "Error", JOptionPane.ERROR_MESSAGE);
                txtAlias.setText("");
                pwdContra.setText("");
                txtAlias.requestFocus();
            }
        }


    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtAlias.setText("");
        pwdContra.setText("");
        txtAlias.requestFocus();

    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(VtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pwdContra;
    private javax.swing.JTextField txtAlias;
    // End of variables declaration//GEN-END:variables
}
