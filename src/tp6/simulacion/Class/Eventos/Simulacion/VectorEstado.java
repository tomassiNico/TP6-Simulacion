/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.simulacion.Class.Eventos.Simulacion;

/**
 *
 * @author nicolastomassi
 */
public class VectorEstado {
    
    private double reloj;
    
    /*
    llegada de buque
    */
    private double rndLlegadaBuque;
    private double tiempoLlegadaBuque;
    private double proximaLlegada;
    
    /*
    ingreso a puerto
    */
    private double rndCarga;
    private double cargaBuque;
   
    //tanques costeros
    
    private double tiempoInicioCargaT1, tiempoFinCargaT1, tiempoFinDescargaT1, capacidadLibreT1;
    private double tiempoInicioCargaT2, tiempoFinCargaT2, tiempoFinDescargaT2, capacidadLibreT2;
    private double tiempoInicioCargaT3, tiempoFinCargaT3, tiempoFinDescargaT3, capacidadLibreT3;
    
    private String estadoT1;
    private String estadoT2;
    private String estadoT3;
    
    // buques
    
    private double cargaActualB1;
    private double cargaActualB2;
    private double cargaActualB3;
    
    
    private String estadoB1;
    private String estadoB2;
    private String estadoB3;
    
    private double rndInterrupcion;
    private double porcentajeInterrupcion;
    private double porcentajeActualInterrupcion;
    private double inicioInterrupcion;
    private double finInterrupcion;
    
    
    // cola
    
    private int cola;
     
    //Vector que ayuda para ver cual es el proximo evento
    private double[] eventos;
    
    
    public VectorEstado(double reloj, double rndLlegada, double tiempoLlegada, double proxLlegada,
            double rndCarga, double cargaBuque,
            double inicioT1, double finT1, double finDescargaT1, double capacidadT1, String estadoT1,
            double inicioT2, double finT2, double finDescargaT2, double capacidadT2, String estadoT2,
            double inicioT3, double finT3, double finDescargaT3, double capacidadT3, String estadoT3,
            double cargaActualB1, double cargaActualB2, double cargaActualB3, 
            String estadoB1, String estadoB2, String estadoB3,  int cola,
            double rndInt, double porcInt, double inicionInt, double finInt) {
        this.reloj = reloj;
        this.rndLlegadaBuque = rndLlegada;
        this.tiempoLlegadaBuque = tiempoLlegada;
        this.proximaLlegada = proxLlegada;
        this.rndCarga = rndCarga;
        this.cargaBuque = cargaBuque;
        this.tiempoInicioCargaT1 = inicioT1;
        this.tiempoInicioCargaT2 = inicioT2;
        this.tiempoInicioCargaT3 = inicioT3;
        this.tiempoFinCargaT1 = finT1;
        this.tiempoFinCargaT2 = finT2;
        this.tiempoFinCargaT3 = finT3;
        this.tiempoFinDescargaT1 = finDescargaT1;
        this.tiempoFinDescargaT2 = finDescargaT2;
        this.tiempoFinDescargaT3 = finDescargaT3;
        this.capacidadLibreT1 = capacidadT1;
        this.capacidadLibreT2 = capacidadT2;
        this.capacidadLibreT3 = capacidadT3;
        this.estadoT1 = estadoT1;
        this.estadoT2 = estadoT2;
        this.estadoT3 = estadoT3;
        this.cargaActualB1 = cargaActualB1;
        this.cargaActualB2 = cargaActualB2;
        this.cargaActualB3 = cargaActualB3;
        this.estadoB1 = estadoB1;
        this.estadoB2 = estadoB2;
        this.estadoB3 = estadoB3;
        this.cola = cola;
        this.rndInterrupcion = rndInt;
        this.porcentajeInterrupcion = porcInt;
        this.inicioInterrupcion = inicionInt;
        this.finInterrupcion = finInt;
    }

