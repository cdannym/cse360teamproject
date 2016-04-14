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
	
	private Label rounds;
	private TextField numRounds;
	private Button roundSub;
	private int game_round;
	
	private Button roll;
	private Label rollNum;
	private TextField showRoll;
	private int random;
	private int roll_time = 0;
	
	private Button start;
	
	private JTextArea stats;
	private JTextPane element;
	
	Random elementGenerator;
	
	public DiceGame(){
		
		setSize(500,600);
		
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
                
            }
        });
		
		//Get game information
		
		panel3 = new JPanel(new FlowLayout()); //For getting player info
		panelGame.add(panel3, panel3.CENTER_ALIGNMENT);
		
		rounds = new Label("Enter the number of rounds you wish to play: ");
		numRounds = new TextField();
		roundSub = new Button("Submit");
		
		panel3.add(rounds);
		panel3.add(numRounds);
		panel3.add(roundSub);
		
		roundSub.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	game_round = Integer.parseInt(numRounds.getText());
            	stats.append("Round\n");
            	for(int i = 1; i <= game_round; i++)
            	{
            		stats.append(i + "\n");
            	}
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
		
		panel4.add(roll);
		panel4.add(rollNum);
		panel4.add(showRoll);
		
		roll.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
            	roll_time++;
            	random = elementGenerator.nextInt(6);
            	if(random == 0){
            			showRoll.setText("FIRE");
            	}else if(random == 1){
        			showRoll.setText("WATER");
            	}else if(random == 2){
        			showRoll.setText("ELECTRICITY");
            	}else if(random == 3){
        			showRoll.setText("GROUND");
            	}else if(random == 4){
        			showRoll.setText("BLAH");
            	}else{
        			showRoll.setText("MEH");
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
		element = new JTextPane();
		panel6.add(element);
		
		
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