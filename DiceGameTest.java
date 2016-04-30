import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;


public class DiceGameTest extends DiceGame {

	@Test

	
	public void winnerTest() {
		
		DiceGame game = new DiceGame();
		
		String player1 = "Bob";
		String player2 = "Billy";
		
		//JTextField declare = new JTextField(20);
	    game.Winner(player1,player2, 20, 0);
	    String output = declare.getText();
		
		assertEquals("Bob", declare.getText());
	}

	public void winnerTest2() {
		
		DiceGame game = new DiceGame();
		
		String player1 = "Bob";
		String player2 = "Billy";
		
		//JTextField declare = new JTextField(20);
	    game.Winner(player1,player2, 0, 20);
	    String output = declare.getText();
		
		assertEquals("Billy", declare.getText());
	}

	
}