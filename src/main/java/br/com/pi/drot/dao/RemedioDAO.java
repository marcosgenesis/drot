package br.com.pi.drot.dao;


public interface RemedioDAO {
	boolean criarRemedio(String nomeRemedio, String dosagem, String bula, String contraIndicacao);
}
