package Damn;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import TextureLoader.TextureLoader;
import TextureLoader.TextureObject;

//наследуемый класс для нормального взаимодействия компонентов и слушателей

abstract public class DamnComponent {

	public int x;
	public int y;
	public int lastX = 0;
	public int lastY = 0;
	public int width;
	public int height;
	public boolean isActive = false;
	public TextureObject textureObject = null;
	public int area = 0;
	String TextureObjectName = null;
	
	public DamnComponent(int _x, int _y, int _width, int _height){
		
		x = _x;
		y = _y;
		width = _width;
		height = _height;		
		
	}
	
	public DamnComponent(int _x, int _y, int _width, int _height,boolean _isActive,String _TextureObjectName) {

		x = _x;
		y = _y;
		width = _width;
		height = _height;
		lastX = x;
		lastY = y;
		isActive = _isActive;
		TextureObjectName = _TextureObjectName;
		area = width * height;
	}
	
	public void SetTexture(){
		
		textureObject = TextureLoader.getTexture(TextureObjectName);
		
	}

	public boolean isCollisioned(int _x, int _y) {
		if (_x <= x + width & _x >= x & _y <= y + height & _y >= y) {
			return true;

		}
		return false;

	}

	public void draw(Graphics g){}

	public void update(){}
	
	public void pressed(int _x, int _y){}

	public void released(int _x, int _y){}

	public void mouseEntered(int _x, int _y){}

	public void mouseExited(int _x, int _y){}

	public void mousedMoved(int _x, int _y){}
	
	public void keyPressed(KeyEvent e){}
	
	public void keyReleased(KeyEvent e){}
	
	public void keyTyped(KeyEvent e){}
	
	
}
