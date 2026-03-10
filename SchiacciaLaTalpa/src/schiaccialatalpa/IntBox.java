/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schiaccialatalpa;

/**
 *
 * @author pasqui.filippo
 */
public class IntBox {
    private int valore=-1;
    private boolean pieno=false;
    
    
    public synchronized void scrivi(int v){
        while(pieno){
            try{wait();}catch(InterruptedException e){}
        }
        valore=v;
        pieno=true;
        notifyAll();
    }
    public synchronized int leggi(){
        while(!pieno){
            try{wait();}catch(InterruptedException e){}
        }
        pieno=false;
        notifyAll();
        return valore;
    }
    public synchronized boolean isPieno(){
        return pieno;
    }
}
