package gestionarchivos;
import java.io.*;
import javax.swing.JFileChooser;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GestionA {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
    public GestionA(){
        
    }
    
    /*Abrir un archivo*/
    public String AbrirATexto(File archivo){
        String contenido="";
        if (archivo.getName().endsWith("pdf")) {
          try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+archivo);
            } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
            
            
        }
        else {
            try {
                entrada = new FileInputStream(archivo);
                int ascci;
                while((ascci = entrada.read())!= -1){
                    char carcater = (char)ascci;
                    contenido += carcater;
                }
            }catch (Exception e) {
            }
        }
        return contenido;
    }
    
    /*Guardar archivo de texto*/
    public String GuardarATexto(File archivo, String contenido){
        String respuesta=null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Se guardó con exito el archivo";
        } catch (Exception e) {
        }
        return respuesta;
    }
    
    /*Abrir una imagen*/
    public byte[] AbrirAImagen(File archivo){
        byte[] bytesImg = new byte[2048*500];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(bytesImg);
        } catch (Exception e) {
        }
        return bytesImg;
    }
    
    /*Guardar imagen*/
    public String GuardarAImagen(String archivo, byte[] bytesImg){
        String respuesta=null;
        try {
            salida = new FileOutputStream(new File(archivo));
            salida.write(bytesImg);
            respuesta = "La imágen se guardo con exito.";
        } catch (Exception e) {
        }
        return respuesta;
    }
}