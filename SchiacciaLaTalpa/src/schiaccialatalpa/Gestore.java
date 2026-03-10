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
    private IntBox box;

    public Gestore( GameForm form, IntBox box1) {
        this.box=box1;
        this.form = form;
    }

    @Override
    public void run() {
        int secondi=0;
        while(inCorso && secondi<durataGioco){
            try{
                int indice = (int) (Math.random() * 9);
                box.scrivi(indice);
                Thread.sleep(1500);
                box.scrivi(-1);
                Thread.sleep(500);
                secondi++;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        box.scrivi(-1);
        System.out.println("GAME OVER - Thread Gestore terminato");
    }
    public void fermaGioco(){
        this.inCorso=false;
    }
    
    
    
    public void faiUscireTalpa(){
      int indiceBuca=(int)(Math.random()*numBucheTot);
      box.scrivi(indiceBuca);
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


}
