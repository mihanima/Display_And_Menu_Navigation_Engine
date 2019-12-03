import Damn.Display;
import PokemonGoAttacksSimulator.PokemonGoMainFrame;
import TextureLoader.TextureLoader;

public class Main {

	public static void main(String[] args) {
		TextureLoader.Load("C:\\Users\\Михаил\\Desktop\\картинки\\textures");
		Display d = new Display("Test_1", 720, 480, 3);
		d.addFrame(new Mainframe());
		d.addFrame(new SFrame());
		d.addFrame(new Launching());
		d.addFrame(new Game());
		d.addFrame(new OkroshkaFrame());
		d.addFrame(new DamnCollisionTestFrame());
		d.addFrame(new PokemonGoMainFrame());
		d.setCurrientFrame("Launching");
		d.start();
		
	}

}
