package lab02.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lab02.system.Sistema;
import lab02.util.Util;


@ManagedBean
@SessionScoped
public class RecombinarBean implements Serializable {

	private static final long serialVersionUID = -2350631568266200986L;
	private String novoTextoRecombinado;
		@PostConstruct
	public void init(){
		setNovoTextoRecombinado("");
	
	}
	

	public String getNovoTextoRecombinado() {
		return novoTextoRecombinado;
	}

	public void setNovoTextoRecombinado(String novoTextoRecombinado) {
		this.novoTextoRecombinado = novoTextoRecombinado;
	}
	public String disable() {
		return Sistema.getInstance().getRecombinador().disable();
	}
	public void addLinha(){
		
		this.novoTextoRecombinado =  Sistema.getInstance().getRecombinador().addLinha(novoTextoRecombinado);
		
	}
	public String salvar(){
		if (novoTextoRecombinado == null);
		else if(novoTextoRecombinado.equals(""));
		else
		{
			Sistema.getInstance().addText(novoTextoRecombinado);
			novoTextoRecombinado = "";
			Sistema.getInstance().setRecombinador( null);
			Util.addMessagem("novo texto foi adicionado");
		}
		return "index.xhtml";
	}
	public String[] getTexto(){

		return novoTextoRecombinado.split("\n");
	}
}
