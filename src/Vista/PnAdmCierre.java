/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Bbdd.Conexion;
import Bbdd.Operaciones;
import Modelo.Caso;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marta
 */
public class PnAdmCierre extends javax.swing.JPanel {

    Conexion conexion;
    Operaciones operaciones;

    DefaultComboBoxModel modelo;
    
    public PnAdmCierre() {
        initComponents();
        Color col = new Color(253, 197, 76); // Creamos y especificamos un color
        setBackground(col);

        conexion = new Conexion();
        operaciones = new Operaciones(conexion);

        if (conexion.establecer("jdbc:mysql://localhost:3306/bufeteorcajoa") == -1) {
            JOptionPane.showMessageDialog(null, "Errores en la base de datos");
            System.exit(-1);
        } else {
            modelo = new DefaultComboBoxModel();
            cmbAbiertos.setModel(modelo);
            cargarCasosAbiertos();
        }
    }

       private void cargarCasosAbiertos() {
        modelo.addElement("Seleccione un caso");
        modelo.addAll(operaciones.casosAbiertos());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbAbiertos = new javax.swing.JComboBox<>();
        btnCerrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CIERRE CASOS");

        jLabel2.setText("CASOS ABIERTOS");

        cmbAbiertos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(cmbAbiertos, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btnCerrar)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbAbiertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnCerrar)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        
        if(cmbAbiertos.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un caso a cerrar", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
   
            Caso c;
            c=(Caso)cmbAbiertos.getSelectedItem();
            operaciones.cerrarCaso(c.getCodCaso());
            JOptionPane.showMessageDialog(this, "El Caso " + c.getCodCaso() + " ha sido cerrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            cmbAbiertos.removeAllItems();
            cargarCasosAbiertos();
        }
        
        
    }//GEN-LAST:event_btnCerrarActionPerformed

  
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cmbAbiertos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
