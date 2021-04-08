package br.com.pi.drot.dao;

import br.com.pi.drot.entity.Remedio;

public interface RemedioDAO {
	Remedio criarRemedio(String nomeRemedio, String dosagem, String bula, String contraIndicacao);

	Remedio buscarRemedioPorID(int id);

	int buscarIdDoRemedioPeloNome(String nome);
}
