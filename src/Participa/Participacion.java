/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Participa;
   

/**
 *
 * @author moises
 */
public class Participacion {
     private int idConfirmacion;
     private int idParticipante;
     private int idActividad;
     private int estadoPago;
     
     public Participacion(){
    
     }

    /**
     * @return the idConfirmacion
     */
    public int getIdConfirmacion() {
        return idConfirmacion;
    }

    /**
     * @param idConfirmacion the idConfirmacion to set
     */
    public void setIdConfirmacion(int idConfirmacion) {
        this.idConfirmacion = idConfirmacion;
    }

    /**
     * @return the idParticipante
     */
    public int getIdParticipante() {
        return idParticipante;
    }

    /**
     * @param idParticipante the idParticipante to set
     */
    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    /**
     * @return the idActividad
     */
    public int getIdActividad() {
        return idActividad;
    }

    /**
     * @param idActividad the idActividad to set
     */
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    /**
     * @return the estadoPago
     */
    public int getEstadoPago() {
        return estadoPago;
    }

    /**
     * @param estadoPago the estadoPago to set
     */
    public void setEstadoPago(int estadoPago) {
        this.estadoPago = estadoPago;
    }
     
   
     
     
}
