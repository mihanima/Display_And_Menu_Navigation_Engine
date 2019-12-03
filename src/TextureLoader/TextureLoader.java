package TextureLoader;

import java.util.ArrayList;

// ��������� ������� � �� �������� �� �������� ������� ,� �� ������� �� ����� ����� ��������� ������� ���� �� ��� �� �����

public class TextureLoader {

	static ArrayList<TextureObject> textures = new ArrayList<TextureObject>();
	static TextureLoad tl = new TextureLoad();

	public static void Load(String _path) {
		tl.setPath(_path);
		tl.start();
	}

	public static TextureObject getTexture(String _name) {
		return tl.getTexture(_name);
	}
	public static boolean getLoaded(){
		return tl.loaded;
	}

}
