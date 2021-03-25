package br.com.pi.drot.controllers;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.pi.drot.model.AdministradorRepository;;

public class SessionContext {

    private static SessionContext instance;

    public static SessionContext getInstance() {
        if (instance == null) {
            instance = new SessionContext();
        }

        return instance;
    }

    private SessionContext() {}

    private ExternalContext currentExternalContext() {
        if (FacesContext.getCurrentInstance() == null) {
            return null;
        } else {
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }

    public AdministradorRepository getAdministradorLogado() {
        return (AdministradorRepository) getAttribute("usuarioLogado");
    }

    public String getNomeAdministradorLogado() {
    	AdministradorRepository administrador = (AdministradorRepository) getAttribute("usuarioLogado");

        return (administrador != null) ? "Bem vindo, " + administrador.getNome() : " ";
    }

    public void setAdministradorLogado(AdministradorRepository administrador) {
        setAttribute("usuarioLogado", administrador);
    }

    public void encerrarSessao() {
        currentExternalContext().invalidateSession();
    }

    public Object getAttribute(String nome) {
        return currentExternalContext().getSessionMap().get(nome);
    }

    public void setAttribute(String nome, Object valor) {
        currentExternalContext().getSessionMap().put(nome, valor);
    }

}
