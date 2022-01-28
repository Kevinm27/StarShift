import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class Leaderboard extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
								
	private GImage background;


	public Leaderboard(MainApplication app) {
		super();
		program = app;
		
	
	}

	@Override
	public void showContents() {

	}

	@Override
	public void hideContents() {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		GObject obj = program.getElementAt(e.getX(), e.getY());
		
		
	}
}
