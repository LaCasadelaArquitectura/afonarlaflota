// importación de módulos necesarios para el desarrollo de la práctica.
package av1_aa2_afonarlaflota;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author JMA
 */
public class AV1_AA2_AfonarLaFlota {

// se delcara la matriz principal del tablero    
     
    
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
             int max_intents= opcion[6];
             
 // se llama a la funcion jugar_partida
               jugar_partida(files,columnes,llanxes,vaixells,cuirassats,
portaavions,max_intents);
               
               
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

         case 3: opcion= new int[] {11,11,1,1,0,0,10};
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
portaavions, int max_intents) {
    
     char[][] tauler_de_joc = crear_tauler(files,columnes);
     imprimir_matriu(tauler_de_joc);
     
     
     
     
  }
  
//funcion crear_tauler_nivell_1() buit amb "-" en totes les poscions y la numeracion perimetral. devulve un array rellenado segun parametros de la práctica.
 public static char[][] crear_tauler(int files, int columnes){
        char[][]  tauler= new char[files][columnes];     
          for (int i = 0; i <tauler.length; ++i) {
            Arrays.fill(tauler[i],'-');
}
          int z=65; 
          for (int j = 1; j <tauler.length; ++j) {
            int asciiValue = z;
            char convertedChar = (char)asciiValue;
            tauler[j][0] = convertedChar;
            z++;
          }
          
          int w=48; 
          for (int j = 1; j <tauler.length; ++j) {
            int asciiValue = w;
            char convertedChar = (char)asciiValue;
            tauler[0][j] = convertedChar;
            w++;
          }
          
          return tauler;
    }
  
 //Funcion aletorio 
   public static int random(){
    int aleatori = (int) (1+Math.random()*(11-1+1));
   return aleatori;
 }
  
//funcion introducir barco
  
   
  
 // función imprimir_matriu(), imprime el array bidimensional en forma de matriz por pantalla.
    public static void imprimir_matriu(char[][]tauler_de_joc){
      /*  int x= 0;
        int y=65; 
           
        for (int i = 0; i <tauler.length; ++i) {
        System.out.print(x+" ");
        x++;
        
        }
        */
        for (int i = 0; i <tauler_de_joc.length; ++i) {
              System.out.println(" ");
              for(int j=0; j<tauler_de_joc.length; j++){
                  System.out.print(tauler_de_joc[i][j]+" ");
                  
              }
          }
    }
    

 


 
 
 
 

 }
   

   
   
   
     
     
     
     
     

