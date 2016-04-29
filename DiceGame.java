import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;
import java.util.*;
import java.util.Random;
import javax.swing.border.Border;

public class DiceGame extends JFrame{
    
    JFrame frame;
    
    private JPanel panelGame;
    private JPanel titlePan;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4, panel4b;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    
    private JLabel title;
    
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
    private TextField life_1, life_2;
    private TextField p_1, p_2;
    private Label sub_name_1, sub_name_2;
    
    private Button roll;
    private Label rollNum;
    private TextField showRoll;
    private int random;
    private int fire, water, electric, grass, ice, earth;
    private int fire1, water1, electric1, grass1, ice1, earth1;
    private int fire2, water2, electric2, grass2, ice2, earth2;
    private int fire3, water3, electric3, grass3, ice3, earth3;
    
    private Button start;
    
    private Label player_names_1, player_names_2;
    private JTextField p_names_1, p_names_2;
    
    private Label life_lbl;
    private Label pts_lbl;
    private Label play_lbl;
    private Label tab_life, tab_pts;
    private JTextField life_field_1, life_field_2;
    private JTextField pts_field_1, pts_field_2;
    
    Random elementGenerator;
    String element;
    
    private JLabel winner;
    private JTextField declare;
    
    
    private JButton reset;
    
    public DiceGame(){
        
        
        //Customize Appearance of Game
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 5);
        Border border2 = BorderFactory.createLineBorder(Color.RED, 5);
        Border border3 = BorderFactory.createLineBorder(Color.DARK_GRAY, 5);
        
        //Set Frame size and color
        setSize(500,600);
        
        life_pt_1 = 5;
        life_pt_2 = 5;
        pts_1 = 0;
        pts_2 = 0;
        
        elementGenerator = new Random();
        
