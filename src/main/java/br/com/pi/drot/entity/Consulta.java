package br.com.pi.drot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Consulta")
public class Consulta{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "paciente_id")
	private Paciente paciente;

	@Column(name = "dataConsulta")
	private Date dataConsulta;

	@Column(name = "descricaoConsulta")
	private String descricaoConsulta;

	@Column(name = "medico_id")
	private Medico medico;

}

