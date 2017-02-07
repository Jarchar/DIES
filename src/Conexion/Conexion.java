package Conexion;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    static java.sql.Connection cn = null; // Variable para la conexion.
    
    public static java.sql.Connection Enlace(java.sql.Connection cn) throws SQLException{
        String ruta = "Dies.sqlite";//Ruta de la base de datos.
        try{
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:"+ruta);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
       return cn;
    }
}
