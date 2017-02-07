package dies;

import java.util.Date;

public class Curso extends Actividad{
    String clave;
    String fecha_inicio;
    String fecha_fin;
    String hora;

    public Curso(String clave, String fecha_inicio, String fecha_fin, String tema, String duracion, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado , String hora) {
        super(tema, duracion, costo, lugar, cupo_max, cupo_min, descripcion, estado);
        this.clave = clave;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin; 
        this.hora = hora;
    }

    
    public Curso(String tema, String duracio, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado) {
        super(tema, duracio, costo, lugar, cupo_max, cupo_min, descripcion, estado);
    }

    public Curso(String clave, String tema, String duracio, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado) {
        super(tema, duracio, costo, lugar, cupo_max, cupo_min, descripcion, estado);
        this.clave = clave;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }   
}
