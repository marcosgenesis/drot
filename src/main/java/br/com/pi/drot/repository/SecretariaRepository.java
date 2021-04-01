package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.SecretariaDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.entity.Secretaria;
import br.com.pi.drot.models.ConsultasDoDia;

public class SecretariaRepository implements SecretariaDAO{
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
			consultasDoDia.add(new ConsultasDoDia(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(), consultas.get(i).getClassificacaoUrgencia(), consultas.size()));
		}

		for (int i = 0; i < consultasDoDia.size(); i++) {
			System.out.println(consultasDoDia.get(i));
		}

		return consultasDoDia;
	}

	public String pegarnomeSecretariaLogada(int idSecretaria) {
		String sqlConsulta = "SELECT s FROM Secretaria s WHERE s.id =: id";
		TypedQuery<Secretaria> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Secretaria.class).setParameter("id", idSecretaria);
		String nomeSecretariaLogada = queryConsultas.getSingleResult().getNome();
		return nomeSecretariaLogada;
	}


	public int quantidadeConsultasDoDia(String dataDoDia) {
		String sqlConsulta = "SELECT COUNT(*) FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
		TypedQuery<ConsultasDoDia> queryConsultasRealizadasDoDia = this.getConnection().getEntityManager().createQuery(sqlConsulta, ConsultasDoDia.class).setParameter("dataConsulta", dataDoDia);
		ConsultasDoDia qtdConsultasDoDia = (ConsultasDoDia)queryConsultasRealizadasDoDia.getResultList();
		int qtdConsultasRealizadas = qtdConsultasDoDia.getQtdConsultas();
		return qtdConsultasRealizadas;
	}

	public int quantidadeConsultasRealizadasDoDia(String dataDoDia) {
		String sqlConsulta = "SELECT COUNT(*) FROM Consulta c WHERE c.dataConsulta =: dataDoDia AND c.consultaRealizada=: true";
		TypedQuery<ConsultasDoDia> queryConsultasRealizadasDoDia = this.getConnection().getEntityManager().createQuery(sqlConsulta, ConsultasDoDia.class).setParameter("dataConsulta", dataDoDia);
		ArrayList<ConsultasDoDia> consultasDoDia= (ArrayList<ConsultasDoDia>)queryConsultasRealizadasDoDia.getResultList();
		int qtdConsultasRealizadas = 0;
		for (int i = 0; i < consultasDoDia.size(); i++) {
			qtdConsultasRealizadas++;
		}
		return qtdConsultasRealizadas;
	}

	public int quantidadeConsultasNaoRealizadasDoDia(String dataDoDia) {
		String sqlConsulta = "SELECT COUNT(*) FROM Consulta c WHERE c.dataConsulta =: dataDoDia AND c.consultaRealizada=: false";
		TypedQuery<ConsultasDoDia> queryConsultasNaoRealizadasDoDia = this.getConnection().getEntityManager().createQuery(sqlConsulta, ConsultasDoDia.class).setParameter("dataConsulta", dataDoDia);
		ArrayList<ConsultasDoDia> consultasDoDia= (ArrayList<ConsultasDoDia>)queryConsultasNaoRealizadasDoDia.getResultList();
		int qtdConsultasNaoRealizadas = 0;
		for (int i = 0; i < consultasDoDia.size(); i++) {
			qtdConsultasNaoRealizadas++;
		}
		return qtdConsultasNaoRealizadas;
	}
}
