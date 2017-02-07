package dies;

import Conexion.Conexion;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Control {
    String actividad; 
    SimpleDateFormat formato  = new SimpleDateFormat("dd-MM-yyyy");
    /*
    Mensaje de confirmacion del registro "¿Estas seguro de finalizar el registro?
    
    Mensaje de error de campos vacios "Campos vacios, no se puede finalizar el registro complete los datos
    
    Mensaje de error de base de datos "Error de conexion de BD, no se realizo el registro
    
    Mensaje de actividad registrada correctamente.
    
    Mensaje de cancelacion "Registro de actividad cancelado"
    */
    public Control(){        
    }
    
    public Control(String actividad){
        this.actividad = actividad;
    }
    
    
    //carga los nombres de los coordinadores en un combo
    public void Coordinador(JComboBox jc){
        Connection cn = null;
        Statement s;
        try{
            DefaultComboBoxModel modeloCombox = new DefaultComboBoxModel();
            String con = "SELECT nombre, aPaterno From Instructor, Persona where Persona.id =  idInstructor;";                      
            cn = Conexion.Enlace(cn);
            s = cn.createStatement();            
            ResultSet rs = s.executeQuery(con);
            modeloCombox.addElement("Selecciona");
            jc.setModel(modeloCombox);
            String nombre;
            while(rs.next()){
                nombre = rs.getObject("nombre").toString() + " "+rs.getObject("aPaterno").toString();
                modeloCombox.addElement(nombre);
                jc.setModel(modeloCombox);
            }            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
        }
    }

    //Metodo que genera un clave para el registro de un Foro
    public String generaClaveF(String tema, String lugar, String fecha, String coor){
        String clave = "";
        ArrayList cl = new ArrayList();
        int i;
        if((tema.length() > 3) && (lugar.length() > 3) && (coor.length() > 2) && fecha != null){
            for(i = 0; i < 3; i++){
                clave = clave + tema.charAt(i);
            }
            for(i = 0; i < 3; i++){
                clave = clave + lugar.charAt(i);
            }
            for(i = 0; i < 2; i++){
                clave = clave + coor.charAt(i);
            }
            for(i = 0; i < fecha.length(); i++){
                if(fecha.charAt(i) != '-'){
                    clave += fecha.charAt(i);
                }
            }                  
            return clave;
        }else{
            
            return clave;
        }
    }
    
    //Metodo que genera un clave para el registro de Platica, Curso, Taller, Conferencia
    public String generaClave(String tema, String lugar, String costo, String cpMax, String fecha){
        String clave = "";
        ArrayList cl = new ArrayList();
        int i;
        if((tema.length() > 3) && (lugar.length() > 3) && (costo.length() > 2) && cpMax != null && fecha != null){
            for(i = 0; i < 3; i++){
                clave = clave + tema.charAt(i);
            }
            for(i = 0; i < 3; i++){
                clave = clave + lugar.charAt(i);
            }
            for(i = 0; i < 2; i++){
                clave = clave + costo.charAt(i);
            }
            for(i = 0; i < fecha.length(); i++){
                if(fecha.charAt(i) != '-'){
                    clave += fecha.charAt(i);
                }
            }
            clave += cpMax;            
            return clave;
        }else{
            
            return clave;
        }
    }

    //Funcion que dato un String regresa un Date.    
    public Date StringToDate(String fecha){
        Date f = null;
        try{
            f = formato.parse(fecha);
            return f;
        }catch(ParseException pe){
            return null;
        }
    }

    //funcion que regresa como String la fecha obtenido desde un JDateChooser.   
    public String getFecha(JDateChooser jd){
        if(jd.getDate() != null){
            return formato.format(jd.getDate());
        }else{
            return null;
        }
    }
    
    //Este grupo de funciones obtiene la clave de un curso... proporcionando el nombre del mismo        
    public String ClaveCurso(String nombre){
        String clave = null;
        Connection cn = null;
        Statement s;
        try{            
            String sql = "SELECT Clave from Curso where Tema = '"+nombre+"'";
            cn = Conexion.Enlace(cn);
            s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if( rs.next()){
                clave = rs.getString("Clave");
            }else{
                System.out.println("No se encontrar coincidencias.");
            }
            rs.close();
            s.close();
            cn.close();            
        }catch(SQLException e){
            System.out.println("Error de busqueda "+e.getMessage());
        }        
        return clave;
     }
     
    public String ClaveTaller(String nombre){
        String clave = null;
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "SELECT Clave from Taller where Tema = '"+nombre+"'";
            cn = cx.Enlace(cn);
            s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if( rs.next()){
                clave = rs.getString("Clave");
            }else{
                System.out.println("No se encontrar coincidencias.");
            }
            rs.close();
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de busqueda "+e.getMessage());
        }
        return clave;
     }
     
    public String ClaveConfe(String nombre){
         String clave = null;
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "SELECT Clave from Conferencia where Tema = '"+nombre+"'";
            cn = cx.Enlace(cn);
            s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if( rs.next()){
                clave = rs.getString("Clave");
            }else{
                System.out.println("No se encontrar coincidencias.");
            }
            rs.close();
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de busqueda "+e.getMessage());
        }
        return clave;
     }
     
    public String ClavePlatica(String nombre){
         String clave = null;
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "SELECT Clave from Conferencia where Tema = '"+nombre+"'";
            cn = cx.Enlace(cn);
            s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if( rs.next()){
                clave = rs.getString("Clave");
            }else{
                System.out.println("No se encontrar coincidencias.");
            }
            rs.close();
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de busqueda "+e.getMessage());
        }
        return clave;
     }
     
    public String ClaveClase(String nombre){
         String clave = null;
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "SELECT Clave from C where Tema = '"+nombre+"'";
            cn = cx.Enlace(cn);
            s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if( rs.next()){
                clave = rs.getString("Clave");
            }else{
                System.out.println("No se encontrar coincidencias.");
            }
            rs.close();
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de busqueda "+e.getMessage());
        }
        return clave;
     }
     
    
    // Carga los instructores de acuerdo a la clave de un curso o taller
    public void InstrucTC(String actividad, String clave, JTable jt){
        Connection cn = null;
        Statement s;
        String sql = null;
        if(actividad.equals("Curso")){
            sql = "Select nombre from Instructor, Persona, ImparteCurso where curso_clave = '"+clave+"' and"
                    + " Persona.id = Instructor.idInstructor and ImparteCurso.instructor_clave = Instructor.idInstructor;";
        }else if (actividad.equals("Taller")){
            sql = "Select nombre from Instructor, Persona, Impartetaller where taller_clave = '"+clave+"' and"
                    + " Persona.id = Instructor.idInstructor and ImparteTaller.instructor_clave = Instructor.idInstructor;";
        }
        System.out.print(sql);
        if(sql != null){
            try{
                cn = Conexion.Enlace(cn);            
                s = cn.createStatement();
                ResultSet r = s.executeQuery(sql);
                ResultSetMetaData rsMd = r.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("Instructores");
                while(r.next()){
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i]=r.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                jt.setModel(modelo);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Actividad desconocida (T-C)");
        }
    }
    
    //Carga los intructores de conferencia y platica selecionada
    public void instructPC(String actividad, String clave, JTable jt){
        Connection cn = null;
        Statement s;        
            if(actividad.equals("Conferencia")){
                try{
                    cn = Conexion.Enlace(cn);
                    String sql = "Select nombre from Instructor, Persona, ImparteConf where confe_clave = '"+clave+"' and"
                        + " Persona.id = Instructor.idInstructor and ImparteConf.instructor_clave = Instructor.idInstructor;";
                    s = cn.createStatement();
                    ResultSet r = s.executeQuery(sql);
                    ResultSetMetaData rsMd = r.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("Instructores");
                    while(r.next()){
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                            fila[i]=r.getObject(i+1);
                        }
                        modelo.addRow(fila);
                    }
                    jt.setModel(modelo);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error de consulta Conferencia \n"+e.getMessage());
                }                
            }else if (actividad.equals("Platica")){
                try{
                    cn = Conexion.Enlace(cn);
                    String sql = "Select nombre from Instructor, Persona, ImpartePlat where platica_clave = '"+clave+"' and"
                        + " Persona.id = Instructor.idInstructor and ImpartePlat.instructor_clave = Instructor.idInstructor;";
                    s = cn.createStatement();
                    ResultSet r = s.executeQuery(sql);
                    ResultSetMetaData rsMd = r.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();
                    DefaultTableModel modelo = new DefaultTableModel();
                    modelo.addColumn("Instructores");
                    while(r.next()){
                        Object[] fila = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                            fila[i]=r.getObject(i+1);
                        }
                        modelo.addRow(fila);
                    }
                    jt.setModel(modelo);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error de consulta de Platica \n"+e.getMessage());
                }                
        }                    
    }
    
    //Carga todos los foros en una tabla
    public void selectF(JTable jt){ // Carga los foros en una tabla
        Connection cn = null;
        Statement s;
        List <String> cab = Arrays.asList("Clave","Tema", "Fecha", "Lugar", "Coordinador");
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            cn = Conexion.Enlace(cn);
            String sql = "Select clave, tema, fecha, lugar, Coordinador from Foro where estado = 1;";
            s = cn.createStatement();
            ResultSet r = s.executeQuery(sql);
            ResultSetMetaData rsMd = r.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for (int i = 0; i < cantidadColumnas; i++) {
                modelo.addColumn(cab.get(i));
            }
            while (r.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=r.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            jt.setModel(modelo);            
            r.close();                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error de carga \n"+e.getMessage());
        }
    }
    
    //Carga los pponentes del foro selecionado en un tabla
    public void PonentesF(String clav, JTable jt){ // Carga los ponentes de acuerdo al foro
        Connection cn = null;
        Statement s;
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            cn = Conexion.Enlace(cn);
            String sql = "Select nombre from Ponente, Persona, Imparteforo where foro_clave = '"+clav+"' and"
                    + " Imparteforo.ponente_clave = Ponente.idPonente and idPonente = Persona.id;";
            s = cn.createStatement();
            ResultSet r = s.executeQuery(sql);
            ResultSetMetaData rsMd = r.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();            
            modelo.addColumn("Ponentes");
            while(r.next()){
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=r.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            jt.setModel(modelo);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e.getLocalizedMessage());
        }
    }
    
    //Cargar conferencias o platicas en la tabla
    public void selectCP(String actividad, JTable jt){ 
        Connection cn = null;
        Statement s;
        List <String> cab = Arrays.asList("Clave","Tema", "Lugar");
        DefaultTableModel modelo = new DefaultTableModel();        
        try{            
            cn = Conexion.Enlace(cn);
            String sql = "Select clave, tema, lugar from '"+actividad+"' where estado = 1";
            s = cn.createStatement();
            ResultSet r = s.executeQuery(sql);
            ResultSetMetaData rsMd = r.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for (int i = 0; i < cantidadColumnas; i++) {
                modelo.addColumn(cab.get(i));
            }
            while (r.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=r.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            jt.setModel(modelo);
            
            r.close();                    
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error de carga \n"+e.getMessage());
            }
    }
    
    
    //Muestra los datos de los ponentes en una tabla.
    public void ponentes(JTable jt){
        Connection cn = null;
        Statement s;
        DefaultTableModel modelo = new DefaultTableModel();
        List <String> cab = Arrays.asList("Clave","Nombre");
        try{
            cn = Conexion.Enlace(cn);
            String sql = "Select idPonente, nombre from Ponente, Persona where idPonente = Persona.id;";
            s = cn.createStatement();
            ResultSet r = s.executeQuery(sql);
            ResultSetMetaData rsMd = r.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for (int i = 0; i < cantidadColumnas; i++) {
                modelo.addColumn(cab.get(i));
            }
            while (r.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=r.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            jt.setModel(modelo);            
            r.close();            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Muestra los datos de los isntructores en una tabla.
    public void Instructores(JTable jt){
        Connection cn = null;
        Statement s;
        DefaultTableModel modelo = new DefaultTableModel();
        List <String> cab = Arrays.asList("Clave","Nombre");
        try{
            cn = Conexion.Enlace(cn);
            String sql = "Select idInstructor, nombre from Instructor, Persona where idInstructor = Persona.id;";
            s = cn.createStatement();
            ResultSet r = s.executeQuery(sql);
            ResultSetMetaData rsMd = r.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            System.out.print("columnas: "+cantidadColumnas);
            for (int i = 0; i < cantidadColumnas; i++) {                
                modelo.addColumn(cab.get(i));
            }
            while (r.next()) {                
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=r.getObject(i+1);
                    System.out.print(r.getObject(i+1));
                }
                modelo.addRow(fila);
            }
            jt.setModel(modelo);            
            r.close();            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
    // Muestra los datos de los cursos o Talleres en una tabla
    public void selectCT(JTable jt, String actividad){
        Connection cn = null;
        Statement s;
        List <String> cab = Arrays.asList("Clave","Tema","Fecha inicio","Fecha final","Lugar");
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            cn = Conexion.Enlace(cn);
            String b = "select Clave, Tema, fecha_ini,fecha_fin, lugar from '"+actividad+"' where estado = 1";
            s = cn.createStatement();
            ResultSet r = s.executeQuery(b);
            ResultSetMetaData rsMd = r.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            for (int i = 0; i < cantidadColumnas; i++) {
                modelo.addColumn(cab.get(i));
            }
            //Creando las filas para el JTable
            while (r.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=r.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            jt.setModel(modelo);
            r.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }
    
    // Cambia el instructor seleccionado de una tabla a la otra
    public void CambioInstrcut(JTable x, JTable y){
        DefaultTableModel modelox = (DefaultTableModel)x.getModel();
        DefaultTableModel modeloy = (DefaultTableModel)y.getModel();
        try{
            int fila = y.getSelectedRow();
            Object filaX [] = new Object[modeloy.getColumnCount()];
            for(int i = 0; i < modeloy.getColumnCount(); i ++){
                filaX[i] = modeloy.getValueAt(fila, i);
            }            
            modelox.addRow(filaX);            
            modeloy.removeRow(fila);            
            x.setModel(modelox);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Seleccione el instructor que desea quitar");
        }
    }
    
    //Regresa una lista con el resultado de la query para cada actividad
    public ArrayList getCT(String actividad, String clave){
        ArrayList campos = new ArrayList();
        String sql = null;
        if(actividad.equals("Taller")){
            sql = "Select *from Taller where clave = '"+clave+"';";
        }else if (actividad.endsWith("Curso")){
            sql = "Select *from Curso where clave = '"+clave+"';";
        }else if(actividad.equals("Platica")){
            sql = "Select *from Platica where clave = '"+clave+"';";
        }else if(actividad.equals("Conferencia")){
            sql = "Select *from Conferencia where clave = '"+clave+"';";
        }else if(actividad.equals("Foro")){
            sql = "Select *from foro where clave = '"+clave+"';";
        }
        if(sql != null){
            try{
                Connection cn = null;
                Statement s;
                cn = Conexion.Enlace(cn);
                s = cn.createStatement();
                ResultSet r = s.executeQuery(sql);
                int i = 0;
                ResultSetMetaData rsMd = r.getMetaData();
                int cantidadColumnas = rsMd.getColumnCount();
                while(r.next()){
                    for (i = 0; i < cantidadColumnas; i++) {
                        campos.add(r.getObject(i+1));
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error activdad desconocida");
        }
        return campos;
    }

    public void rActv(String actividad, String clave_actv){
        Connection c = null;
        Statement s;
        String cons;
        try{
            c = Conexion.Enlace(c);
            cons = "Insert into Actividad values ( '"+clave_actv+"', '"+actividad+"')";
            s = c.createStatement();
            s.execute(cons);
            if(s.getUpdateCount() != -1){
                JOptionPane.showMessageDialog(null,"Error de registro actv.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}