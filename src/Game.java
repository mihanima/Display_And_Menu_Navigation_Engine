
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import Damn.Frame;

public class Game extends Frame {

	Players pl1 = new Players(10,10,10,75,KeyEvent.VK_W,KeyEvent.VK_S);
	Players pl2 = new Players(690,10,10,75,38,40);
	Ball ball = new Ball();
	
	boolean ballSpawnCommand = false;
	
	int goals1 = 0;
	int goals2 = 0; 
	
	public Game() {
		super("Game");
	}

	@Override
	public void update() {
	
		pl1.update();
		pl2.update();
		ball.update();
		
		if(ball.x <= 0 ){
			ball.destroy();
			goals2++;
		}
		if(ball.x >= 700){
			ball.destroy();
			goals1++;
		}
		
		
		if(!ball.exist & ballSpawnCommand){
			ball.spawn(new Random().nextInt(100) + 300,new Random().nextInt(300)+100,new Random().nextInt(2) + 6,new Random().nextInt(2)+ 6);
			ballSpawnCommand = false; //hard war code
			
		}
		
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D gg = (Graphics2D) g;

		gg.setBackground(new Color(0xff000000));
		gg.clearRect(0, 0, 750, 500);
		gg.fillRect(355, 0, 10, 500);
		
		ball.draw(g);
		pl1.draw(g);
		pl2.draw(g);
		
		g.drawString(String.valueOf(goals1), 100, 100);
		g.drawString(String.valueOf(goals2), 600, 100);
	}

	public void keyReleased(KeyEvent e){
		
		int keyID = e.getKeyCode();		
		if (keyID == 32)  //пробел
			ballSpawnCommand = true;
		//System.out.println("game " +keyID);
	}

	@Override
	public void SetTextures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFirstCall() {
		ball.spawn(new Random().nextInt(100) + 300,new Random().nextInt(300)+100,new Random().nextInt(3) + 5,new Random().nextInt(2) + 4);	
		// ball.spawn(600, 100, 3, 0);
		addToKeyListenerComponent(pl1);
		addToKeyListenerComponent(pl2);
		addToKeyListenerComponent(this);
	//	addToKeyListenerComponent(this);
		//this.removeKeyListeners();
		//this.addKeyListener(pl1);
		//this.addKeyListener(pl2);
		ball.setPl(pl1, pl2);
		
	}

	@Override
	public void onCall() {
		// TODO Auto-generated method stub
		
	}
	
}
