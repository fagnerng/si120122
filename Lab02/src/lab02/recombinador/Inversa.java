package lab02.recombinador;

import java.util.List;

import lab02.util.Util;

public class Inversa implements RecombinadorInterface{
	private List<String> listaDePalavras;
	String disable;
	public Inversa (String texto){
		listaDePalavras = Util.stringToList(texto);
		this.disable  = "false";
	}
	@Override
	public String disable() {
		
		return disable;
	}

	@Override
	public String addLinha(String Original) {
		int count = 0;
		String temp = "";
		while (count<= 12 &&  !listaDePalavras.isEmpty()){
			temp+=listaDePalavras.remove(Util.random(listaDePalavras.size()-1))+" " ;
			count++;
		}
		if (temp.length()!=0) {
			return temp+ "\n" + Original;
			
		}
		Util.addMessagem("Palavras disponiveis acabaram");
		this.disable = "true";
		return Original ;
	}
}
