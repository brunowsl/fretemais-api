package br.com.fretemais.fretemaisapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fretemais.fretemaisapi.model.Usuario;
import br.com.fretemais.fretemaisapi.repository.UsuarioRepository;
import br.com.fretemais.fretemaisapi.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private UsuarioService service;

	@ResponseBody
	@GetMapping(value = "/{usuarioId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> findById(@PathVariable Integer usuarioId) {
		Usuario usuario = repo.findById(usuarioId).get();
		return ResponseEntity.ok(usuario);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listarTodos() {
		List<Usuario> usuarios = repo.findAll();
		return ResponseEntity.ok(usuarios);
	}

	@PostMapping("/add")
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = service.salvar(usuario);
		return ResponseEntity.ok(novoUsuario);
	}

}
