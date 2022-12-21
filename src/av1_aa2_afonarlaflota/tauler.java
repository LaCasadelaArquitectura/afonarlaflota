/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package av1_aa2_afonarlaflota;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class tauler {
    int files;
    int columnes;
    char[][] matriu = new char[files][columnes];
    
    public tauler(){
        int files=11;
        int columnes=11;
    }
    
    public tauler(int files, int columnes){
        
        this.files=files;
        this.columnes=columnes;
        
     
    }
    
    public  char[][] crear_tauler_nivell_1(){
        
          char[][] matriu = new char[11][11];
          for (int i = 0; i <11; ++i) {
            Arrays.fill(matriu[i],'-');
}return matriu;
    }
    
    public void imprimir_matriu(){
        
           for (int i = 0; i <11; ++i) {
              System.out.println(" ");
              for(int j=0; j<11; j++){
                  System.out.println(matriu[i][j]+" ");
                  
              }
          }
    }
}
