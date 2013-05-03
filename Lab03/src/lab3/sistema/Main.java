package lab3.sistema;

import lab03.util.ContadorDePalavras;
import lab03.util.GerenciadorDeResultados;
import lab03.util.ListadorDeArquivos;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListadorDeArquivos listador = new ListadorDeArquivos("D:/work/Lab03");
		GerenciadorDeResultados resultado = new GerenciadorDeResultados();
		for (String string : listador.getListaDeArquivos()) {
			ContadorDePalavras contador = new ContadorDePalavras(string);
			resultado.AddResultado(contador.getResultado());
		}
		
	}

}
