package br.com.pi.drot.dao;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.entity.Exame;

public interface ExameDAO {
	boolean cadastrarExame(String nomeExame, String diagnosticoExame, String descricaoExame, Date dataExame);

	boolean listarExamePorId(int id);

	ArrayList<Exame> listarExame();

	boolean removerExamePorId(int id);
}
