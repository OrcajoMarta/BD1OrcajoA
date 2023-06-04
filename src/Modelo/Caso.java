/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Marta
 */
public class Caso {
    
    String codCaso;
    String dni;
    String titulo;
    String descripcion;
    String situacion;

    public Caso(String codCaso, String dni, String titulo, String descripcion, String situacion) {
        this.codCaso = codCaso;
        this.dni = dni;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    public String getCodCaso() {
        return codCaso;
    }

    public String getDni() {
        return dni;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSituacion() {
        return situacion;
    }

    @Override
    public String toString() {
        return codCaso;
    }

  
    
    
    
    
}
