package Damn;

import java.util.ArrayList;

//наследуемый класс,реализующий хрение элементов для слушателей

abstract public class DamnListener {

	ArrayList<DamnComponent> components = new ArrayList<DamnComponent>();

	public void addComponent(DamnComponent c) {
		
		components.add(c);

	}

	public void changeList(ArrayList<DamnComponent> l) {

		components = l;

	}

}
