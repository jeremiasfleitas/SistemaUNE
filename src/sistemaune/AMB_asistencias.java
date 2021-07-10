/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaune;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Juan Fleitas
 */
public class AMB_asistencias extends javax.swing.JFrame {

    Conexion cc = new Conexion();
    Connection cn = cc.conexion();
    ArrayList mlistaAlumnos;
    ArrayList mlistaMaterias;
    ConexionAsistencias ca= new ConexionAsistencias();

    /*conexion mConexion;*/
    /**
     * Creates new form AMB_asistencias
     */
    public AMB_asistencias() {
        initComponents();
        ArrayList mlistaAlumnos = new ArrayList();
         ArrayList mlistaMaterias = new ArrayList();
        LlenarCBAlumnos();
        LlenarCBMaterias();
       
        Txtfecha.setDate(fechaActual());
        this.setLocationRelativeTo(null);
        //mostrardatos();
    }
    
    public void LlenarCBAlumnos() {
                cbAlumnos.removeAllItems();
                mlistaAlumnos = ca.getListaAlumnos();
                Iterator Iterador = mlistaAlumnos.iterator();
                
           while(Iterador.hasNext()) {
                Alumno mAlumnos = (Alumno) Iterador.next();
                cbAlumnos.addItem(mAlumnos);   
           }
         AutoCompleteDecorator.decorate(cbAlumnos);       
        }
    
    public void LlenarCBAlumnospormaterias(Integer id) {
                cbAlumnos.removeAllItems();
                mlistaAlumnos = ca.getListaAlumnospormaterias(id);
                Iterator Iterador = mlistaAlumnos.iterator();
                
           while(Iterador.hasNext()) {
                Alumno mAlumnos = (Alumno) Iterador.next();
               // System.out.println("Cargar:" + mAlumnos.getId_materia());
                cbAlumnos.addItem(mAlumnos);   
           }
                
        } 
    
    public void LlenarCBMaterias(){
               cbMaterias.removeAllItems();
               mlistaMaterias = ca.getListaMaterias();
                Iterator Iterador = mlistaMaterias.iterator();
                
           while(Iterador.hasNext()) {
              Materia mMaterias = (Materia) Iterador.next();
                cbMaterias.addItem(mMaterias); 
                cbinforme.addItem(mMaterias);
           }
         AutoCompleteDecorator.decorate(cbMaterias);
    }  
    
    
    public void buscarmaterias(Integer id){
        String sql= "SELECT * FROM materias WHERE id_materia= "+id+""; 
        try {
            Statement ts = cn.createStatement();
            ResultSet rs = ts.executeQuery(sql);
            rs.next();
            //lbid.setText("Código:"+ rs.getInt(1)+ rs.getString(2));
            LlenarCBAlumnospormaterias(rs.getInt(1));
            }
        
        catch(Exception ex){}   
    }
    
