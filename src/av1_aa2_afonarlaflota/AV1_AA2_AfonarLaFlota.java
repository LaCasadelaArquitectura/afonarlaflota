// Importació de móduls necesaris per el desembolupament de la practica.
package av1_aa2_afonarlaflota;

import java.util.Scanner;
import objetos.Barco;
import java.util.*;
import java.lang.*;

/**
 *
 * @author JMA
 */
public class AV1_AA2_AfonarLaFlota {

// Es delcara la matriu principal del tauler. 
     
int contador = 1;   
// Es declara la funcion main
    public static void main(String[] args) {
// Es crida a la funcio inici 1 que conté el misatje de benvinguda.      
        inici1();
        
// Es crida a la funcio inici 2 que conté la llista de nivels a triar.        
        inici2();
        
//Es declara el esacaner que ens permet introduir dades per el teclat.
        Scanner scan=new Scanner(System.in);
        
// Es demana una dada de entrada al usuari i es crida a la funció nivell().
        int niv = scan.nextInt();
        int nivell =  nivell(niv);
       
// Es crida a la funcio opció. S'agafa el valor de les variables del nivell
// buscant en la direccion concreta dins del arrel.
    
    int[] opcion= opcion(nivell);
    
        int files= opcion[0];
        int columnes= opcion[1];
        int llanxes= opcion[2];
        int vaixells= opcion[3];
        int cuirassats= opcion[4];
        int portaavions= opcion[5];
        int trets= opcion[6];
             
 // Es Crida a la funció jugar_partida (El programa pricipal continuará dins d'aquesta funció.)
        jugar_partida(files,columnes,llanxes,vaixells,cuirassats,portaavions, trets);          
    }
      
// FUNCIÓ:  inici1() trau per pantalla el misatje de benvinguda.      
    public static void inici1(){
         System.out.println("===== BENVINGUTS A ENFONSAR LA FLOTA =====");
      System.out.println("");
      System.out.println("Nivells de dificultat:");}

// FUNCIÓ:  inici2() trau per pantalla els nivells de dificultad disponibles        
    public static void inici2(){
      System.out.println("1. Fàcil: 5 llanxes, 3 vaixells, 1 cuirassat i 1 portaavions (50 trets).");
      System.out.println("2. Mitjà: 2 llanxes, 1 vaixell, 1 cuirassat i 1 portaavions (30 trets).");
      System.out.println("3. Difícil: 1 llanxa y 1 vaixell (10 trets).");
      System.out.println("Quin nivell tries? ");
    }
 
// FUNCIÓ: repetirNumero() trau per pantalla un misatje de error si l'usuari intrdueix un numero diferent als disponibles.
     public static void repetirNumero() {
     System.out.println("El nivell escollit no es correcte, torna a triar");    
    }  
 
// FUNCIÓ: nivell (niv) torna el número del nivell nomes si es correcte.  
     public static int nivell (int niv){
      Scanner scan=new Scanner(System.in);
      while (niv != 1 && niv != 2 && niv != 3 && niv != 4){
          repetirNumero();
          inici2();
          niv = scan.nextInt();
      }return niv;
    }
    
// FUNCIÓ: opcion()  segons el nivell escollit, mijançant un switch, es introduixen dins un arrel  
//   totes les  variables relatives al nivell (files, columnes, llanxes, vaixells, cuirassats
//   portaavions i trets) Retorna l'arrel escollit..
 public static int[] opcion(int nivell) {
          
     Scanner scan=new Scanner(System.in);
      int[] opcion = new int[7];
     
     switch(nivell){
    
         case 1: opcion= new int[] {10,10,5,3,1,1,50};
         break;
         
         case 2: opcion= new int[] {10,10,2,1,1,1,30};
         break;

         case 3: opcion= new int[] {10,10,1,1,0,0,10};
         break;

        case 4: 
            opcion= new int[7];
            for (int i = 0; i <opcion.length; ++i) {
           opcion[i] = scan.nextInt();
        } break;   
        
                } return opcion;
            }
     
// FUNCIÓ: jugar_partida() (El programa pricipal continua ací.)
  public static void jugar_partida(int files, int columnes, int llanxes, int vaixells, int cuirassats, int
portaavions, int trets) {
      
     char[][] tauler_buit = crear_tauler(files,columnes);
     char[][] tauler_barcos = crear_tauler(files,columnes);
     tauler_barcos = tauler_barcos(tauler_barcos,llanxes,vaixells,cuirassats,portaavions);
     trets(tauler_barcos,tauler_buit,trets);
     imprimir_tauler(tauler_barcos);
     fi_partida(tauler_barcos);  
  }
  
// FUNCIÓ: crear_tauler_nivell_1() buit amb "-" en totes les poscions y la numeració perimetral. 
//  torna un array ple segons les indicacions de la práctica. Per poder auto plenar els caracters
// permitrals es fa mijançant el codi ASCII. 
 public static char[][] crear_tauler(int files, int columnes){
        char[][]  tauler= new char[files][columnes];     
          for (int i = 0; i <tauler.length; ++i) {
            Arrays.fill(tauler[i],'-');
    }return tauler;
    }
  
// FUNCIÓ: Aletori. Donant-li la columna o fila máxima, retorna un valor aleatori.
   public static int random(int colmax){
    int aleatori = (int) (1+Math.random()*(colmax-1+1));
   return aleatori;
 }
  
/* PROCEDIMENT: Inserir els barcos en posicions aleatòries
   Es crida als "objectes" barcos de la clase "Barco" els cuals porten prededinides les seues
   caracteristiques en funció del tipus de vaixell. (lletra, numero de espais que ocupa y la posició
   maxima en la que es pot inserir). 
Per inserir els Barcos, es crea un bucle for per cada tipus on s'agafa un numero aleatori per
   les files y atre per les columnes, amb la columna mazima predefinida per la clase en funció
   de les caselles que ocupa el barco. Comprova que les posicions son buides i inserix el Barco.
Per ultim, torna l'arrel bidimensional del tauler.   
*/

public static char[][] tauler_barcos(char[][] tauler_barcos,int llanxes, int vaixells, int cuirassats, int
portaavions){
     int x; int y; int z;
      Barco portaavio;  portaavio = new Barco("portaavions");
     
      for (int i=0; i<portaavions; i++){
         do{x=random(9); y= random(portaavio.colmax);
         }while(tauler_barcos[x][y] != '-' ||
                 tauler_barcos[x][y+1] != '-' ||
                 tauler_barcos[x][y+2] != '-' ||
                 tauler_barcos[x][y+3] != '-'||
                 tauler_barcos[x][y+4] != '-');
         for(z=y; z<y+portaavio.ncasillas; z++){
         tauler_barcos[x][z]= portaavio.letra;}  
      }
      Barco cuirassat;  cuirassat = new Barco("cuirassat");
      for (int i=0; i<cuirassats; i++){
         do{x=random(9); y= random(portaavio.colmax);
         }while(tauler_barcos[x][y] != '-' ||
                 tauler_barcos[x][y+1] != '-' ||
                 tauler_barcos[x][y+2] != '-' ||
                 tauler_barcos[x][y+3] != '-'||
                 tauler_barcos[x][y+4] != '-');
         for(z=y; z<y+cuirassat.ncasillas; z++){
         tauler_barcos[x][z]= cuirassat.letra;}
      }
     Barco vaixell;  vaixell = new Barco("vaixell");
       for (int i=0; i<vaixells; i++){
         do{x=random(9); y= random(portaavio.colmax);
         }while(tauler_barcos[x][y] != '-' ||
                 tauler_barcos[x][y+1] != '-' ||
                 tauler_barcos[x][y+2] != '-' ||
                 tauler_barcos[x][y+3] != '-'||
                 tauler_barcos[x][y+4] != '-');
         for(z=y; z<y+vaixell.ncasillas; z++){
         tauler_barcos[x][z]= vaixell.letra;}
      }
    Barco llanxa;  llanxa = new Barco("llanxa");
         for (int i=0; i<llanxes; i++){
         do{x=random(9); y= random(portaavio.colmax);
         }while(tauler_barcos[x][y] != '-' ||
                 tauler_barcos[x][y+1] != '-' ||
                 tauler_barcos[x][y+2] != '-' ||
                 tauler_barcos[x][y+3] != '-'||
                 tauler_barcos[x][y+4] != '-');
         for(z=y; z<y+llanxa.ncasillas; z++){
         tauler_barcos[x][z]= llanxa.letra;}
      }return tauler_barcos;
     }
 
/* FUNCIÓ: Tret.  Declara l'éscaner, un contador de trets, dos variables numeriques per
les files i les columnes, dos varialbes String on els numeros o les lletres coincidixen amb el
index del String transofrmat a arrel i el tauler.
Es crea un Do While dins de un for igual al numero de trets. El escaner ens demana una entrada
i si aquesta no está dins el parametres de les String, retorna -1, que el while s'encarrega de filtrar.
A continuació mijantant if comprobem si la casella es buida y actuem en consequencia.
Finalment es mostra el tauler per pantalla.

*/
 public static void trets(char[][] tauler_barcos,char[][] tauler_buit, int trets){
    Scanner scan=new Scanner(System.in);
     int contador=1;
     int fila=0;
     int columna=0;
    String letras= "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
    String numeros= "0123456789"; 
     imprimir_tauler(tauler_buit);
     
     for(int i=0; i<trets; i++){
     do{
         System.out.print("tret: " + contador +", introdueix fila");
     char f = scan.next().charAt(0);
     fila= letras.indexOf(f);        
     System.out.print("tret: " + contador +", introdueix columna");
     char c = scan.next().charAt(0);
     columna= numeros.indexOf(c);
      }while(fila  == -1 || columna == -1 );
     
     
    if(tauler_barcos[fila][columna] == '-' || tauler_barcos[fila][columna] == 'A'){
        System.out.println("Aigua!");
        tauler_buit[fila][columna]= 'A';
        tauler_barcos[fila][columna]= 'A';
    }else{
        System.out.println("Tocat!!");
        tauler_buit[fila][columna]= 'X';
        tauler_barcos[fila][columna]= 'X';
    }
    imprimir_tauler(tauler_buit);
    
  
// FUNCIÓ: Break. Para la partida y te indica la victoria cuan afones tots els barcos.
// Mijançant la funció Arrays.deepToString(), es transforma l'arrel en un String.
// Amb la funció tf.contains() es recorre la String en busca dels caracters identificatius dels barcos.
// si no es troba ningú, ejecuta un break en la funcio Trets()
    String tf= Arrays.deepToString(tauler_barcos);
     boolean t = tf.contains("P")||tf.contains("Z")||tf.contains("V")||tf.contains("L");
     if (t == false){
     break;}
     contador++;
     } 
 }
// FUNCIÓ: fi de partida. Amb el mateix metode que la funció Break, escaneja el tauler en busca
// de les lletres identificatives del Barcos i finalmente imprimix per pantalla el resultat final. 
 
 public static void fi_partida(char[][] tauler_final){
  
     String tf= Arrays.deepToString(tauler_final);
     boolean t = tf.contains("P")||tf.contains("Z")||tf.contains("V")||tf.contains("L");
     if (t){
     System.out.println("HAS PERDUT!!!");}else{
         System.out.println("HAS GUANYAT!!!");
 }
 }

// FUNCIÓ:  imprimir_tauler(), imprimix l'arrel bidimensional en forma de matriu per pantalla 
 //cada vegada que es cridada. Aquesta funció es cridada diverses vegades en aquest programa.
    public static void imprimir_tauler(char[][]tauler){
     
      char convertedChar = 'a';
                 
        System.out.print("-  ");
        for (int i = 0; i <tauler.length; ++i) {
       System.out.print(i + "  ");
      }
        for (int i = 0; i <tauler.length; ++i) {
            System.out.println(" ");
             int asciiValue = i+65;
            convertedChar = (char)asciiValue;
            System.out.print(convertedChar+"  ");  
              for(int j=0; j<tauler.length; j++){
                  System.out.print(tauler[i][j]+"  ");
                 }
          }System.out.println(" ");System.out.println(" ");
    }
 }
   

   
   
   
     
     
            
     
     
     

