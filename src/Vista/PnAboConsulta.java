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
public class PnAboConsulta extends javax.swing.JPanel {

    Personal p;
    Conexion conexion;
    Operaciones operaciones;
    DefaultComboBoxModel modeloCaso;
    MiModeloDatos modeloA;
    ArrayList<Caso> casos;

    public PnAboConsulta(Personal p) {
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
            /*COMBO*/
            modeloCaso = new DefaultComboBoxModel();
            cmbCasos.setModel(modeloCaso);
            cargarCasos();

            /*TABLA*/
            modeloA = new MiModeloDatos();
            String[] titulosA = {"Código accion", "Fecha", "Descripcion"}; // Creamos un conjunto de titulos y le asignamos los nombres 
            modeloA.setColumnIdentifiers(titulosA);
            tblAcciones.setModel(modeloA);

        }

    }

    private void cargarCasos() {
        modeloCaso.addElement("Seleccione un caso");
        casos = operaciones.todosCasos(p.getDni());
        modeloCaso.addAll(casos);
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

    private void borrarTbl() {
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
        cmbCasos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAcciones = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSituacion = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CONSULTA");

        jLabel2.setText("CASOS");

        cmbCasos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCasos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCasosItemStateChanged(evt);
            }
        });

        jLabel4.setText("TITULO");

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

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setText("DESCRIPCION");

        jLabel6.setText("ACCIONES EFECTUADAS");

        jLabel7.setText("SITUACION");

        lblSituacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lblDesc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSituacion)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(jLabel5))
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cmbCasos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel6)
                                .addGap(254, 254, 254))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCasos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitulo)
                            .addComponent(lblDesc)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSituacion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCasosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCasosItemStateChanged

        if (cmbCasos.getSelectedIndex() != 0) {

            borrarTbl();

            int posicion = cmbCasos.getSelectedIndex() - 1;
            Caso c = casos.get(posicion);

            lblTitulo.setText(c.getTitulo());
            lblDesc.setText(c.getDescripcion());
            lblSituacion.setText(transformarSituacion(c.getSituacion()));
            cargarAcciones(operaciones.accionesAsignadas(c.getCodCaso()));
        }


    }//GEN-LAST:event_cmbCasosItemStateChanged

    private String transformarSituacion (String situacion){
        if ("C".equals(situacion)) {
            situacion = "CERRADO";
        } else {
            situacion = "ABIERTO";
        }
        return situacion;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCasos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblSituacion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAcciones;
    // End of variables declaration//GEN-END:variables
}
