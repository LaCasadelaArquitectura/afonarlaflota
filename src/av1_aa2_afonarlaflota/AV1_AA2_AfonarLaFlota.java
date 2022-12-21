package av1_aa2_afonarlaflota;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class AV1_AA2_AfonarLaFlota {

    public static char[][]  matriu= new char[11][11];     
    public static void main(String[] args) {
        // TODO code application logic here
        inicio1();
        inicio2();
        Scanner scan=new Scanner(System.in);
        int niv = scan.nextInt();
     
        niv = nivell(niv);
        AV1_AA2_AfonarLaFlota.matriu= matriu;
        crear_tauler_nivell_1();
        imprimir_matriu();
 //   for (int i = 0; i < tauler.length; i++) {
// Per a cada columna (nota)
//for (int j = 0; j < tauler[i].length; j++) {
//System.out.println(tauler[i][j]);
//}
//}
      
      
        
    }
    
    public static void inicio1(){
         System.out.println("===== BENVINGUTS A ENFONSAR LA FLOTA =====");
      System.out.println("");
      System.out.println("Nivells de dificultat:");}
   
    public static void inicio2(){
      System.out.println("1. Fàcil: 5 llanxes, 3 vaixells, 1 cuirassat i 1 portaavions (50 trets).");
      System.out.println("2. Mitjà: 2 llanxes, 1 vaixell, 1 cuirassat i 1 portaavions (30 trets).");
      System.out.println("3. Difícil: 1 llanxa y 1 vaixell (10 trets).");
      System.out.println("Quin nivell tries? ");
    }
    
     public static void repetirNumero() {
     System.out.println("El nivell escollit no es correcte, torna a triar");
    
    }  
     
     public static int nivell (int niv){
      Scanner scan=new Scanner(System.in);
      while (niv != 1 && niv != 2 && niv != 3){
          repetirNumero();
          inicio2();
          niv = scan.nextInt();
      }return niv;
    }
     
     
     
     //=======================================
// MÈTODES DE TAULER
//=======================================
//
// FUNCIÓ: Crear tauler buit amb "-" en totes les poscions
 public static char[][] crear_tauler_nivell_1(){
        
          for (int i = 0; i <11; ++i) {
            Arrays.fill(matriu[i],'-');
}
          int z=65; 
          for (int j = 1; j <11; ++j) {
            int asciiValue = z;
            char convertedChar = (char)asciiValue;
            matriu[j][0] = convertedChar;
            z++;
          }
          
          int w=48; 
          for (int j = 1; j <11; ++j) {
            int asciiValue = w;
            char convertedChar = (char)asciiValue;
            matriu[0][j] = convertedChar;
            w++;
          }
          return matriu;
    }
    
    public static void imprimir_matriu(){
        
           for (int i = 0; i <11; ++i) {
              System.out.println(" ");
              for(int j=0; j<11; j++){
                  System.out.print(matriu[i][j]+" ");
                  
              }
          }
    }
}
   
   
   
     
     
     
     
     
  /* 
public static char[][] crear_tauler(int files, int columnes) {
char tauler[][] = new char[files][columnes];

for (int i = 0; i <columnes; ++i) {
Arrays.fill(tauler[i],'-');
}
return tauler;
} 

// PROCEDIMENT: Mostra per pantalla el tauler
public static void mostra_tauler(char[][] tauler, boolean veureTot) {}
     
     public static void mostartablero(){
        for(int i=0;i<11;i++){
            for(int o=0;o<11;o++){
                System.out.print(tauler[i][o]+"    ");
            }
          }
    }    
     
     
}
*/
