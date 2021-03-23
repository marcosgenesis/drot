package br.com.pi.drot.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.pi.drot.model.AdministradorModel;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Login {
    private AdministradorModel administrador;
    FacesMessage mensagem;

    private boolean verificaCadastroUsuario() {
		return false;

    }

     public AdministradorModel getUsuarioLogado() {
        return (AdministradorModel) SessionContext.getInstance().getAdministradorLogado();
    }

     public String doLogin(ActionEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        if (!verificaCadastroUsuario()) {
            mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario não cadastrado!", null);
        }

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
        	administrador = new AdministradorModel(0, null, null, null, null, null, null, null, null);
            mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Email ou Senha incorretos! \n Por favor tente novamente.", null);
        }
        facesContext.addMessage(null, mensagem);
        return "";
    }


}