/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schiaccialatalpa;

/**
 *
 * @author pasqui.filippo
 */
public class Giocatore {
    private String nome;
    private int punteggio;
    
    
    public void aggiungiPunti(int p){
        this.punteggio+=p;
    }

    public int getPunteggio() {
        return punteggio;
    }
    
    
    public void gestisciMancataPressione(){
        if(punteggio>=2){
            punteggio-=2;
        }
    }
}
