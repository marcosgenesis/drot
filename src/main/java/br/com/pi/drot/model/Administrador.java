package br.com.pi.drot.model;

import java.sql.Date;

public class Administrador extends Usuario{

	public Administrador (int id, String nome, int cPF, int rG, Date data_nascimento, boolean isAdmin) {
		super(id, nome, cPF, rG, data_nascimento, isAdmin);
	}

	public void setIsAdmin(boolean isAdmin) {
		isAdmin = true;
	}

	public boolean cadastrarNovoUsuario(Usuario usuario) {
		return false;
	}

	public boolean removerNovoUsuario(Usuario usuario) {
		return false;
	}

	public boolean editarNovoUsuario(Usuario usuario) {
		return false;
	}


}
