/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaune;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fernando
 */
public class ABM_Alumnos_Materias extends javax.swing.JFrame {

    //Own Variables
    private int alumno;
    private ConexionAlumnosMaterias cc = new ConexionAlumnosMaterias();
    private ConexionCarreras cca = new ConexionCarreras();
    
    private ArrayList listaCarreras;
    
    public ABM_Alumnos_Materias(int id_alumno) {
        initComponents();
        alumno = id_alumno;
        mostrarDatosCompletos();
        this.setLocationRelativeTo(null);
    }

    public void mostrarDatosCompletos(){
        
        mostrarNombre();
        mostrarCarreras();
        mostrarSemestre();
        actualizarTablas();
    }
    
    public void actualizarTablas(){
        mostrarMaterias();
        mostarMateriasCursadas();
    }
    
    public void mostrarNombre(){
        ResultSet rs = cc.buscarNombreAlumno(alumno);
        try {
            while(rs.next()){
                label_campoAlumno.setText(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ABM_Alumnos_Materias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarCarreras(){
        comboBox_carrera.removeAllItems();
        listaCarreras = cca.getListaCarreras();
        Iterator iterador = listaCarreras.iterator();
        while(iterador.hasNext()){
            Carrera carrera = (Carrera) iterador.next();
            comboBox_carrera.addItem(carrera);
        }
        //AutoCompleteDecorator.decorate(comboBox_carrera);
    }
    
    public void mostrarSemestre(){
        comboBox_semestre.removeAllItems();
        for (int i = 1; i <= 10; i++) {
           comboBox_semestre.addItem(String.valueOf(i)); 
        }
    }
    
    public void mostrarMaterias(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Contador");
        modelo.addColumn("Nombre");
        modelo.addColumn("Semestre");
        modelo.addColumn("Carrera");
        modelo.addColumn("Id");
        
        table_materias.setModel(modelo);
       
        String[] datos = new String[5];
        try{
            ResultSet rs = cc.buscarMaterias(comboBox_semestre.getSelectedIndex()+1, ((Carrera)comboBox_carrera.getSelectedItem()).getId() );
            int i = 1;
            while(rs.next()){
                datos[0] = String.valueOf(i);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(1);
                                
                modelo.addRow(datos);
                i++;
            }
            table_materias.setModel(modelo);
            TableColumnModel tcm = table_materias.getColumnModel();
            tcm.removeColumn(tcm.getColumn(4));
            tcm.removeColumn(tcm.getColumn(3));
            tcm.removeColumn(tcm.getColumn(2));
            
        }catch(SQLException ex){
            System.out.println("Algo falló");
        }
        
        
    }
    
    
    
    public void mostarMateriasCursadas(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Contador");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        modelo.addColumn("Carrera");
        modelo.addColumn("Semestre");
        modelo.addColumn("Id Carrera");
        modelo.addColumn("Id Materia");
        modelo.addColumn("Id Materia_Alumno");
        
        table_materiasCursadas.setModel(modelo);
       
        String[] datos = new String[8];
        try{
            ResultSet rs = cc.buscarAlumnosMaterias(alumno);
            int i = 1;
            while(rs.next()){
                datos[0] = String.valueOf(i);
                datos[1] = rs.getString(6);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(10);
                datos[4] = rs.getString(7);
                datos[5] = rs.getString(8);
                datos[6] = rs.getString(3);
                datos[7] = rs.getString(1);;
                        
                modelo.addRow(datos);
                i++;
            }
            table_materiasCursadas.setModel(modelo);
            TableColumnModel tcm = table_materiasCursadas.getColumnModel();
            tcm.removeColumn(tcm.getColumn(7));
            tcm.removeColumn(tcm.getColumn(6));
            tcm.removeColumn(tcm.getColumn(5));
            
        }catch(SQLException ex){
            System.out.println("Algo falló");
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

        popUp_materias = new javax.swing.JPopupMenu();
        menuItem_agregar = new javax.swing.JMenuItem();
        popUp_materias_cursadas = new javax.swing.JPopupMenu();
        menuItem_borrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        label_carrera = new javax.swing.JLabel();
        comboBox_carrera = new javax.swing.JComboBox<>();
        label_semestre = new javax.swing.JLabel();
        comboBox_semestre = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        label_alumno = new javax.swing.JLabel();
        label_campoAlumno = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label_materias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_materias = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_materiasCursadas = new javax.swing.JTable();
        label_materiasCursadas = new javax.swing.JLabel();

        menuItem_agregar.setText("Subscribir");
        menuItem_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_agregarActionPerformed(evt);
            }
        });
        popUp_materias.add(menuItem_agregar);

        menuItem_borrar.setText("Desubscribir");
        menuItem_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_borrarActionPerformed(evt);
            }
        });
        popUp_materias_cursadas.add(menuItem_borrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_carrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_carrera.setText("Carrera:");

        comboBox_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_carreraActionPerformed(evt);
            }
        });

        label_semestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_semestre.setText("Semestre:");

        comboBox_semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_semestreActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label_alumno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_alumno.setText("Alumno:");

        label_campoAlumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_campoAlumno.setText("...");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(label_campoAlumno))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(label_alumno)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_alumno)
                .addGap(18, 18, 18)
                .addComponent(label_campoAlumno)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_semestre)
                    .addComponent(label_carrera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_carrera)
                            .addComponent(comboBox_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_semestre)
                            .addComponent(comboBox_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label_materias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_materias.setText("Materias");

        table_materias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_materias.setComponentPopupMenu(popUp_materias);
        jScrollPane1.setViewportView(table_materias);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(label_materias)
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_materias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        table_materiasCursadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_materiasCursadas.setComponentPopupMenu(popUp_materias_cursadas);
        jScrollPane2.setViewportView(table_materiasCursadas);

        label_materiasCursadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_materiasCursadas.setText("Materias Cursadas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(label_materiasCursadas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_materiasCursadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBox_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_carreraActionPerformed
        actualizarTablas();
    }//GEN-LAST:event_comboBox_carreraActionPerformed

    private void comboBox_semestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_semestreActionPerformed
        actualizarTablas();
    }//GEN-LAST:event_comboBox_semestreActionPerformed

    private void menuItem_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_agregarActionPerformed
        int fila = table_materias.getSelectedRow();
        //4 es la columna de la JTable donde está cargado el id de materia, está oculto.
        int idMateria = Integer.parseInt(table_materias.getModel().getValueAt(fila, 4).toString().trim()); 
        int[] materias = new int[table_materiasCursadas.getRowCount()];
        for (int i = 0; i < materias.length; i++) {
            materias[i] = Integer.parseInt(table_materiasCursadas.getModel().getValueAt(i, 6).toString().trim());;
        }
        for (int id : materias) {
            if(id==idMateria){
                JOptionPane.showMessageDialog(rootPane, "Esta materia ya está vinculada al alumno", "Atención", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        cc.guardarAlumnoMateria(alumno, idMateria);
        actualizarTablas();
    }//GEN-LAST:event_menuItem_agregarActionPerformed

    private void menuItem_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_borrarActionPerformed
        int fila = table_materiasCursadas.getSelectedRow();
        //4 es la columna de la JTable donde está cargado el id de materia, está oculto.
        int idMateriaAlumno = Integer.parseInt(table_materiasCursadas.getModel().getValueAt(fila, 7).toString().trim());
        cc.deleteAlumnoMateria(idMateriaAlumno);
        actualizarTablas();
    }//GEN-LAST:event_menuItem_borrarActionPerformed

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
            java.util.logging.Logger.getLogger(ABM_Alumnos_Materias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABM_Alumnos_Materias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABM_Alumnos_Materias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABM_Alumnos_Materias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABM_Alumnos_Materias(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Carrera> comboBox_carrera;
    private javax.swing.JComboBox<String> comboBox_semestre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_alumno;
    private javax.swing.JLabel label_campoAlumno;
    private javax.swing.JLabel label_carrera;
    private javax.swing.JLabel label_materias;
    private javax.swing.JLabel label_materiasCursadas;
    private javax.swing.JLabel label_semestre;
    private javax.swing.JMenuItem menuItem_agregar;
    private javax.swing.JMenuItem menuItem_borrar;
    private javax.swing.JPopupMenu popUp_materias;
    private javax.swing.JPopupMenu popUp_materias_cursadas;
    private javax.swing.JTable table_materias;
    private javax.swing.JTable table_materiasCursadas;
    // End of variables declaration//GEN-END:variables
}
