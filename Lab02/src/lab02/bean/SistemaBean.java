package lab02.bean;


import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lab02.system.Sistema;
import lab02.util.Util;

@ManagedBean(name = "main")
@SessionScoped
public class SistemaBean {
	private Sistema system;
	private String editableTexto;


	public SistemaBean() {
		this.system = Sistema.getInstance();
		this.editableTexto = "";
		
	}
	public String recombinar() {
		return "selecionador.xhtml";

	}

	public String addNovoTexto() {
		if (this.editableTexto == null)
			;

		else if (this.editableTexto.equals(""))
			;

		else {
			system.addText(this.editableTexto);
			this.editableTexto = "";
			Util.addMessagem("novo texto foi adicionado");
		}

		return "index.xhtml";
	}

	public String getEditableTexto() {
		return this.editableTexto;
	}

	public void setEditableTexto(String editableTexto) {
		this.editableTexto = editableTexto;
	}

	public Set<String> getAllTextos() {
		return system.getAllTexts();
	}



}
