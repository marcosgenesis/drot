package br.com.pi.drot.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Login() {
    private UsuarioDTO usuario;
    FacesMessage message;

    private boolean verificaCadastroUsuario() {

    }

     public UsuarioDTO getUsuarioLogado() {
        return (UsuarioDTO) SessionContext.getInstance().getUsuarioLogado();
    }


     public String doLogin(ActionEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        if (!verificaCadastroUsuario()) {
            mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario não cadastrado!", null);
        }

        usuario = UsuarioDAO.isAutentico(usuario);
        if (usuario != null) {
            SessionContext.getInstance().setUsuarioLogado(usuario);
            mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem-Vindo!", usuario.getNome());
            facesContext.addMessage(null, mensagem);
            try {
                externalContext.redirect("calendario.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            usuario = new UsuarioPO(null, null, null, null);
            mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Ra ou Senha incorretos! \n Por favor tente novamente.", null);
        }
        facesContext.addMessage(null, mensagem);
        return "";
    }


}