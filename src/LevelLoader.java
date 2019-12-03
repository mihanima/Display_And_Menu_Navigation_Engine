import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import ObjectLoader.FileObject;
import ObjectLoader.ObjectLoader;

 public class LevelLoader extends ObjectLoader{

	public FileObject loadStatements(String _filepath) {
		
		try {
			ArrayList<String> imgsPaths = new ArrayList<>();
			Level lvl =new Level();
			
			Scanner scn = new Scanner(new File(_filepath));
			lvl.name = scn.nextLine();
			lvl.looped = scn.nextBoolean();
			lvl.random = scn.nextBoolean();
			while(scn.hasNextLine()){
				imgsPaths.add(scn.nextLine());
			}
			lvl.imgsPaths = imgsPaths.toArray(null);
			
			scn.close();
			
			return lvl;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void saveStatements(String _dirPath, FileObject _FileObject) {
		// TODO Auto-generated method stub
		
	}

}
