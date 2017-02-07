package dies;

public class Foro{
    String clave;
    String tema;
    String duracion;
    String lugar;
    String descripcion;
    int estado;
    String fecha;
    String coordinador;
    String horario;

    public Foro(String clave, String tema, String duracion, String lugar, String descripcion, int estado, String fecha, String coordinador, String horario) {
        this.clave = clave;
        this.tema = tema;
        this.duracion = duracion;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.coordinador = coordinador;
        this.horario = horario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }            
}
