package lab02.system;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.faces.model.ListDataModel;

import lab02.recombinador.RecombinadorInterface;
import lab02.util.Util;

public class Sistema extends ListDataModel<String> implements Serializable {

	private static final long serialVersionUID = 7976411472730219629L;
	private Map<String, String> allTexts;
	private static Sistema sistema;
	private RecombinadorInterface recombinador;

	private Sistema() {
		allTexts = new HashMap<String, String>();
	}

	public Set<String> getAllTexts() {

		return allTexts.keySet();
	}

	public void addText(String texto) {
		if (texto == null)
			return;
		if (texto.equals(""))
			return;
		getAllTexts();
		this.allTexts.put(Util.getSmallTitle(texto, 12), texto.replace("\n", " "));
	}

	public static Sistema getInstance() {
		if (sistema == null) {
			sistema = new Sistema();
		}
		return sistema;
	}

	public Map<String, String> getAllTextos() {
		return this.allTexts;
	}

	public RecombinadorInterface getRecombinador() {
		return recombinador;
	}

	public void setRecombinador(RecombinadorInterface recombinador) {
		this.recombinador = recombinador;
	}

}
