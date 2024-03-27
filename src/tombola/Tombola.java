/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tombola;

import java.util.Random;

/**
 *
 * @author paolo
 */
public class Tombola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int cartella[][] = new int[3][9];
        int tombolone[][] = new int[9][10];
        int k = 1;
        
        
        //Tombolone
        for (int i = 0; i < tombolone.length; i++) {
            
            for (int j = 0; j < tombolone[i].length; j++) {
                
                tombolone[i][j] = k;
                k++;
                
            }
            
        }
        
        System.out.println("Tombolone: \n");
        
        for (int i = 0; i < tombolone.length; i ++) {
            
            for (int j = 0; j < tombolone[i].length; j++) {
                
                if (tombolone[i][j] < 10) {
                    
                    System.out.print("0");
                    
                }
                

                
                System.out.print(tombolone[i][j] + " ");
                
                if(tombolone[i][j] % 10 == 5) {
                    
                    System.out.print("| ");
                    
                }
                
                if (j == 9) {
                    
                    System.out.println();
                    
                }
                
            }
            
        }
        
        //creazione cartella
        
        Random rand = new Random();
        
        
        
        
        //print cartella
        for (int i = 0; i < cartella.length; i++) {
            
            for (int j = 0; j < cartella[i].length; j++) {
                
                System.out.println(cartella[i][j]);
                
            }
            
        }
        
    }
    
}
