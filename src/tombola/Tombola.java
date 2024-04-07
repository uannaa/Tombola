/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tombola;

import static java.lang.System.err;
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
        printTombolone(tombolone);
        CreaCartella(cartella);
        System.out.println("\nCartella: \n");
        print(cartella);
        estrainumero(cartella, tombolone);
        
    }
    
    public static void Tabellone(int matrice[][]) {
        
        int k = 1;
        
        for (int i = 0; i < matrice.length; i++) {
            
            for (int j = 0; j < matrice[i].length; j++) {
                
                matrice[i][j] = k;
                k++;
                
            }
            
        }
        
    }
    
    public static void printTombolone(int matrice[][]) {
        
        System.out.println("Tombolone: \n");
        
        for (int i = 0; i < matrice.length; i ++) {
            
            for (int j = 0; j < matrice[i].length; j++) {
                
                if (matrice[i][j] < 10) {
                    
                    System.out.print("0");
                    
                }
                
                
                if (matrice[i][j] == 91) {
                    
                    System.out.print("||" + " ");
                    
                    if (j == 4) {
                        
                        System.out.print("| ");
                        
                    }
                    
                }
                

                if (matrice[i][j] != 91) {
                    
                    System.out.print(matrice[i][j] + " "); 
                    
                }
                
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
    
    public static int[] estrainumero(int cartella[][], int tabellone[][]) {
                
        Random rand = new Random();
        Scanner s = new Scanner(System.in);
        
        int estratto[] = new int[90];
        int contatore = 0;
        int contatore91 = 0;
        
        for (int i = 0; i < estratto.length; i++) {
            
            System.out.println("Vuoi estrarre un numero?\n[1] Si \n[2] No\n");
            char select = s.next().charAt(0);
            

            if (select == '1') {
                
                estratto[i] = rand.nextInt(90 - 1) + 1;
                System.out.println("Il numero estratto e' " + estratto[i]);
                
                
                //Cartella
                for (int h = 0; h < cartella.length; h++) {
                    
                    for (int g = 0; g < cartella[h].length; g++) {
                        
                        if (cartella[h][g] == estratto[i]) {
                            
                            cartella[h][g] = 91;
                            System.out.println("Hai questo numero!");
                            System.out.println("Cartella aggiornata: ");
                            print(cartella);
                            System.out.println();
                            contatore++;
                            controlla(contatore, cartella, false);
                            
                        }
                        
                    }
                    
                }
                
                System.out.println();
                
                int contatoreTabella = 0;
                
                for (int z = 0; z < tabellone.length; z++) {
                    
                    for (int b = 0; b < tabellone[z].length; b++) {
                        
                        if (tabellone[z][b] == estratto[i]) {
                        
                            tabellone[z][b] = 91;
                            System.out.println("Il tabellone ha questo numero!");
                            System.out.println("Tabellone aggiornato: ");
                            printTombolone(tabellone);
                            contatoreTabella = 0;
                            controlla(contatoreTabella, tabellone, true);
                            
                        }
                        
                    }
                    
                }
                
                
            } else if (select == '2') {
                
                break;
                
            } else {
                
                System.out.println("Error");
                
            }
            
            
        }     
        
        return estratto;
        
    }
    
    public static void controlla(int contatore, int matrice[][], boolean check) {
        
        int ambo = 0, terno = 0, quaterna = 0, quintina = 0;
        int contatore91 = 0;
        
        
        //Cartella
        if (contatore >= 2 && check == false) {

        //Se in quella riga ci sono 2 o piu numeri uguali a 91, allora segnalare il numero dei numeri equivalenti a 91.
        // 2 = ambo ...
            int nf = 1;

            for (int f = 0; f < matrice.length; f++) {

                for (int j = 0; j < matrice[f].length; j++) {

                    if (matrice[f][j] == 91) {

                        if (nf != f) {

                            contatore91 = 0;
                            nf = f;

                        }

                        contatore91++;

                    }

                }

                if (ambo == 0 && contatore91 == 2) {

                    System.err.println("Hai fatto ambo nella riga " + (f + 1));
                    ambo = 1;
  
                } else if (ambo == 1 && terno == 0 && contatore91 == 3) {

                    System.err.println("Hai fatto terno nella riga " + (f + 1));
                    terno = 1;

                } else if (ambo == 1 && terno == 1 && quaterna == 0 && contatore91 == 4) {

                    System.err.println("Hai fatto quaterna nella riga " + (f + 1));
                    quaterna = 1;

                } else if (ambo == 1 && terno == 1 && quaterna == 1 && quintina == 0 && contatore91 == 5) {

                    System.err.println("Hai fatto quintina nella riga " + (f + 1));
                    quintina = 1;

                } 

            }

        }
        
        //tabellone        
        if (contatore >= 2 && check == true) {
            
            int nt = 1;
            
            for (int i = 0; i < matrice.length; i++) {
                
                for (int l = 0; l < 5; l++) {
                    
                    if (matrice[i][l] == 91) {
                        
                        if (nt != i) {
                            
                            contatore91 = 0;
                            nt = i;
                            
                        }
                        
                        contatore91++;
                        
                    }
                    
                } 
                
                if (ambo == 1 || ambo == 0 && contatore91 == 2) {

                    System.err.println("Hai fatto ambo nella riga " + (i + 1));
                    ambo = 2;

                } else if (ambo == 2 && terno == 0 || terno == 1 && contatore91 == 3) {

                    System.err.println("Hai fatto terno nella riga " + (i + 1));
                    terno = 2;

                } else if (ambo == 2 && terno == 2 && quaterna == 0 || quaterna == 1 && contatore91 == 4) {

                    System.err.println("Hai fatto quaterna nella riga " + (i + 1));
                    quaterna = 2;

                } else if (ambo == 2 && terno == 2 && quaterna == 2 && quintina == 0 || quintina == 1&& contatore91 == 5) {

                    System.err.println("Hai fatto quintina nella riga " + (i + 1));
                    quintina = 2;

                }
                
            }
            
        }
        
    }
    
//    public static void ControllaTabellone() {
//        
//         int nf = 1;
//        
//    }
    
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
