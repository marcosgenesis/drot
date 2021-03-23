package br.com.pi.drot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Remedio")
public class Remedio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nomeRemedio")
	private String nomeRemedio;

	@Column(name = "dosagem")
	private String dosagem;

	@Column(name = "bula")
	private String bula;

	@Column(name = "contraIndicacao")
	private String contraIndicacao;


}
