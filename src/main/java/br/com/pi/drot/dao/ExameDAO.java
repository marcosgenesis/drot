package br.com.pi.drot.dao;

public interface ExameDAO {
	boolean criarExame(String nomeExame, String diagnosticoExame, String descricaoExame, String dataExame);
}
