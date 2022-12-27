/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author JMA
 */

// Clase. Es crea la clase barco per poder crear els diferents tipus de barcos.
// ací es declaren els atrubutos del barcos.
public class Barco {
    public String tipodebarco;
    public char letra;
    public int ncasillas;
    public int colmax;
    
// ací declarem el constructor, en nun switch plenem tosts el atributos dient nomes el tipus de barco.  
    public Barco(String tipodebarco) {
     
        switch(tipodebarco){
        
            case "llanxa": letra='L'; ncasillas=1; colmax= 10-ncasillas; break;
        
            case "vaixell": letra='V'; ncasillas=3; colmax= 10-ncasillas;break;
            
            case "cuirassat": letra='Z'; ncasillas=4; colmax= 10-ncasillas;break;
             
            case "portaavions": letra='P'; ncasillas=5; colmax= 10-ncasillas;break;
    }
        
      
    }
    
}
