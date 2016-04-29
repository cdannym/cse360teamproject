import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Decorator extends JDialog {
	
	String message;

	
	public Decorator(JFrame frame,String message) {
		 super(frame, true); 
		 this.message = message;
		setTitle("Dice Informer");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               
            }
        });         
 
        JPanel infoPanel = new JPanel();
        JLabel info = new JLabel();    
        info.setForeground(Color.WHITE);
        info.setText(message);  
        
        info.setBounds(10,50, 50, 20);      
        infoPanel.add(info);
        Random rand = new Random();
        
        Color randomColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        getContentPane().setPreferredSize(new Dimension(180, 80));
        infoPanel.setBackground(randomColor);
        getContentPane().add(infoPanel, BorderLayout.CENTER);
        pack();
        setLocation(new Point(400, 300));
		// TODO Auto-generated constructor stub
	}
	 /* private void cacelWindow() {
	        System.exit(0);
	    }*/
	        

}
