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
public class VtnOperAdmin extends javax.swing.JFrame {

    Conexion conexion;
    Operaciones operaciones;
    Personal p;
    PnAdmNuevosCasos panelNuevosCasos;
    PnAdmCierre panelCierreCasos;
    PnAdmConsulta panelConsulta;

    public VtnOperAdmin(Personal p) {
        initComponents();
        this.p = p;
        setTitle("Menú de " + p.getPerfil());
        setSize(300, 300);
        Color col = new Color(66, 76, 86); // Creamos un color y lo especificamos
        getContentPane().setBackground(col);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCaso = new javax.swing.JMenuItem();
        menuCierre = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuDesc = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/imagenAdm.jpg"))); // NOI18N
        getContentPane().add(jLabel1);

        jMenu1.setText("OPERACIONES");

        menuCaso.setText("NUEVO CASO");
        menuCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCasoActionPerformed(evt);
            }
        });
        jMenu1.add(menuCaso);

        menuCierre.setText("CIERRE CASO");
        menuCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCierreActionPerformed(evt);
            }
        });
        jMenu1.add(menuCierre);

        menuConsulta.setText("CONSULTA");
        menuConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultaActionPerformed(evt);
            }
        });
        jMenu1.add(menuConsulta);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("SALIR");

        menuDesc.setText("DESCONECTAR");
        menuDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDescActionPerformed(evt);
            }
        });
        jMenu2.add(menuDesc);

        menuSalir.setText("SALIR APP");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu2.add(menuSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDescActionPerformed

        new VtnLogin().setVisible(true);
        dispose(); // Elimina la ventana
        pack(); //Reorganizar      
    }//GEN-LAST:event_menuDescActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        dispose(); // Elimina la ventana
        System.exit(0); // Pon el sistema a 0
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCierreActionPerformed

        quitarPaneles();// Quitamos cualquier panel que pueda estar abierto para que no se duplique
        panelCierreCasos = new PnAdmCierre();// Creamos el panel y le enviamos empresa y usuario
        this.getContentPane().add(panelCierreCasos);// Le añadimos el contenido
        pack();//Reorganizar
    }//GEN-LAST:event_menuCierreActionPerformed

    private void menuCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCasoActionPerformed
        quitarPaneles();// Quitamos cualquier panel que pueda estar abierto para que no se duplique
        panelNuevosCasos = new PnAdmNuevosCasos();// Creamos el panel y le enviamos empresa y usuario
        this.getContentPane().add(panelNuevosCasos);// Le añadimos el contenido
        pack();//Reorganizar
    }//GEN-LAST:event_menuCasoActionPerformed

    private void menuConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultaActionPerformed
        quitarPaneles();// Quitamos cualquier panel que pueda estar abierto para que no se duplique
        panelConsulta = new PnAdmConsulta();// Creamos el panel y le enviamos empresa y usuario
        this.getContentPane().add(panelConsulta);// Le añadimos el contenido
        pack();//Reorganizar
    }//GEN-LAST:event_menuConsultaActionPerformed

    private void quitarPaneles() {
        try {
            this.getContentPane().remove(panelNuevosCasos);
        } catch (Exception ex) {
        }
        try {
            this.getContentPane().remove(panelCierreCasos);
        } catch (Exception ex) {
        }
        try {
            this.getContentPane().remove(panelConsulta);
        } catch (Exception ex) {
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCaso;
    private javax.swing.JMenuItem menuCierre;
    private javax.swing.JMenuItem menuConsulta;
    private javax.swing.JMenuItem menuDesc;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
}
