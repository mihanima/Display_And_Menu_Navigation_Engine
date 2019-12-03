import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import Damn.Frame;

public class Mainframe extends Frame {

	int x;
	int xx;
	double d = 0;

	int next = 0;
	DamnButton b = new DamnButton(100,100,100,100,this,"SFrame");

	Mainframe() {
		super("Mainframe");
	}

	@Override
	public void update() {
		
		x = (int) (100 * Math.sin(d));
		xx = (int) (100 * Math.sin(d + 0.6f));
		d += 0.02f;
		
	}

	@Override
	public void draw(Graphics g) {

		Graphics2D gg = (Graphics2D) g;

		gg.setBackground(new Color(0xff0000ff));

		gg.clearRect(0, 0, 990, 990);
		gg.setColor(new Color(0xff00ff00));
		((Graphics2D) gg).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gg.fillOval(x + 200, 200, 150, 150);
		// ((Graphics2D) gg).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_OFF);
		gg.fillOval(xx + 200, 30, 150, 150);
		b.draw(g);
		
	}

	@Override
	public void SetTextures() {
		b.setTextures();
		
	}

	@Override
	public void onFirstCall() {
		addToMouseListenerComponent(b);
		addToMouseMoutionListenerComponent(b);
		addToKeyListenerComponent(b);
		
	}

	@Override
	public void onCall() {
		
		setTimerSettings(500,240);
	}

}
