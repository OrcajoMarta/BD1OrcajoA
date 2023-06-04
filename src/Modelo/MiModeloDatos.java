/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marta
 */
public class MiModeloDatos extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {

        boolean resultado = true;

        if (column == 0) {
            // Si la columna es 0, no te la dejo modificar (false)
            resultado = false;
        }

        return resultado;
    }

}
