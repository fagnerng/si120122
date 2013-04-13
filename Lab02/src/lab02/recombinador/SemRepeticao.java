package lab02.recombinador;

import java.util.List;

import lab02.util.Util;

public class SemRepeticao implements RecombinadorInterface {
	private List<String> listaDePalavras;
	private String disable;

	
	public SemRepeticao (String texto){
		listaDePalavras = Util.stringToList(texto);
		this.disable = "false";
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
		
		if (temp.length()!=0){
			return Original + "\n" + temp;
		}
		Util.addMessagem("Palavras disponiveis acabaram");
		this.disable = "true";
		return Original;
	}

}
