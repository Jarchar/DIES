package dies;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Personal extends Persona{
    String usuario;
    String pass;
    String puesto;
    

    public Personal(){
        
    }
    public Personal(String usuario, String pass, String puesto, String nombre, String direccion, String telefono, String ciudad, Date fecha_nac, String genero) {
        super(nombre, direccion, telefono, ciudad, fecha_nac, genero);
        this.usuario = usuario;
        this.pass = pass;
        this.puesto = puesto;
    }
    
    public Personal(String nombre, String direccion, String telefono, String ciudad, Date fecha_nac, String genero) {
        super(nombre, direccion, telefono, ciudad, fecha_nac, genero);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    //----- METODOS PARA EL REGISTRO, ACTUALIZACION Y BAJA DE ACTIVIDADES-------
    
    /*Los metodos dar de baja contemplan que, al selecionar un actividad ( curso
    , clase, conferencia o taller) de un combo puede verse en el prototipo, 
    se obtengan todos los datos desde la base y se guarden en un objeto del tipo 
    de la clase.
    
    los metodos de registra, requiere de un obejto de la clase ha registrar, de 
    los cuales se guardaran todos los campos  desde la interfaz, para luego ser 
    almacenados por el metodo.
    
    El metodo modifica, necesita de un check como se ve en la interfaz del protoipo
    que al estar palomeado ademas de modificar algun campo que haya sido cambiado,
    tambien cambiara el estado del curso en la base de datos. Ademas de requerir 
    un objeto del tipo que se requiera acutalizar.
    
    
    Los metodos que ClaveCurso, ClaveTaller...etec, tienen el objetivo de obtener
    el nombre o cadena del combo box, segun el tipo de actividad, ir a la base de
    de datos buscar la actividadad, y de encontrarla regresan la clave.
    
    */
            
    //-----------------------------------------------------------------------------
    //Métodos para el registro, baja y actualizacion de un curso
    public void registraCurso(Curso cr){
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "INSERT INTO Curso VALUES('"+cr.getClave()+"', '"+cr.getTema()+"', "
                    + "'"+cr.getDuracion()+"', '"+cr.getCosto()+"', '"+cr.getLugar()+"', '"+cr.getCupo_max()+"'"
                    + ", '"+cr.getCupo_min()+"', '"+cr.getDescripcion()+"',1, '"+cr.getFecha_inicio()+"', '"+cr.getFecha_fin()+"'"
                    + " , '"+cr.getHora()+"');";
            cn = cx.Enlace(cn);
            s = cn.createStatement();
            s.executeQuery(sql);
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de registro de curso - "+e.getMessage());
        }
    }
    
    public void bajaCurso(String clave){
        Connection cn = null;
        Statement s;
        if(clave != null){
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Curso set estado = 'inactivo' where clave = '"+clave+"';";
                cn = cx.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();            
                cn.close();
            }catch(SQLException e){
                System.out.println("Error de baja de curso /n[" + e.getMessage()+" ]");
            }
        }
    }
    
    public void ModifcaCurso(JCheckBox cb, Curso c){
        if(cb.isSelected()){
            bajaCurso(c.getClave());            
        }else{
            Connection cn = null;
            Statement s;
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Curso SET Tema = '"+c.getTema()+"', Duracion = '"+c.getDuracion()+"'"
                        + ", Costo = '"+c.getCosto()+"', Lugar = '"+c.getLugar()+"', Cupo_max = '"+c.getCupo_max()+"'"
                        + ", Cupo_min = '"+c.getCupo_min()+"', Descripcion = '"+c.getDescripcion()+"' "
                        + ", fecha_ini = '"+c.getFecha_inicio()+"', fecha_fin = '"+c.getFecha_fin()+"'"
                        + "'WHERE Clave = '"+c.getClave()+"';";
                cn = Conexion.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();
                cn.close();
            }catch(SQLException e){
                System.out.println("Error de Modificacion  de curso /n[ " + e.getMessage()+ " ]");
            }
        }
    }
    
    //--------------------------------------------------------------------------
    //Metodos para el registro, baja y actualizacion de una platica.
    public void registraPlatica(Platica p){
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "INSERT INTO Platica VALUES('"+p.getClave()+"', '"+p.getTema()+"', "
                    + "'"+p.getDuracion()+"', '"+p.getCosto()+"', '"+p.getLugar()+"', '"+p.getCupo_max()+"'"
                    + ", '"+p.getCupo_min()+"', '"+p.getDescripcion()+"',1, '"+p.getFecha_inicio()+"', "
                    + " '"+p.getHorario()+"');";
            cn = Conexion.Enlace(cn);
            s = cn.createStatement();
            s.executeQuery(sql);
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de registro de Platica - "+e.getMessage());
        }
    }
    
    public void bajaPlatica(String clave){
        Connection cn = null;
        Statement s;
        if(clave != null){
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Platica set estado = 0 where clave = '"+clave+"';";
                cn = Conexion.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);            
                s.close();
                cn.close();
            }catch(SQLException e){
                System.out.println("Error para dar de baja [" + e.getMessage()+" ]");
            }
        }
    }
    
    public void ModificaPlatica(JCheckBox cb, Platica p){
        if(cb.isSelected()){
            bajaPlatica(p.getClave());
        }else{
            Connection cn = null;
            Statement s;
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Platica SET Tema = '"+p.getTema()+"', Duracion = '"+p.getDuracion()+"'"
                        + ", Costo = '"+p.getCosto()+"', Lugar = '"+p.getLugar()+"', Cupo_max = '"+p.getCupo_max()+"'"
                        + ", Cupo_min = '"+p.getCupo_min()+"', Descripcion = '"+p.getDescripcion()+"', estado = '1', "
                        + " fecha = '"+p.getFecha_inicio()+"', horario = '"+p.getHorario()+"' WHERE Clave = '"+p.getClave()+"';";
                cn = Conexion.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();
                cn.close();
            }catch(SQLException e){
                System.out.println("Error de Modificacion [ " + e.getMessage()+ " ]");
            }
        }
    }
    
    //--------------------------------------------------------------------------
    //Metodos para el registro de una conferencia
    public void registraConfe(Conferencia ch){
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "INSERT INTO Conferencia VALUES('"+ch.getClave()+"', '"+ch.getTema()+"', "
                    + "'"+ch.getDuracion()+"', '"+ch.getCosto()+"', '"+ch.getLugar()+"', '"+ch.getCupo_max()+"'"
                    + ", '"+ch.getCupo_min()+"', '"+ch.getDescripcion()+"',1, '"+ch.getFecha_inicio()+"',"
                    + " '"+ch.getHorario()+"');";
            cn = Conexion.Enlace(cn);
            s = cn.createStatement();
            s.executeQuery(sql);
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de registro de clase - "+e.getMessage());
        }
    }
    
    public void bajaConfe(String clave){
        Connection cn = null;
        Statement s;
        if(clave != null){
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Conferencia set estado = 0 where clave = '"+clave+"';";
                cn = Conexion.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();            
                cn.close();
            }catch(SQLException e){
                System.out.println("Error para dar de baja [" + e.getMessage()+" ]");
            }
        }
    }
    
    public void ModificaConfe(JCheckBox cb,Conferencia ch){
        if(cb.isSelected()){
            bajaConfe(ch.getClave());            
        }else{
            Connection cn = null;
            Statement s;
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Conferencia SET Tema = '"+ch.getTema()+"', Duracion = '"+ch.getDuracion()+"'"
                        + ", Costo = '"+ch.getCosto()+"', Lugar = '"+ch.getLugar()+"', Cupo_max = '"+ch.getCupo_max()+"'"
                        + ", Cupo_min = '"+ch.getCupo_min()+"', Descripcion = '"+ch.getDescripcion()+"', estado = 1,  fecha = '"+ch.getFecha_inicio()+"', horario = '"+ch.getHorario()+"'"
                        + "  WHERE Clave = '"+ch.getClave()+"';";
                cn = Conexion.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();
                cn.close();
            }catch(SQLException e){
                System.out.println("Error de Modificacion [ " + e.getMessage()+ " ]");
            }
        }
    }
    
    //--------------------------------------------------------------------------
    //Metodos para el registro de un foro
    public void registraForo(Foro c){
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "INSERT INTO Foro VALUES('"+c.getClave()+"', '"+c.getTema()+"', "
                    + "'"+c.getDuracion()+"', '"+c.getLugar()+"', '"+c.getDescripcion()+"',1, '"+c.getFecha()+"' "
                    + ", '"+c.getCoordinador()+"', '"+c.getHorario()+"' )";
            cn = Conexion.Enlace(cn);
            s = cn.createStatement();
            s.executeQuery(sql);
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de registro de foro - "+e.getMessage());
        }
    }
    
    public void bajaForo(String clave){
        Connection cn = null;
        Statement s;
        if (clave != null){
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Foro set estado = 0 where clave = '"+clave+"';";
                cn = Conexion.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();
                cn.close();
            }catch(SQLException e){
                System.out.println("Error para dar de baja [" + e.getMessage()+" ]");
            }
        }
    }
    
    public void ModificaForo(JCheckBox cb, Foro c){
        if(cb.isSelected()){
            bajaForo(c.getClave());            
        }else{
            Connection cn = null;
            Statement s;
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Foro SET Tema = '"+c.getTema()+"', Duracion = '"+c.getDuracion()+"'"
                        + ", Lugar = '"+c.getLugar()+"', Descripcion = '"+c.getDescripcion()+"' , estado = 1"
                        + ", fecha = '"+c.getFecha()+"', coordinador = '"+c.getCoordinador()+"', horario ='"+c.getHorario()+"' where Clave = '"+c.getClave()+"';";
                System.out.print("\n \n "+ sql+"\n \n");
                cn = Conexion.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();
                cn.close();
            }catch(SQLException e){
                System.out.println("Error de Modificacion [ " + e.getMessage()+ " ]");
            }
        }
    }
    
    //---------------------------------------------------------------------------
    //Metodos del registro de Taller.
    public void registraTaller(Taller t){
        Connection cn = null;
        Statement s;
        try{
            Conexion cx = new Conexion();
            String sql = "INSERT INTO Taller VALUES('"+t.getClave()+"', '"+t.getTema()+"', "
                    + " '"+t.getDuracion()+"', '"+t.getCosto()+"', '"+t.getLugar()+"', '"+t.getCupo_max()+"'"
                    + ", '"+t.getCupo_min()+"', '"+t.getDescripcion()+"', 1, '"+t.getFecha_inicio()+"',"
                    + "'"+t.getFecha_fin()+"', '"+t.getHorario()+"');";
            cn = Conexion.Enlace(cn);
            s = cn.createStatement();
            s.executeQuery(sql);
            s.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error de registro de taller - "+e.getMessage());
        }
    }
    
    public void bajaTaller(String clave){
        Connection cn = null;
        Statement s;
        if(clave != null){
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Taller SET estado = 0 WHERE Clave = '"+clave+"';";
                cn = cx.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();
                cn.close();            
            }catch(SQLException e){
                System.out.println("Error para dar de baja [" + e.getMessage()+" ]");
            }
        }
    }
    
    public void ModifcaTaller(JCheckBox cb, Taller t){
        if(cb.isSelected()){
            bajaTaller(t.getClave());            
        }else{
            Connection cn = null;
            Statement s;
            try{
                Conexion cx = new Conexion();
                String sql = "UPDATE Taller SET Tema = '"+t.getTema()+"', Duracion = '"+t.getDuracion()+"'"
                        + ", Costo = '"+t.getCosto()+"', Lugar = '"+t.getLugar()+"', Cupo_max = '"+t.getCupo_max()+"'"
                        + ", Cupo_min = '"+t.getCupo_min()+"', Descripcion = '"+t.getDescripcion()+"' , estado = 1 "
                        + ", fecha_ini = '"+t.getFecha_inicio()+"'"
                        + ", fecha_fin = '"+t.getFecha_fin()+"', horario = '"+t.getHorario()+"' where Clave = '"+t.getClave()+"';";
                cn = cx.Enlace(cn);
                s = cn.createStatement();
                s.executeUpdate(sql);
                s.close();
                cn.close();
            }catch(SQLException e){
                System.out.println("Error de Modificacion [" + e.getMessage()+" ]");
            }
        }
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------
    //Funcion que dada una tabla con los instructores o ponentes (en el caso del foro) y la actividad los registra en la tabla correspondiente
    public void registraLI(JTable x, String actividad, String clave_actividad){
        String sql = null;
        int i = 0;
        String tabla = null;
         if ("Curso".equals(actividad)){
                tabla = "impartecurso";
         }
         else if ("Taller".equals(actividad)){
                tabla = "impartetaller";
         }
         else if (actividad.equals("Conferencia")){
                tabla = "imparteconf";
         }
         else if ("Platica".equals(actividad)){
                tabla = "imparteplat";
         }
         else if ("Foro".equals(actividad)){
                tabla = "imparteforo";
         }
        if(tabla != null){
            try{
                Connection cn = null;
                Statement s;
                Conexion cx = new Conexion();
                cn = cx.Enlace(cn);
                s = cn.createStatement();
                System.out.println(tabla);
                for(i = 0; i < x.getModel().getRowCount(); i ++){
                        sql = "INSERT INTO "+tabla+" VALUES( '"+x.getModel().getValueAt(i, 0)+ "' , '" +clave_actividad+ "' );";
                        System.out.print(sql);
                        s.executeUpdate(sql);
                  }
                 s.close();
                cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error actividad desconocida");
        }
    }
    
    //Funcion para eliminar todos los instructores/ ponentes de una actividad determinada por el parametro    
    public void deleteIP(String actividad, String clave_actividad){
         String sql = null;
        int i = 0;
        String tabla = null;
        String campo = null;
         if ("Curso".equals(actividad)){
                tabla = "impartecurso";
                campo = "curso_clave";
         }
         else if ("Taller".equals(actividad)){
                tabla = "impartetaller";
                campo = "taller_clave";
         }
         else if (actividad.equals("Conferencia")){
                tabla = "imparteconf";
                campo = "Confe_clave";
         }
         else if ("Platica".equals(actividad)){
                tabla = "imparteplat";
                campo = "Platica_clave";
         }
         else if ("Foro".equals(actividad)){
                tabla = "imparteforo";
                campo = "foro_clave";
         }        
        if(tabla != null){
            try{
                Connection cn = null;
                Statement s;
                Conexion cx = new Conexion();
                cn = cx.Enlace(cn);
                s = cn.createStatement();
                System.out.println(tabla);
                sql =" Delete from "+tabla+" where "+campo+" = '"+clave_actividad+"' ";
                System.out.println(sql);
                s.executeUpdate(sql);
                s.close();
                cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error actividad desconocida");
        }        
    }
}