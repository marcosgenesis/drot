package br.com.pi.drot.model;

import java.sql.Date;

public class Administrador extends Usuario{

	public Administrador (int id, String nome, String CPF, String RG, Date dataNascimento, String endereco, String telefone, boolean isAdmin) {
		super(id, nome, CPF, RG, dataNascimento, endereco, telefone, isAdmin);
	}

	public void setIsAdmin(boolean isAdmin) {
		isAdmin = true;
	}

	public boolean cadastrarNovoUsuario(Usuario usuario) {
		//Administrador admin = new Administrador("Ítalo", ", 2007005060018, "08/02/2001", true);
		return false;
	}

	public boolean removerNovoUsuario(Usuario usuario) {
		return false;
	}

	public boolean editarNovoUsuario(Usuario usuario) {
		return false;
	}

}
