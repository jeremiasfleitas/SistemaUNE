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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author Fernando
 */
public class ABM_Materias extends javax.swing.JFrame {

    
    public ABM_Materias() {
        initComponents();
        listaCarreras = new ArrayList();
        llenarCBCarreras();
        mostrarDatos("");
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
        nombre_textField = new javax.swing.JTextField();
        carrera_label = new javax.swing.JLabel();
        carreras_comboBox = new javax.swing.JComboBox<>();
        anho_label = new javax.swing.JLabel();
        anho_textField = new javax.swing.JTextField();
        panel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();
        panel2 = new javax.swing.JPanel();
        editar_button = new javax.swing.JButton();
        guardar_button = new javax.swing.JButton();
        panel3 = new javax.swing.JPanel();
        buscar_button = new javax.swing.JButton();
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

        panel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nombre_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombre_label.setText("Nombre:");

        carrera_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        carrera_label.setText("Carrera:");

        anho_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        anho_label.setText("Semestre:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(carrera_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(carreras_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addComponent(nombre_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(anho_label)
                        .addGap(65, 65, 65)
                        .addComponent(anho_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)))
                .addGap(98, 98, 98))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_label)
                    .addComponent(nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carrera_label)
                    .addComponent(carreras_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anho_label)
                    .addComponent(anho_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        panel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaMaterias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMaterias.setComponentPopupMenu(opciones_popupMenu);
        jScrollPane2.setViewportView(tablaMaterias);
        tablaMaterias.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
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
                .addGap(44, 44, 44)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(guardar_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editar_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editar_button)
                .addGap(43, 43, 43)
                .addComponent(guardar_button)
                .addGap(52, 52, 52))
        );

        panel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buscar_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscar_button.setText("Buscar");
        buscar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(busqueda_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscar_button)
                .addGap(49, 49, 49))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar_button)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_buttonActionPerformed
        if(nombre_textField.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Debes seleccionar la materia en la tabla antes de editar, utiliza clic izquierdo sobre la materia a editar");
        }else{
            try{
                int anho = Integer.parseInt(anho_textField.getText().trim());
                Carrera carrera = (Carrera) carreras_comboBox.getSelectedItem();
                System.out.println(idEditar);
                System.out.println(anho);
                System.out.println(nombre_textField.getText());
                System.out.println(carrera.getId());
                cm.actualizar(idEditar, nombre_textField.getText(), anho, carrera.getId());
                mostrarDatos("");
                idEditar = null;
                nombre_textField.setText("");
                anho_textField.setText("");
                carreras_comboBox.setSelectedIndex(0);
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(rootPane, "El año debe ser de tipo numérico y no debe contener espacios!!!");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_editar_buttonActionPerformed

    private void guardar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_buttonActionPerformed
        if(nombre_textField.getText().equals("") || anho_textField.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "No puede agregar valores vacíos");
        }else{
            try{
                int anho = Integer.parseInt(anho_textField.getText().trim());
                Carrera carrera = (Carrera) carreras_comboBox.getSelectedItem();
                cm.guardar(nombre_textField.getText(), anho, carrera.getId());
                mostrarDatos("");
                nombre_textField.setText("");
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(rootPane, "El año debe ser de tipo numérico y no debe contener espacios!!!");
            }
           
              
        } 
    }//GEN-LAST:event_guardar_buttonActionPerformed

    private void buscar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_buttonActionPerformed
        String valor = busqueda_textField.getText();
        mostrarDatos(valor);
    }//GEN-LAST:event_buscar_buttonActionPerformed

    private void editar_popupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_popupActionPerformed
        int filaSeleccionada = tablaMaterias.getSelectedRow();
        nombre_textField.setText(tablaMaterias.getValueAt(filaSeleccionada, 1).toString());
        anho_textField.setText(tablaMaterias.getValueAt(filaSeleccionada, 2).toString());
        
        String nombreCarreraTabla = tablaMaterias.getValueAt(filaSeleccionada, 3).toString().trim();
        //Bucle para cambiar el comboBox a la materia Seleccionada
        for (int i = 0; i < carreras_comboBox.getItemCount(); i++) {
            Carrera carrera = (Carrera) carreras_comboBox.getItemAt(i);
            if(nombreCarreraTabla.equals(carrera.getNombre().trim())){
                carreras_comboBox.setSelectedIndex(i);
            }
        }
        idEditar = Integer.parseInt(tablaMaterias.getModel().getValueAt(filaSeleccionada, 4).toString());
    }//GEN-LAST:event_editar_popupActionPerformed

    private void borrar_popupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_popupActionPerformed
        int filaSeleccionada = tablaMaterias.getSelectedRow();
        idEditar = Integer.parseInt(tablaMaterias.getModel().getValueAt(filaSeleccionada, 4).toString());
        cm.delete(idEditar);
        mostrarDatos("");
        idEditar = null;
    }//GEN-LAST:event_borrar_popupActionPerformed

    // Own functions ***********************************************************
    void mostrarDatos(String nombre){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Contador");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        modelo.addColumn("Carrera");
        modelo.addColumn("Id");
        
        
        tablaMaterias.setModel(modelo);
       
        String[] datos = new String[5];
        try{
            ResultSet rs = cm.buscar(nombre);
            int i = 1;
            while(rs.next()){
                datos[0] = String.valueOf(i);
                datos[1] = rs.getString(2).trim();
                datos[2] = rs.getString(3).trim();
                for (int j = 0; j < listaCarreras.size(); j++) {
                   int carreraNumero =  Integer.parseInt(rs.getString(4).trim());
                   Carrera carrera = (Carrera) listaCarreras.get(j);
                   if(carrera.getId() == carreraNumero){
                       datos[3] = carrera.getNombre().trim(); 
                   }
                }
                datos[4] = rs.getString(1).trim(); 
                modelo.addRow(datos);
                i++;
            }
            tablaMaterias.setModel(modelo);
            TableColumnModel tcm = tablaMaterias.getColumnModel();
            tcm.removeColumn(tcm.getColumn(4));
            
        }catch(SQLException ex){
            System.out.println("Algo falló");
        }
    }
        
    public void llenarCBCarreras(){
        carreras_comboBox.removeAllItems();
        listaCarreras = cm.getListaCarreras();
        Iterator iterador = listaCarreras.iterator();
        while(iterador.hasNext()){
            Carrera carrera = (Carrera) iterador.next();
            carreras_comboBox.addItem(carrera);
        }
        AutoCompleteDecorator.decorate(carreras_comboBox);
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABM_Materias().setVisible(true);
            }
        });
    }
    //Ownt Variables
    public Conexion cc = new Conexion();
    public Connection cn = cc.conexion();
    public ConexionMaterias cm = new ConexionMaterias();
    public Integer idEditar = 0;
    public ArrayList listaCarreras;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anho_label;
    private javax.swing.JTextField anho_textField;
    private javax.swing.JMenuItem borrar_popup;
    private javax.swing.JButton buscar_button;
    private javax.swing.JTextField busqueda_textField;
    private javax.swing.JLabel carrera_label;
    private javax.swing.JComboBox<Carrera> carreras_comboBox;
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
    private javax.swing.JTable tablaMaterias;
    // End of variables declaration//GEN-END:variables
}
