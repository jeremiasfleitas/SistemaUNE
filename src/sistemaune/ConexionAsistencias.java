/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaune;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class ConexionAsistencias {
      private static Connection Conection;
        private static Statement Sentencia;
        private static ResultSet Resultado;
        Conexion cc= new Conexion ();
    
    public ArrayList getListaAlumnos() {
        ArrayList mListaAlumnos = new ArrayList();
        Alumno mAlumnos= null;
        Statement consulta;
        ResultSet resultado;
        
       try {
                consulta = cc.conexion().createStatement();
                resultado = consulta.executeQuery("SELECT * FROM alumnos");
                      
              while(resultado.next()){
                  mAlumnos = new Alumno(); 
                  mAlumnos.setId_alumno(resultado.getInt(1));
                  mAlumnos.setNombre_alumno(resultado.getString(2));
                  mListaAlumnos.add(mAlumnos);   
                }             
            } catch (SQLException e) {
            }             
    
            return mListaAlumnos;
       }
        

        
        public ArrayList getListaAlumnospormaterias(Integer id) {
        ArrayList mListaAlumnos = new ArrayList();
        Alumno mAlumnos= null;
        Statement consulta;
        ResultSet resultado;
        
       try {
                consulta = cc.conexion().createStatement();
                resultado = consulta.executeQuery("SELECT am.id_alumno_materia, a.nombre_alumno, am.id_materia FROM alumnos a, alumnos_materias am, materias m WHERE a.id_alumno = am.id_alumno and am.id_materia = m.id_materia and am.id_materia =  " + id);
                      
              while(resultado.next()){
                  mAlumnos = new Alumno(); 
                  mAlumnos.setId_alumno(resultado.getInt(1));
                  mAlumnos.setNombre_alumno(resultado.getString(2));
                  mListaAlumnos.add(mAlumnos);   
                }             
            } catch (SQLException e) {
            }             
    
            return mListaAlumnos;
       }

    ArrayList getListaMaterias() {
        ArrayList mListaMaterias = new ArrayList();
        Materia mMaterias= null;
        Statement consulta;
        ResultSet resultado;
        
       try {
                consulta = cc.conexion().createStatement();
                resultado = consulta.executeQuery("SELECT id_materia, nombre_materia, nombre_carrera FROM materias, carreras WHERE materias.id_carrera= carreras.id_carrera");
                      
              while(resultado.next()){
                  mMaterias = new Materia(); 
                  mMaterias.setId_materia(resultado.getInt(1));
                  mMaterias.setNombre_materia(resultado.getString(2)+" "+ resultado.getString(3));
                  mListaMaterias.add(mMaterias);   
                }             
            } catch (SQLException e) {
            }             
    
            return mListaMaterias;
    }
}
