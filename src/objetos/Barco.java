/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Usuario
 */
public class Barco {
    public String tipodebarco;
    public char letra;
    public int ncasillas;
    public int colmax;
    
  
    public Barco(String tipodebarco) {
     
        switch(tipodebarco){
        
            case "llanxa": letra='L'; ncasillas=1; colmax= 11-ncasillas; break;
        
            case "vaixell": letra='B'; ncasillas=3; colmax= 11-ncasillas;break;
            
            case "cuirassat": letra='Z'; ncasillas=4; colmax= 11-ncasillas;break;
             
            case "portaavions": letra='P'; ncasillas=5; colmax= 11-ncasillas;break;
    }
        
      
    }
    
}
