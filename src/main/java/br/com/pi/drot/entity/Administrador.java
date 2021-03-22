package br.com.pi.drot.entity;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medico")
public class Administrador{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "CPF")
	private String CPF;

	@Column(name = "RG")
	private String RG;

	@Column(name = "Data_nascimento")
	private Date dataNascimento;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "is_admin")
	private boolean isAdmin;

	public void setIsAdmin(boolean isAdmin) {
		isAdmin = true;
	}

	public boolean cadastrarNovoUsuario(Paciente paciente) {
		//Administrador admin = new Administrador("Ítalo", ", 2007005060018, "08/02/2001", true);
		return false;
	}

	public boolean removerNovoUsuario(Usuario usuario) {
		return false;
	}

	public boolean editarNovoUsuario(Paciente paciente) {
		return false;
	}

	public Usuario buscarUsuarioPorID(int id){
		return null;
	}

	public ArrayList<Paciente> listarUsuarios() {
		return null;
	}

	public boolean editar(Paciente paciente){
		return false;
	}

	public boolean removerPorId(int id){
		return false;
	}
}
