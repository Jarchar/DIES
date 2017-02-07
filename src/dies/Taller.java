package dies;

public class Taller extends Actividad{
    String clave;
    String fecha_inicio;
    String fecha_fin;
    String horario;

    public Taller(){
    }   
    
    public Taller(String tema, String duracion, double costo, String lugar, int cupo_max, int cupo_min, String descripcion,boolean estado) {
        super(tema, duracion, costo, lugar, cupo_max, cupo_min, descripcion, estado);
    }

    public Taller(String clave, String tema, String duracio, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado) {
        super(tema, duracio, costo, lugar, cupo_max, cupo_min, descripcion, estado);
        this.clave = clave;
    }

    public Taller(String clave, String fecha_inicio, String fecha_fin, String tema, String duracion, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado, String horario) {
        super(tema, duracion, costo, lugar, cupo_max, cupo_min, descripcion, estado);
        this.clave = clave;        
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.horario = horario;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Taller{" + "clave=" + clave + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", horario=" + horario + '}';
    }    
}

