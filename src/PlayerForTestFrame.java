
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Damn.DamnComponent;


public class PlayerForTestFrame extends DamnComponent{
	
	int w, s,a,d;
	int speedY = 0;
	int speedX = 0;
	
	public PlayerForTestFrame(int _x, int _y, int _width, int _height, boolean _isActive, String _TextureObjectName, int _w, int _s, int _a, int _d) {
		super(_x, _y, _width, _height, _isActive, _TextureObjectName);
		
		s = _s;
		w = _w;
		a = _a;
		d =_d;
	}
	
	public void update() {
		lastX = x;
		lastY = y;
		y += speedY;
		x += speedX;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int keyID = e.getKeyCode();
		
		if (keyID == w) {
			speedY = -3;
		} else if (keyID == s) {
			speedY = 3;
		}
		
		if (keyID == a) {
			speedX = -3;
		} else if (keyID == d) {
			speedX = 3;
		}
	
	}

	public void keyReleased(KeyEvent e) {
		
		//System.out.println("Players " + keyID);
		int keyID = e.getKeyCode();
		
		if (keyID == w) {
			speedY = 0;
		} else if (keyID == s) {
			speedY = 0;
		}
		
		if (keyID == a) {
			speedX = 0;
		} else if (keyID == d) {
			speedX = 0;
		}
		
	}
	
	public void draw(Graphics g){
		
		g.drawImage(textureObject.image,x,y,width,height,null);
	}
	
}
