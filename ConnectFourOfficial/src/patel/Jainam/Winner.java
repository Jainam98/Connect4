package patel.Jainam;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Winner {
    public static boolean IsWin(JButton[][] slots, Color playerColor, int column, int row) {   
        
        boolean result = false;
        
        // horizontal      
        boolean found = false;
        int counter = 0;
        
        for ( int i = 0; i < slots.length; i++ ) {        
          if ( slots[i][row].getBackground().equals(playerColor)) { 
            
            counter++;
            
            // win 
            if ( found == true ) {            
              if ( counter == 4 ) {               
                result = true;
                break;
              }
            }
            else {            
              found = true;
            }
          }
          
          // reset counter
          else {          
            if ( found == true ) {            
              counter = 0;
            }          
            found = false;
          }
        }
        
        // vertical 
        for ( int i = 0; i < slots.length; i++ ) {        
          if ( slots[column][i].getBackground().equals(playerColor)) { 
            
            counter++;
            
            // win           
            if ( found == true ) {            
              if ( counter == 4 ) {               
                result = true;
                break;
              }
            }
            else {            
              found = true;
            }
          }
          
          // reset counter
          else {          
            if ( found == true ) {             
              counter = 0;
            }
            
            found = false;
          }
        }
        
        // Diagonal Checking  
        //Winning diagonally towards right
        for (int i = 5; i > 2; i-- ) {
          for(int j = 0; j < 4; j++) {        
            
            if (slots[i][j].getBackground().equals(playerColor) &&
                slots[i-1][j+1].getBackground().equals(playerColor) &&
                slots[i-2][j+2].getBackground().equals(playerColor) &&
                slots[i-3][j+3].getBackground().equals(playerColor)) {
              String message = playerColor.equals(Color.red) ? " Player One Won! " : " Player Two Won! ";
              JOptionPane.showMessageDialog(null, message, " Results ", JOptionPane.INFORMATION_MESSAGE);
              System.exit(0);            
            }
          }
        } 
        
        // Diagonal
        //Winning diagonally towards left
        for (int i = 6; i > 2; i-- ) {
            for(int j = 6; j > 2; j--) {        
              
              if (slots[i][j].getBackground().equals(playerColor) &&
                  slots[i-1][j-1].getBackground().equals(playerColor) &&
                  slots[i-2][j-2].getBackground().equals(playerColor) &&
                  slots[i-3][j-3].getBackground().equals(playerColor)) {
                String message = playerColor.equals(Color.red) ? " Player One Won! " : " Player Two Won! ";
                JOptionPane.showMessageDialog(null, message, " Results ", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);              
              }
            }
          }       
        return result;
      } 
}