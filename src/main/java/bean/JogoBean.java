package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDAO;
import entidade.Jogo;

@ManagedBean
public class JogoBean {
	Jogo jogo = new Jogo();
	List<Jogo> listaJogo;
	
	
	public String salvar() {
		try {
				JogoDAO.salvar(jogo);
				jogo = new Jogo();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Seu jogo foi salvo com sucesso!", ""));
		} 
		catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO ao tentar salvar", ""));
		}
		return null;
	}
	
	public String editar() {
		try {
				JogoDAO.editar(jogo);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Edição realizada com sucesso!", ""));
		} 
		catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO ao tentar editar", ""));
		}
		return null;
	}
	
	public String deletar() {
		try {
				JogoDAO.excluir(jogo);
				listaJogo.remove(jogo);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogo excluído!!", ""));
		}
		catch (Exception e){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO ao tentar excluir", ""));
		}
		
		return null;
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getListaJogo() {
		if (listaJogo == null)
		{
			listaJogo = JogoDAO.listar();
		}
		
		return listaJogo;
	}

	public void setListaJogo(List<Jogo> listaJogo) {
		this.listaJogo = listaJogo;
	}
	

}
