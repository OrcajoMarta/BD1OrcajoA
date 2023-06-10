/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bbdd;


import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;

/**
 *
 * @author Marta
 */
public class Conexion {
    Connection conexion;

    /**
     * Método para registrar Driver
     * @return resultado
     */
    
    public int registrarDriver(){ 
        // METODO PARA REGISTRAR EL DRIVER DE MYSQL
        int resultado;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Buscame la clase con el nombre...
       resultado=0; // Si la encuentras... resultado=0
        } catch (ClassNotFoundException ex) { //Error clase no encontrada
        // La siguiente línea es un mensaje con la información del error. Se puede poner un System.out.println   
        java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        resultado=-1; // Si NO  la encuentras... resultado=-1
        }
        return resultado;
    }
    
    /**
     * Método para conectar a la BBDD
     * @param url
     * @return resultado
     */
    public int conectar(String url){ 
        
        int resultado;
     
        try {
            conexion=DriverManager.getConnection(url,"root","admin");
            /*Base de datos a la que quiero acceder*/
            /*usuario que se está conectando*/
            /*contraseña con la que se está conectando*/
            
              resultado=0; // Si la encuentras... resultado=0
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         resultado=-1; // Si NO  la encuentras... resultado=-1
        }

        return resultado;
    }
     
    /**
     * Método para establecer conexion con la BBDD
     * @param url
     * @return resultado
     */
    public int establecer(String url){
         int resultado;
         resultado=registrarDriver(); //Si es diferente a -1, lo ha encontrado
         if(resultado!=-1){ // Si el raesultado es diferente a -1...
             resultado=conectar(url); // conectar
         }
         return resultado;
     }
    
    /**
     * Método para cerrar conexión
     */
    
    public void cerrar(){ 
       // Método para quitar la conexión
        try {
            conexion.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }  
    }

  
    
    public Connection getConexion() {
        return conexion;
    }
     
} //fin clase
