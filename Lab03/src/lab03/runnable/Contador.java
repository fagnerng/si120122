package lab03.runnable;

import lab03.ui.TabelaDeResultados;
import lab03.util.ContadorDePalavras;
import lab03.util.GerenciadorDeResultados;

public class Contador implements Runnable{
	private String filePath;
	public Contador( String filePath){
		this.filePath = filePath;
		
	}
	@Override
	public void run() {
		ContadorDePalavras contador = new ContadorDePalavras(filePath);
		GerenciadorDeResultados.getCurrentInstance().AddResultado(contador.getResultado());
		TabelaDeResultados.updateTable();
	}

}