        panelGame = new JPanel(); //Get player information
        panelGame.setLayout(new BoxLayout(panelGame, BoxLayout.Y_AXIS));
        add(panelGame);
        
        
        //Add title to the game
        titlePan = new JPanel(new FlowLayout());
        title = new JLabel("Ultimate Dice Game");
        titlePan.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Impact", Font.PLAIN, 50));
        panelGame.add(titlePan);
        titlePan.add(title);
        
        
        //Get player 1 information
        panel1 = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel1, panel1.CENTER_ALIGNMENT);
        panel1.setBackground(Color.BLACK);
        
        player1 = new Label("Player 1: ");
        player1.setForeground(Color.WHITE);
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
                sub_name_1 = new Label(user_name_1);
                p_names_1.setText(user_name_1);
                name1.setText(" ");
                name1.setEditable(false);
                playSub1.setEnabled(false);
            }
        });
        
        //Get Player 2 information
        panel2 = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel2, panel2.CENTER_ALIGNMENT);
        panel2.setBackground(Color.BLACK);
        
        player2 = new Label("Player 2: ");
        player2.setForeground(Color.WHITE);
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
                p_names_2.setText(user_name_2);
                name2.setText(" ");
                name2.setEditable(false);
                playSub2.setEnabled(false);
                
            }
        });
        
        //Start game
        panel3 = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel3, panel3.CENTER_ALIGNMENT);
        panel3.setBackground(Color.BLACK);
        
        start = new Button("START");
        panel3.add(start);
        
        //Roll
        panel4 = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel4, panel4.CENTER_ALIGNMENT);
        panel4.setBackground(Color.BLACK);
        
        roll = new Button("Roll!");
        rollNum = new Label("Your roll: ");
        rollNum.setForeground(Color.WHITE);
        roll.setEnabled(false);
        
        showRoll = new TextField(10);
        turn = 0;
        turn_1 = 0;
        turn_2 = 0;
        pts_1 = 0;
        pts_2 = 0;
        
        panel4.add(roll);
        panel4.add(rollNum);
        panel4.add(showRoll);
        
        fire = 0; fire1 = 1; fire2 = 2; fire3 = 3;
        water = 4; water1 = 5; water2 = 6; water3 = 7;
        electric = 8; electric1 = 9; electric2 = 10; electric3 = 11;
        grass = 12; grass1 = 13; grass2 = 14; grass3 = 15;
        ice = 16; ice1 = 17; ice2 = 18; ice3 = 19;
        earth = 20; earth1 = 21; earth2 = 22; earth3 = 23;
        
        roll.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                
                turn++;
                random = elementGenerator.nextInt(27);
                
                
                if(random == fire || random == fire1 || random == fire2 || random == fire3){
                    element = "FIRE";
                    showRoll.setText("FIRE"  + random);
                }else if(random == water || random == water1 || random == water2 || random == water3){
                    element = "WATER";
                    showRoll.setText("WATER"  + random);
                }else if(random == electric || random == electric1 || random == electric2 || random == electric3){
                    element = "ELECTRIC";
                    showRoll.setText("ELECTRIC"  + random);
                }else if(random == grass || random == grass1 || random == grass2 || random == grass3){
                    element = "GRASS";
                    showRoll.setText("GRASS"  + random);
                }else if(random == ice || random == ice1 || random == ice2 || random == ice3){
                    element = "ICE";
                    showRoll.setText("ICE"  + random);
                }else if(random == earth || random == earth1 || random == earth2 || random == earth3){
                    element = "EARTH";
                    showRoll.setText("EARTH"  + random);
                }
                else if(random == 24 || random == 25){
                    element = "LEGENDARY";
                    showRoll.setText("LEGENDARY"  + random);
                }
                
                //If player 1 rolls
                if(turn % 2 == 1)
                {
                    //p_names_1.setBackground(Color.RED);
                    //p_names_2.setBackground(Color.WHITE);
                    //player_names_1.setForeground(Color.RED);
                    //player_names_1.setForeground(Color.WHITE);
                    turn_1 = 1;
                    res_1 = random;
                    
                }else{
                    //If player 2 rolls
                    //	p_names_1.setForeground(Color.WHITE);
                    //p_names_2.setForeground(Color.RED);
                    turn_2 = 1;
                    res_2 = random;
                }
                
                //Color Changes for Player 1
                if(res_1 == fire || res_1 == fire1 || res_1 == fire2 || res_1 == fire3)
                {
                    p_names_1.setBackground(Color.RED);
                }
                else if(res_1 == water || res_1 == water1 || res_1 == water2 || res_1 == water3)
                {
                    p_names_1.setBackground(Color.BLUE);
                }
                else if(res_1 == electric || res_1 == electric1 || res_1 == electric2 || res_1 == electric3)
                {
                    p_names_1.setBackground(Color.YELLOW);
                }
                else if(res_1  == grass || res_1 == grass1 || res_1 == grass2 || res_1 == grass3)
                {
                    p_names_1.setBackground(Color.GREEN);
                }
                else if(res_1  == ice || res_1 == ice1 || res_1 == ice2 || res_1 == ice3)
                {
                    p_names_1.setBackground(Color.CYAN);
                }
                else if(res_1  == earth || res_1 == earth1 || res_1 == earth2 || res_1 == earth3)
                {
                    p_names_1.setBackground(Color.GRAY);
                }
                else if(res_1 == 24 || res_1 == 25)
                {
                    p_names_1.setBackground(Color.ORANGE);
                }
                
                
                //Color Changes for Player 2
                if(res_2 == fire || res_2 == fire1 || res_2 == fire2 || res_2 == fire3)
                {
                    p_names_2.setBackground(Color.RED);
                }
                else if(res_2 == water || res_2 == water1 || res_2 == water2 || res_2 == water3)
                {
                    p_names_2.setBackground(Color.BLUE);
                }
                else if(res_2 == electric || res_2 == electric1 || res_2 == electric2 || res_2 == electric3)
                {
                    p_names_2.setBackground(Color.YELLOW);
                }
                else if(res_2  == grass || res_2 == grass1 || res_2 == grass2 || res_2 == grass3)
                {
                    p_names_2.setBackground(Color.GREEN);
                }
                else if(res_2  == ice || res_2 == ice1 || res_2 == ice2 || res_2 == ice3)
                {
                    p_names_2.setBackground(Color.CYAN);
                }
                else if(res_2  == earth || res_2 == earth1 || res_2 == earth2 || res_2 == earth3)
                {
                    p_names_2.setBackground(Color.GRAY);
                }
                else if(res_2 == 24 || res_2 == 25)
                {
                    p_names_2.setBackground(Color.MAGENTA);
                }
                
                //Total points tracker
                
                while(turn_1 == 1 && turn_2 == 1)
                {
                    //ELEMENTAL COMBINATIONS
                    //FIRE PLAYER 1
                    if((res_1  == fire || res_1 == fire1 || res_1 == fire2 || res_1 == fire3)  &&
                       ((res_2 == water || res_2 == water1 || res_2 == water2 || res_2 == water3)
                        || (res_2 == earth || res_2 == earth1 || res_2 == earth2 || res_2 == earth3)))
                    {
                        //FIRE is beat by WATER & EARTH
                        pts_2 += 50;
                        life_pt_1--;
                        life_pt_1--;
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        
                    }
                    else if((res_1  == fire || res_1 == fire1 || res_1 == fire2 || res_1 == fire3)
                            && ((res_2  == fire || res_2 == fire1 || res_2 == fire2 || res_2 == fire3)
                                || (res_2  == electric || res_2  == electric1 || res_2  == electric2 || res_2  == electric3)))
                    {
                        //FIRE VS FIRE & ELECTRIC
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    //FIRE PLAYER 2
                    else if((res_2  == fire || res_2 == fire1 || res_2 == fire2 || res_2 == fire3)  &&
                            ((res_1 == water || res_1 == water1 || res_1 == water2 || res_1 == water3)
                             || (res_1 == earth || res_1 == earth1 || res_1 == earth2 || res_1 == earth3)))
                    {
                        //FIRE is beat by WATER & EARTH
                        pts_1 += 50;
                        life_pt_2--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else if((res_2  == fire || res_2 == fire1 || res_2 == fire2 || res_2 == fire3)
                            && ((res_1  == fire || res_1 == fire1 || res_1 == fire2 || res_1 == fire3)
                                || (res_1  == electric || res_1  == electric1 || res_1  == electric2 || res_1  == electric3)))
                    {
                        //FIRE VS FIRE & ELECTRIC
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                    }
                    else
                    {
                        pts_1 = pts_1;
                    }
                    //WATER PLAYER 1
                    if((res_1  == water || res_1 == water1 || res_1 == water2 || res_1 == water3) &&
                       ((res_2  == electric || res_2  == electric1 || res_2  == electric2 || res_2  == electric3)
                        || (res_2  == grass || res_2  == grass1 || res_2  == grass2 || res_2  == grass3)))
                    {
                        //WATER is beat by ELECTRIC & GRASS
                        pts_2 += 50;
                        life_pt_1--;
                        life_pt_1--;
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        
                    }
                    else if((res_1  == water || res_1  == water1 || res_1  == water2 || res_1  == water3) &&
                            ((res_2  == water || res_2  == water1 || res_2  == water2 || res_2  == water3)
                             || (res_2  == ice || res_2  == ice1 || res_2  == ice2 || res_2  == ice3)))
                    {
                        //WATER VS WATER & ICE
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    //WATER PLAYER 2
                    else if((res_2  == water || res_2 == water1 || res_2 == water2 || res_2 == water3) &&
                            ((res_1  == electric || res_1  == electric1 || res_1  == electric2 || res_1  == electric3)
                             || (res_1  == grass || res_1  == grass1 || res_1  == grass2 || res_1  == grass3)))
                    {
                        //WATER is beat by ELECTRIC & GRASS
                        pts_1 += 50;
                        life_pt_2--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else if((res_2  == water || res_2  == water1 || res_2  == water2 || res_2  == water3) &&
                            ((res_1  == water || res_1  == water1 || res_1  == water2 || res_1  == water3)
                             || (res_1  == ice || res_1  == ice1 || res_1  == ice2 || res_1  == ice3)))
                    {
                        //WATER VS WATER & ICE
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else
                    {
                        pts_1 = pts_1;
                    }
                    //ELECTRIC PLAYER 1
                    if((res_1  == electric || res_1  == electric1 || res_1  == electric2 || res_1  == electric3) &&
                       ((res_2  == grass || res_2  == grass1 || res_2  == grass2 || res_2  == grass3)
                        || (res_2 == earth || res_2 == earth1 || res_2 == earth2 || res_2 == earth3)))
                    {
                        //ELECTRIC is beat by GRASS & EARTH
                        pts_2 += 50;
                        life_pt_1--;
                        life_pt_1--;
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        
                    }
                    else if((res_1  == electric || res_1  == electric1 || res_1  == electric2 || res_1  == electric3) &&
                            ((res_2  == electric || res_2  == electric1 || res_2  == electric2 || res_2  == electric3)))
                    {
                        //ELECTRIC VS ELECTRIC
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    //ELECTRIC PLAYER 2
                    else if((res_2  == electric || res_2  == electric1 || res_2  == electric2 || res_2  == electric3) &&
                            ((res_1  == grass || res_1  == grass1 || res_1  == grass2 || res_1  == grass3)
                             || (res_1 == earth || res_1 == earth1 || res_1 == earth2 || res_1 == earth3)))
                    {
                        //ELECTRIC is beat by GRASS & EARTH
                        pts_1 += 50;
                        life_pt_2--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else if((res_2  == electric || res_2  == electric1 || res_2  == electric2 || res_2  == electric3) &&
                            ((res_1  == electric || res_1  == electric1 || res_1  == electric2 || res_1  == electric3)))
                    {
                        //ELECTRIC VS ELECTRIC
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else
                    {
                        pts_1 = pts_1;
                    }
                    //GRASS PLAYER 1
                    if((res_1 == grass || res_1 == grass1 || res_1 == grass2 || res_1 == grass3) &&
                       ((res_2 == fire || res_2 == fire1 || res_2 == fire2 || res_2 == fire3)
                        || (res_2 == ice || res_2 == ice1 || res_2 == ice2 || res_2 == ice3)))
                    {
                        //GRASS is beat by FIRE & ICE
                        pts_2 += 50;
                        life_pt_1--;
                        life_pt_1--;
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        
                    }
                    else if((res_1 == grass || res_1 == grass1 || res_1 == grass2 || res_1 == grass3) &&
                            ((res_2 == grass || res_2 == grass1 || res_2 == grass2 || res_2 == grass3)
                             || (res_2 == earth || res_2 == earth1 || res_2 == earth2 || res_2 == earth3)))
                    {
                        //GRASS VS GRASS & EARTH
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    //GRASS PLAYER 2
                    else if((res_2 == grass || res_2 == grass1 || res_2 == grass2 || res_2 == grass3) &&
                            ((res_1 == fire || res_1 == fire1 || res_1 == fire2 || res_1 == fire3)
                             || (res_1 == ice || res_1 == ice1 || res_1 == ice2 || res_1 == ice3)))
                    {
                        //GRASS is beat by FIRE & ICE
                        pts_1 += 50;
                        life_pt_2--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else if((res_2 == grass || res_2 == grass1 || res_2 == grass2 || res_2 == grass3) &&
                            ((res_1 == grass || res_1 == grass1 || res_1 == grass2 || res_1 == grass3)
                             || (res_1 == earth || res_1 == earth1 || res_1 == earth2 || res_1 == earth3)))
                    {
                        //GRASS VS GRASS & EARTH
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else
                    {
                        pts_1 = pts_1;
                    }
                    //ICE PLAYER 1
                    if((res_1 == ice || res_1 == ice1 || res_1 == ice2 || res_1 == ice3) &&
                       ((res_2 == fire || res_2 == fire1 || res_2 == fire2 || res_2 == fire3)
                        || (res_2 == electric || res_2 == electric1 || res_2 == electric2 || res_2 == electric3)))
                    {
                        //ICE is beat by FIRE & ELECTRIC
                        pts_2 += 50;
                        life_pt_1--;
                        life_pt_1--;
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        
                    }
                    else if((res_1 == ice || res_1 == ice1 || res_1 == ice2 || res_1 == ice3) &&
                            ((res_2 == ice || res_2 == ice1 || res_2 == ice2 || res_2 == ice3)))
                    {
                        //ICE VS ICE
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    //ICE PLAYER 2
                    else if((res_2 == ice || res_2 == ice1 || res_2 == ice2 || res_2== ice3) &&
                            ((res_1 == fire || res_1 == fire1 || res_1 == fire2 || res_1 == fire3)
                             || (res_1 == electric || res_1 == electric1 || res_1 == electric2 || res_1 == electric3)))
                    {
                        //ICE is beat by FIRE & ELECTRIC
                        pts_1 += 50;
                        life_pt_2--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else if((res_2 == ice || res_2 == ice1 || res_2 == ice2 || res_2 == ice3) &&
                            ((res_1 == ice || res_1 == ice1 || res_1 == ice2 || res_1 == ice3)))
                    {
                        //ICE VS ICE
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else
                    {
                        pts_1 = pts_1;
                    }
                    //EARTH PLAYER 1
                    if((res_1 == earth || res_1 == earth1 || res_1 == earth2 || res_1 == earth3) &&
                       ((res_2 == water || res_2 == water1 || res_2 == water2 || res_2 == water3)
                        || (res_2 == ice || res_2 == ice1 || res_2 == ice2 || res_2 == ice3)))
                    {
                        //EARTH is beat by WATER & ICE
                        pts_2 += 50;
                        life_pt_1--;
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        
                    }
                    else if((res_1 == earth || res_1 == earth1 || res_1 == earth2 || res_1 == earth3) &&
                            ((res_2 == earth || res_2 == earth1 || res_2 == earth2 || res_2 == earth3)))
                    {
                        //EARTH VS EARTH
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    //EARTH PLAYER 2
                    else if((res_2 == earth || res_2 == earth1 || res_2 == earth2 || res_2 == earth3) &&
                            ((res_1 == water || res_1 == water1 || res_1 == water2 || res_1 == water3)
                             || (res_1 == ice || res_1 == ice1 || res_1 == ice2 || res_1 == ice3)))
                    {
                        //EARTH is beat by WATER & ICE
                        pts_1 += 50;
                        life_pt_2--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else if((res_2 == earth || res_2 == earth1 || res_2 == earth2 || res_2 == earth3) &&
                            ((res_1 == earth || res_1 == earth1 || res_1 == earth2 || res_1 == earth3)))
                    {
                        //EARTH VS EARTH
                        pts_1 += 25;
                        pts_2 += 25;
                        life_pt_1--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    else
                    {
                        pts_1 = pts_1;
                    }
                    //LEGENDARY PLAYER 1
                    if((res_1 == 24 || res_1 == 25) && (res_2 == fire || res_2 == water  ||
                                                        res_2 == electric || res_2 == grass || res_2 == ice  || res_2 == earth))
                    {
                        //LEGENDARY BEATS 1 OF EVERYTHING
                        pts_1 += 150;
                        life_pt_2--;
                        life_pt_2--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    //LEGENDARY PLAYER 2
                    else if((res_2 == 24 || res_2 == 25) && (res_1 == fire || res_1 == water
                                                             || res_1 == electric  || res_1 == grass || res_1 == ice  || res_1 == earth))
                    {
                        //LEGENDARY BEATS 1 OF EVERYTHING
                        pts_2 += 150;
                        life_pt_1--;
                        life_pt_1--;
                        life_pt_1--;
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        
                    }
                    //LEGENDARY ULTIMATE
                    if((res_1 == 26) && (res_2 == 24 || res_2 == 25))
                    {
                        //LEGENDARY PLAYER 1 WINS GAME
                        pts_1 += 500;
                        life_pt_2--;
                        life_pt_2--;
                        life_pt_2--;
                        life_pt_2--;
                        life_pt_2--;
                        life_pt_2--;
                        pts_field_1.setText(Integer.toString(pts_1));
                        life_field_2.setText(Integer.toString(life_pt_2));
                        
                    }
                    //LEGENDARY ULTIMATE
                    if((res_2 == 26) && (res_1 == 24 || res_1 == 25))
                    {
                        //LEGENDARY PLAYER 2 WINS GAME
                        pts_2 += 500;
                        life_pt_1--;
                        life_pt_1--;
                        life_pt_1--;
                        life_pt_1--;
                        life_pt_1--;
                        life_pt_1--;
                        pts_field_2.setText(Integer.toString(pts_2));
                        life_field_1.setText(Integer.toString(life_pt_1));
                        
                    }
                    
                    
                    //Declares a Winner
                    Winner();
                    
                    turn_1 = 0;
                    turn_2 = 0;
                }
                
            }
        });
        
        
        //Player Stats
        panel4b = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel4b, panel4b.CENTER_ALIGNMENT);
        panel4b.setBackground(Color.BLACK);
        
        player_names_1 = new Label("     Player 1:");
        player_names_1.setForeground(Color.WHITE);
        
        player_names_2 = new Label("Player 2:");
        player_names_2.setForeground(Color.WHITE);
        
        p_names_1 = new JTextField(5);
        p_names_2 = new JTextField(5);
        
        p_names_1.setBorder(border1);
        p_names_2.setBorder(border1);
        
        p_names_1.setEditable(false);
        p_names_2.setEditable(false);
        
        panel4b.add(player_names_1);
        panel4b.add(p_names_1);
        panel4b.add(player_names_2);
        panel4b.add(p_names_2);
        
        //Universal lab variable
        tab_life = new Label("            ");
        tab_pts = new Label("            ");
        
        //Life points stats
        panel5 = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel5, panel5.CENTER_ALIGNMENT);
        panel5.setBackground(Color.BLACK);
        
        
        life_lbl = new Label(" Life points: ");
        life_lbl.setForeground(Color.white);
        life_field_1 = new JTextField(5);
        life_field_2 = new JTextField(5);
        
        life_field_1.setBorder(border2);
        life_field_2.setBorder(border2);
        
        life_field_1.setEditable(false);
        life_field_2.setEditable(false);
        
        panel5.add(life_lbl);
        panel5.add(life_field_1);
        panel5.add(tab_life);
        panel5.add(life_field_2);
        
        
        //Points output
        panel6 = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel6, panel6.CENTER_ALIGNMENT);
        panel6.setBackground(Color.BLACK);
        
        pts_lbl = new Label("Total points: ");
        pts_lbl.setForeground(Color.WHITE);
        pts_field_1 = new JTextField(5);
        pts_field_2 = new JTextField(5);
        
        pts_field_1.setBorder(border2);
        pts_field_2.setBorder(border2);
        
        pts_field_1.setEditable(false);
        pts_field_2.setEditable(false);
        
        panel6.add(pts_lbl);
        panel6.add(pts_field_1);
        panel6.add(tab_pts);
        panel6.add(pts_field_2);
        
        start.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                
                life_field_1.setText("5");
                life_field_2.setText("5");
                
                pts_field_1.setText("0");
                pts_field_2.setText("0");
                
                start.setEnabled(false);
                roll.setEnabled(true);
                
                
            }
        });
        
        
        //Game output/ Winner Declaration
        panel7 = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel7, panel7.CENTER_ALIGNMENT);
        panel7.setBackground(Color.BLACK);
        
        winner = new JLabel("Winner: ");
        winner.setForeground(Color.WHITE);
        declare = new JTextField(15);
        
        declare.setBorder(border3);
        declare.setEditable(false);
        
        panel7.add(winner);
        panel7.add(declare);
        
        //Reset Game
        panel8 = new JPanel(new FlowLayout()); //For getting player info
        panelGame.add(panel8, panel8.CENTER_ALIGNMENT);
        panel8.setBackground(Color.BLACK);
        
        reset = new JButton("RESET");
        panel8.add(reset);
        
        reset.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                start.setEnabled(true);
                
                name1.setEditable(true);
                playSub1.setEnabled(true);
                
                name2.setEditable(true);
                playSub2.setEnabled(true);
                
                p_names_2.setText(" ");
                p_names_1.setText(" ");
                declare.setText(" ");
                showRoll.setText(" ");
                
                p_names_1.setBackground(Color.WHITE);
                p_names_2.setBackground(Color.WHITE);
                
                life_pt_1 = 5;
                life_pt_2 = 5;
                pts_1 = 0;
                pts_2 = 0;
                
                life_field_1.setText(" ");
                life_field_2.setText(" ");
                
                pts_field_1.setText(" ");
                pts_field_2.setText(" ");
                
                
                
            }
        });
        
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
    public void Winner()
    {
        //Winner declaration
        if(life_pt_1 <= 0)
        {
            declare.setText(user_name_2);
            roll.setEnabled(false);
        }
        
        if(life_pt_2 <= 0)
        {
            declare.setText(user_name_1);
            roll.setEnabled(false);
        }
    }
    
    public static void main(String[] args){
        
        Frame f = new DiceGame();
        f.show();
    }
    
    
}