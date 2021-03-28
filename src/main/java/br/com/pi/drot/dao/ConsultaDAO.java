package br.com.pi.drot.dao;

import java.sql.Date;

import br.com.pi.drot.entity.Consulta;
import br.com.pi.drot.entity.Medico;
import br.com.pi.drot.entity.Paciente;

public interface ConsultaDAO{
	boolean criarConsulta(int paciente, int medico, String dataConsulta, String descricao);

	boolean remarcarConsulta(Consulta consulta, String dataConsulta);

	boolean desmarcarConsulta(Consulta consulta);

	Consulta buscarConsultaPorId(int id);
}
