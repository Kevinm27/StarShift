import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map.Entry;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class Leaderboard extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private GImage background;
	private GLabel leaderboard;
	private GLabel name;
	private GLabel score;
	private GLabel [] playerNames = new GLabel[10];
	private GLabel[] playerScore = new GLabel[10];
	private GLabel back;
	
	private HashMap<Integer, String> scores = new HashMap<Integer, String>();


	public Leaderboard(MainApplication app) {
		super();
		program = app;
		Font space = new Font("Space", Font.PLAIN, 24);
		Color purple = new Color(128,0,128);
		
		background = new GImage("Background.jpg");
		background.setSize(MainApplication.WINDOW_WIDTH, MainApplication.WINDOW_HEIGHT);
		
		leaderboard = new GLabel("Score Board", app.getWidth()/2 - 50, app.getHeight()/2 - 50* 5);
		leaderboard.setFont(space);
		leaderboard.setColor(purple);
		
		name = new GLabel("User-Names", app.getWidth()/2 - 250, app.getHeight()/2 - 50 * 4);
		name.setFont(space);
		name.setColor(purple);
		
		score = new GLabel("Scores", app.getWidth() / 2 + 200, app.getHeight()/2 - 50 * 4);
		score.setFont(space);
		score.setColor(purple);
		
		back = new GLabel("Return", app.getWidth() / 2, app.getHeight() / 2 + 200);
		back.setFont(space);
		back.setColor(purple);
		
		scores = FileReader.grabInfoFromFile();
		int yCord = 100;
		int i = 0;
		for(Entry<Integer, String> entry : scores.entrySet()) {
			playerNames[i] = new GLabel(entry.getValue(), app.getWidth()/2 - 250, app.getHeight() / 2 + yCord);
			playerNames[i].setFont(space);
			playerNames[i].setColor(purple);
			playerScore[i] = new GLabel(Integer.toString(entry.getKey()), app.getWidth() / 2 + 50 * 4, app.getHeight() / 2 + yCord);
			playerScore[i].setFont(space);
			playerScore[i].setColor(purple);
			yCord -= 30;
			i++;
		}
		
	}

	@Override
	public void showContents() {
		program.add(background);
		program.add(leaderboard);
		program.add(name);
		program.add(score);
		program.add(back);
		for(int i = 0; i < 10; i++) {
			program.add(playerNames[i]);
			program.add(playerScore[i]);
		}
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(leaderboard);
		program.remove(name);
		program.remove(score);
		program.remove(back);
		for(int i = 0; i < 10; i++) {
			program.add(playerNames[i]);
			program.remove(playerScore[i]);
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
