package lab03.runnable;

import java.io.File;
import java.util.concurrent.ExecutorService;

import lab03.ui.TabelaDeResultados;
import lab03.util.GerenciadorDeResultados;

public class Leitor implements Runnable{
	private ExecutorService executor;
	private File pastaOuArquivo;
	
	public Leitor( ExecutorService executor, String filePath){
		this.executor = executor;
		pastaOuArquivo = new File(filePath);
		
	}
	@Override
	public void run() {
		File fList[] = pastaOuArquivo.listFiles();
		for (File file : fList) {
			if (file.isDirectory()) {
				executor.execute(new Leitor(executor, file.getAbsolutePath()));
			} else if (file.getName().endsWith(".java")) {
				GerenciadorDeResultados.getCurrentInstance().addArquivo();
				TabelaDeResultados.updateNumArquivo();
				executor.execute(new Contador(file.getAbsolutePath()));
			}
			
		}
		
	}

}
