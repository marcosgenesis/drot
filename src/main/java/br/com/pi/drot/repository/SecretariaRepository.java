package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.models.ConsultasDoDia;
import br.com.pi.drot.models.ConsultasPaciente;

public class SecretariaRepository {
	private Connection connection;

	public SecretariaRepository() {
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<ConsultasDoDia> consultasDoDia(int idPaciente, String dataDoDia) {
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
		TypedQuery<Consulta> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataConsulta", dataDoDia);
		ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();


		ArrayList<ConsultasDoDia> consultasDoDia = new ArrayList<ConsultasDoDia>();

		for (int i = 0; i < consultas.size(); i++) {
			Paciente paciente = this.getConnection().getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
			consultasDoDia.add(new ConsultasDoDia(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(), consultas.get(i).getClassificacaoUrgencia()));
		}

		for (int i = 0; i < consultasDoDia.size(); i++) {
			System.out.println(consultasDoDia.get(i));
		}

		return consultasDoDia;
	}
	
	public int quantidadeConsultasEmEspera() {
		
	}
	
	public int quantidadeConsultasEmEspera() {
		
	}

}
