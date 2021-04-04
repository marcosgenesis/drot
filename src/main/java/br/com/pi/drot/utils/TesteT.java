package br.com.pi.drot.utils;

import java.util.ArrayList;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import br.com.pi.drot.entity.Exame;
import br.com.pi.drot.entity.Remedio;
import br.com.pi.drot.entity.TratamentoPaciente;
import br.com.pi.drot.models.ConsultasMedico;
import br.com.pi.drot.models.ConsultasPaciente;
import br.com.pi.drot.models.TratamentosPaciente;
import br.com.pi.drot.repository.AdministradorRepository;
import br.com.pi.drot.repository.ConsultaRepository;
import br.com.pi.drot.repository.EnderecoRepository;
import br.com.pi.drot.repository.ExameRepository;
import br.com.pi.drot.repository.MedicoRepository;
import br.com.pi.drot.repository.PacienteRepository;
import br.com.pi.drot.repository.RemedioRepository;
import br.com.pi.drot.repository.TratamentoPacienteRepository;

public class TesteT {

	public static void main(String[] args) {
		//AdministradorRepository aR = new AdministradorRepository();
		//EnderecoRepository eR = new EnderecoRepository();

		//É SÓ LER PARA ENTENDER, :)

		//eR.cadastrarEndereco("CE", "Rua Teste", 111, "Teste", "Onde o cão não habita", "88888-852");

		/*if (eR.pegarIdEndereco("88888-852", 111) != -1) {
			aR.cadastrarNovoAdministrador("Irineu 3", "076.221.343-41", "0000000000000", "1900/01/01", eR.pegarIdEndereco("88888-852", 111), "888888888888", "irineu@gmail.com", "qwe123");
		}else{
			System.out.println("Endereço não encontrado");
		}
		*/

		//eR.cadastrarEndereco("CE", "Rua Teste", 222, "Teste", "Onde o cão não habita", "0");

		/*int idEndereco = eR.pegarIdEndereco("0", 222);

		if (idEndereco != -1) {
			aR.cadastrarNovoMedico("t", "000000000", "00000", "1900/01/01", idEndereco, "9999999", "teste", "teste");
		} else{
			System.out.println("Endereço não encontrado");
		}*/

		//eR.cadastrarEndereco("CE", "Rua Teste", 333, "Teste", "Onde o cão não habita", "1");
		/*int idEndereco = eR.pegarIdEndereco("1", 333);

		if (idEndereco != -1) {
			aR.cadastrarNovoPaciente("t2", "000000000", "00000", "1900/01/01", idEndereco, "9999999", "t", "t", "teste", "teste");
			//aR.cadastrarNovoPaciente("t2", "000000000", "00000", "1900/01/01", idEndereco, "9999999", "t", "t", "teste", "teste");
		} else{
			System.out.println("Endereço não encontrado");
		}*/


		//eR.cadastrarEndereco("CE", "Rua Teste", 444, "Teste", "Onde o cão não habita", "2");
		/*int idEndereco = eR.pegarIdEndereco("2", 444);

		if (idEndereco != -1) {
			aR.cadastrarNovaSecretaria("t", "000000000", "00000", "1900/01/01", idEndereco, "9999999", "teste", "teste");
			//aR.cadastrarNovoPaciente("t2", "000000000", "00000", "1900/01/01", idEndereco, "9999999", "t", "t", "teste", "teste");
		} else{
			System.out.println("Endereço não encontrado");
		}*/

		/*int IdPaciente = aR.buscarPacientePorCPF("000000000");
		int IdMedico = aR.buscarMedicoPorCPF("000000000");

		if (IdPaciente != -1 && IdMedico != -1) {
			ConsultaRepository cR = new ConsultaRepository();
			cR.criarConsulta(IdPaciente, IdMedico, "1900/01/01", "Teste do teste do my eggys 2", "nenhuma");
		} else {
			System.out.println("Num foi não!");
		}*/

		/*TratamentoPacienteRepository tP = new TratamentoPacienteRepository();

		RemedioRepository remedioRepository = new RemedioRepository();
		ExameRepository exameRepository = new ExameRepository();

		//Remedio remedio = remedioRepository.criarRemedio("Dorflex", "15mg", "Bula.pdf", "Dor de cabeça e dores no corpo");
		//Exame exame = exameRepository.criarExame("Vista", "Miopia", "You cego man ?", "2021/10/10");

		Remedio remedio = remedioRepository.criarRemedio("AS", "0.1mg", "Bula.pdf", "Dor de cabeça");
		Exame exame = exameRepository.criarExame("Perna", "Fêmur", "You cego man ?", "2021/10/10");

		//Criar paciente com ID 1d
		//tP.criarTratamentoPaciente(1, 45);

		tP.adicionarExame(exame.getId(), 4);
		tP.adicionarRemedio(remedio.getId(), 4);

		/*String senha = "qwe1234";

		System.out.println("Senha => " + senha);
		System.out.println("Senha => " + CriptografarSenha.criptografarSenha(senha));*/

		//MedicoRepository mR = new MedicoRepository();
		//ArrayList<ConsultasMedico> consultasRetorno = (ArrayList<ConsultasMedico>) mR.consultasRealizadas(1);

		/*for (int i = 0; i < consultasRetorno.size(); i++) {
			System.out.println(consultasRetorno.get(i));
		}

		/*PacienteRepository pR = new PacienteRepository();
		ArrayList<ConsultasPaciente> consultasRetorno = (ArrayList<ConsultasPaciente>) pR.consultasPaciente(1);

		for (int i = 0; i < consultasRetorno.size(); i++) {
			System.out.println(consultasRetorno.get(i));
		}*/

		//TratamentoPacienteRepository tPR = new TratamentoPacienteRepository();
		//ArrayList<TratamentosPaciente> consultasRetorno = (ArrayList<TratamentosPaciente>) tPR.tratamentosPaciente(1);

		/*for (int i = 0; i < consultasRetorno.size(); i++) {
			System.out.println(consultasRetorno.get(i));
		}*/

		System.out.println(CriptografarSenha.criptografarSenha("qwe123"));
	}

}
