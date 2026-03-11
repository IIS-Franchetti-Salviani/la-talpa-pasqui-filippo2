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
    private Livello lvl;
    
    private int tempoVisibile;
    private int pausaTraTalpe;

    public Gestore( IntBox box1,Livello l) {
        this.box=box1;
        this.lvl=l;
        impostaParametriLivello(l);
        
    }

    @Override
    public void run() {
        int secondi=0;
        while(inCorso && secondi<durataGioco){
            try{
                int indice = (int) (Math.random() * 9);
                tipoTalpa tipo=selezionaTipoCasuale();
                
                int codiceInvio=indice+(tipo.ordinal()*10);
                
                box.scrivi(codiceInvio);
                
                Thread.sleep(tempoVisibile);
                
                box.scrivi(-1);
                
                Thread.sleep(pausaTraTalpe);
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
        this.interrupt();
    }
    
    public void impostaParametriLivello(Livello l){
        switch(l){
            case FACILE:
                tempoVisibile=2000;
                pausaTraTalpe=1000;
                break;
            case INTERMEDIO:
                tempoVisibile=1200;
                pausaTraTalpe=600;
                break;
            case DIFFICILE:
                tempoVisibile=800;
                pausaTraTalpe=400;
                break;
        }
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
