package lab03.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class ContadorDePalavras {
	private Map<String, Integer> mapa;
	private String filePath;
	private Set<String> librarySet;
	private final String[] library = { "abstract", "continue", "for", "new",
			"switch", "assert", "default", "if", "package", "synchronized",
			"boolean", "do", "goto", "private", "this", "break", "double",
			"implements", "protected", "throw", "byte", "else", "import",
			"public", "throws", "case", "enum", "instanceof", "return",
			"transient", "catch", "extends", "int", "short", "try", "char",
			"final", "interface", "static", "void", "class", "finally", "long",
			"strictfp", "volatile", "const", "float", "native", "super",
			"while" };

	public ContadorDePalavras(String filePath) {

		criaLibrary();
		mapa = new HashMap<String, Integer>();
		this.filePath = filePath;
		criarMapa();

	}

	private void criaLibrary() {
		librarySet = new TreeSet<String>();
		for (String chave : library) {
			librarySet.add(chave);
		}

	}

	private void criarMapa() {
		BufferedReader arquivoEmBuffer;
		try {
			arquivoEmBuffer = new BufferedReader(new FileReader(filePath));
			while (arquivoEmBuffer.ready()) {

				String input = arquivoEmBuffer.readLine();
				StringTokenizer quebraFrase = new StringTokenizer(input);
				while (quebraFrase.hasMoreTokens()) {
					String palavra = quebraFrase.nextToken().toLowerCase();

					if (librarySet.contains(palavra)) {

						if (mapa.containsKey(palavra)) {
							int contador = mapa.get(palavra);

							mapa.put(palavra, contador + 1);

						} else
							mapa.put(palavra, 1);

					}
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public Map<String, Integer> getResultado() {
		return mapa;
	}

}