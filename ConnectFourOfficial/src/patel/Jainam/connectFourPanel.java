package patel.Jainam;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class connectFourPanel extends JPanel { 
  
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
  
  // Slots 
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

  public connectFourPanel () { 
    
    setBackground(Color.black);        
    
    lblWelcome = new JLabel (" Connect 4 ", SwingConstants.CENTER);    
    lblWelcome.setFont(new Font("Times New Roman", Font.ITALIC, 115));
    lblWelcome.setForeground(Color.white);
    add(lblWelcome);
    lblWelcome.setVisible(true);
    
    playButton = new JButton (" Play ");
    playButton.setFont(new Font("Times New Roman", Font.ITALIC, 95));
    playButton.setBackground(Color.black);
    playButton.setForeground(Color.GREEN);
    add(playButton);
    playButton.setVisible(true);
    playButton.addActionListener(new playButtonListener());
    
    helpButton = new JButton ( " Help ");
    helpButton.setFont(new Font("Times New Roman", Font.ITALIC, 85));
    helpButton.setBackground(Color.black);
    helpButton.setForeground(Color.magenta);
    add(helpButton);
    helpButton.setVisible(true);
    helpButton.addActionListener(new helpListener()); 
    
    quitButton = new JButton ( " Quit ");
    quitButton.setFont(new Font("Times New Roman", Font.ITALIC, 85));
    quitButton.setBackground(Color.black);
    quitButton.setForeground(Color.orange);
    add(quitButton);
    quitButton.setVisible(true); 
    quitButton.addActionListener(new CloseListener());     
    
    twoPlayer = new JButton (" 1 Player ");
    twoPlayer.setFont(new Font("Times New Roman", Font.ITALIC, 63));
    twoPlayer.setBackground(Color.black);
    twoPlayer.setForeground(Color.GREEN);
    add(twoPlayer);
    twoPlayer.setVisible(false);
    twoPlayer.addActionListener(new twoPlayerButtonListener());
    
    onePlayer = new JButton (" 2 Player ");
    onePlayer.setFont(new Font("Times New Roman", Font.ITALIC, 63));
    onePlayer.setBackground(Color.black);
    onePlayer.setForeground(Color.GREEN);
    add(onePlayer);
    onePlayer.setVisible(false);
    onePlayer.addActionListener(new onePlayerButtonListener()); 
    
    goBack = new JButton ( " Go Back "); 
    goBack.setFont(new Font("Times New Roman", Font.ITALIC, 70));
    goBack.setBackground(Color.black);
    goBack.setForeground(Color.BLUE);
    add(goBack);
    goBack.setVisible(false); 
    goBack.addActionListener(new goBackButtonListener());
    
    clickMeOne = new JButton (" 1 ");
    clickMeOne.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    clickMeOne.setBackground(Color.gray);
    clickMeOne.setForeground(Color.CYAN);
    clickMeOne.setName("clickMeOne");
    add(clickMeOne);
    clickMeOne.setVisible(false); 
    clickMeOne.addActionListener(new clikMeButtonListener());
    
    clickMeTwo = new JButton (" 2 ");
    clickMeTwo.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    clickMeTwo.setBackground(Color.gray);
    clickMeTwo.setForeground(Color.CYAN);
    clickMeTwo.setName("clickMeTwo");
    add(clickMeTwo);
    clickMeTwo.setVisible(false); 
    clickMeTwo.addActionListener(new clikMeButtonListener());
    
    clickMeThree = new JButton (" 3 ");
    clickMeThree.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    clickMeThree.setBackground(Color.gray);
    clickMeThree.setForeground(Color.CYAN);
    clickMeThree.setName("clickMeThree");
    add(clickMeThree);
    clickMeThree.setVisible(false); 
    clickMeThree.addActionListener(new clikMeButtonListener());
    
    clickMeFour = new JButton (" 4 ");
    clickMeFour.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    clickMeFour.setBackground(Color.gray);
    clickMeFour.setForeground(Color.CYAN);
    clickMeFour.setName("clickMeFour");
    add(clickMeFour);
    clickMeFour.setVisible(false); 
    clickMeFour.addActionListener(new clikMeButtonListener());
    
    clickMeFive = new JButton (" 5 ");
    clickMeFive.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    clickMeFive.setBackground(Color.gray);
    clickMeFive.setForeground(Color.CYAN);
    clickMeFive.setName("clickMeFive");
    add(clickMeFive);
    clickMeFive.setVisible(false); 
    clickMeFive.addActionListener(new clikMeButtonListener());
    
    clickMeSix = new JButton (" 6 ");
    clickMeSix.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    clickMeSix.setBackground(Color.gray);
    clickMeSix.setForeground(Color.CYAN);
    clickMeSix.setName("clickMeSix");
    add(clickMeSix);
    clickMeSix.setVisible(false);  
    clickMeSix.addActionListener(new clikMeButtonListener());
    
    clickMeSeven = new JButton (" 7 ");
    clickMeSeven.setFont(new Font("Times New Roman", Font.ITALIC, 20));
    clickMeSeven.setBackground(Color.gray);
    clickMeSeven.setForeground(Color.CYAN);
    clickMeSeven.setName("clickMeSeven");
    add(clickMeSeven);
    clickMeSeven.setVisible(false); 
    clickMeSeven.addActionListener(new clikMeButtonListener());    
    
    clickMeOne.setBorder(new LineBorder(Color.black));
    clickMeTwo.setBorder(new LineBorder(Color.black)); 
    clickMeThree.setBorder(new LineBorder(Color.black)); 
    clickMeFour.setBorder(new LineBorder(Color.black)); 
    clickMeFive.setBorder(new LineBorder(Color.black)); 
    clickMeSix.setBorder(new LineBorder(Color.black)); 
    clickMeSeven.setBorder(new LineBorder(Color.black));   
    
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
            onePlayer.setFont(new Font("Times New Roman", Font.ITALIC, 40));
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
            
        // String message = "1) Player One Goes First. \n";
        //  JOptionPane.showMessageDialog(null, message, " Turn ", JOptionPane.INFORMATION_MESSAGE);
                        
            setLayout(new GridLayout(xsize, ysize));
            slots = new JButton[xsize - 1][ysize];
            
            for (int column = 0; column < ysize; column++) {
              for (int row = 0; row < xsize - 1; row++) {
                slots[row][column] = new JButton();
                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER); 
                slots[row][column].setBackground(Color.white);
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
        
        isHumanVsComputer = true;
        
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
            twoPlayer.setFont(new Font("Times New Roman", Font.ITALIC, 40));
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
            
         
        // String message = "1) Player One Goes First. \n";         
        //  JOptionPane.showMessageDialog(null, message, " Turn ", JOptionPane.INFORMATION_MESSAGE);
                        
            setLayout(new GridLayout(xsize, ysize));
            slots = new JButton[xsize - 1][ysize];
            
            for (int column = 0; column < ysize; column++) {
              for (int row = 0; row < xsize - 1; row++) {
                slots[row][column] = new JButton();
                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER); 
                slots[row][column].setBackground(Color.white);
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
      
      if (event.getSource() == goBack){         
        
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
    public void actionPerformed(ActionEvent event){
      
      if (event.getSource() == quitButton) { 
        
        int quitTheGame = JOptionPane.showConfirmDialog(null, " Are You Sure You Want to Leave The Game? ", " Quit? "
                                                          , JOptionPane.YES_NO_OPTION);        
        
        if (quitTheGame == JOptionPane.YES_OPTION){
          System.exit(0);
        }        
      }
    }
  }
  
  private class helpListener implements ActionListener{
    public void actionPerformed(ActionEvent event) {
      
      if (event.getSource() == helpButton) {           
        String message = "1) Decide Who Plays first. Players will alternate turns after playing a checker.\n \n";
        message += "2) On your turn, drop one of your checkers down ANY of the slots in the top of the grid.\n \n";
        message += "3) Play alternated until one player gets FOUR checkers of his or her colour in a row.\n \n";
        message += "4) The four in a row can be horizontal, vertical or diagonal.";
        JOptionPane.showMessageDialog(null, message, " Help ", JOptionPane.INFORMATION_MESSAGE);
        
      }
    }
  } 
  
  private Color playerColor = Color.red;  
  private boolean isHumanVsComputer = false;  
  
  private class clikMeButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event) {      
      
      if (event.getSource() == clickMeOne 
            || event.getSource() == clickMeTwo
            || event.getSource() == clickMeThree
            || event.getSource() == clickMeFour
            || event.getSource() == clickMeFive
            || event.getSource() == clickMeSix
            || event.getSource() == clickMeSeven
         ) {
        
        JButton button = (JButton)event.getSource();
        
        int column = 0;
        switch ( button.getName() ) {
          
          case "clickMeOne" : column = 0; break;
          case "clickMeTwo" : column = 1; break;
          case "clickMeThree" : column = 2; break;
          case "clickMeFour" : column = 3; break;
          case "clickMeFive" : column = 4; break;
          case "clickMeSix" : column = 5; break;
          case "clickMeSeven" : column = 6; break;
        }
        
        int lastEmptyIdx = -1;
        
        for ( int i = 0; i < slots[column].length; i++ ) {          
          if ( slots[column][i].getBackground() != Color.white ) {
            
            break;
          }
          else {            
            lastEmptyIdx = i;
          }
        }
        
        if ( lastEmptyIdx != -1 ) {          
          slots[column][lastEmptyIdx].setBackground(playerColor);
          
          if ( Winner.IsWin(slots, playerColor, column, lastEmptyIdx) ) {
            
            String message = playerColor == Color.red ? " Player One Won!" : " Player Two Won!";
            JOptionPane.showMessageDialog(null, message, " Results ", JOptionPane.INFORMATION_MESSAGE);
            
            System.exit(0);            
          }
          
          else {     
            playerColor = playerColor == Color.red ? Color.yellow : Color.red; 
            
            // assuming that Color.yellow is for computer player
            if ( isHumanVsComputer && playerColor == Color.yellow ) {               
              doComputerMove();
            }
          }      
        }
      } 
    }
    
    public void doComputerMove () {
      
      // count how many available slots exists
      int howManyAvailableSlots = 0;
      for ( int column = 0; column < slots.length; column++) {
        
        if (slots[column][0].getBackground().equals(Color.white) ) {
          
          howManyAvailableSlots++;
        }
      }
      
      JButton buttonToClick = null;
      
      // Generate a random number
      Random rand = new Random();
      int randomIndex = rand.nextInt(howManyAvailableSlots);
      
      for ( int column = 0; column < slots.length; column++) {        
        if (slots[column][0].getBackground().equals(Color.white) ) {
          
          if ( randomIndex == 0) {           
            // find out the button 
            switch ( column ) {
              case 0 : buttonToClick = clickMeOne; break;
              case 1 : buttonToClick = clickMeTwo; break;
              case 2 : buttonToClick = clickMeThree; break;
              case 3 : buttonToClick = clickMeFour; break;
              case 4 : buttonToClick = clickMeFive; break;
              case 5 : buttonToClick = clickMeSix; break;
              case 6 : buttonToClick = clickMeSeven; break;
            }            
            break;
          }
          else {            
            randomIndex--;
          }
        }
      }
      
      final JButton theButton = buttonToClick;
      SwingUtilities.invokeLater( new Runnable() {        
        
        public void run() {
          Random random = new Random();
          
          try {
            Thread.sleep(random.nextInt(300));    // simulate "thinking" time
          } catch (InterruptedException e) {            
            e.printStackTrace();
          }          
          theButton.doClick(300); // simulate click for 0.3 seconds
        }        
      }
      );
    }
  }
}