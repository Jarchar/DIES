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
public class Pago {
    private int idConfirmacion;
    private int cantidadRestante;
    private int noPago;
    public Pago(){
        
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
     * @return the cantidadRestante
     */
    public int getCantidadRestante() {
        return cantidadRestante;
    }

    /**
     * @param cantidadRestante the cantidadRestante to set
     */
    public void setCantidadRestante(int cantidadRestante) {
        this.cantidadRestante = cantidadRestante;
    }

    /**
     * @return the noPago
     */
    public int getNoPago() {
        return noPago;
    }

    /**
     * @param noPago the noPago to set
     */
    public void setNoPago(int noPago) {
        this.noPago = noPago;
    }
    
}
