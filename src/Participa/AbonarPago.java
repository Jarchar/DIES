/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Participa;

import Conexion.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import gestionarchivos.GestionA;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author moises
 */
public class AbonarPago extends javax.swing.JFrame {
    String idConf="";
    String clabe;
    String cantidad;
    int clabeT;
    double cantidadT;
    DefaultTableModel dTm;
    Object datos[]=new Object[3]; 
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    byte[] bytesImg;
    GestionA gestion = new GestionA();
     BufferedImage image = null;
    String rfc;   
    double costo;
     
    public AbonarPago()  {
      initComponents();
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
    }
    public AbonarPago(String noConfirmacion,String RFC, double cost) throws SQLException  {
        initComponents();
        jButton6.setEnabled(false);
        idConf = noConfirmacion;
        jLabel14.setText(idConf);
        dTm= new DefaultTableModel(null,getColumnas());
        setFilas();
        jTable1.setModel(dTm);
        jScrollPane1.add(jTable1);
        this.add(jScrollPane1);
        jScrollPane1.setViewportView(jTable1);        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        rfc=RFC;
        costo=cost;
    }
    private String[] getColumnas() {
        String columna[] = new String[]{"Cantidad Restante","numero de Pago"};
        return columna;
    }
    private void elimFilas() {
        int i;
        for (i = 0; i < dTm.getRowCount(); i++) {
            dTm.removeRow(i);
        }
    }
    private void setFilas() throws SQLException {
        elimFilas();
        Connection cn = null;
        Statement s;
        Conexion cx = new Conexion();
        String con = "SELECT cantidadRestante, noPago From Pago WHERE idConfirmacion ="+idConf+";";
        cn = cx.Enlace(cn);
        s = cn.createStatement();
        ResultSet rs = s.executeQuery(con);
        try {
            while (rs.next()) {
                for (int i = 0; i < 2; i++) {
                    datos[i] = rs.getObject(i + 1);
                }
                dTm.addRow(datos);
            }
            rs.close();
        } catch (SQLException e) {
        }
        s.close();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setText("No Confirmación:");

        jLabel14.setText("##########");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setText("Abonar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Modificar Pago Realizado");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad a abonar");

        jLabel2.setText("Número de Baucher");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Agregar archivo");

        jButton1.setText("Adjuntar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Archivo.jpg");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Registrar Pago:");

        jLabel6.setText("$.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(196, 196, 196))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton5)
                                            .addComponent(jTextField1))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(157, 157, 157))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(jLabel3))
                                        .addGap(64, 64, 64))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6)
                                .addGap(45, 45, 45)
                                .addComponent(jButton2)))
                        .addGap(0, 57, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton2)))
                    .addComponent(jButton5)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ModificarPago Mp2= new ModificarPago(idConf,clabeT,cantidadT,rfc);
        Mp2.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png","jpeg");
        seleccionado.setFileFilter(filtro);
        if(seleccionado.showDialog(null, "ABRIR ARCHIVO") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.canRead()){
                    if(archivo.getName().endsWith("jpeg")||archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")||archivo.getName().endsWith("gif")){
                        bytesImg = gestion.AbrirAImagen(archivo);
                        jLabel4.setText(archivo.toString());
                       // lblImagen.setIcon(new ImageIcon(bytesImg));
                    }else{
                        JOptionPane.showMessageDialog(null, "Por favor seleccione un archivo de texto o de imagen.");
                    }            
            }
        }
        /*FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        seleccionado.setFileFilter(filtro);
        if(seleccionado.showDialog(null, "GUARDAR IMAGEN") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            jLabel4.setText(archivo.toString());
            if(archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")){
                try {
                    System.out.println(archivo);
                    image = ImageIO.read(archivo);
                    ImageIO.write(image, "jpg",new File("C:\\DiezImages/prueba.jpg"));
                    ImageIO.write(image, "png",new File("C:\\auto_loan.png"));

                    //String respuesta = gestion.GuardarAImagen(archivo, bytesImg);
                    //if(respuesta!=null){
                    //  JOptionPane.showMessageDialog(null, respuesta);
                    //}else{
                    //  JOptionPane.showMessageDialog(null, "Error al guardar imagen.");
                    //}
                } catch (IOException ex) {
                    Logger.getLogger(AbonarPago.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "La imagen se debe guardar en formato de imagen pgn, jpg o gif.");
            }
        }
        
        /*int resultado;
        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = 
        new FileNameExtensionFilter("JPG y PNG","jpg","png");
        ventana.jfchCargarfoto.setFileFilter(filtro);
        resultado= ventana.jfchCargarfoto.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado){
            fichero = ventana.jfchCargarfoto.getSelectedFile();
            try{
                    ImageIcon icon = new ImageIcon(fichero.toString());
                    Icon icono = new ImageIcon(icon.getImage().
                    getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), 
                    Image.SCALE_DEFAULT));
                    lblFoto.setText(null);
                    lblFoto.setIcon( icono );
            }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, 
                    "Error abriendo la imagen "+ ex);
            }


    } */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            clabe=jTextField2.getText();
            cantidad=jTextField1.getText();
            if(clabe!=null && cantidad!=null && jLabel4.getText()!="Archivo.jpg"){
                Connection cn = null;
                Statement s;
                Conexion cx = new Conexion();
                String con = "INSERT INTO Pago (idConfirmacion,cantidadRestante,noPago ) VALUES ("+idConf+","+cantidad+","+clabe+");";
                cn = cx.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(con);
                s.close();
                cn.close();
                
                String url= "C:\\img\\"+rfc+"\\"+idConf+"\\";
                File ruta= new File(url);
                if (!ruta.exists()) 
                    ruta.mkdirs();
                
                if(archivo.getName().endsWith("jpeg")||archivo.getName().endsWith("jpg")||archivo.getName().endsWith("png")||archivo.getName().endsWith("gif")){
                    String respuesta = gestion.GuardarAImagen(url+archivo.getName(), bytesImg);
                    if(respuesta!=null){
                        JOptionPane.showMessageDialog(null, respuesta);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al guardar imagen.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La imagen se debe guardar en formato de imagen.");
                }
                
                JOptionPane.showMessageDialog(this, "Registro completo");
                validarEstado(idConf);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Campos faltantes");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbonarPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton6.setEnabled(true);
        cantidadT= (double)( jTable1.getValueAt(jTable1.getSelectedRow(),0));
        clabeT=(int) ( jTable1.getValueAt(jTable1.getSelectedRow(),1));
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(AbonarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbonarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbonarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbonarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    new AbonarPago().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private int validarEstado(String idConfi) throws SQLException {
        double total=0;
        Connection cn = null;
        Statement s;
        Conexion cx = new Conexion();
        String con = "SELECT cantidadRestante From Pago WHERE idConfirmacion ="+idConfi+";";
        cn = cx.Enlace(cn);
        s = cn.createStatement();
        ResultSet rs = s.executeQuery(con);
        while (rs.next()) {
                total=total+(double)rs.getObject("cantidadRestante");
        }
        rs.close();
        s.close();
        System.out.println(total);
        if(total>=costo){
            con="UPDATE Participa SET estadoPago=1 WHERE idConfirmacion="+idConfi+";";
            s.executeUpdate(con);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(this, "Actividad  pagada.");
        }else{
            double resta=costo-total;
            String rest=String.valueOf(resta);
            JOptionPane.showMessageDialog(this, "Total a cubrir: "+String.valueOf(costo)+". Resta: "+rest+".");
        }
        
        return 0;
    }
}