    public double getProxEventoHora(boolean interrupcion){
        
        String evento;
        evento = "RELOJ :: " + this.reloj + "   Cola::: "   + this.cola + "   --- ";
        evento += "proxLlegada: " + proximaLlegada + " --- ";
        evento += "finCargaT1: " + tiempoFinCargaT1 + " --- ";
        evento += "finCargaT2: " + tiempoFinCargaT2 + " --- ";
        evento += "finCargaT3: " + tiempoFinCargaT3 + " --- ";
        evento += "finDescargaT1: " + tiempoFinDescargaT1 + " --- ";
        evento += "finDescargaT2: " + tiempoFinDescargaT2 + " --- ";
        evento += "finDescargaT3: " + tiempoFinDescargaT3 + " --- ";
        evento += "inicioInterrupcion: " + inicioInterrupcion + " --- ";
        evento += "finInterrupcion: " + finInterrupcion + " --- ";
        
        System.out.println(evento);
        
        
        this.eventos = new double[9];
        this.eventos[0] = this.proximaLlegada;
        this.eventos[1] = this.tiempoFinCargaT1;
        this.eventos[2] = this.tiempoFinCargaT2;
        this.eventos[3] = this.tiempoFinCargaT3;
        this.eventos[4] = this.tiempoFinDescargaT1;
        this.eventos[5] = this.tiempoFinDescargaT2;
        this.eventos[6] = this.tiempoFinDescargaT3;
        if(interrupcion == false){this.eventos[7] = this.inicioInterrupcion;}
        else {this.eventos[7] = -1;} 
        
        this.eventos[8] = this.finInterrupcion;
       
        double menor = this.proximaLlegada;
        for ( int i = 1; i< eventos.length ; i++){
            if ( eventos[i] < menor && eventos[i] >= 0){
                menor = eventos[i];
            } 
        }
        
//        System.out.println("EL menor es : "+ menor);
        return menor;
    }
    public double getReloj() {
        return reloj;
    }

    public void setReloj(double reloj) {
        this.reloj = reloj;
    }

    public double getRndLlegadaBuque() {
        return rndLlegadaBuque;
    }

    public void setRndLlegadaBuque(double rndLLegadaBuque) {
        this.rndLlegadaBuque = rndLLegadaBuque;
    }

    public double getTiempoLlegadaBuque() {
        return tiempoLlegadaBuque;
    }

    public void setTiempoLlegadaBuque(double tiempoLLegadaBuque) {
        this.tiempoLlegadaBuque = tiempoLLegadaBuque;
    }

    public double getProximaLlegada() {
        return proximaLlegada;
    }

    public void setProximaLlegada(double proximaLllegada) {
        this.proximaLlegada = proximaLllegada;
    }

    public double getRndCarga() {
        return rndCarga;
    }

    public void setRndCarga(double rndCarga) {
        this.rndCarga = rndCarga;
    }

    public double getCargaBuque() {
        return cargaBuque;
    }

    public void setCargaBuque(double cargaBuque) {
        this.cargaBuque = cargaBuque;
    }

    public double getTiempoInicioCargaT1() {
        return tiempoInicioCargaT1;
    }

    public void setTiempoInicioCargaT1(double tiempoInicioCargaT1) {
        this.tiempoInicioCargaT1 = tiempoInicioCargaT1;
    }

    public double getTiempoFinCargaT1() {
        return tiempoFinCargaT1;
    }

    public void setTiempoFinCargaT1(double tiempoFinCargaT1) {
        this.tiempoFinCargaT1 = tiempoFinCargaT1;
    }

    public double getTiempoFinDescargaT1() {
        return tiempoFinDescargaT1;
    }

    public void setTiempoFinDescargaT1(double tiempoFinDescargaT1) {
        this.tiempoFinDescargaT1 = tiempoFinDescargaT1;
    }

    public double getCapacidadLibreT1() {
        return capacidadLibreT1;
    }

    public void setCapacidadLibreT1(double capacidadLibreT1) {
        this.capacidadLibreT1 = capacidadLibreT1;
    }

    public double getTiempoInicioCargaT2() {
        return tiempoInicioCargaT2;
    }

    public void setTiempoInicioCargaT2(double tiempoInicioCargaT2) {
        this.tiempoInicioCargaT2 = tiempoInicioCargaT2;
    }

    public double getTiempoFinCargaT2() {
        return tiempoFinCargaT2;
    }

    public void setTiempoFinCargaT2(double tiempoFinCargaT2) {
        this.tiempoFinCargaT2 = tiempoFinCargaT2;
    }

    public double getTiempoFinDescargaT2() {
        return tiempoFinDescargaT2;
    }

