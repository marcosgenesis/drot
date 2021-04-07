package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.RelatorioConsultasPacienteDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.models.ConsultasPaciente;

public class RelatorioConsultasPacienteRepository implements RelatorioConsultasPacienteDAO {
	Connection connection = Connection.getInstance();

	public RelatorioConsultasPacienteRepository () {}

	public ArrayList<ConsultasPaciente> consultasPaciente(int idPaciente) {
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.paciente =: id";
		TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("id", idPaciente);
		ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();

		ArrayList<ConsultasPaciente> consultasRealizadas = new ArrayList<ConsultasPaciente>();

		for (int i = 0; i < consultas.size(); i++) {
			Paciente paciente = this.connection.getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
			consultasRealizadas.add(new ConsultasPaciente(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(), consultas.get(i).getClassificacaoUrgencia()));
		}

		for (int i = 0; i < consultasRealizadas.size(); i++) {
			System.out.println(consultasRealizadas.get(i));
		}

		return consultasRealizadas;
	}
}
