/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaune;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class ConexionMaterias {
    public Conexion cc = new Conexion();
    public Connection cn = cc.conexion();
    
    public ResultSet buscar(String nombre){
        String sql="";
        if(nombre.equals("")){
            sql = "SELECT * FROM materias";
        }else{
            sql = "SELECT * FROM materias WHERE nombre_materia='"+nombre+"'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMaterias.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void guardar(String nombre, int anho, int carrera){
        try{
            PreparedStatement pst = cc.conexion().prepareStatement("INSERT INTO materias(nombre_materia, anho_materia, id_carrera) VALUES (?,?,?)");
            pst.setString(1, nombre);
            pst.setInt(2, anho);
            pst.setInt(3, carrera);
            pst.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizar(Integer id, String nombre, int anho, int carrera){
        try {
            PreparedStatement pst;
            pst = cc.conexion().prepareStatement("UPDATE materias SET nombre_materia='"+nombre+"', anho_materia='"+anho+"', id_carrera='"+carrera+"'WHERE id_materia='"+id+"'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMaterias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
        try {
            PreparedStatement pst;
            pst = cc.conexion().prepareStatement("DELETE FROM materias WHERE id_materia='"+id+"'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMaterias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getListaCarreras(){
        ArrayList listaCarreras = new ArrayList();
        Carrera carrera = null;
        Statement consulta;
        ResultSet resultado;
        try {
            consulta = cn.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM carreras");
            while(resultado.next()){
                carrera = new Carrera();
                carrera.setId(resultado.getInt("id_carrera"));
                carrera.setNombre(resultado.getString("nombre_carrera"));
                listaCarreras.add(carrera);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMaterias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCarreras;
    }
}
