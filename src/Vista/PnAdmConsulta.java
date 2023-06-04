/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Bbdd.Conexion;
import Bbdd.Operaciones;
import Modelo.Accion;
import Modelo.Caso;
import Modelo.MiModeloDatos;
import Modelo.Personal;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marta
 */
public class PnAdmConsulta extends javax.swing.JPanel {

    Conexion conexion;
    Operaciones operaciones;
    DefaultComboBoxModel modeloAbog;
    MiModeloDatos modelo;
    MiModeloDatos modeloA;
    Personal a;
    ArrayList<Caso> casosA;

    public PnAdmConsulta() {
        initComponents();
        Color col = new Color(253, 197, 76); // Creamos y especificamos un color
        setBackground(col);

        conexion = new Conexion();
        operaciones = new Operaciones(conexion);

        if (conexion.establecer("jdbc:mysql://localhost:3306/bufeteorcajoa") == -1) {
            JOptionPane.showMessageDialog(null, "Errores en la base de datos");
            System.exit(-1);
        } else {
            modeloAbog = new DefaultComboBoxModel();
            cmbAbogados.setModel(modeloAbog);
            cargarAbogados();

            modelo = new MiModeloDatos();
            String[] titulos = {"Código Caso"}; // Creamos un conjunto de titulos y le asignamos los nombres 
            modelo.setColumnIdentifiers(titulos);
            tblCasosAbiertos.setModel(modelo);

            modeloA = new MiModeloDatos();
            String[] titulosA = {"Código accion","Fecha","Descripcion"}; // Creamos un conjunto de titulos y le asignamos los nombres 
            modeloA.setColumnIdentifiers(titulosA);
            tblAcciones.setModel(modeloA);

        }
    }

    private void cargarAbogados() {
        modeloAbog.addElement("Seleccione un abogado");
        modeloAbog.addAll(operaciones.abogadosConCasosAbiertos());
    }

    private void cargarCasos(ArrayList<Caso> casos) {
        for (Caso c : casos) {
            /* for(tipo elemento:conjunto) es for each
             */
            Vector v = new Vector();
            v.add(c.getCodCaso());
            modelo.addRow(v); // te añado toda una fila completa  del elemento "v" (que cada dato puede ser de diferente tipo)

        }
    }

     private void cargarAcciones(ArrayList<Accion> acciones) {
        for (Accion a : acciones) {
            /* for(tipo elemento:conjunto) es for each
             */
            Vector v = new Vector();
            v.add(a.getCodAccion());
            v.add(a.getFecha());
            v.add(a.getDescripcion());
            
            modeloA.addRow(v); // te añado toda una fila completa  del elemento "v" (que cada dato puede ser de diferente tipo)

        }
     }

    private void borrarTblCaso() {
        DefaultTableModel dm = (DefaultTableModel) this.modelo;
        int rowCount = dm.getRowCount();
        // Borra las líneas una a una hasta el final de la tabla
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
    
    private void borrarTblAcc() {
        DefaultTableModel dm = (DefaultTableModel) this.modeloA;
        int rowCount = dm.getRowCount();
        // Borra las líneas una a una hasta el final de la tabla
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbAbogados = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCasosAbiertos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAcciones = new javax.swing.JTable();
        lblDesc = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CONSULTA");

        jLabel2.setText("ABOGADOS CON CASOS ABIERTOS");

        cmbAbogados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAbogados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAbogadosItemStateChanged(evt);
            }
        });

        tblCasosAbiertos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCasosAbiertos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCasosAbiertosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCasosAbiertos);

        jLabel3.setText("TITULO");

        jLabel4.setText("DESCRIPCION");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo.setText("jLabel5");

        tblAcciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblAcciones);

        lblDesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDesc.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblDesc)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(cmbAbogados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAbogados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitulo)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDesc))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblCasosAbiertosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCasosAbiertosMouseClicked

        int fila = tblCasosAbiertos.rowAtPoint(evt.getPoint()); //Dime la fila donde ha hecho clic
        if (fila > -1) {
             borrarTblAcc();

            ArrayList<Accion> ac;
            ac = operaciones.accionesAsignadas(casosA.get(fila).getCodCaso());
            lblTitulo.setText(casosA.get(fila).getTitulo());
            lblDesc.setText(casosA.get(fila).getDescripcion());
            cargarAcciones(ac);

        }
    }//GEN-LAST:event_tblCasosAbiertosMouseClicked

    private void cmbAbogadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAbogadosItemStateChanged

        if (cmbAbogados.getSelectedIndex() != 0) {
             borrarTblCaso();
             borrarTblAcc();
             lblTitulo.setText("");
             lblDesc.setText("");
             
             
            casosA = new ArrayList<Caso>();
            a = (Personal) cmbAbogados.getSelectedItem();

            casosA = operaciones.casosAbiertos(a.getDni());
            cargarCasos(casosA);
        }

    }//GEN-LAST:event_cmbAbogadosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbAbogados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAcciones;
    private javax.swing.JTable tblCasosAbiertos;
    // End of variables declaration//GEN-END:variables

}
