package TextureLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
//  недомудрил с нахождением полигона к картинке в создании нового TExtureObject так как не у любой картинки будет свой полигооон!
public class TextureLoad extends Thread{
	
	 boolean loaded;
	 String path;
	 ArrayList<TextureObject> textures = new ArrayList<TextureObject>();
	 ArrayList<String> directories = new ArrayList<String>();
	 ArrayList<String> imageFiles = new ArrayList<>();
	 ArrayList<String> poligonfiles = new ArrayList<String>();
	 
	public void setPath(String _path){
		path=_path;
		
	}
	
	@Override
	public void run() {

		loaded = false;

		File f = new File(path);

		if (f.isDirectory()) {
			directories.add(f.getAbsolutePath());

		} else {
			if (f.getName().substring(f.getName().length() - 4).equals(".pol")) {
				poligonfiles.add(f.getAbsolutePath());

			} else {
				imageFiles.add(f.getAbsolutePath());

			}

		}

		while (!directories.isEmpty()) {
			File directory = new File(directories.get(0));

			for (String s : directory.list()) {
				File file = new File(directory.getAbsolutePath()+"\\"+s);

				if (file.isDirectory()) {
					directories.add(file.getAbsolutePath());

				} else {
					if (file.getName().substring(file.getName().length() - 4).equals(".pol")) {
						poligonfiles.add(file.getAbsolutePath());

					} else {
						imageFiles.add(file.getAbsolutePath());

					}

				}
			}
			directories.remove(0);
		}

		for (String s : imageFiles) {
			TextureObject tObject = new TextureObject();
			tObject.image = new ImageIcon(s).getImage();
														
			tObject.poligon = null;
			tObject.name = new File(s).getName();

			if (!poligonfiles.isEmpty()) {
				String a = new File(s).getName();
				String b = new File(poligonfiles.get(0)).getName();

				if (a.substring(0, a.length() - 4).equals(b.substring(0, b.length() - 4))) {

					try {
						//?????????????????????
						int size = 0;
						
						Scanner scn1 = new Scanner(new File(poligonfiles.get(0)));
						
						for(int i = 0;i< tObject.image.getHeight(null);i++)
							for(int j = 0;j<tObject.image.getWidth(null);j++)
								if(scn1.nextShort() == 2)
									size++;
	
						scn1.close();
						
						//
						
						short[][] pol = new short[tObject.image.getHeight(null)][tObject.image.getWidth(null)];
						Scanner scn = new Scanner(new File(poligonfiles.get(0)));
						
						int k = 0;
						int[][] borderLinePolygon = new int[size][2];
						
						for(int i = 0;i< pol.length;i++){
							for(int j = 0;j<pol[i].length;j++){
								
								short res = scn.nextShort();
								
								if(res == 2){
									
									borderLinePolygon[k][0] = j;
									borderLinePolygon[k][1] = i;
									k++;
									
								}
								
								pol[i][j]= res;
									
							}
						}
						tObject.poligon = pol;
						tObject.borderLinePolygon = borderLinePolygon;
						scn.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					poligonfiles.remove(0);
				}
			}

			textures.add(tObject);

		}
		loaded = true;
		
		/*System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("kek");
	
		for(TextureObject o : textures){
			System.out.println(o.name);
			if(o.image != null){
				System.out.println("ImageExists");
			}
			if(o.poligon != null){
				System.out.println("PoigonExists");
			}
		}
		*/
		//TextureLoader.textures = textures;
	}
	public TextureObject getTexture(String _name){
		
		if(loaded){
			
			for(TextureObject o : textures){
				
				if(o.name.equals(_name)){
					return o;
				}
				
			}
			
		}
		
		return null;
	}
	
}
