import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Damn.Frame;
import TextureLoader.TextureLoader;

public class Launching extends Frame{
	double d= 0;

	public Launching() {
		super("Launching");
	}

	@Override
	public void update() {
		if(TextureLoader.getLoaded()){
			change("SFrame");
		}
		d+=0.01f;
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 990,990);
		g.setColor(Color.YELLOW);
		g.drawString("DownLoading Textures", 300, 200);
	}

	@Override
	public void SetTextures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFirstCall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCall() {
		// TODO Auto-generated method stub
		
	}


}
