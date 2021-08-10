package br.com.fretemais.fretemaisapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fretemais.fretemaisapi.model.Usuario;
import br.com.fretemais.fretemaisapi.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repo;

	@ResponseBody
	@GetMapping(value = "/{usuarioId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> findById(@PathVariable Integer usuarioId) {
		Usuario usuario = repo.findById(usuarioId).get();
		return ResponseEntity.ok(usuario);
	}

}
