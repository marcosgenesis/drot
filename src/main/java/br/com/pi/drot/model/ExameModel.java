package br.com.pi.drot.model;

import java.sql.Date;
import java.util.ArrayList;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.ExameDAO;
import br.com.pi.drot.dao.GenericDAO;
import br.com.pi.drot.entity.Exame;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class ExameModel extends GenericDAO<ExameModel> implements ExameDAO{
	private int id;
	private String nomeExame;
	private String diagnosticoExame;
	private String descricaoExame;
	private Date dataExame;
	private Connection connection;


	public ExameModel(NameDataBaseConnection nameDataBaseConnection){
		super(Exame.class);
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public ExameModel(int id, String nomeExame, String diagnosticoExame, String descricaoExame, Date dataExame) {
		super(Exame.class);
		this.id = id;
		this.nomeExame = nomeExame;
		this.diagnosticoExame = diagnosticoExame;
		this.descricaoExame = descricaoExame;
		this.dataExame = dataExame;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public String getDiagnosticoExame() {
		return diagnosticoExame;
	}

	public void setDiagnosticoExame(String diagnosticoExame) {
		this.diagnosticoExame = diagnosticoExame;
	}

	public String getDescricaoExame() {
		return descricaoExame;
	}

	public void setDescricaoExame(String descricaoExame) {
		this.descricaoExame = descricaoExame;
	}

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

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
