package br.com.pi.drot.utils;

import br.com.pi.drot.repository.AdministradorRepository;
import br.com.pi.drot.repository.EnderecoRepository;

public class TesteT {

	public static void main(String[] args) {
		AdministradorRepository aR = new AdministradorRepository();
		EnderecoRepository eR = new EnderecoRepository();

		//eR.cadastrarEndereco("CE", "Rua Teste", 111, "Teste", "Onde o cão não habita", "88888-852");

		if (eR.pegarIdEndereco("88888-852", 111) != -1) {
			aR.cadastrarNovoAdministrador("Irineu 3", "076.221.343-41", "0000000000000", "1900/01/01", eR.pegarIdEndereco("88888-852", 111), "888888888888", "irineu@gmail.com", "qwe123");
		}else{
			System.out.println("Endereço não encontrado");
		}

	}

}
