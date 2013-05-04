package lab03.sistema;

import javax.swing.JFrame;

import lab03.ui.TelaInicial;
import lab03.util.ListadorDeArquivos;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListadorDeArquivos listadorDeArquivos = null;
		TelaInicial janela = new  TelaInicial(listadorDeArquivos);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
	
	}

	

}
