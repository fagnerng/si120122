package lab03.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeResultados {

	private Map<String, Integer> resultado;
	private int totalEncontrado;
	private int arquivosPesquisados;
	private int numTotalArquivos;
	private boolean modificada;
	private static GerenciadorDeResultados currentInstance;
	private long initTime;
	private long endTime;

	private GerenciadorDeResultados() {

		resultado = new HashMap<String, Integer>();
		arquivosPesquisados = 0;
		numTotalArquivos = 0;
		modificada = false;
		initTime = Calendar.getInstance().getTimeInMillis();
	}
	public Map<String, Integer> getResultado() {
		synchronized (resultado) {

			modificada = false;
			return resultado;
		}
	}

	public int getArquivosPesquisados() {
		return arquivosPesquisados;
	}

	public void AddResultado(Map<String, Integer> parcial) {
		synchronized (resultado) {
			MergeResultado(parcial);
			arquivosPesquisados++;
			modificada = true;
			endTime = Calendar.getInstance().getTimeInMillis();

		}
	}

	private void MergeResultado(Map<String, Integer> parcial) {

		for (String chave : parcial.keySet()) {
			if (!resultado.containsKey(chave)) {
				resultado.put(chave, 0);
			}
			resultado.put(chave, resultado.get(chave) + parcial.get(chave));
			totalEncontrado += parcial.get(chave);
		}

	}

	public int getTotalEncontrado() {
		return totalEncontrado;
	}

	public static GerenciadorDeResultados getCurrentInstance() {
		if (currentInstance == null)
			currentInstance = new GerenciadorDeResultados();
		return currentInstance;
	}

	public boolean temModificacao() {
		return modificada;
	}

	public int getNumTotalArquivos() {
		return numTotalArquivos;
	}

	public synchronized void addArquivo() {
		numTotalArquivos++;
	}
	
	public long getTempoDecorrido(){
		return endTime - initTime;
	}

}
