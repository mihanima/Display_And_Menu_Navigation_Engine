package Damn;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//слушатель клавиатуры на окне

public class DamnKeyListener extends DamnListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		
		for (DamnComponent c : components) {
			c.keyTyped(e);
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//System.out.println("res");
		for (DamnComponent c : components) {
			c.keyPressed(e);
			
		}
		//System.out.println("res2");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		for (DamnComponent c : components) {
			c.keyReleased(e);
			
		}
	}

}
