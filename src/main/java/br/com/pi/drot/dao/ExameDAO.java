package br.com.pi.drot.dao;

import br.com.pi.drot.entity.Exame;

public interface ExameDAO {
	Exame criarExame(String nomeExame, String diagnosticoExame, String descricaoExame, String dataExame);

	Exame buscarExamePorID(int id);

	int buscarIdExamePeloNome(String nome);
}
