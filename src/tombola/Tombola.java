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
        
        
        
        spaziVuoti();
        
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
        
        int max = 0;
        int min = 0;
        
        for (int i = 0; i < cartella.length; i++) {
            
            max = 9;
            min = 0;
            
            for (int j = 0; j < cartella[i].length; j++) {
                
                cartella[i][j] = rand.nextInt(max - min) + min;
                rimuoviDuplicati(cartella, max, min);
                
                
                max += 10;
                min += 10;
                
            }
            
        }
        
        
        
        System.out.println("\nCartella: \n");
        
        ordinaMatrice(cartella);
        
        
        for (int i = 0; i < 4; i++) {
            
            System.out.println(spaziVuoti());
            
        }
        
        //print cartella
        for (int i = 0; i < cartella.length; i++) {
            
            for (int j = 0; j < cartella[i].length; j++) {
                
                if (cartella[i][j] < 10) {
                    
                    System.out.print("0");
                    
                }
                
                System.out.print(cartella[i][j] + " ");
                
                
                
                if (j == 8) {
                    
                    System.out.println();
                    
                }
                
            }
            
        }
        
        for (int i = 0; i < cartella.length; i++) {
            
            for (int j = 0; j < cartella[i].length; j++) {
                
                if (cartella[i][j] == 0) {
                    
                    
                    
                }
            }
            
        }
        

        
        System.out.println("\nCartella: \n");
//        
//        for (int i = 0; i < cartella.length; i++) {
//            
//            for (int j = 0; j < cartella[i].length; j++) {
//                
//                if (cartella[i][j] < 10) {
//                    
//                    System.out.print("0");
//                    
//                }
//                
//                System.out.print(cartella[i][j] + " ");
//                
//                
//                
//                if (j == 8) {
//                    
//                    System.out.println();
//                    
//                }
//                
//            }
//            
//        }
        
    }
    
    public static void rimuoviDuplicati(int matrice[][], int max, int min) {
        
        Random rand = new Random();
        
        for (int colonna = 0; colonna < matrice[0].length; colonna++) {
            
            for (int riga = 0; riga < matrice.length; riga++) {
                
                int valoreCorrente = matrice[riga][colonna];
                
                for (int confrontoRiga = riga + 1; confrontoRiga < matrice.length; confrontoRiga++) {
                    
                    if (matrice[confrontoRiga][colonna] == valoreCorrente) {
                        matrice[confrontoRiga][colonna] = 0; 
                    }
                    
                }
            }
        }
        
    }
    
    public static void ordinaMatrice(int[][]cartella){
        
        for (int col = 0; col < cartella[0].length; col++) {

            for (int i = 0; i < cartella.length - 1; i++) {

                int min = i;

                for (int j = i + 1; j < cartella.length; j++) {

                    if (cartella[j][col] < cartella[min][col]) {

                        min = j;

                    }
                }
                if (min != i) {

                    int temp = cartella[i][col];
                    cartella[i][col] = cartella[min][col];
                    cartella[min][col] = temp;

                }
            }
        }
    }
    
    public static int[] spaziVuoti() {
        
        Random rand = new Random();
        
        int numvuoti[] = new int[4];
        int numvuoti2[] = new int[4];
        int numvuoti3[] = new int[4];
        
        for (int i = 0; i < numvuoti.length; i++) {
            
            numvuoti[i] = rand.nextInt(8-0) + 0;
            for (int j = 0; j < numvuoti.length; j++) {
                
                while (numvuoti[i] == numvuoti[j]) {
                    
                    numvuoti[i] = rand.nextInt(8-0) + 0;
                    
                }
                
            }
            
        }
        
        return numvuoti;
        
    }
    
}
