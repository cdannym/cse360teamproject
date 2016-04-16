import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import java.util.*;
import java.util.Random;

public class DiceGame extends JFrame{
	
	JFrame frame;
	
	private JPanel panelGame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	
	private Label player1;
	public String user_name_1;
	private TextField name1;
	private Button playSub1;
	private int click1 = 0;

	
	private Label player2;
	private String user_name_2;
	private TextField name2;
	private Button playSub2;
	private int click2 = 0;
	
	private int turn; //turn counter for game altogether
	private int turn_1; //turn counter for player 1
	private int turn_2; //turn counter for player 2
	private int life_pt_1, life_pt_2; //life points left
	private int pts_1, pts_2; //number of points each player had
	private int res_1, res_2; //roll of each player
	
	private Button roll;
	private Label rollNum;
	private TextField showRoll;
	private int random;
	
	private Button start;
	
	private JTextArea stats;
	private JTextArea pt_stat;
	
	Random elementGenerator;
	String element;
	
	public DiceGame(){
		
		setSize(500,600);
		life_pt_1 = 3;
		life_pt_2 = 3;
		
		elementGenerator = new Random();
		
		panelGame = new JPanel(); //Get player information
		panelGame.setLayout(new BoxLayout(panelGame, BoxLayout.Y_AXIS));
		add(panelGame);
		
		
		//Get player 1 information
		panel1 = new JPanel(new FlowLayout()); //For getting player info
		panelGame.add(panel1, panel1.CENTER_ALIGNMENT);
		
		player1 = new Label("Player 1: ");
		name1 = new TextField(10);
		
		playSub1 = new Button("Submit");
		
		panel1.add(player1);
		panel1.add(name1);
		panel1.add(playSub1);
		
		
		playSub1.addActionListener(new ActionListener() {
 
			
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	click1 = 1;
            	user_name_1 = name1.getText();
            	stats.append("\t");
            	stats.append(user_name_1);
            	stats.append("\t");
            	name1.setText(" ");
            
                
          
			}
        });  
 
		//Get Player 2 information
		
		
		panel2 = new JPanel(new FlowLayout()); //For getting player info
		panelGame.add(panel2, panel2.CENTER_ALIGNMENT);
		
		player2 = new Label("Player 2: ");
		name2 = new TextField(10);
		playSub2 = new Button("Submit");
		
		panel2.add(player2);
		panel2.add(name2);
		panel2.add(playSub2);
		
		playSub2.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	click2 = 1;
            	user_name_2 = name2.getText();
            	stats.append(user_name_2);
            	stats.append("\n");
            	name2.setText(" ");
            	
            	stats.append("Life points:\t" + life_pt_1 + "\t" + life_pt_2);
                
            }
        });
		
		
		//Start game
		panel3 = new JPanel(new FlowLayout()); //For getting player info
		panelGame.add(panel3, panel3.CENTER_ALIGNMENT);
		
		start = new Button("START");
		panel3.add(start);
		
		start.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	System.out.println("Blah");
                
            }
        });
		
		//Roll
		panel4 = new JPanel(new FlowLayout()); //For getting player info
		panelGame.add(panel4, panel4.CENTER_ALIGNMENT);
		
		roll = new Button("Roll!");
		rollNum = new Label("Your roll: ");
		showRoll = new TextField(10);
		turn = 0;
		turn_1 = 0;
		turn_2 = 0;
		pts_1 = 0;
		pts_2 = 0;
		
		panel4.add(roll);
		panel4.add(rollNum);
		panel4.add(showRoll);
		
		roll.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	turn++;
            	random = elementGenerator.nextInt(6);
            	
            	if(random == 0){
            			element = "FIRE";
            	}else if(random == 1){
            			element = "WATER";
            	}else if(random == 2){
        				element = "ELECTRIC";
            	}else if(random == 3){
        				element = "GRASS";
            	}else if(random == 4){
        				element = "ICE";
            	}else if(random == 5){
        				element = "EARTH";
            	}
            	
            	//If player 1 rolls
            	if(turn % 2 == 1)
            	{
            		turn_1 = 1;
            		res_1 = random;
            		
            	}else{
            		//If player 2 rolls
            		turn_2 = 1;
            		res_2 = random;
            	}
            	
            	if(turn_1 == 1 && turn_2 == 1)
            	{
            		//If both players have rolled, player 2 beats player 1
            		if(res_1 == 0 && (res_2 == 1 || res_2 == 5))
            		{
            			//Water, earth beats fire
            			pts_2 += 200;
            			pt_stat.append("\n");
            			pt_stat.append(user_name_2 + " has won 200 points!");
            			
            		}
            		else if(res_1 == 1 && (res_2 == 2 || res_2 == 3))
            		{
            			//Electric, grass beats water
            			pts_2 += 200;
            			pt_stat.append("\n");
            			pt_stat.append(user_name_2 + " has won 200 points!");
            			
            		}
            		else if(res_1 == 2 && (res_2 == 3 || res_2 == 5))
            		{
            			//Grass, earth beats electric
            			pts_2 += 200;
            			pt_stat.append("\n");
            			pt_stat.append(user_name_2 + " has won 200 points!");
            			
            		}
            		else
            		{
            			pts_1 = pts_1;
            		}
            		
            		turn_1 = 0;
            		turn_2 = 0;
            	}
            	
            }
        });
		
		//Player Stats
		panel5 = new JPanel(new FlowLayout()); //For getting player info
		panelGame.add(panel5, panel5.CENTER_ALIGNMENT);
		stats = new JTextArea();
		panel5.add(stats);
		
		
		
		//Game output
		panel6 = new JPanel(new FlowLayout()); //For getting player info
		panelGame.add(panel6, panel6.CENTER_ALIGNMENT);
		pt_stat = new JTextArea();
		panel6.add(pt_stat);
		pt_stat.append("*******GAME STATS******");
		
		
		//Winner declaration
	

		
		
		
		panelGame.setVisible(true);
		
		//Window listener
		addWindowListener
	      (new WindowAdapter() {
	          public void windowClosing(WindowEvent e) {
	             System.exit(0);
	             }
	          }
	      );
	}
	
	
	public static void main(String[] args){
	
		Frame f = new DiceGame();
		f.show();
	}
	
}
