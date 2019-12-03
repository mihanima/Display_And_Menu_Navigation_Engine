package Damn;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//слушатель событий мыши на окне

public class DamnMouseListener extends DamnListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		for (DamnComponent c : components) {
			if (c.isCollisioned(e.getX(), e.getY())) {
				c.pressed(e.getX(), e.getY());

			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		for (DamnComponent c : components) {
			c.released(e.getX(), e.getY());

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
