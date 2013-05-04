package lab03.util;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ListadorDeArquivos {
	private LinkedList<String> listadeArquivos;
	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public ListadorDeArquivos(String filePath) {
		listadeArquivos = new LinkedList<String>();
		this.filePath = filePath;
		listarAquivos(filePath);
	}

	public List<String> getListaDeArquivos() {
		return listadeArquivos;
	}

	private void listarAquivos(String filePath) {
		File fList[] = new File(filePath).listFiles();
		for (File file : fList) {
			if (file.isDirectory()) {
				listarAquivos(file.getAbsolutePath());
			} else if (file.getName().endsWith(".java")) {
				listadeArquivos.addLast(file.getAbsolutePath());
			}
		}

	}
}
