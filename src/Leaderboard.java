import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class Leaderboard extends GraphicsPane{
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private GImage background;
	private GLabel leaderboard;
	private GLabel userName;
	private GLabel score;
	private GLabel [] playerNames = new GLabel[10];
	private GLabel[] playerScore = new GLabel[10];
	private GLabel back;

	private Font space = new Font("Space", Font.PLAIN, 24);
	private Color purple = new Color(128,0,128);
	
	private HashMap<Integer, String> scores = new HashMap<Integer, String>();
	private double appWidth;
	private double appHeight;

	public Leaderboard(MainApplication app) {
		super();
		program = app;
		
		appWidth = app.getWidth();
		appHeight = app.getHeight();
		
		background = new GImage("Background.jpg");
		background.setSize(MainApplication.WINDOW_WIDTH, MainApplication.WINDOW_HEIGHT);
		
		leaderboard = new GLabel("Score Board", app.getWidth()/2 - 50, app.getHeight()/2 - 50* 5);
		leaderboard.setFont(space);
		leaderboard.setColor(purple);
		
		userName = new GLabel("User-Names", app.getWidth()/2 - 250, app.getHeight()/2 - 50 * 4);
		userName.setFont(space);
		userName.setColor(purple);
		
		score = new GLabel("Scores", app.getWidth() / 2 + 200, app.getHeight()/2 - 50 * 4);
		score.setFont(space);
		score.setColor(purple);
		
		back = new GLabel("Return", app.getWidth() / 2 - 50, app.getHeight() / 2 + 100);
		back.setFont(space);
		back.setColor(purple);
		scores = FileReader.grabInfoFromFile();
		
		
		
	}
	
	public void displayData() {
		scores = FileReader.grabInfoFromFile();
		int yCord = 0;
		int i = 0;
		for(Entry<Integer, String> entry : scores.entrySet()) {
			playerNames[i] = new GLabel(entry.getValue(), appWidth/2 - 250, appHeight / 2 - 150 + yCord);
			playerNames[i].setFont(space);
			playerNames[i].setColor(purple);
			playerScore[i] = new GLabel(Integer.toString(entry.getKey()), appWidth / 2 + 50 * 4, appHeight / 2 - 150 + yCord);
			playerScore[i].setFont(space);
			playerScore[i].setColor(purple);
			yCord += 30;
			i++;
		}
	}
	

	@Override
	public void showContents() {
		displayData();
		program.add(background);
		program.add(leaderboard);
		program.add(userName);
		program.add(score);
		program.add(back);
		if(scores.size() > 0) {
			for(int j = 0; j < scores.size(); j++) {
				program.add(playerNames[j]);
				program.add(playerScore[j]);
			}
		}	
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(leaderboard);
		program.remove(userName);
		program.remove(score);
		program.remove(back);
		if(scores.size() > 0) {
			for(int i = 0; i < scores.size(); i++) {
				program.remove(playerNames[i]);
				program.remove(playerScore[i]);
			}
		}
	}
	


	@Override
	public void mousePressed(MouseEvent e) {

		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == back) {
			program.switchToMenu();
		}
		
	}
}
