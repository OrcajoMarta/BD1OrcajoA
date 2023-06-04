/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Bbdd.Conexion;
import Bbdd.Operaciones;
import Modelo.Caso;
import Modelo.Personal;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marta
 */
public class PnAboNuevasAcciones extends javax.swing.JPanel {

    Conexion conexion;
    Operaciones operaciones;
    Personal p;
    DefaultComboBoxModel modelo;
    ArrayList<Caso>casos;

    public PnAboNuevasAcciones(Personal p) {
        initComponents();
        this.p = p;
        Color col = new Color(253, 197, 76); // Creamos y especificamos un color
        setBackground(col);

        conexion = new Conexion();
        operaciones = new Operaciones(conexion);

        if (conexion.establecer("jdbc:mysql://localhost:3306/bufeteorcajoa") == -1) {
            JOptionPane.showMessageDialog(null, "Errores en la base de datos");
            System.exit(-1);
        } else {
            lblFecha.setText(utilidades.Fecha.FechaActualString());
             modelo = new DefaultComboBoxModel();
            cmbCasos.setModel(modelo);
            cargarCasosAbiertos();
        }
    }
    
        private void cargarCasosAbiertos() {
        modelo.addElement("Seleccione un caso");
        casos=operaciones.casosAbiertosA(p.getDni());
        modelo.addAll(casos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCasos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtAccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NUEVAS ACCIONES");

        jLabel2.setText("CASOS ABIERTOS");

        cmbCasos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("CODIGO ACCION");

        jLabel4.setText("FECHA");

        lblFecha.setText("jLabel5");

        jLabel5.setText("DESCRIPCION");

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFecha)
                            .addComponent(cmbCasos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAccion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnAceptar)
                        .addGap(28, 28, 28)
                        .addComponent(btnCancelar)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCasos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblFecha))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        int error = 0;
        String mensajeError = ""; // Configuro el mensaje de error 
        
          try {

            if (txtAccion.getText().isEmpty() || txtDesc.getText().isEmpty() || cmbCasos.getSelectedIndex()==0) {
                error = 1;
                mensajeError = "Debe rellenar todos los campos";
                
            }else if(txtAccion.getText().length()>3 || txtAccion.getText().length()<3){
                error = 1;
                mensajeError = "El código de acción debe contener 3 caracteres alfanumericos";

            }else if (operaciones.existeAccion(txtAccion.getText())){
                 error = 1;
                mensajeError = "Ya existe una acción con ese código";
            }   
                
              if (error == 1) {
                // Si alguno de los filtros anteriores ha modificado el valor de error a 1...
                JOptionPane.showMessageDialog(this, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);

            } else {   
      
                int posicion=cmbCasos.getSelectedIndex();
                operaciones.grabarAccion(casos.get(posicion-1).getCodCaso(),txtAccion.getText(),lblFecha.getText(),txtDesc.getText());
                 JOptionPane.showMessageDialog(this, "Acción " + txtAccion.getText() + " asignada al caso " + casos.get(posicion-1).getCodCaso(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
                 limpiar();
              }
            
            
          }  catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en el proceso de Nueva acción", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar(); // Borra todos los campos
            txtAccion.requestFocus(); // Código recupera el foco
        }
            
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

private void limpiar(){
    cmbCasos.setSelectedIndex(0);
    txtAccion.setText("");
    txtAccion.requestFocus();
    txtDesc.setText("");
}
    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbCasos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JTextField txtAccion;
    private javax.swing.JTextArea txtDesc;
    // End of variables declaration//GEN-END:variables
}
