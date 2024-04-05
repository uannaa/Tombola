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
    
    public static void main(String[] args) {
        
        int cartella[][] = new int[3][9];
        int tombolone[][] = new int[9][10];
        
        

        Tabellone(tombolone);
        CreaCartella(cartella);
        System.out.println("\nCartella: \n");
        print(cartella);
        estrainumero(cartella);
        
    }
    
    public static void Tabellone(int matrice[][]) {
        
        int k = 1;
        //Tombolone
        for (int i = 0; i < matrice.length; i++) {
            
            for (int j = 0; j < matrice[i].length; j++) {
                
                matrice[i][j] = k;
                k++;
                
            }
            
        }
        
        System.out.println("Tombolone: \n");
        
        for (int i = 0; i < matrice.length; i ++) {
            
            for (int j = 0; j < matrice[i].length; j++) {
                
                if (matrice[i][j] < 10) {
                    
                    System.out.print("0");
                    
                }
                

                
                System.out.print(matrice[i][j] + " ");
                
                if(matrice[i][j] % 10 == 5) {
                    
                    System.out.print("| ");
                    
                }
                
                if (j == 9) {
                    
                    System.out.println();
                    
                }
                
            }
            
        }
        
    }
    
    public static void CreaCartella(int cartella[][]) {
     
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
        
    }
    
    public static void print(int cartella[][]) {
        
        for (int i = 0; i < cartella.length; i++) {
            
            for (int j = 0; j < cartella[i].length; j++) {
                
                if (cartella[i][j] < 10 && cartella[i][j] != 0) {
                    
                    System.out.print("0");
                    
                }
                

                if (cartella[i][j] != 0 && cartella[i][j] != 91) {
                    
                    System.out.print(cartella[i][j] + " ");
                    
                } else if (cartella[i][j] == 0) {
                    
                    System.out.print("// ");
                    
                } else if (cartella[i][j] > 90) {
                    
                    System.out.print("|| ");
                    
                }
                

                
                
                if (j == 8) {
                    
                    System.out.println();
                    
                }
                
            }
            
        }
        
        System.out.println();
        
    }
    
    public static int[] estrainumero(int cartella[][]) {
                
        Random rand = new Random();
        Scanner s = new Scanner(System.in);
        
        int estratto[] = new int[90];
        int contatore = 0;
        int contatore91 = 0;
        boolean ambo = false, terno = false, quaterna = false, quintina = false;
        
        for (int i = 0; i < estratto.length; i++) {
            
            System.out.println("Vuoi estrarre un numero?\n[1] Si \n[2] No\n");
            char select = s.next().charAt(0);
            

            if (select == '1') {
                
                estratto[i] = rand.nextInt(90 - 1) + 1;
                System.out.println("Il numero estratto e' " + estratto[i]);
                
                for (int h = 0; h < cartella.length; h++) {
                    
                    for (int g = 0; g < cartella[h].length; g++) {
                        
                        if (cartella[h][g] == estratto[i]) {
                            
                            cartella[h][g] = 91;
                            System.out.println("Hai questo numero!");
                            System.out.println("Cartella aggiornata: ");
                            print(cartella);
                            System.out.println();
                            contatore++;
                            
                            if (contatore >= 2) {
                                
                                //Se in quella riga ci sono 2 o piu numeri uguali a 91, allora segnalare il numero dei numeri equivalenti a 91.
                                // 2 = ambo ...
                                int nf = 1;
                                
                                 for (int f = 0; f < cartella.length; f++) {
                                    
                                    for (int j = 0; j < cartella[f].length; j++) {
                                        
                                        if (cartella[f][j] == 91) {
                                            
                                            if (nf != f) {
                                                
                                                contatore91 = 0;
                                                nf = f;
                                                
                                            }
                                            
                                            contatore91++;
                                            
                                        }
                                        
                                    }
                                    
                                    if (ambo == false && contatore91 == 2) {
                                        
                                        System.err.println("Hai fatto ambo nella riga " + (f + 1));
                                        ambo = true;
                                        
                                    } else if (ambo == true && terno == false && contatore91 == 3) {
                                        
                                        System.err.println("Hai fatto terno nella riga " + (f + 1));
                                        terno = true;
                                        
                                    } else if (ambo == true && terno == true && quaterna == false && contatore91 == 4) {
                                        
                                        System.err.println("Hai fatto quaterna nella riga " + (f + 1));
                                        quaterna = true;
                                        
                                    } else if (ambo == true && terno == true && quaterna == true && quintina == false && contatore91 == 5) {
                                        
                                        System.err.println("Hai fatto quintina nella riga " + (f + 1));
                                        quintina = true;
                                        
                                    } 
                                    
                                }
                                 
                            }
                            
                        }
                        
                    }
                    
                }
                
                System.out.println();
                
                
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
                        numeroCasuale = random.nextInt(max - min) + min;
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
