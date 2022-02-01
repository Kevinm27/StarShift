import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class EnterName extends GraphicsPane implements KeyListener {
	private MainApplication program;
	private GImage background;
	private GLabel congratMessage;
	private GLabel enterName;
	public static GLabel score;
	private GLabel submitName;
	private GLabel startEntering;
	private String input = "";
	public Font space = new Font("Space", Font.PLAIN, 24);
	public Color purple = new Color(128,0,128);
	public boolean clicked;
	public EnterName(MainApplication app) {
		super();
		program = app;
		background = new GImage("Background.jpg");
		background.setSize(MainApplication.WINDOW_WIDTH, MainApplication.WINDOW_HEIGHT);
		
		congratMessage = new GLabel("Congratulations! You made it on the Local Leaderboard!! ", app.getWidth()/2 - 300, app.getHeight()/2 - 50*5);
		congratMessage.setFont(space);
		congratMessage.setColor(purple);
		
		score = new GLabel("Score: " + Score.getScore(), app.getWidth()/2 - 100, app.getHeight()/2 - 50 *4);
		score.setFont(space);
		score.setColor(purple);
		
		enterName = new GLabel("Enter your Name in the Console Below!", app.getWidth()/2 - 200, app.getHeight()/2 - 50 *3);
		enterName.setFont(space);
		enterName.setColor(purple);
		
		startEntering = new GLabel("Click here to start entering!!", app.getWidth()/2 - 150, app.getHeight()/2 - 100);
		startEntering.setFont(space);
		startEntering.setColor(purple);
		
		submitName = new GLabel("Submit", app.getWidth()/2 - 50, app.getHeight()/2 + 50 * 2);
		submitName.setFont(space);
		submitName.setColor(purple);

		
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub	
		//program.addKeyListeners(new TAdapter());
		program.add(background);
		program.add(congratMessage);
		program.add(submitName);
		program.add(enterName);
		program.add(startEntering);
		program.add(score);
		//program.addKeyListeners(new TAdapter());
		
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(background);
		program.remove(congratMessage);
		program.remove(submitName);
		program.remove(enterName);
		program.remove(startEntering);
		program.remove(score);
	}
	
	/*private class TAdapter extends KeyAdapter implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			int key = e.getKeyCode();
			if(input.length() < 10 && ((key >= 48 && key <= 57) || (key >= 65 && key <= 90) )) {
			
				
					input += e.getKeyChar();
				
			}	
		}
	}
	
	*/
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());

		if(obj == submitName) {
			FileReader.inputNewScore(Score.getScore(), input);
			program.switchToLeaderboard();
		}
		if(obj == startEntering) {
			startEntering.setColor(Color.BLUE);
			program.add(startEntering);
			clicked = true;
			
		}
		else if(clicked == true) {
			try {
				Scanner myObj = new Scanner(System.in);
				input = myObj.nextLine();
				myObj.close();
				}
				catch(NoSuchElementException e1){
					System.out.println("Click the Label/Text !!");
				}
			clicked = false;
		}
	}
	


}
