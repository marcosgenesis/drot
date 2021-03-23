package br.com.pi.drot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")

@NamedQueries({
	@NamedQuery(name = "Administrador.loginAdm", query = "SELECT a FROM Administrador a WHERE a.email = :email AND a.senha = :senha"),
    @NamedQuery(name="...", query="..."),
})

public class Administrador{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codadmin")
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "CPF")
	private String CPF;

	@Column(name = "RG")
	private String RG;

	@Column(name = "dataNascimento")
	private Date dataNascimento;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

}
