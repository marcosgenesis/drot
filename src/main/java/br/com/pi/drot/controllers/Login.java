package br.com.pi.drot.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pi.drot.model.AdministradorRepository;

public class Login extends HttpServlet{
	private AdministradorRepository administrador;
	FacesMessage mensagem;

	public Login() {
		this.administrador= new AdministradorRepository(0, null, null, null, null, null, null, null, null);
	}

	private boolean verificaCadastroUsuario() {
		System.out.println("true");
		return false;
	}

	public AdministradorRepository getUsuarioLogado() {
		return (AdministradorRepository) SessionContext.getInstance().getAdministradorLogado();
	}

	public String doLogin(javafx.event.ActionEvent event) {
		System.out.println("ola");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		System.out.println("ola 2");

		if (!verificaCadastroUsuario()) {
			mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario não cadastrado!", null);
		}

		System.out.println("ola 3");

		administrador = this.administrador.isAutentico(administrador);
		if (administrador != null) {
			SessionContext.getInstance().setAdministradorLogado(administrador);
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem-Vindo!", administrador.getNome());
			facesContext.addMessage(null, mensagem);
			try {
				externalContext.redirect("calendario.xhtml");
			} catch (IOException ex) {
				Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			administrador = new AdministradorRepository(0, null, null, null, null, null, null, null, null);
			mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Email ou Senha incorretos! \n Por favor tente novamente.", null);
		}
		facesContext.addMessage(null, mensagem);
		return "";
	}

}