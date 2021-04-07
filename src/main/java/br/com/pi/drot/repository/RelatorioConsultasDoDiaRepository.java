package br.com.pi.drot.repository;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.utils.DataDoDia;

public class RelatorioConsultasDoDiaRepository {
	Connection connection = Connection.getInstance();

	public RelatorioConsultasDoDiaRepository() {}

	public int quantidadeConsultasDoDia(String dataDoDia) {
		DataDoDia dataDoDiaFormatada = DataDoDia.getInstance();
		dataDoDia = dataDoDiaFormatada.retornarDataDoDia();
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
        TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataDoDia", dataDoDia);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();
        return consultas.size();
	}

	public int quantidadeConsultasRealizadasDoDia(String dataDoDia) {
		DataDoDia dataDoDiaFormatada = DataDoDia.getInstance();
		dataDoDia = dataDoDiaFormatada.retornarDataDoDia();
        String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
        TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataDoDia", dataDoDia);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();
        int consultasRealizadas = 0;
        for (Consulta c: consultas) {
            if(c.getConsultaRealizada() ==  true) {
                consultasRealizadas++;
            }
        }
        return consultasRealizadas;
	}

	public int quantidadeConsultasNaoRealizadasDoDia(String dataDoDia) {
		DataDoDia dataDoDiaFormatada = DataDoDia.getInstance();
		dataDoDia = dataDoDiaFormatada.retornarDataDoDia();
		String sqlConsulta = "SELECT c FROM Consulta c WHERE c.dataConsulta =: dataDoDia";
        TypedQuery<Consulta> queryConsultas = this.connection.getEntityManager().createQuery(sqlConsulta, Consulta.class).setParameter("dataDoDia", dataDoDia);
        ArrayList<Consulta> consultas = (ArrayList<Consulta>) queryConsultas.getResultList();
        int consultasNaoRealizadas = 0;
        for (Consulta c: consultas) {
            if(c.getConsultaRealizada() ==  false) {
            	consultasNaoRealizadas++;
            }
        }
        return consultasNaoRealizadas;
	}
}
