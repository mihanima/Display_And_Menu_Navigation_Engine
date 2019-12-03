package PokemonGoAttacksSimulator;

import java.awt.Color;
import java.awt.Graphics;

import Damn.DamnButton;
import Damn.Frame;

public class PokemonGoButton extends DamnButton{
	
	Color color = new Color(0xff00ffff);

	public PokemonGoButton(int _x, int _y, int _width, int _height, Frame frame) {
		super(_x, _y, _width, _height, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onPressed() {
		color = new Color(0xffff0000);
		
	}

	@Override
	public void onReleased() {
		color = new Color(0xff00ffff);
		
	}

	@Override
	public void onFocused() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUnFocused() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
	}

}
