package TextureLoader;

import java.awt.Image;

public class TextureObject {
	public Image image; 
	public short[][] poligon;// хранит карту картинки 
	public int[][] borderLinePolygon; //хранит только граничные пиксели в виде списка
	public String name;
	
}