    public static Date fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = null;
        return(fecha);
    }
    
    
    public void buscarasistencia(){
        String sql= "SELECT nombre_alumno, presencia_asistencia, fecha_asistencia, nombre_materia FROM alumnos, materias, asistencias"; 
        try {
            Statement ts = cn.createStatement();
            ResultSet rs = ts.executeQuery(sql);
            rs.next();
            System.out.println("Código:"+ rs.getInt(1)+ rs.getString(2) + rs.getString(3));
            }
        catch(Exception ex){}   
    }
       //recibir variable 
    void mostrardatos(){        
        DefaultTableModel modelo = new DefaultTableModel(); 
        modelo.addColumn ("Nombre");
        modelo.addColumn ("Estado");
        modelo.addColumn ("Fecha");
        modelo.addColumn ("Materia");
        
        tablaAsistencia.setModel(modelo);
         Alumno Alumno = (Alumno) cbAlumnos.getSelectedItem();
        String sql = "SELECT a.nombre_alumno, asis.presencia_asistencia, asis.fecha_asistencia, m.nombre_materia   FROM alumnos a, materias m, asistencias asis, alumnos_materias am "
                + "WHERE" + " asis.fecha_asistencia= '"+ Txtfecha.getDate()+"'" 
                + " and am.id_alumno_materia = asis.id_alumno_materia and am.id_alumno = a.id_alumno and m.id_materia = am.id_materia";
     
    String [] datos = new String [4];
    try {
            Statement ts = cn.createStatement();
            ResultSet rs = ts.executeQuery(sql);
            
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                modelo.addRow(datos);
            }
            
         tablaAsistencia.setModel (modelo);
     } catch (SQLException ex) {
         Logger.getLogger(AMB_asistencias.class.getName()).log(Level.SEVERE, null, ex);   
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

        jPanel6 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        txtreporte = new com.toedter.calendar.JDateChooser();
        fechainicio = new com.toedter.calendar.JDateChooser();
        cbinforme = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAsistencia = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cbAlumnos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbAsistencia = new javax.swing.JComboBox<>();
        btnguardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbMaterias = new javax.swing.JComboBox<>();
        Txtfecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnbuscar.setText(" Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        cbinforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbinformeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("REPORTE");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(cbinforme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtreporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnbuscar)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(266, 266, 266))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnbuscar)
                    .addComponent(fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbinforme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtreporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tablaAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaAsistencia.setToolTipText("");
        tablaAsistencia.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tablaAsistencia);
        tablaAsistencia.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Materia: ");

        jButton1.setText("Seleccionar carrera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnosActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("  Estado:");

        cbAsistencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presente", "Ausente", "Virtual" }));
        cbAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAsistenciaActionPerformed(evt);
            }
        });

        btnguardar.setText(" Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha asistencia");

        cbMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Carga de Asistencias");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnguardar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel5)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnguardar)
                        .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Materia M = (Materia) cbMaterias.getSelectedItem();
        System.out.println(M.getNombre_materia());
        if(M.getNombre_materia().length()>0){ 
          buscarmaterias(M.getId_materia());  
         
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String path = "C:\\Users\\ACER\\Documents\\NetBeansProjects\\SistemaUNE\\src\\sistemaune\\InformeAsistencias.jasper"; //Ponemos la localizacion del reporte creado
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            HashMap map = new HashMap();
            System.out.println();
            
           map.put("FechaInicio", fechainicio.getDate());
           map.put("FechaFin", txtreporte.getDate());
           Materia M = (Materia) cbinforme.getSelectedItem();
           map.put("Carrera", M.getNombre_materia());
           map.put("id_carrera", M.getId_materia());
           
            JasperPrint jasperPrint = null;
            Connection connection = null;
            //map.put("p_StuID","MCA001"); 
JasperPrint jprint = JasperFillManager.fillReport(reporte, map, cc.conexion());
            JasperViewer viewer = new JasperViewer(jprint, false); 
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Se declara con dispose_on_close para que no se cierre el programa cuando se cierre el reporte
            viewer.setVisible(true); //Se vizualiza el reporte
        } catch (JRException ex) { 
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        Alumno Alumno= (Alumno) cbAlumnos.getSelectedItem();
        String Fecha= Txtfecha.getDate().toString();
        Date fecha2=null; 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = null;
        java.sql.Date data = null;
        /*try {
        parsed = sdf.parse(Txtfecha.getDate().toString());
        data = new java.sql.Date(parsed.getTime()); 
        } catch (ParseException e1) {
        e1.printStackTrace();
     }*/
        data = new java.sql.Date(Txtfecha.getDate().getTime());
        String Presente= cbAsistencia.getSelectedItem().toString();
        Integer id_alumno_materia = Alumno.getId_alumno();   
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO asistencias (id_alumno_materia, fecha_asistencia, presencia_asistencia) VALUES (?,?,?)");
            pst.setInt(1, id_alumno_materia);
            pst.setDate(2, (java.sql.Date) data);
            pst.setString(3, Presente);
            pst.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(AMB_asistencias.class.getName()).log(Level.SEVERE, null, ex);
        } 
           mostrardatos();      

    }//GEN-LAST:event_btnguardarActionPerformed

    private void cbAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAsistenciaActionPerformed

    private void cbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAlumnosActionPerformed

    private void cbMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMateriasActionPerformed

    private void cbinformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbinformeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbinformeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AMB_asistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AMB_asistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AMB_asistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AMB_asistencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AMB_asistencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Txtfecha;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<Alumno> cbAlumnos;
    private javax.swing.JComboBox<String> cbAsistencia;
    private javax.swing.JComboBox<Materia> cbMaterias;
    private javax.swing.JComboBox<Materia> cbinforme;
    private com.toedter.calendar.JDateChooser fechainicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAsistencia;
    private com.toedter.calendar.JDateChooser txtreporte;
    // End of variables declaration//GEN-END:variables

}
