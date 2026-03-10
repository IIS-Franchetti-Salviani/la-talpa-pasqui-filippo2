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
public class Talpa {
    private LocalTime tempoRietro;
    private int frequenzaApparizione;
    private int valorePunteggio;
    private boolean isSchiaccia;
    
    
    
    
    
    
    public void gestisciComportamento(tipoTalpa t){}
    public static int  assegnaPunti(tipoTalpa t){
        switch(t){
            case ORO: return 50;
            case ARGENTO: return 20;
            case BASIC: return 10;
            default:return 0;
        }
    
    }
}
