package br.com.pi.drot.dao;

import br.com.pi.drot.entity.Consulta;

public interface ConsultaDAO{
	boolean criarConsulta(int paciente, int medico, String dataConsulta, String descricao, String classificacaoUrgencia);

	boolean remarcarConsulta(int idConsulta, String dataConsulta);

	boolean desmarcarConsulta(int idConsulta);

	Consulta buscarConsultaPorId(int idConsulta);

	boolean marcarConsultaComoConcluida(int idConsulta);
}
