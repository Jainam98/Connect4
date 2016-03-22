package patel.Jainam;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class connectFourDesign extends JPanel { 
  
  private static final long serialVersionUID = 1L;   
  
  // Welcome Screen
  private JLabel lblWelcome;
  
  // Buttons for Welcome Screen
  private JButton playButton;
  private JButton helpButton; 
  private JButton quitButton;  
  
  // Go Back Button
  private JButton goBack;    

  private JButton clickMeOne;
  private JButton clickMeTwo;
  private JButton clickMeThree;
  private JButton clickMeFour;
  private JButton clickMeFive;
  private JButton clickMeSix;
  private JButton clickMeSeven;
  
  // Grid xSize,ySize and 2D Array
  private int ysize = 7;
  private int xsize = 8;
  private JButton[][] slots;
  
  
  public static void main(String[] args) {
    
    JFrame frame = new JFrame(" Connect Four ");
    frame.setSize(500, 500);
    frame.getContentPane().add(new connectFourDesign());
    frame.setVisible(true);
    frame.setResizable(false);
  }  
  
  public connectFourDesign () { 
    
    setBackground(Color.black);        
    
    lblWelcome = new JLabel (" Connect 4 ", SwingConstants.CENTER);    
    lblWelcome.setFont(new Font("Astron Boy Rg", Font.ITALIC, 120));
    lblWelcome.setForeground(Color.white);
    add(lblWelcome);
    lblWelcome.setVisible(true);
    
    playButton = new JButton (" Play ");
    playButton.setFont(new Font("Astron Boy Rg", Font.ITALIC, 102));
    playButton.setBackground(Color.black);
    playButton.setForeground(Color.GREEN);
    add(playButton);
    playButton.setVisible(true);
    playButton.addActionListener(new playButtonListener());
    
    helpButton = new JButton ( " Help ");
    helpButton.setFont(new Font("Astron Boy Rg", Font.ITALIC, 102));
    helpButton.setBackground(Color.black);
    helpButton.setForeground(Color.magenta);
    add(helpButton);
    helpButton.setVisible(true);
    helpButton.addActionListener(new helpListener()); 
    
    quitButton = new JButton ( " Quit ");
    quitButton.setFont(new Font("Astron Boy Rg", Font.ITALIC, 102));
    quitButton.setBackground(Color.black);
    quitButton.setForeground(Color.orange);
    add(quitButton);
    quitButton.setVisible(true); 
    quitButton.addActionListener(new CloseListener());     
    
    goBack = new JButton ( " Go Back "); 
    goBack.setFont(new Font("Astron Boy Rg", Font.ITALIC, 80));
    goBack.setBackground(Color.black);
    goBack.setForeground(Color.BLUE);
    add(goBack);
    goBack.setVisible(false); 
    goBack.addActionListener(new goBackButtonListener());
    
    clickMeOne = new JButton ();
    clickMeOne.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeOne.setBackground(Color.lightGray);
    clickMeOne.setForeground(Color.CYAN);
    add(clickMeOne);
    clickMeOne.setVisible(false); 
    
    clickMeTwo = new JButton ();
    clickMeTwo.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeTwo.setBackground(Color.lightGray);
    clickMeTwo.setForeground(Color.CYAN);
    add(clickMeTwo);
    clickMeTwo.setVisible(false); 
    
    clickMeThree = new JButton ();
    clickMeThree.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeThree.setBackground(Color.lightGray);
    clickMeThree.setForeground(Color.CYAN);
    add(clickMeThree);
    clickMeThree.setVisible(false); 
    
    clickMeFour = new JButton ();
    clickMeFour.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeFour.setBackground(Color.lightGray);
    clickMeFour.setForeground(Color.CYAN);
    add(clickMeFour);
    clickMeFour.setVisible(false); 
    
    clickMeFive = new JButton ();
    clickMeFive.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeFive.setBackground(Color.lightGray);
    clickMeFive.setForeground(Color.CYAN);
    add(clickMeFive);
    clickMeFive.setVisible(false); 
    
    clickMeSix = new JButton ();
    clickMeSix.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeSix.setBackground(Color.lightGray);
    clickMeSix.setForeground(Color.CYAN);
    add(clickMeSix);
    clickMeSix.setVisible(false);     
    
    clickMeSeven = new JButton ();
    clickMeSeven.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeSeven.setBackground(Color.lightGray);
    clickMeSeven.setForeground(Color.CYAN);
    add(clickMeSeven);
    clickMeSeven.setVisible(false); 
    
    clickMeOne.setIcon(new ImageIcon("kdevelop_down.png"));   
    clickMeTwo.setIcon(new ImageIcon("kdevelop_down.png"));
    clickMeThree.setIcon(new ImageIcon("kdevelop_down.png"));
    clickMeFour.setIcon(new ImageIcon("kdevelop_down.png"));
    clickMeFive.setIcon(new ImageIcon("kdevelop_down.png"));
    clickMeSix.setIcon(new ImageIcon("kdevelop_down.png"));
    clickMeSeven.setIcon(new ImageIcon("kdevelop_down.png"));
    
    clickMeOne.setBorder(new LineBorder(Color.black));
    clickMeTwo.setBorder(new LineBorder(Color.black)); 
    clickMeThree.setBorder(new LineBorder(Color.black)); 
    clickMeFour.setBorder(new LineBorder(Color.black)); 
    clickMeFive.setBorder(new LineBorder(Color.black)); 
    clickMeSix.setBorder(new LineBorder(Color.black)); 
    clickMeSeven.setBorder(new LineBorder(Color.black));    
    
    validate();
    
  }
  
  private class playButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      
      if (event.getSource() == playButton) {
        
        lblWelcome.setVisible(false);
        playButton.setVisible(true);
        helpButton.setVisible(false); 
        quitButton.setVisible(false);
        
        Thread thread =new Thread() {
          
          public void run() {
            playButton.setText(" Game Starts In ");
            playButton.setFont(new Font("Astron Boy Rg", Font.ITALIC, 60));
            playButton.setBackground(Color.black);
            playButton.setForeground(Color.BLUE);
            try {
              Thread.sleep(1000);                        
            }catch (Exception e) {
            }
            playButton.setText("3");
            try {
              Thread.sleep(1000);                        
            }catch (Exception e) {
            }
            playButton.setText("2");
            try {
              Thread.sleep(1000);                        
            }catch (Exception e) {
            }
            playButton.setText("1");  
            try {
              Thread.sleep(1000);                        
            }catch (Exception e) {
            }   
            
            setLayout(new GridLayout(xsize, ysize));
            slots = new JButton[xsize - 1][ysize];
            
            for (int column = 0; column < ysize; column++) {
              for (int row = 0; row < xsize - 1; row++) {
                slots[row][column] = new JButton();
                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER); 
                slots[row][column].setBackground(Color.GREEN);
                slots[row][column].setBorder(new LineBorder(Color.black));                      
                add(slots[row][column]);
              }
            }  
            
            lblWelcome.setVisible(false);
            remove(lblWelcome);
            playButton.setVisible(false);
            remove(playButton);
            helpButton.setVisible(false);
            remove(helpButton);
            quitButton.setVisible(false);
            remove(quitButton);
            goBack.setVisible(false);
            remove(goBack);
            
            clickMeOne.setVisible(true);
            clickMeTwo.setVisible(true);
            clickMeThree.setVisible(true);
            clickMeFour.setVisible(true);
            clickMeFive.setVisible(true);
            clickMeSix.setVisible(true);
            clickMeSeven.setVisible(true);  
            
         //   goBack.setVisible(true);
          //  add(goBack);
          }
        };
        thread.start();        
      }
    }
  }
  
  
  private class goBackButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {      
      
      if (event.getSource() == goBack) {         
        
        lblWelcome.setVisible(true);
        playButton.setVisible(true);
        helpButton.setVisible(true); 
        quitButton.setVisible(true);        
        goBack.setVisible(false);        
      }
    }
  }
  
  private class CloseListener implements ActionListener{
    public void actionPerformed(ActionEvent event) {
      
      if (event.getSource() == quitButton) { 
        
        int quitTheGame = JOptionPane.showConfirmDialog(null, " Are You Sure You Want to Leave The Game? ", " Quit? "
                                                          , JOptionPane.YES_NO_OPTION);        
        
        if (quitTheGame == JOptionPane.YES_OPTION)  {
          System.exit(0);
        }        
      }
    }
  }
  
  private class helpListener implements ActionListener{
    public void actionPerformed(ActionEvent event) {
      
      if (event.getSource() == helpButton) {           
        JOptionPane.showMessageDialog(null, " 1) Choose who plays first.", " Help ", JOptionPane.INFORMATION_MESSAGE);

      }
    }
  }
}
