/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Bbdd.Conexion;
import Bbdd.Operaciones;
import Modelo.Caso;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marta
 */
public class PnAdmCierre extends javax.swing.JPanel {

    Conexion conexion;
    Operaciones operaciones;
    ArrayList<Caso> casos;
    Caso c;

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

            /*COMBO*/
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
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CIERRE CASOS");

        jLabel2.setText("CASOS ABIERTOS");

        cmbAbiertos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAbiertos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAbiertosItemStateChanged(evt);
            }
        });

        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblNombre.setText(".");

        jLabel3.setText("ABOGADO");

        jLabel4.setText("TITULO");

        lblTitulo.setText(".");

        jLabel5.setText("DESCRIPCION");

        lblDesc.setText(".");

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
                        .addGap(150, 150, 150)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAbiertos, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
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
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTitulo))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblDesc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        if (cmbAbiertos.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un caso a cerrar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            c = (Caso) cmbAbiertos.getSelectedItem();
            operaciones.cerrarCaso(c.getCodCaso());
            JOptionPane.showMessageDialog(this, "El Caso " + c.getCodCaso() + " ha sido cerrado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            cmbAbiertos.removeItem(cmbAbiertos.getSelectedItem());
            limpiar();
            //cargarCasosAbiertos();
        }


    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cmbAbiertosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAbiertosItemStateChanged
        int posicion = cmbAbiertos.getSelectedIndex();
        if (posicion != 0) {
            // limpiar();

            c = (Caso) cmbAbiertos.getSelectedItem();
            lblTitulo.setText(c.getTitulo());
            lblNombre.setText(operaciones.dimeNombreAbogado(c.getDni()).getNombre());
            lblDesc.setText(c.getDescripcion());

        }

    }//GEN-LAST:event_cmbAbiertosItemStateChanged

    private void limpiar() {
        cmbAbiertos.setSelectedIndex(0);
        lblTitulo.setText("");
        lblNombre.setText("");
        lblDesc.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cmbAbiertos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
