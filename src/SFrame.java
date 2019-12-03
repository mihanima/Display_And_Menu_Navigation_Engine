import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import Damn.Frame;

public class SFrame extends Frame {

	int x;
	int xx;
	double d = 0;

	int next;
	DamnButton testColl = new DamnButton(100,300,100,100,this,"DamnCollisionTestFrame"); 
	DamnButton b = new DamnButton(100,100,100,100,this,"Game");
	DamnButton okroshka = new DamnButton(400,100,100,100,this,"OkroshkaFrame"); 
	DamnButton PokemonGoMainFramebutton = new DamnButton(400,300,100,100,this,"PokemonGoMainFrame"); 

	SFrame() {
		super("SFrame");

	}
	
	@Override
	public void update() {

		x = (int) (100 * Math.sin(d));
		xx = (int) (100 * Math.sin(d + 0.6f));
		d += 0.02f;

		if (next == 60 * 10) {

			change("Mainframe");
			next = -1;
		}

		next++;

	}

	@Override
	public void draw(Graphics g) {

		Graphics2D gg = (Graphics2D) g;

		gg.setBackground(new Color(0xff0000ff));

		gg.clearRect(0, 0, 990, 990);
		gg.setColor(new Color(0xff00ff00));
		((Graphics2D) gg).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gg.fillRect(x + 200, 200, 150, 150);
		// ((Graphics2D) gg).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_OFF);
		gg.fillRect(xx + 200, 30, 150, 150);
		
		b.draw(g);
		okroshka.draw(g);
		testColl.draw(g);
		PokemonGoMainFramebutton.draw(g);

	}

	@Override
	public void SetTextures() {
		b.setTextures();
		okroshka.setTextures();
		testColl.setTextures();
		PokemonGoMainFramebutton.setTextures();
	}

	@Override
	public void onFirstCall() {
		addToMouseListenerComponent(b);
		addToMouseMoutionListenerComponent(b);
		addToKeyListenerComponent(b);
		
		addToMouseListenerComponent(okroshka);
		addToMouseMoutionListenerComponent(okroshka);
		addToKeyListenerComponent(okroshka);
		
		addToMouseListenerComponent(testColl);
		addToMouseMoutionListenerComponent(testColl);
		addToKeyListenerComponent(testColl);
		
		addToMouseListenerComponent(PokemonGoMainFramebutton);
		addToMouseMoutionListenerComponent(PokemonGoMainFramebutton);
		addToKeyListenerComponent(PokemonGoMainFramebutton);
		
	}

	@Override
	public void onCall() {
		setTimerSettings(120);
		
	}

}
