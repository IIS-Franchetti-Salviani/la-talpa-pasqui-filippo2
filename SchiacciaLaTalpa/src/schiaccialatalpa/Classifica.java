/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schiaccialatalpa;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author pasqui.filippo
 */
public class Classifica {
    private static final String filePath="classifica.txt";
    
    
    
    public static void salvaClassifica(String nome, int punteggio){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            writer.write(nome + ":"+ punteggio);
            writer.newLine();
        }catch (IOException e) {
            System.err.println("Errore nel salvataggio della classifica: " + e.getMessage());
        }
    }
    
    
    
   public static List<String[]> leggiClassifica() {
        List<String[]> record = new ArrayList<>();
        File file = new File(filePath);
        
        if (!file.exists()) return record; 

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String riga;
            while ((riga = reader.readLine()) != null) {
                
                String[] parti = riga.split(":");
                if (parti.length == 2) {
                    record.add(parti);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura della classifica: " + e.getMessage());
        }
        
        
        return record;
    }
}

