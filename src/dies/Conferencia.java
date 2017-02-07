package dies;


public class Conferencia extends Actividad{
    String clave;
    String fecha_inicio;
    String horario;

    public Conferencia(String clave, String fecha_inicio, String tema, String duracion, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado, String horario) {
        super(tema, duracion, costo, lugar, cupo_max, cupo_min, descripcion, estado);
        this.clave = clave;
        this.fecha_inicio = fecha_inicio;
        this.horario = horario;
    }
        
    public Conferencia(String tema, String duracio, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado) {
        super(tema, duracio, costo, lugar, cupo_max, cupo_min, descripcion, estado);
    }

    public Conferencia(String clave, String tema, String duracio, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado) {
        super(tema, duracio, costo, lugar, cupo_max, cupo_min, descripcion, estado);
        this.clave = clave;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }       
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
