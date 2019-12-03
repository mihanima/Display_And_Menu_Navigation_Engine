package Damn;

import java.awt.Graphics;

public abstract class DamnButton extends DamnComponent{
	public boolean focused = false;
	public boolean pressed = false;
	Frame frame;
	
	public DamnButton(int _x, int _y, int _width, int _height,Frame frame) {
		super(_x, _y, _width, _height);
		this.frame = frame;
		// TODO Auto-generated constructor stub
	}

	abstract public void onPressed();
	
	abstract public void onReleased();
	
	abstract public void onFocused();
	
	abstract public void onUnFocused();
	
	public abstract void draw(Graphics g);


}

