package br.com.pi.drot.dao;

import br.com.pi.drot.entity.Consulta;

public interface ConsultaDAO{
	boolean criarConsulta(int paciente, int medico, String descricao, String classificacaoUrgencia, boolean consultaRealizada, String consultorioConsulta);
	
	boolean remarcarConsulta(int idConsulta, String dataConsulta);

	boolean desmarcarConsulta(int idConsulta);

	Consulta buscarConsultaPorId(int idConsulta);

	boolean editarAndamentoConsulta(int idConsulta, String andamentoConsulta);

	boolean editarUrgenciaDaConsulta(int idConsulta, String classificacaoUrgencia);

	boolean marcarConsultaComoConcluida(int idConsulta);
}
