// importación de módulos necesarios para el desarrollo de la práctica.
package av1_aa2_afonarlaflota;

import java.util.Scanner;
import objetos.Barco;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 *
 * @author JMA
 */
public class AV1_AA2_AfonarLaFlota {

// se delcara la matriz principal del tablero    
     
int contador = 1;   
// se declara la funcion main
    public static void main(String[] args) {
// se llama a la funcion inicio 1 que continee el mensaje de bienvenida.        
        inicio1();
        
// se llama a la funcion inicio 2 que contiene la lista de niveles a escoger.        
        inicio2();
        
//se declara el esacaner que nos permite introdcir datos por teclado.
        Scanner scan=new Scanner(System.in);
        
// se pide un dato de entrada al usuario y se llama a la funcion nivell()
       int niv = scan.nextInt();
       int nivell =  nivell(niv);
       
// se llama a la funcion opcion
    
    int[] opcion= opcion(nivell);
    
             int files= opcion[0];
             int columnes= opcion[1];
             int llanxes= opcion[2];
             int vaixells= opcion[3];
             int cuirassats= opcion[4];
             int portaavions= opcion[5];
             int trets= opcion[6];
             
 // se llama a la funcion jugar_partida
               jugar_partida(files,columnes,llanxes,vaixells,cuirassats,
portaavions, trets);
               
               
// Se llama a la funcion crear_tauler_nivell_1(), que crea el tablero de nivel 1 según parametros de la práctica        
       // crear_tauler_nivell_1();
// Se llama a la funcion imprimir_matriu(); que muestra el tablero vacio en pantalla        
  //      char[][] tauler_de_joc = crear_tauler(files,columnes);        
   //     imprimir_matriu(tauler_de_joc);

     
        
    }
// funcion inicio1() muestra el mensaje de bienvenida.      
    public static void inicio1(){
         System.out.println("===== BENVINGUTS A ENFONSAR LA FLOTA =====");
      System.out.println("");
      System.out.println("Nivells de dificultat:");}

// funcion inicio2() muestra los niveles de dificultad disponibles        
    public static void inicio2(){
      System.out.println("1. Fàcil: 5 llanxes, 3 vaixells, 1 cuirassat i 1 portaavions (50 trets).");
      System.out.println("2. Mitjà: 2 llanxes, 1 vaixell, 1 cuirassat i 1 portaavions (30 trets).");
      System.out.println("3. Difícil: 1 llanxa y 1 vaixell (10 trets).");
      System.out.println("Quin nivell tries? ");
    }
 
// funcion repetirNumero() muestra mesaje de error 
     public static void repetirNumero() {
     System.out.println("El nivell escollit no es correcte, torna a triar");
    
    }  
 
// funcion nivell (niv) devuelve el numero del nivel solo si es correcto.  
     public static int nivell (int niv){
      Scanner scan=new Scanner(System.in);
      while (niv != 1 && niv != 2 && niv != 3 && niv != 4){
          repetirNumero();
          inicio2();
          niv = scan.nextInt();
      }return niv;
    }
    
// función opcion()  
 public static int[] opcion(int nivell) {
          
     Scanner scan=new Scanner(System.in);
      int[] opcion = new int[7];
     
     switch(nivell){
    
         case 1: opcion= new int[] {11,11,5,3,1,1,50};
         break;
         
         case 2: opcion= new int[] {11,11,2,1,1,1,30};
         break;

         case 3: opcion= new int[] {11,11,0,0,0,1,30};
         break;

        case 4: 
            opcion= new int[7];
            for (int i = 0; i <opcion.length; ++i) {
           opcion[i] = scan.nextInt();
        } break;   
        
                } return opcion;
            }
     
// funcion jugar_partida() 
  public static void jugar_partida(int files, int columnes, int llanxes, int vaixells, int cuirassats, int
portaavions, int trets) {
      
     char[][] tauler_buit = crear_tauler(files,columnes);
     char[][] tauler_barcos = crear_tauler(files,columnes);
     tauler_barcos = tauler_barcos(tauler_barcos,llanxes,vaixells,cuirassats,portaavions);
     trets(tauler_barcos,tauler_buit,trets);
     imprimir_tauler(tauler_barcos);
     fi_partida(tauler_barcos);
     
    
     
   
  }
  
//funcion crear_tauler_nivell_1() buit amb "-" en totes les poscions y la numeracion perimetral. devulve un array rellenado segun parametros de la práctica.
 public static char[][] crear_tauler(int files, int columnes){
        char[][]  tauler= new char[files][columnes];     
          for (int i = 0; i <tauler.length; ++i) {
            Arrays.fill(tauler[i],'-');
}
          int z=65; 
          for (int j = 0; j <tauler.length; ++j) {
            int asciiValue = z;
            char convertedChar = (char)asciiValue;
            tauler[j][0] = convertedChar;
            z++;
          }
          
        
          return tauler;
    }
  
 //Funcion aletorio 
   public static int random(int colmax){
    int aleatori = (int) (1+Math.random()*(colmax-1+1));
   return aleatori;
 }
  
//funcion introducir barco
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
      }
 
     return tauler_barcos;
     }
 
 //funcio tret 
 public static void trets(char[][] tauler_barcos,char[][] tauler_buit, int trets){
    Scanner scan=new Scanner(System.in);
     int contador=1;
     int fila=0;
     int columna=0;
    String letras= "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
    String numeros= " 123456789"; 
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
    
  
// para la partida y te indica la victoria cunado hundes todos los barcos.    
    String tf= Arrays.deepToString(tauler_barcos);
     boolean t = tf.contains("P")||tf.contains("Z")||tf.contains("V")||tf.contains("L");
     if (t == false){
     break;}
     contador++;
     } 
 }
 
 //funcion comprobar tablero
 
 public static void fi_partida(char[][] tauler_final){
 
     
     String tf= Arrays.deepToString(tauler_final);
     boolean t = tf.contains("P")||tf.contains("Z")||tf.contains("V")||tf.contains("L");
     if (t){
     System.out.println("HAS PERDUT!!!");}else{
         System.out.println("HAS GUANYAT!!!");
 }
 }

 // función imprimir_matriu(), imprime el array bidimensional en forma de matriz por pantalla.
    public static void imprimir_tauler(char[][]tauler){
      System.out.print("-  ");
        for (int i = 1; i <tauler.length; ++i) {
       System.out.print(i + "  ");
      }
        for (int i = 0; i <tauler.length; ++i) {
              System.out.println(" ");
              for(int j=0; j<tauler.length; j++){
                  System.out.print(tauler[i][j]+"  ");
                 }
          }System.out.println(" ");System.out.println(" ");
    }

 }
   

   
   
   
     
     
     
     
     

