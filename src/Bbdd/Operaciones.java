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

    /**
     * Método para comprobar si existe usuario
     *
     * @param aliaS
     * @param contrA
     * @return resultado
     */
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

    /**
     * Método para comprobar si existe usuario
     *
     * @param aliaS
     * @param contrA
     * @return p
     */
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

    /**
     * Método para obtener todos los trabajadores con perfil abogado
     *
     * @return ArrayList
     */
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

    /**
     * Método para conseguir los casos de un determinado abogado
     *
     * @param dnI
     * @return c
     */
    public ArrayList<Caso> todosCasos(String dnI) {

        ArrayList<Caso> c = new ArrayList<>();
        String sql = "select * from tblcasos where dni ='" + dnI + "'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                c.add(new Caso(registros.getString("codcaso"), dnI,
                        registros.getString("titulo"), registros.getString("descripcion"), registros.getString("situacion")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    /**
     * Método para comprobar si existe un caso
     *
     * @param codCaso
     * @return resultado
     */
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

    /**
     * Método para grabar caso nuevo
     *
     * @param codCaso
     * @param dniA
     * @param tit
     * @param desc
     * @param sit
     * @return resultado
     */
    public int grabarCaso(String codCaso, String dniA, String tit, String desc, String sit) {
        int resultado = 0;
        String sql;
        PreparedStatement sentencia;

        if (!existeCaso(codCaso)) { //Si NO EXISTE

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

    /**
     * Método para grabar acción nueva
     *
     * @param codCaso
     * @param codAcc
     * @param fech
     * @param desc
     * @return resultado
     */
    public int grabarAccion(String codCaso, String codAcc, String fech, String desc) {
        int resultado = 0;
        String sql;
        PreparedStatement sentencia;

        if (!existeAccion(codAcc, codCaso)) { //Si NO EXISTE

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

    /**
     * Método para obtener todos casos que estén abiertos
     *
     * @return
     */
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

    /**
     * Método para obtener los casos abiertos de un abogado en concreto
     *
     * @param dniA
     * @return
     */
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

    /**
     * Método para cerrar un caso
     *
     * @param codC
     * @return resultado
     */
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

    /**
     * Método para obtener los abogados con casos abiertos
     *
     * @return a
     */
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

    /**
     * Método para obtener los casos que estén abiertos
     *
     * @param dniA
     * @return
     */
    public ArrayList<Caso> casosAbiertosA(String dniA) {

        ArrayList<Caso> c = new ArrayList<>();
        String sql = "select * from tblcasos where situacion in ('A') and dni ='" + dniA + "'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {

                c.add(new Caso(registros.getString("codcaso"), dniA,
                        registros.getString("titulo"), registros.getString("descripcion"),
                        "A"));

            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    /**
     * Método para obtener las acciones asignadas a un caso
     *
     * @param codCasO
     * @return a
     */
    public ArrayList<Accion> accionesAsignadas(String codCasO) {

        ArrayList<Accion> a = new ArrayList<>();
        String sql = "select * from tblacciones where codcaso ='" + codCasO + "'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {

                a.add(new Accion(codCasO, registros.getString("codaccion"), registros.getString("fecha"),
                        registros.getString("descripcion")));

            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    /**
     * Método para comprobar si ya existe una acción
     *
     * @param codA
     * @return resultado
     */
    public boolean existeAccion(String codA, String codCaso) {
        boolean resultado = false;

        String sql = "select codaccion from tblacciones where codaccion ='" + codA + "' and codcaso ='" + codCaso + "'";
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

    public Personal dimeNombreAbogado(String dni) {

        Personal a = null;

        String sql = "select nombre from tblpersonal where dni ='"+dni+"'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                a = new Personal(registros.getString("nombre"));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

} //fin operaciones