    public void setTiempoFinDescargaT2(double tiempoFinDescargaT2) {
        this.tiempoFinDescargaT2 = tiempoFinDescargaT2;
    }

    public double getCapacidadLibreT2() {
        return capacidadLibreT2;
    }

    public void setCapacidadLibreT2(double capacidadLibreT2) {
        this.capacidadLibreT2 = capacidadLibreT2;
    }

    public double getTiempoInicioCargaT3() {
        return tiempoInicioCargaT3;
    }

    public void setTiempoInicioCargaT3(double tiempoInicioCargaT3) {
        this.tiempoInicioCargaT3 = tiempoInicioCargaT3;
    }

    public double getTiempoFinCargaT3() {
        return tiempoFinCargaT3;
    }

    public void setTiempoFinCargaT3(double tiempoFinCargaT3) {
        this.tiempoFinCargaT3 = tiempoFinCargaT3;
    }

    public double getTiempoFinDescargaT3() {
        return tiempoFinDescargaT3;
    }

    public void setTiempoFinDescargaT3(double tiempoFinDescargaT3) {
        this.tiempoFinDescargaT3 = tiempoFinDescargaT3;
    }

    public double getCapacidadLibreT3() {
        return capacidadLibreT3;
    }

    public void setCapacidadLibreT3(double capacidadLibreT3) {
        this.capacidadLibreT3 = capacidadLibreT3;
    }

    public String getEstadoT1() {
        return estadoT1;
    }

    public void setEstadoT1(String estadoT1) {
        this.estadoT1 = estadoT1;
    }

    public String getEstadoT2() {
        return estadoT2;
    }

    public void setEstadoT2(String estadoT2) {
        this.estadoT2 = estadoT2;
    }

    public String getEstadoT3() {
        return estadoT3;
    }

    public void setEstadoT3(String estadoT3) {
        this.estadoT3 = estadoT3;
    }

    public double getCargaActualB1() {
        return cargaActualB1;
    }

    public void setCargaActualB1(double cargaActualB1) {
        this.cargaActualB1 = cargaActualB1;
    }

    public double getCargaActualB2() {
        return cargaActualB2;
    }

    public void setCargaActualB2(double cargaActualB2) {
        this.cargaActualB2 = cargaActualB2;
    }

    public double getCargaActualB3() {
        return cargaActualB3;
    }

    public void setCargaActualB3(double cargaActualB3) {
        this.cargaActualB3 = cargaActualB3;
    }

    public String getEstadoB1() {
        return estadoB1;
    }

    public void setEstadoB1(String estadoB1) {
        this.estadoB1 = estadoB1;
    }

    public String getEstadoB2() {
        return estadoB2;
    }

    public void setEstadoB2(String estadoB2) {
        this.estadoB2 = estadoB2;
    }

    public String getEstadoB3() {
        return estadoB3;
    }

    public void setEstadoB3(String estadoB3) {
        this.estadoB3 = estadoB3;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }

    public double getRndInterrupcion() {
        return rndInterrupcion;
    }

    public void setRndInterrupcion(double rndInterrupcion) {
        this.rndInterrupcion = rndInterrupcion;
    }

    public double getPorcentajeInterrupcion() {
        return porcentajeInterrupcion;
    }

    public void setPorcentajeInterrupcion(double porcentajeInterrupcion) {
        this.porcentajeInterrupcion = porcentajeInterrupcion;
    }

    public double getInicioInterrupcion() {
        return inicioInterrupcion;
    }

    public void setInicioInterrupcion(double inicioInterrupcion) {
        this.inicioInterrupcion = inicioInterrupcion;
    }

    public double getFinInterrupcion() {
        return finInterrupcion;
    }

    public void setFinInterrupcion(double finInterrupcion) {
        this.finInterrupcion = finInterrupcion;
    }

    public double[] getEventos() {
        return eventos;
    }

    public void setEventos(double[] eventos) {
        this.eventos = eventos;
    }

    public double getPorcentajeActualInterrupcion() {
        return porcentajeActualInterrupcion;
    }

    public void setPorcentajeActualInterrupcion(double porcentajeActualInterrupcion) {
        this.porcentajeActualInterrupcion = porcentajeActualInterrupcion;
    }

    
 
}

