package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.MedicoDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.models.ConsultasDoDia;
import br.com.pi.drot.models.ConsultasMedico;

public class MedicoRepository implements MedicoDAO{
	private Connection connection;

	public MedicoRepository() {
		this.connection = new Connection();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<ConsultasMedico> consultasRealizadas(int idMedico) {
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.medico =: id";
		TypedQuery<Consulta> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("id", idMedico);
		ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();


		ArrayList<ConsultasMedico> consultasRealizadas = new ArrayList<ConsultasMedico>();

		for (int i = 0; i < consultas.size(); i++) {
			Paciente paciente = this.getConnection().getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
			consultasRealizadas.add(new ConsultasMedico(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta()));
		}

		for (int i = 0; i < consultasRealizadas.size(); i++) {
			System.out.println(consultasRealizadas.get(i));
		}

		return consultasRealizadas;
	}

	public String pegarNomeMedicoLogado(int idMedico) {
		String sqlConsulta = "SELECT m FROM Medico m WHERE m.id =: id";
		TypedQuery<Medico> queryConsultas = this.getConnection().getEntityManager().createQuery(sqlConsulta, Medico.class).setParameter("id", idMedico);
		String nomeMedicoLogado = queryConsultas.getSingleResult().getNome();
		return nomeMedicoLogado;
	}


	public ArrayList<ConsultasDoDia> consultasDoDia(int idMedico, String dataDoDia) {
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.medico =:idMedico AND c.dataConsulta =: dataDoDia";
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
}


