package lab03.util;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ListadorDeArquivos {
	private LinkedList<String> listadeArquivos;

	public ListadorDeArquivos(String filePath) {
		listadeArquivos = new LinkedList<String>();

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
			} else if (file.getName().indexOf(".java") == file.getName()
					.length() - 5) {
				listadeArquivos.addLast(file.getAbsolutePath());
			}
		}

	}

}
