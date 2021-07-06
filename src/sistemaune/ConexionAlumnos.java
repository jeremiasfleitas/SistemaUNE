/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaune;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class ConexionAlumnos {
    public Conexion cc = new Conexion();
    public Connection cn = cc.conexion();
    
    public ResultSet buscar(String nombre, String cedula){
        String sql="";
        if(cedula.equals("") && nombre.equals("")){
            sql = "SELECT * FROM alumnos";
        }else{
            if(nombre.equals("")){
                sql = "SELECT * FROM alumnos WHERE documento_alumno='"+cedula+"'";
            }else{
                sql = "SELECT * FROM alumnos WHERE nombre_alumno='"+nombre+"'";
            }
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void guardar(String nombre, String cedula, String contacto){
        try{
            PreparedStatement pst = cc.conexion().prepareStatement("INSERT INTO alumnos(nombre_alumno,documento_alumno,contacto_alumno) VALUES (?,?,?)");
            pst.setString(1, nombre);
            pst.setString(2, cedula);
            pst.setString(3, contacto);
            pst.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizar(Integer id, String nombre, String cedula, String contacto){
        try {
            PreparedStatement pst;
            pst = cc.conexion().prepareStatement("UPDATE alumnos SET nombre_alumno='?', documento_alumno='?', contacto_alumno='?' WHERE id_alumno='?'");
            pst.setString(1, nombre);
            pst.setString(2, cedula);
            pst.setString(3, contacto);
            pst.setInt(4, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
        try {
            PreparedStatement pst;
            pst = cc.conexion().prepareStatement("DELETE FROM alumnos WHERE id_alumno='?'");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
