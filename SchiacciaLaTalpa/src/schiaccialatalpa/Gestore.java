/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schiaccialatalpa;

import java.time.LocalTime;

/**
 *
 * @author pasqui.filippo
 */
public class Gestore extends Thread {
    private int durataGioco=30;
    private int numBucheTot=9;
    private boolean inCorso=true;
    private GameForm form;

    public Gestore( GameForm form) {
        
        this.form = form;
    }

    @Override
    public void run() {
        int secondi=0;
        while(inCorso && secondi<durataGioco){
            try{
                faiUscireTalpa();
                Thread.sleep(1500);
                faiScomparireTalpa();
                Thread.sleep(500);
                secondi+=2;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    public void faiUscireTalpa(){
        int indiceBuca=(int)(Math.random()*numBucheTot);
        tipoTalpa t = selezionaTipoCasuale();
        
        java.awt.EventQueue.invokeLater(() -> {
            form.resettaTutteLeBuche();
            form.cambiaImmagineBuca(indiceBuca, t);
        });
    }
    public tipoTalpa selezionaTipoCasuale(){
        double r=Math.random();
        if(r<0.1){
            return tipoTalpa.ORO;
        }
        if(r<0.3){
            return tipoTalpa.ARGENTO;
        }
        return tipoTalpa.BASIC;
        
    }
    public void faiScomparireTalpa(){
        java.awt.EventQueue.invokeLater(()->{
            form.resettaTutteLeBuche();
        });
    }
    public void gestisciLivello(Livello l){}
    public void gestionePunteggi(){}
}
