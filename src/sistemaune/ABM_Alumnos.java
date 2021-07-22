package sistemaune;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sistemaune.Conexion;

/**
 *
 * @author Fernando
 */
public class ABM_Alumnos extends javax.swing.JFrame {

    
    public ABM_Alumnos() {
        initComponents();
        mostrarDatos("","");
        this.setLocationRelativeTo(null);
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opciones_popupMenu = new javax.swing.JPopupMenu();
        editar_popup = new javax.swing.JMenuItem();
        borrar_popup = new javax.swing.JMenuItem();
        panel1 = new javax.swing.JPanel();
        nombre_label = new javax.swing.JLabel();
        cedula_label = new javax.swing.JLabel();
        nombre_textField = new javax.swing.JTextField();
        cedula_textField = new javax.swing.JTextField();
        contacto_label = new javax.swing.JLabel();
        contacto_textField = new javax.swing.JTextField();
        carrera_button = new javax.swing.JButton();
        panel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        panel2 = new javax.swing.JPanel();
        editar_button = new javax.swing.JButton();
        guardar_button = new javax.swing.JButton();
        panel3 = new javax.swing.JPanel();
        buscar_button = new javax.swing.JButton();
        busqueda_comboBox = new javax.swing.JComboBox<>();
        busqueda_textField = new javax.swing.JTextField();

        editar_popup.setText("Editar");
        editar_popup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_popupActionPerformed(evt);
            }
        });
        opciones_popupMenu.add(editar_popup);

        borrar_popup.setText("Borrar");
        borrar_popup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_popupActionPerformed(evt);
            }
        });
        opciones_popupMenu.add(borrar_popup);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nombre_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombre_label.setText("Nombre:");

        cedula_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cedula_label.setText("Cedula:");

        contacto_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contacto_label.setText("Contacto:");

        carrera_button.setText("Carrera");
        carrera_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrera_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre_label)
                            .addComponent(cedula_label)
                            .addComponent(contacto_label))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cedula_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contacto_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(carrera_button)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contacto_label)
                    .addComponent(contacto_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(carrera_button)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaAlumnos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaAlumnos.setComponentPopupMenu(opciones_popupMenu);
        jScrollPane2.setViewportView(tablaAlumnos);
        tablaAlumnos.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );

        panel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        editar_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editar_button.setText("Editar");
        editar_button.setToolTipText("");
        editar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_buttonActionPerformed(evt);
            }
        });

        guardar_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        guardar_button.setText("Guardar");
        guardar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardar_button)
                    .addComponent(editar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar_button)
                    .addComponent(editar_button))
                .addGap(76, 76, 76))
        );

        panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buscar_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscar_button.setText("Buscar");
        buscar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_buttonActionPerformed(evt);
            }
        });

        busqueda_comboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        busqueda_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Cedula" }));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(busqueda_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busqueda_textField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar_button)
                .addGap(58, 58, 58))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar_button)
                    .addComponent(busqueda_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busqueda_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_buttonActionPerformed
        if(nombre_textField.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el alumno en la tabla antes de editar, utiliza clic izquierdo sobre el alumno a editar");
        }else{
            try{
                System.out.println(idEditar);
                ca.actualizar(idEditar, nombre_textField.getText(), cedula_textField.getText(), contacto_textField.getText());
                mostrarDatos("","");
                idEditar = null;
                nombre_textField.setText("");
                cedula_textField.setText("");
                editar_button.setVisible(false);
                guardar_button.setVisible(true);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_editar_buttonActionPerformed

    private void guardar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_buttonActionPerformed
        if(nombre_textField.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "No puedes guardar un valor vació");
        }else{
            ca.guardar(nombre_textField.getText(), cedula_textField.getText(), contacto_textField.getText()); 
            mostrarDatos("","");
            nombre_textField.setText("");
            cedula_textField.setText("");
            contacto_textField.setText("");
        }
    }//GEN-LAST:event_guardar_buttonActionPerformed

    private void buscar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_buttonActionPerformed
        String valor = busqueda_textField.getText();
        String filtro = busqueda_comboBox.getSelectedItem().toString();
        if(filtro.equals("Nombre")){
            mostrarDatos(valor, "");
        }else{
            mostrarDatos("", valor);
        }
    }//GEN-LAST:event_buscar_buttonActionPerformed

    private void editar_popupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_popupActionPerformed
        int filaSeleccionada = tablaAlumnos.getSelectedRow();
        nombre_textField.setText(tablaAlumnos.getValueAt(filaSeleccionada, 1).toString().trim());
        cedula_textField.setText(tablaAlumnos.getValueAt(filaSeleccionada, 2).toString().trim());
        contacto_textField.setText(tablaAlumnos.getValueAt(filaSeleccionada, 3).toString().trim());
        idEditar = Integer.parseInt(tablaAlumnos.getModel().getValueAt(filaSeleccionada, 4).toString());
        editar_button.setVisible(true);
        carrera_button.setVisible(true);
        guardar_button.setVisible(false);
    }//GEN-LAST:event_editar_popupActionPerformed

    private void borrar_popupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_popupActionPerformed
        int filaSeleccionada = tablaAlumnos.getSelectedRow();
       
        idEditar = Integer.parseInt(tablaAlumnos.getModel().getValueAt(filaSeleccionada, 3).toString());
        ca.delete(idEditar);
        mostrarDatos("","");
        idEditar = null;
    }//GEN-LAST:event_borrar_popupActionPerformed

    private void carrera_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrera_buttonActionPerformed
        ABM_Alumnos_Materias abm = new ABM_Alumnos_Materias(idEditar);
        abm.setVisible(true);
    }//GEN-LAST:event_carrera_buttonActionPerformed

    // Own functions ***********************************************************
    void mostrarDatos(String nombre, String cedula){
        
        editar_button.setVisible(false);
        carrera_button.setVisible(false);
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Contador");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cedula");
        modelo.addColumn("Contacto");
        modelo.addColumn("Id");
        
        tablaAlumnos.setModel(modelo);
       
        String[] datos = new String[5];
        try{
            ResultSet rs = ca.buscar(nombre, cedula);
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
            tablaAlumnos.setModel(modelo);
            TableColumnModel tcm = tablaAlumnos.getColumnModel();
            tcm.removeColumn(tcm.getColumn(4));
            
        }catch(SQLException ex){
            System.out.println("Algo falló"+ex);
        }
        
        editar_button.setVisible(false);
    }
        
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABM_Alumnos().setVisible(true);
            }
        });
    }
    //Own Variables
    public ConexionAlumnos ca = new ConexionAlumnos();
//    
    public Integer idEditar = 0;
    
    public Integer idCarrera = 0;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem borrar_popup;
    private javax.swing.JButton buscar_button;
    private javax.swing.JComboBox<String> busqueda_comboBox;
    private javax.swing.JTextField busqueda_textField;
    private javax.swing.JButton carrera_button;
    private javax.swing.JLabel cedula_label;
    private javax.swing.JTextField cedula_textField;
    private javax.swing.JLabel contacto_label;
    private javax.swing.JTextField contacto_textField;
    private javax.swing.JButton editar_button;
    private javax.swing.JMenuItem editar_popup;
    private javax.swing.JButton guardar_button;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombre_label;
    private javax.swing.JTextField nombre_textField;
    private javax.swing.JPopupMenu opciones_popupMenu;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
