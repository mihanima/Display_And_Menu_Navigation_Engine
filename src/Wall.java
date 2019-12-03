import java.awt.Graphics;

import Damn.DamnComponent;


public class Wall extends DamnComponent{
		

	
	public Wall(int _x, int _y, int _width, int _height, boolean _isActive, String _TextureObjectName) {
		super(_x, _y, _width, _height, _isActive, _TextureObjectName);
		
	}
	
	public void draw(Graphics g){
		
		g.drawImage(textureObject.image,x,y,width,height,null);
		
	}
}
