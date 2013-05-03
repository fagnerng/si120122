package lab03.util;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeResultados {

	private Map<String, Integer> resultado;
	private int arquivosPesquisados;

	public GerenciadorDeResultados() {
		resultado = new HashMap<String, Integer>();
		arquivosPesquisados = 0;

	}

	public Map<String, Integer> getResultado() {
		return resultado;
	}

	public int getArquivosPesquisados() {
		return arquivosPesquisados;
	}

	public void AddResultado(Map<String, Integer> parcial) {
		
		MergeResultado(parcial);
		arquivosPesquisados++;
		printaParcial();
	}

	private void printaParcial() {
		for (String chave : resultado.keySet()) {
			System.out.println(chave + " = " + resultado.get(chave));
		}
		System.out.println("========================================");
	}

	private synchronized void MergeResultado(Map<String, Integer> parcial) {
		for (String chave : parcial.keySet()) {
			if (!resultado.containsKey(chave)) {
				resultado.put(chave, 0);
			}
			resultado.put(chave, resultado.get(chave) + parcial.get(chave));

		}
	}
}
