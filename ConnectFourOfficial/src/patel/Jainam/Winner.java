package patel.Jainam;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 * IsWin class controls all the winning part in two players game mode 
 * It also check every area such as vertically, Horizontally and Diagonally 
 */
public class Winner {
  
 /**
  * Declares Winner when found in two players mode  in three aspects vertically,horizontally, and diagonally 
  * @param column
  *              Column checks the winner vertically 
  * @param row
  *     Row checks the winner Horizontally 
  * @return
  *     Returns false if no winner is found 
  */
 
     public boolean IsWin(JButton[][] slots, Color playerColor, int column, int row) {    
        
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
          if (slots[column][i].getBackground().equals(playerColor)) {             
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