/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.simulacion.Class.Objetos;

import java.util.logging.Logger;

/**
 *
 * @author aleex
 */
public class Buque {
    private double cargaActual;
    private String estado; // Los estados pueden ser solo 'SA' 'ER' 'EA'
//    private double tiempoRemanenteCarga;

    public Buque(double cargaActual, String estado, double tiempoRemanenteCarga) {
        this.cargaActual = cargaActual;
        this.estado = estado;
    }

    public Buque() {
    }

    public Buque(double cargaActual, String estado) {
        this.cargaActual = cargaActual;
        this.estado = estado;
    }
    
    public void ponerSiendoAtendido(){
        this.estado = "SA";
    }
    
    public void ponerEsperandoAtencion(){
        this.estado = "EA";
    }
    
    public void ponerEsperandoReanudacion(){
        this.estado = "ER";
    }
//    public void calcularTiempoRemanente(){
//        double aux = 0.5 + this.cargaActual / 10000;
//        aux = Math.round(aux*100.0) /100.0;
//        this.tiempoRemanenteCarga = aux;
//    }

    public double getCargaActual() {
        return cargaActual;
    }

    public String getEstado() {
        return estado;
    }

    public void setCargaActual(double cargaActual) {
        this.cargaActual = cargaActual;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
