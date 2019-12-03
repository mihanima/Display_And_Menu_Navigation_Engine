import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import Damn.DamnComponent;

public class Players extends DamnComponent{
	public Players(int _x, int _y, int _width, int _height, int _w, int _s) {
		super(_x, _y, _width, _height);
		// TODO Auto-generated constructor stub
		
		s = _s;
		w = _w;
	}

	int w, s;
	int speedy = 0;

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	/*	g.setColor(Color.BLUE);
		g.fillRect(x, y+ height / 4, width, height / 2);
		g.setColor(Color.red);
		g.fillRect(x, y+ (height / 8) *3, width, height / 4);
*/
	}

	@Override
	public void update() {
		y += speedy;

	}

	@Override
	public void pressed(int _x, int _y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void released(int _x, int _y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(int _x, int _y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(int _x, int _y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousedMoved(int _x, int _y) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int keyID = e.getKeyCode();
		
		if (keyID == w) {
			speedy = -3;
		} else if (keyID == s) {
			speedy = 3;
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		//System.out.println("Players " + keyID);
		int keyID = e.getKeyCode();
		
		if (keyID == w) {
			speedy = 0;
		} else if (keyID == s) {
			speedy = 0;
		}
	}


	
}