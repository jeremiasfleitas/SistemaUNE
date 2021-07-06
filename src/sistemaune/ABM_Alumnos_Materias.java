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
        label_alumno = new javax.swing.JLabel();
        label_campoAlumno = new javax.swing.JLabel();
        comboBox_carrera = new javax.swing.JComboBox<>();
        label_carrera = new javax.swing.JLabel();
        label_semestre = new javax.swing.JLabel();
        comboBox_semestre = new javax.swing.JComboBox<>();
        button_cancelar = new javax.swing.JButton();
        label_materias = new javax.swing.JLabel();
        label_materiasCursadas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_materias = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_materiasCursadas = new javax.swing.JTable();

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

        label_alumno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_alumno.setText("Alumno");

        label_campoAlumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_campoAlumno.setText("...");

        comboBox_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_carreraActionPerformed(evt);
            }
        });

        label_carrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_carrera.setText("Carrera:");

        label_semestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_semestre.setText("Semestre:");

        comboBox_semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_semestreActionPerformed(evt);
            }
        });

        button_cancelar.setText("Cancelar");
        button_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelarActionPerformed(evt);
            }
        });

        label_materias.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_materias.setText("Materias");

        label_materiasCursadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_materiasCursadas.setText("Materias Cursadas");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(label_materias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_materiasCursadas)
                .addGap(195, 195, 195))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_carrera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 19, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_alumno)
                                .addGap(183, 183, 183))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_semestre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBox_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_campoAlumno)
                        .addGap(205, 205, 205))))
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(button_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_carrera)
                    .addComponent(label_alumno))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_semestre)
                            .addComponent(comboBox_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_campoAlumno)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_materias)
                    .addComponent(label_materiasCursadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(button_cancelar)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBox_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_carreraActionPerformed
        actualizarTablas();
    }//GEN-LAST:event_comboBox_carreraActionPerformed

    private void comboBox_semestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_semestreActionPerformed
        actualizarTablas();
    }//GEN-LAST:event_comboBox_semestreActionPerformed

    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_button_cancelarActionPerformed

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
    private javax.swing.JButton button_cancelar;
    private javax.swing.JComboBox<Carrera> comboBox_carrera;
    private javax.swing.JComboBox<String> comboBox_semestre;
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
