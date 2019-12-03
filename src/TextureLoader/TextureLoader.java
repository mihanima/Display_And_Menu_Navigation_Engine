package TextureLoader;

import java.util.ArrayList;

// «агружает спрайты и их полигоны из фаиловой системы ,и по запросу из любой части программы передаЄт одну из них по имени

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
