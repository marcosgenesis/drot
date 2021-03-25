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
@Table(name = "TratamentoPaciente")
public class TratamentoPaciente{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "exame")
	private ArrayList <Exame> exame;

	@Column(name = "remedio")
	private ArrayList <Remedio> remedio;

	@Column(name = "tempoTratamento")
	private Date tempoTratamento;

}