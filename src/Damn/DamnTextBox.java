package Damn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class DamnTextBox extends DamnComponent{
	
	boolean focused = false;
	String text = "";
	String name = "";
	Color color;

	public DamnTextBox(int _x, int _y, int _width, int _height,Color color) {
		super(_x, _y, _width, 13);
		this.color = color;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(new Color(0xff000000));
		g.drawString( name+": \n"+text, x, y + 10);
	
	}
	
	public void released(int _x, int _y){

		if(isCollisioned(_x,_y)){
			System.out.println("textbox kek " + name);
			focused = true;
		}else
			focused = false;
	}
	
	public void keyTyped(KeyEvent e) {
		
		if(!focused)
			return;
		
		int keyID = e.getKeyChar();
		
		if(!e.isActionKey()){
			text+= e.getKeyChar();
		}
		
		
		if(keyID == 8){ // backspace
			if(text.length() > 1){
			text =	text.substring(0, text.length() - 2);
			
			}
		}
	}
	


	public String getText(){
		
		return text;
	}
	
	public void setText(String _text){
		
		text = _text;
	}
	
	public void setName(String _name){
		
		name = _name;
	}
}
