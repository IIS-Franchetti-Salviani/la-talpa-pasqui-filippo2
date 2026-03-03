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
    private int numBucheTot;
    private boolean inCorso;
    private GameForm form;

    public Gestore(boolean inCorso, GameForm form) {
        this.inCorso = inCorso;
        this.form = form;
    }

    @Override
    public void run() {
        int secondi=0;
        while(inCorso && secondi<durataGioco){
            try{
                faiUscireTalpa();
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    public void faiUscireTalpa(){}
    public void faiScomparireTalpa(){}
    public void gestisciLivello(Livello l){}
    public void gestionePunteggi(){}
}
