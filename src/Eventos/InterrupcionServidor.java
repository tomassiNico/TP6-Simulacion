/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.util.Random;

/**
 *
 * @author nicolastomassi
 */
public class InterrupcionServidor {
    
    private Random rnd;
    private double rndInterrupcion, porcInterrupcion, inicioInterrupcion, finInterrupcion;
    private double alfa = 0.5;
    private double h = 0.1;
    
    public InterrupcionServidor (){
        this.rnd = new Random();
        this.rndInterrupcion = -1;
        this.porcInterrupcion = -1;
        this.inicioInterrupcion = -1;
        this.finInterrupcion = -1;
    }    

    public void setRndInterrupcion(double rndInterrupcion) {
        this.rndInterrupcion = rndInterrupcion;
    }

    public void setPorcInterrupcion(double porcInterrupcion) {
        this.porcInterrupcion = porcInterrupcion;
    }

    public void setInicioInterrupcion(double inicioInterrupcion) {
        this.inicioInterrupcion = inicioInterrupcion;
    }

    public void setFinInterrupcion(double finInterrupcion) {
        this.finInterrupcion = finInterrupcion;
    }

    public double getAlfa() {
        return alfa;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Random getRnd() {
        return rnd;
    }

    public double getRndInterrupcion() {
        return rndInterrupcion;
    }

    public double getPorcInterrupcion() {
        return porcInterrupcion;
    }

    public double getInicioInterrupcion() {
        return inicioInterrupcion;
    }

    public double getFinInterrupcion() {
        return finInterrupcion;
    }
    
    
    
    
    
    public void generarProximaInterrupcion(double reloj){
        /*
        calcula porcentaje en que se interrumpirá
        */
        this.rndInterrupcion = Math.round(rnd.nextDouble() * 100.0) / 100.0;
        if (rndInterrupcion == 1) {
            rndInterrupcion = 0.99;
        }
        
        this.porcInterrupcion = this.porcentajeInterrupcion();
        this.inicioInterrupcion = reloj + this.calcularTiempoInterrupcion();
        
    }
    
    public void calcularFinInterrupcion() {
        /*
        otro método para llamar cuando recién se interrumpa y no de antemano
        */
        this.finInterrupcion = this.inicioInterrupcion + 5;
    }
   
    public int porcentajeInterrupcion() {
        /*
        retorna el porcentaje en el cual se dará la interrupcion
        */
        int porcentaje = 100;
        
        if (this.rndInterrupcion >= 0.5) {
            porcentaje = 70;
        }
        
        if (this.rndInterrupcion >= 0.8) {
            porcentaje = 50;
        }
        
        return porcentaje;
    }
    
    private double calcularTiempoInterrupcion() {
        /*
        retorna el tiempo en que tardará en interrumpirse,
        NO cuando lo hará ( falta sumarle el reloj para saberlo)
        */
        double anterior[] = new double[3];
        double actual[] = new double[3];
        
        /*
        condicion inicial
        */
        
        anterior [0] = 0; //tiempo
        anterior [1] = 5; //tamaño inicial - porcentaje inicial
        anterior [2] = alfa * anterior[1]; // dT/dt - tasa de crecimiento
        
        
        /*
        comienza el calculo
        */
        actual[1] = -1;
        
        while(anterior[1] <= this.porcInterrupcion) {
            actual[0] = anterior[0] + h;
            actual[1] = anterior[1] + (anterior[2] * h);
            actual[2] = alfa * actual[1];
            anterior = actual;
        }
        
        return actual[0]; 
    }
}
