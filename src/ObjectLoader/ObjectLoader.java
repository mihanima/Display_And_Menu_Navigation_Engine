package ObjectLoader;

import java.io.File;
import java.util.ArrayList;

//загружает уровень и все объекты на нём из файловой системы

public abstract class ObjectLoader {
	ArrayList<FileObject> Objects = new ArrayList<>();
	ArrayList<String> directories = new ArrayList<>();
	ArrayList<String> files = new ArrayList<>();

	public void load(String path) {

		File f = new File(path);

		if (f.isDirectory()) {
			directories.add(f.getAbsolutePath());

		} else {
			files.add(f.getAbsolutePath());

		}

		while (!directories.isEmpty()) {
			File directory = new File(directories.get(0));

			for (String s : directory.list()) {
				File file = new File(directory.getAbsolutePath() + "\\" + s);

				if (file.isDirectory()) {
					directories.add(file.getAbsolutePath());

				} else {
					files.add(file.getAbsolutePath());

				}
			}
			directories.remove(0);
		}

		for (String s : files) {
			FileObject o = loadStatements(s);

			if (o != null)
				Objects.add(o);

		}

	}

	abstract public FileObject loadStatements(String _filepath);

	public void save(String _path, ArrayList<FileObject> _list) {

		for (FileObject o : _list) {
			saveStatements(_path, o);
		}
	}

	abstract public void saveStatements(String _dirPath, FileObject _FileObject);

	public FileObject GetLevel(String name) {
		
		for (FileObject o : Objects) {
			
			if (o.name.equals(name)) {
				return o;
			}
		}

		return null;
	}
}