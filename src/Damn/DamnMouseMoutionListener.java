package Damn;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

//слушатель изменения координат мыши на окне

public class DamnMouseMoutionListener extends DamnListener implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for (DamnComponent c : components) {
			c.mousedMoved(e.getX(),e.getY());
		
		}
		
	}

}
