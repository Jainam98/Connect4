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
  
  // Game Modes  
  private JButton onePlayer;
  private JButton twoPlayer;
  
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
    
    onePlayer = new JButton (" 1 Player ");
    onePlayer.setFont(new Font("Astron Boy Rg", Font.ITALIC, 55));
    onePlayer.setBackground(Color.black);
    onePlayer.setForeground(Color.GREEN);
    add(onePlayer);
    onePlayer.setVisible(false);
    onePlayer.addActionListener(new onePlayerButtonListener());
    
    twoPlayer = new JButton (" 2 Player ");
    twoPlayer.setFont(new Font("Astron Boy Rg", Font.ITALIC, 55));
    twoPlayer.setBackground(Color.black);
    twoPlayer.setForeground(Color.GREEN);
    add(twoPlayer);
    twoPlayer.setVisible(false);
    twoPlayer.addActionListener(new twoPlayerButtonListener());     
    
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
    goBack.setFont(new Font("Astron Boy Rg", Font.ITALIC, 60));
    goBack.setBackground(Color.black);
    goBack.setForeground(Color.BLUE);
    add(goBack);
    goBack.setVisible(false); 
    goBack.addActionListener(new goBackButtonListener());
    
    clickMeOne = new JButton ();
    clickMeOne.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeOne.setBackground(Color.black);
    clickMeOne.setForeground(Color.CYAN);
    add(clickMeOne);
    clickMeOne.setVisible(false); 
    clickMeOne.addActionListener(new clikMeOneButtonListener());
    
    clickMeTwo = new JButton ();
    clickMeTwo.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeTwo.setBackground(Color.black);
    clickMeTwo.setForeground(Color.CYAN);
    add(clickMeTwo);
    clickMeTwo.setVisible(false); 
    
    clickMeThree = new JButton ();
    clickMeThree.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeThree.setBackground(Color.black);
    clickMeThree.setForeground(Color.CYAN);
    add(clickMeThree);
    clickMeThree.setVisible(false); 
    
    clickMeFour = new JButton ();
    clickMeFour.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeFour.setBackground(Color.black);
    clickMeFour.setForeground(Color.CYAN);
    add(clickMeFour);
    clickMeFour.setVisible(false); 
    
    clickMeFive = new JButton ();
    clickMeFive.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeFive.setBackground(Color.black);
    clickMeFive.setForeground(Color.CYAN);
    add(clickMeFive);
    clickMeFive.setVisible(false); 
    
    clickMeSix = new JButton ();
    clickMeSix.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeSix.setBackground(Color.black);
    clickMeSix.setForeground(Color.CYAN);
    add(clickMeSix);
    clickMeSix.setVisible(false);     
    
    clickMeSeven = new JButton ();
    clickMeSeven.setFont(new Font("Astron Boy Rg", Font.ITALIC, 20));
    clickMeSeven.setBackground(Color.black);
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
  
  private class onePlayerButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      
      if (event.getSource() == onePlayer) {
        
        lblWelcome.setVisible(false);
        playButton.setVisible(false);
        helpButton.setVisible(false); 
        quitButton.setVisible(false);
        twoPlayer.setVisible(false);
        onePlayer.setVisible(true);
        goBack.setVisible(false);
        
        Thread thread =new Thread() {
          
          public void run() {
        	  onePlayer.setText(" Game Starts In ");
        	  onePlayer.setFont(new Font("Astron Boy Rg", Font.ITALIC, 40));
        	  onePlayer.setBackground(Color.black);
        	  onePlayer.setForeground(Color.BLUE);
            try {
              Thread.sleep(1000);                        
            }catch (Exception e) {
            }
            onePlayer.setText("3");
            try {
              Thread.sleep(1000);                        
            }catch (Exception e) {
            }
            onePlayer.setText("2");
            try {
              Thread.sleep(1000);                        
            }catch (Exception e) {
            }
            onePlayer.setText("1");  
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
            onePlayer.setVisible(false);
            remove(onePlayer);
            twoPlayer.setVisible(false);
            remove(twoPlayer);
            
            clickMeOne.setVisible(true);
            clickMeTwo.setVisible(true);
            clickMeThree.setVisible(true);
            clickMeFour.setVisible(true);
            clickMeFive.setVisible(true);
            clickMeSix.setVisible(true);
            clickMeSeven.setVisible(true); 

          }
        };
        thread.start();        
      }
    }
  }

  private class twoPlayerButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent event) {
	      
	      if (event.getSource() == twoPlayer) {
	        
	          lblWelcome.setVisible(false);
	          playButton.setVisible(false);
	          helpButton.setVisible(false); 
	          quitButton.setVisible(false);
	          twoPlayer.setVisible(true);
	          onePlayer.setVisible(false);
	          goBack.setVisible(false);
	          
	        
	        Thread thread =new Thread() {
	          
	          public void run() {
	        	  twoPlayer.setText(" Game Starts In ");
	        	  twoPlayer.setFont(new Font("Astron Boy Rg", Font.ITALIC, 40));
	        	  twoPlayer.setBackground(Color.black);
	        	  twoPlayer.setForeground(Color.blue);
	            try {
	              Thread.sleep(1000);                        
	            }catch (Exception e) {
	            }
	            twoPlayer.setText("3");
	            try {
	              Thread.sleep(1000);                        
	            }catch (Exception e) {
	            }
	            twoPlayer.setText("2");
	            try {
	              Thread.sleep(1000);                        
	            }catch (Exception e) {
	            }
	            twoPlayer.setText("1");  
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
	            onePlayer.setVisible(false);
	            remove(onePlayer);
	            twoPlayer.setVisible(false);
	            remove(twoPlayer);
	            
	            
	            clickMeOne.setVisible(true);
	            clickMeTwo.setVisible(true);
	            clickMeThree.setVisible(true);
	            clickMeFour.setVisible(true);
	            clickMeFive.setVisible(true);
	            clickMeSix.setVisible(true);
	            clickMeSeven.setVisible(true);  

	          }
	        };
	        thread.start();        
	      }
	    }
	  }
  
  private class playButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent event) {      
	      
	      if (event.getSource() == playButton) {         
	        
	        lblWelcome.setVisible(true);
	        playButton.setVisible(false);
	        helpButton.setVisible(false); 
	        quitButton.setVisible(false); 
	        onePlayer.setVisible(true);
	        twoPlayer.setVisible(true);
	        goBack.setVisible(true);        
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
        onePlayer.setVisible(false);
        twoPlayer.setVisible(false);
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
  
  private class clikMeOneButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent event) {
	        
	        if (event.getSource() == clickMeOne || event.getSource() == clickMeTwo) { 
	        	
	        	slots[0][0].setBackground(Color.red);	  
	        	slots[0][1].setBackground(Color.red);
	        	slots[0][2].setBackground(Color.red);
	        	slots[0][3].setBackground(Color.red);
	        	
	        	slots[1][0].setBackground(Color.yellow);	  
	        	slots[1][1].setBackground(Color.yellow);
	        	slots[1][2].setBackground(Color.yellow);	        	
	        	
	        	JOptionPane.showMessageDialog(null, " Player One Won!", " Results ", JOptionPane.INFORMATION_MESSAGE);
	        }
	    }
  }
}
