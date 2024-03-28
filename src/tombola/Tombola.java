/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tombola;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
        
        int max = 0;
        int min = 0;
        
        for (int i = 0; i < cartella.length; i++) {
            
            max = 9;
            min = 1;
            
            for (int j = 0; j < cartella[i].length; j++) {
                
                cartella[i][j] = rand.nextInt(max - min) + min;
                rimuoviDuplicatiEGeneraCasualeColonne(cartella, max, min);
                
                
                max += 10;
                min += 10;
                
            }
            
        }
        
        ordinaMatrice(cartella);
        spaziVuoti(cartella);
        
        //print cartella
        
        System.out.println("\nCartella: \n");
        
        for (int i = 0; i < cartella.length; i++) {
            
            for (int j = 0; j < cartella[i].length; j++) {
                

                
                if (cartella[i][j] < 10 && cartella[i][j] != 0) {
                    
                    System.out.print("0");
                    
                }
                
                if (cartella[i][j] != 0) {
                    
                    System.out.print(cartella[i][j] + " ");
                    
                } else if (cartella[i][j] == 0) {
                    
                    System.out.print("// ");
                    
                }
                
                if (j == 8) {
                    
                    System.out.println();
                    
                }
                
            }
            
        }
        
        estrainumero();
        controllaNumTabellone(tombolone);
        controlloCartella(cartella);
        
    }
    
    public static void controllaNumTabellone(int tabellone[][]) {
        
        
        
    }
    
    public static void controlloCartella(int cartella[][]){
        
        int estratti[] = estrainumero();
        
        for (int i = 0; i < estratti.length; i++) {
            
            for (int j = 0; j < cartella.length; j++) {
                
                for (int k = 0; k < cartella[j].length; k++) {
                    
                    if (estratti[i] == cartella[j][k]) {
                        
                        System.out.println("HAI IL NUMERO " + estratti[i]);
                        
                    }
                    
                }
                
            }
            
        }
        
    }
    
    
    public static int[] estrainumero() {
        
        Random rand = new Random();
        Scanner s = new Scanner(System.in);
        
        int estratto[] = new int[90];
        
        for (int i = 0; i < estratto.length; i++) {
            
            System.out.println("Vuoi estrarre un numero?\n[1] Si \n[2] No\n");
            char select = s.next().charAt(0);
            
            if (select == '1') {
                
                estratto[i] = rand.nextInt(90 - 1) + 1;
                System.out.println("Il numero estratto e' " + estratto[i]);
                
            } else if (select == '2') {
                
                break;
                
            } else {
                
                System.out.println("Error");
                
            }
            
            
        }     
        
        return estratto;
        
    }
    
    public static void rimuoviDuplicatiEGeneraCasualeColonne(int[][] matrice, int max, int min) {
        Random random = new Random();

        for (int j = 0; j < matrice[0].length; j++) {
            boolean[] presenti = new boolean[90];

            for (int i = 0; i < matrice.length; i++) {
                if (!presenti[matrice[i][j]]) {
                    presenti[matrice[i][j]] = true;
                } else {
                    int numeroCasuale;
                    do {
                        numeroCasuale = random.nextInt(max - min) + min; // Genera un numero casuale da 0 a 8
                    } while (presenti[numeroCasuale]);
                    presenti[numeroCasuale] = true;
                    matrice[i][j] = numeroCasuale;
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
    
    public static void spaziVuoti(int matrice[][]) {
        
        Random rand = new Random();
        
        int spazivuoti[][] = new int[3][4];
        
        for (int i = 0; i < spazivuoti.length; i++) {
            
            for (int j = 0; j < spazivuoti[i].length; j++) {
                
                spazivuoti[i][j] = rand.nextInt(8 - 0) - 0;
                
            }
            
        }
        
        rimuoviDuplicatiEGeneraCasuale(spazivuoti, 8, 0);
        
        
        for (int i = 0; i < spazivuoti.length; i++) {
        
            for (int j = 0; j < spazivuoti[i].length; j++) {
                
                int k = spazivuoti[i][j];
                
                matrice[i][k] = 0;
                
            }
        
        }
        
//        print
//        int temp = 0;
//        
//        for (int i = 0; i < spazivuoti.length; i++) {
//            
//            for (int j = 0; j < spazivuoti[i].length; j++) {
//                
//                if (temp != i) {
//                    
//                    System.out.println();
//                    
//                }
//                System.out.print(spazivuoti[i][j]);
//                
//                temp = i;
//            }
//            
//            System.out.println();
//            
//        }
        
    }
    
    public static void rimuoviDuplicatiEGeneraCasuale(int[][] matrice, int max, int min) {
        Random random = new Random();

        for (int i = 0; i < matrice.length; i++) {
            boolean[] presenti = new boolean[9];
            int[] nuovaRiga = new int[matrice[i].length];
            int index = 0;

            for (int numero : matrice[i]) {
                if (!presenti[numero]) {
                    presenti[numero] = true;
                    nuovaRiga[index++] = numero;
                } else {
                    int numeroCasuale;
                    do {
                        numeroCasuale = random.nextInt(max - min) + min; // Genera un numero casuale da 0 a 8
                    } while (presenti[numeroCasuale]);
                    presenti[numeroCasuale] = true;
                    nuovaRiga[index++] = numeroCasuale;
                }
            }

            matrice[i] = Arrays.copyOf(nuovaRiga, index);
        }
    }
    
}
