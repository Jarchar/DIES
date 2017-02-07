package dies;

public class Platica extends Actividad{
    String clave;
    String fecha_inicio; 
    String horario;

    public Platica(String clave, String fecha_inicio, String tema, String duracion, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado, String horario) {
        super(tema, duracion, costo, lugar, cupo_max, cupo_min, descripcion, estado);
        this.clave = clave;
        this.horario = horario;
        this.fecha_inicio = fecha_inicio;
    }
    
    public Platica(String tema, String duracio, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado) {
        super(tema, duracio, costo, lugar, cupo_max, cupo_min, descripcion, estado);
    }

    public Platica(String clave, String tema, String duracio, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado) {
        super(tema, duracio, costo, lugar, cupo_max, cupo_min, descripcion, estado);
        this.clave = clave;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setInstructor(String horario) {
        this.horario = horario;
    }
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }    
}