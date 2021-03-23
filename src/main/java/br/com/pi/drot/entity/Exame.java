package br.com.pi.drot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exame")
public class Exame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nomeExame")
	private String nomeExame;

	@Column(name = "diagnosticoExame")
	private String diagnosticoExame;

	@Column(name = "descricaoExame")
	private String descricaoExame;

	@Column(name = "dataExame")
	private Date dataExame;

}
