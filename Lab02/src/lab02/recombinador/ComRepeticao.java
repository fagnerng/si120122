package lab02.recombinador;

import lab02.util.Util;


public class ComRepeticao implements RecombinadorInterface{

	
	private String[] palavras;
	
	public ComRepeticao(String texto){
		
		this.palavras = texto.split(" ");
		}
	@Override
	public String disable() {
		return "false";
	}

	@Override
	public String addLinha(String Original) {
		String temp = "";
		for (int i = 0 ; i<12; i++){
			temp += palavras[Util.random(palavras.length - 1)];	
			if (i < 11) temp += " ";
	}
		return Original +" \n"+ temp;
	}

}
