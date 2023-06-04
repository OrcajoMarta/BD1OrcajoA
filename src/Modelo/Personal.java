/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Marta
 */
public class Personal {
    
String dni;
String nombre;
String login;
String contra;
String perfil;

    public Personal() {
    }

    public Personal(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }



    public Personal(String dni, String nombre, String login, String contra, String perfil) {
        this.dni = dni;
        this.nombre = nombre;
        this.login = login;
        this.contra = contra;
        this.perfil = perfil;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogin() {
        return login;
    }

    public String getContra() {
        return contra;
    }

    public String getPerfil() {
        return perfil;
    }
  
    
    @Override
    public String toString() {
        return nombre;
    }


    
    
}
