package Damn;

import java.util.ArrayList;

//����������� �����,����������� ������ ��������� ��� ����������

abstract public class DamnListener {

	ArrayList<DamnComponent> components = new ArrayList<DamnComponent>();

	public void addComponent(DamnComponent c) {
		
		components.add(c);

	}

	public void changeList(ArrayList<DamnComponent> l) {

		components = l;

	}

}
