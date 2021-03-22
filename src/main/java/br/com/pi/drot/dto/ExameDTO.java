package br.com.pi.drot.dto;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.dao.ExameDAO;
import br.com.pi.drot.entity.Exame;

public class ExameDTO implements ExameDAO {

	@Override
	public boolean cadastrarExame(String nomeExame, String diagnosticoExame, String descricaoExame, Date dataExame) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean listarExamePorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Exame> listarExame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removerExamePorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
