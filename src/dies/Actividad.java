package dies;

public class Actividad {
    String tema;
    String duracion;
    double costo;
    String lugar;
    int cupo_max;
    int cupo_min;
    String descripcion;
    boolean estado;
    
    public Actividad(){
        
    }

    public Actividad(String tema, String duracion, double costo, String lugar, int cupo_max, int cupo_min, String descripcion, boolean estado) {
        this.tema = tema;
        this.duracion = duracion;
        this.costo = costo;
        this.lugar = lugar;
        this.cupo_max = cupo_max;
        this.cupo_min = cupo_min;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public void setDuracio(String duracio) {
        this.duracion = duracio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCupo_max() {
        return cupo_max;
    }

    public void setCupo_max(int cupo_max) {
        this.cupo_max = cupo_max;
    }

    public int getCupo_min() {
        return cupo_min;
    }

    public void setCupo_min(int cupo_min) {
        this.cupo_min = cupo_min;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Actividad{" + "tema=" + tema + ", duracion=" + duracion + ", costo=" + costo + ", lugar=" + lugar + ", cupo_max=" + cupo_max + ", cupo_min=" + cupo_min + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }
        
}
