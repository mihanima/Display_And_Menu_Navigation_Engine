import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Damn.Frame;

public class DamnCollisionTestFrame extends Frame{
	
	
	DamnCollisionClassTest coll = new DamnCollisionClassTest();
	Wall w = new Wall(200,400,300,50,false,"wall.png");
	Wall w2 = new Wall(300,330,300,50,false,"wall.png");
	PlayerForTestFrame pl = new PlayerForTestFrame(350,100,50,50,true,"TestPlayerOval.png",KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_A,KeyEvent.VK_D);

	public DamnCollisionTestFrame() {
		super("DamnCollisionTestFrame");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		pl.update();
		coll.checkCollisions();
		
	}
	@Override
	public void SetTextures() {
		w.SetTexture();
		w2.SetTexture();
		
		pl.SetTexture();
		addToKeyListenerComponent(pl);
		coll.addObjectToDamnCollision(pl);
		
		coll.addObjectToDamnCollision(w);
		coll.addObjectToDamnCollision(w2);
		
		
		
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D gg = (Graphics2D) g;

		gg.setBackground(new Color(0xff000000));
		gg.clearRect(0, 0, 750, 500);
		w.draw(g);
		w2.draw(g);
		pl.draw(g);
		
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
