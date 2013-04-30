package lab03.util;

//ContadorFrequencia.java  
//Programa conta o numero de ocorrencias de cada palavra em uma frase  

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
	private final String[] library = { "abstract", "continue",
			"for", "new", "switch", "assert", "default", "if", "package",
			"synchronized", "boolean", "do", "goto", "private", "this",
			"break", "double", "implements", "protected", "throw", "byte",
			"else", "import", "public", "throws", "case", "enum", "instanceof",
			"return", "transient", "catch", "extends", "int", "short", "try",
			"char", "final", "interface", "static", "void", "class", "finally",
			"long", "strictfp", "volatile", "const", "float", "native",
			"super", "while" };

	public ContadorDePalavras(String filePath) {

		criaLibrary();
		mapa = new HashMap<String, Integer>(); // Cria o HashMap
		this.filePath = filePath;
		criarMapa(); // Cria Mapa baseado na entrada de usuario
		
	}

	private void criaLibrary() {
		librarySet = new TreeSet<String>();
		for (String chave : library) {
			librarySet.add(chave);
		}

	}

	// Cria Mapa baseado na entrada de usuario
	private void criarMapa() {
		BufferedReader arquivoEmBuffer;
		try {
			arquivoEmBuffer = new BufferedReader(new FileReader(filePath));
			while (arquivoEmBuffer.ready()) {
				
				String input = arquivoEmBuffer.readLine();

				// Cria StringTokenizer para a frase de entrada
				StringTokenizer quebraFrase = new StringTokenizer(input);

				// Processamento de texto de entrada
				while (quebraFrase.hasMoreTokens())// Enquanto houver mais entradas
				{
					String palavra = quebraFrase.nextToken().toLowerCase(); // Obtem
																			// palavra
					if (librarySet.contains(palavra)) {
						// Se o mapa tiver a palavra
						if (mapa.containsKey(palavra)) // Palavras esta no mapa
						{
							int contador = mapa.get(palavra); // Obtem contagem
																// atual
							mapa.put(palavra, contador + 1); // Incrementa a
																// contagem
						} else
							mapa.put(palavra, 1); // Adiciona uma nova palavra com
													// contagem de 1 ao mapa
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// retorna conteudo do mapa
	public Map<String, Integer> getResultado() {
		return mapa; 
	}



}