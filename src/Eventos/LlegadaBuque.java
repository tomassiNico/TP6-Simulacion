/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import distribuciones.Exponencial;
import static java.lang.Math.exp;
import static java.lang.StrictMath.exp;
import java.util.Random;

/**
 *
 * @author aleex
 */
public class LlegadaBuque {
    //Debe haber solo una instancia de la clase, se usa como contenedor
    private double rndLLegadaBuque;
    private double tiempoLLegadaBuque;
    private double proximaLllegada;
    
    private Exponencial exp;
    //metodo mas importante.........................
    public double generarTiempoLlegada(double rnd){
        double tiempo = (double) exp.generarNumero(rnd);
        return tiempo;
    }
    
    public LlegadaBuque() {
        this.exp = new Exponencial(0.125);
        this.rndLLegadaBuque = -1;
        this.tiempoLLegadaBuque = -1;
        this.proximaLllegada = -1;
    }

    public double getRndLLegadaBuque() {
        return rndLLegadaBuque;
    }

    public double getTiempoLLegadaBuque() {
        return tiempoLLegadaBuque;
    }

    public double getProximaLlegada() {
        return proximaLllegada;
    }

    public void setRndLLegadaBuque(double rndLLegadaBuque) {
        this.rndLLegadaBuque = rndLLegadaBuque;
    }

    public void setTiempoLLegadaBuque(double tiempoLLegadaBuque) {
        this.tiempoLLegadaBuque = tiempoLLegadaBuque;
    }

    public void setProximaLllegada(double proximaLllegada) {
        this.proximaLllegada = proximaLllegada;
    }
    
}
