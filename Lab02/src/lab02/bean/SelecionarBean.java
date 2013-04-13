package lab02.bean;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import lab02.recombinador.ComRepeticao;
import lab02.recombinador.Inversa;
import lab02.recombinador.SemRepeticao;
import lab02.system.Sistema;
import lab02.util.Util;

@ManagedBean
@SessionScoped
public class SelecionarBean implements Serializable {
	private List<String> selectedTextos;
	private Map<String, String> Textos;
	private static final long serialVersionUID = -4754728111177763933L;

	private Sistema sistema;

	@PostConstruct
	public void init()
	{
		sistema = Sistema.getInstance();
		Textos = sistema.getAllTextos();
	}


	public List<String> getSelectedTextos() {
		return selectedTextos;
	}

	public void setSelectedTextos(List<String> selectedTextos) {
		this.selectedTextos = selectedTextos;
	}

	public Map<String, String> getTextos() {
		return Textos;
	}

	public void setTextos(Map<String, String> textos) {
		Textos = textos;
	}

	public String titulo() {
		if (Textos.isEmpty())
			return "Nenhum Texto Disponivel";
		if (Textos.size() == 1)
			return "Texto Disponivel";
		return "Textos Disponiveis";
	}

	public String enable() {
		return Textos.isEmpty() ? "true" : "false";
	}

	public String comRepeticao() {
		
		sistema.setRecombinador(new ComRepeticao(Util
				.listToString(selectedTextos)));
		return paginaRecombinar();
	}

	public String semRepeticao() {
		sistema.setRecombinador(new SemRepeticao(Util
				.listToString(selectedTextos)));
		return paginaRecombinar();
	}

	public String inversa() {
		sistema.setRecombinador(new Inversa(Util
				.listToString(selectedTextos)));
		
		return paginaRecombinar();
	}

	private String paginaRecombinar() {
		if (selectedTextos == null || selectedTextos.isEmpty()){
			Util.addMessagem("Selecione pelo menos um texto");
			return null;
		}
		selectedTextos = new ArrayList<String>();
		return "recombinador.xhtml";
	}

}
