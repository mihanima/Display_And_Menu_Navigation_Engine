import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import Damn.DamnComponent;
import Damn.Frame;
import TextureLoader.TextureLoader;
import TextureLoader.TextureObject;

public class DamnButton extends DamnComponent {
	boolean focused = false;
	boolean pressed = false;
	Image img;

	Color color = new Color(0xff00ffff);
	Frame fr;
	String name;

	DamnButton(int _x, int _y, int _width, int _height, Frame _fr, String _name) {
		super(_x, _y, _width, _height);
		fr = _fr;
		name = _name;
		
	}
	
	public void setTextures(){
		
		if (img == null) {
			TextureObject o = TextureLoader.getTexture("кирпичная стена 128x128.png");

			if (o != null) {
				img = o.image;
			}
		}
		
	}

	public void draw(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.drawImage(img, x, y,  width, height,null);

	}

	public void pressed(int _x, int _y) {
		color = new Color(0xffff0000);

	}

	public void released(int _x, int _y) {
		color = new Color(0xff00ffff);
		if (isCollisioned(_x, _y)){
			fr.change(name);
		}
	}

	public void mousedMoved(int _x, int _y) {
		if (!focused & isCollisioned(_x, _y)) {
			mouseEntered(_x, _y);

		} else if (focused & !isCollisioned(_x, _y)) {
			mouseExited(_x, _y);
		}
		focused = !focused;
	}

	public void mouseEntered(int _x, int _y) {
		if (!pressed)
			color = new Color(0xff00ff00);
	}

	public void mouseExited(int _x, int _y) {
		if (!pressed)
			color = new Color(0xff00ffff);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyID = e.getID();
		
		if (KeyEvent.getKeyText(keyID).equals("Enter")) {
			color = new Color(0xffff0000);
			pressed = true;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int keyID = e.getID();
		
		if (KeyEvent.getKeyText(keyID).equals("Enter")) {
			color = new Color(0xff00ffff);
			fr.change(name);
			pressed = false;
		}
	}

}
