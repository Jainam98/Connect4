package patel.Jainam;

import javax.swing.*;

public class driver {
	
	public static void main(String[] args) {
		   
    JFrame frame = new JFrame(" Connect Four ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new connectFourDesign());  
	frame.pack();
    frame.setResizable(false);
    frame.setVisible(true);   
    frame.setSize(500, 500);    
  }
}


