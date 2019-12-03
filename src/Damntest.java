import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import TextureLoader.*;
import Damn.DamnComponent;

public class Damntest extends DamnComponent {
	int speedy = 0;
	int speedx = 0;

	public Damntest(int _x, int _y, int _width, int _height) {
		super(_x, _y, _width, _height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.CYAN);
		g.fillRect(x, y, width, height);

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

		int keyID = e.getID();
		
		switch (keyID) {
		case 38://KeyEvent.VK_W:
			speedy = -0;
			break;

		case 40 ://KeyEvent.VK_S:
			speedy = 0;
			break;
		case 37: //KeyEvent.VK_A:
			speedx = -5;
			break;
		case 39: //KeyEvent.VK_D:
			speedx = 5;
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int keyID = e.getID();
		
		//System.out.println(keyID);
		switch (keyID) {

		case 38:
			speedy = 0;
			break;
		case 40:
			speedy = 0;
			break;
		case 37:
			speedx = 0;
			break;
		case 39:
			speedx = 0;
			break;
		case KeyEvent.VK_E:
			System.exit(0);
		}
	}

	@Override
	public void update() {
		TextureLoader.getTexture("1");
		x+=speedx;
		y+=speedy;
	}

}
