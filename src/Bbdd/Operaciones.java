package Bbdd;

import Modelo.Accion;
import Modelo.Caso;
import Modelo.Personal;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Marta
 */
public class Operaciones {

    Conexion bd;

    public Operaciones(Conexion bd) {
        this.bd = bd;
    }

    public boolean existeUsuario(String aliaS, String contrA) {
        boolean resultado = false;
        contrA = utilidades.Encriptar.getMD5(contrA);

        String sql = "select * from tblpersonal where login ='" + aliaS + "' and contra ='" + contrA + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);//Poner un punto de interrupcion en este punto y comprobar
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public Personal existeUsuario2(String aliaS, String contrA) {

        Personal p = null;
        String sql = "select * from tblpersonal where login in ('" + aliaS + "') and contra in('" + contrA + "')";
        //String sql =select * from tblpersonal where login in ("a") and contra in ("202cb962ac59075b964b07152d234b70");
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                p = new Personal(registros.getString("dni"), registros.getString("nombre"), registros.getString("login"), registros.getString("contra"), registros.getString("perfil"));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public ArrayList<Personal> todosAbogados() {

        ArrayList<Personal> p = new ArrayList<>();
        String sql = "select * from tblpersonal where perfil in ('abogado')";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                p.add(new Personal(registros.getString("dni"), registros.getString("nombre"),
                        registros.getString("login"), registros.getString("contra"), registros.getString("perfil")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public ArrayList<Caso> todosCasos(String dnI) {

        ArrayList<Caso> c = new ArrayList<>();
        String sql = "select * from tblcasos where dni ='" + dnI + "'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                c.add(new Caso(registros.getString("codcaso"),dnI,
                        registros.getString("titulo"), registros.getString("descripcion"), registros.getString("situacion")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public boolean existeCaso(String codCaso) {
        boolean resultado = false;

        String sql = "select * from tblcasos where codcaso ='" + codCaso + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);//Poner un punto de interrupcion en este punto y comprobar
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public int grabarCaso(String codCaso, String dniA, String tit, String desc, String sit) {
        int resultado = 0;
        String sql;
        PreparedStatement sentencia;
        //Si existe el usuario, no se puede modificar, solo consultar
        if (!existeCaso(codCaso)) { //Si NO EXISTE

            // "INSERT INTO usuario (login,nombre) values ('"login"', '"nombre"')";  
            sql = "INSERT INTO tblcasos(codcaso,dni,titulo,descripcion,situacion) values ('"
                    + codCaso + "','" + dniA + "','" + tit + "','" + desc + "','" + sit + "')";

            try {
                sentencia = bd.getConexion().prepareStatement(sql);
                sentencia.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            resultado = -1;
        }

        return resultado;
    }
    
       public int grabarAccion(String codCaso, String codAcc, String fech, String desc) {
        int resultado = 0;
        String sql;
        PreparedStatement sentencia;
        //Si existe el usuario, no se puede modificar, solo consultar
        if (!existeAccion(codAcc)) { //Si NO EXISTE

            // "INSERT INTO usuario (login,nombre) values ('"login"', '"nombre"')";  
            sql = "INSERT INTO tblacciones(codcaso,codaccion,fecha,descripcion) values ('"
                    + codCaso + "','" + codAcc + "','" + fech + "','" + desc + "')";

            try {
                sentencia = bd.getConexion().prepareStatement(sql);
                sentencia.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            resultado = -1;
        }

        return resultado;
    }

    public ArrayList<Caso> casosAbiertos() {

        ArrayList<Caso> casos = new ArrayList<>();
        String sql = "select * from tblcasos where situacion in ('A')";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                casos.add(new Caso(registros.getString("codcaso"), registros.getString("dni"), registros.getString("titulo"), registros.getString("descripcion"), registros.getString("situacion")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return casos;
    }
    
        public ArrayList<Caso> casosAbiertos(String dniA) {

        ArrayList<Caso> casos = new ArrayList<>();
        String sql = "select * from tblcasos where dni in ('" + dniA + "') and situacion in ('A')";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                casos.add(new Caso(registros.getString("codcaso"), registros.getString("dni"), registros.getString("titulo"), registros.getString("descripcion"), registros.getString("situacion")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return casos;
    }

    public int cerrarCaso(String codC) {
        int resultado = 0;
        PreparedStatement sentencia;
        try {
            String sql = "UPDATE tblcasos SET situacion = 'C' where codcaso in ('" + codC + "')";
            sentencia = bd.getConexion().prepareStatement(sql);
            resultado = sentencia.executeUpdate();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public ArrayList<Personal> abogadosConCasosAbiertos() {

        ArrayList<Personal> a = new ArrayList<>();

        String sql = "select distinct tblpersonal.dni, tblpersonal.nombre from tblpersonal inner join tblcasos on tblpersonal.dni=tblcasos.dni where situacion in ('A')";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                a.add(new Personal(registros.getString("dni"), registros.getString("nombre")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
        public  ArrayList<Caso> casosAbiertosA(String dniA) {

        ArrayList<Caso> c = new ArrayList<>();
        String sql = "select * from tblcasos where situacion in ('A') and dni ='" + dniA + "'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
             
              c.add(new Caso(registros.getString("codcaso"),dniA,
                        registros.getString("titulo"),registros.getString("descripcion"),
                        "A"));
               
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
        
            public ArrayList<Accion> accionesAsignadas(String codCasO) {

        ArrayList<Accion> a = new ArrayList<>();
        String sql = "select * from tblacciones where codcaso ='" + codCasO + "'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
             
              a.add(new Accion(codCasO,registros.getString("codaccion"),registros.getString("fecha"),
                      registros.getString("descripcion")));
               
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }  
             
        
         public boolean existeAccion(String codA) {
        boolean resultado = false;

        String sql = "select codaccion from tblacciones where codaccion ='" + codA + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);//Poner un punto de interrupcion en este punto y comprobar
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }       
             
             
             
        

}
