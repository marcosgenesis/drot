package br.com.pi.drot.repository;

import java.text.ParseException;
import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.PacienteDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.models.ConsultasPaciente;
import br.com.pi.drot.utils.CalcularIdade;

public class PacienteRepository implements PacienteDAO{
	Connection connection = Connection.getInstance();


	public PacienteRepository() {
	}


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

	public String pegarNomePacienteLogado(int idPaciente) {
		String sqlConsulta = "SELECT p FROM Paciente p WHERE p.id =: id";
		TypedQuery<Paciente> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Paciente.class).setParameter("id", idPaciente);
		String nomePacienteLogado = queryConsultas.getSingleResult().getNome();
		return nomePacienteLogado;
	}
	public int pegarIdPaciente(String cpf) {
        try {
            Paciente p = this.connection.getEntityManager().createNamedQuery("Paciente.getIdByCpf", Paciente.class).setParameter("cpf", cpf).getSingleResult();

            return p.getId();
        } catch(NoResultException e) {
            return -1;

        }
    }
	public int pegarIdadePaciente(int idPaciente) {
		String sqlConsulta = "SELECT p FROM Paciente p WHERE p.id =: id";
		TypedQuery<Paciente> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Paciente.class).setParameter("id", idPaciente);
		String dataNascimento = queryConsultas.getSingleResult().getDataNascimento();
	    try {
			CalcularIdade calcularIdade = new CalcularIdade();
			return calcularIdade.calcularIdade(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	    return 0;
	}
}

