package lab03.util;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeResultados {

	private Map<String, Integer> resultado;
	private int totalEncontrado;
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
		
	}



	private synchronized void MergeResultado(Map<String, Integer> parcial) {
		for (String chave : parcial.keySet()) {
			if (!resultado.containsKey(chave)) {
				resultado.put(chave, 0);
			}
			resultado.put(chave, resultado.get(chave) + parcial.get(chave));
			totalEncontrado+= parcial.get(chave);
		}
	}

	public int getTotalEncontrado() {
		return totalEncontrado;
	}

}
