package br.com.pi.drot.controllers;

import br.com.pi.drot.dto.UsuarioDTO;
import br.com.pi.drot.model.Usuario;

public class NovoUsuarioFXController {


	public boolean cadastrarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Ítalo Lima");
		usuario.setRG("777");
		usuario.setCPF("777");
		usuario.setEndereco("Quixadá-CE");
		usuario.setTelefone("777");


		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.cadastrarUsuario(usuario);

		return true;
	}


}
