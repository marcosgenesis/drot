package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.RelatorioConsultasMedicoDAO;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Paciente;
import br.com.pi.drot.models.ConsultasDoDia;
import br.com.pi.drot.models.ConsultasMedico;
import br.com.pi.drot.utils.DataDoDia;

public class RelatorioConsultasMedicoRepository implements RelatorioConsultasMedicoDAO {
	Connection connection = Connection.getInstance();

	public RelatorioConsultasMedicoRepository () {}

	public ArrayList<ConsultasMedico> consultasRealizadasDoMedico(int idMedico) {
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.medico =: id";
		TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("id", idMedico);
		ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();


		ArrayList<ConsultasMedico> consultasRealizadas = new ArrayList<ConsultasMedico>();

		for (int i = 0; i < consultas.size(); i++) {
			Paciente paciente = this.connection.getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
			consultasRealizadas.add(new ConsultasMedico(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(),consultas.get(i).getAndamentoConsulta()));
		}

		for (int i = 0; i < consultasRealizadas.size(); i++) {
			System.out.println(consultasRealizadas.get(i));
		}

		return consultasRealizadas;
	}

	public int quantidadeConsultasDiariasDoMedico(int medico, String dataDoDia) {
		DataDoDia dataDoDiaFormatada = DataDoDia.getInstance();
		dataDoDia = dataDoDiaFormatada.retornarDataDoDia();
        String sqlConsulta = "SELECT c FROM Consulta c WHERE c.medico =:medico AND c.dataConsulta =: dataDoDia";
        TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataDoDia", dataDoDia).setParameter("medico", medico);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();
        System.out.println("numero de consultas do dia: " + consultas.size() );
        return consultas.size();
    }

	public int pegarNumPacientesDoMedico(int idMedico) {
        String sqlConsulta = "SELECT c FROM Consulta c WHERE c.medico =: id";
        TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("id", idMedico);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();


        ArrayList<ConsultasMedico> consultasRealizadas = new ArrayList<ConsultasMedico>();

        for (int i = 0; i < consultas.size(); i++) {
            Paciente paciente = this.connection.getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
            consultasRealizadas.add(new ConsultasMedico(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(),consultas.get(i).getAndamentoConsulta()));
        }

        return consultasRealizadas.size();
    }

	public ArrayList<Paciente> pacientesDoMedico(int idMedico) {
        String sqlConsulta = "SELECT c FROM Consulta c WHERE c.medico =: id";
        TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("id", idMedico);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();


        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        for (int i = 0; i < consultas.size(); i++) {
            Paciente paciente = this.connection.getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
            pacientes.add(paciente);
        }

        return pacientes;
    }

	public ArrayList<ConsultasDoDia> consultasDiariasMedico(int idMedico,String dataDoDia) {
		DataDoDia dataDoDiaFormatada = DataDoDia.getInstance();
		dataDoDia = dataDoDiaFormatada.retornarDataDoDia();
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.medico =:idMedico AND c.dataConsulta =: dataDoDia";


		TypedQuery<Consulta> queryConsultas = this.connection
				.getEntityManager()
				.createQuery(sqlConsulta, Consulta.class)
				.setParameter("idMedico", idMedico)
				.setParameter("dataDoDia", dataDoDia);
		ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();


		ArrayList<ConsultasDoDia> consultasDoDia = new ArrayList<ConsultasDoDia>();

		for (int i = 0; i < consultas.size(); i++) {
			Paciente paciente = this.connection.getEntityManager().createNamedQuery("Paciente.getById", Paciente.class).setParameter("idP", consultas.get(i).getPaciente()).getSingleResult();
			consultasDoDia.add(new ConsultasDoDia(paciente.getNome(), consultas.get(i).getDataConsulta(), consultas.get(i).getDescricaoConsulta(), consultas.get(i).getClassificacaoUrgencia(), consultas.size()));
		}

		return consultasDoDia;
	}
}
