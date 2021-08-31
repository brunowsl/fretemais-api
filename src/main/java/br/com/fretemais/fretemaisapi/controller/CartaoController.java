package br.com.fretemais.fretemaisapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fretemais.fretemaisapi.model.Cartao;
import br.com.fretemais.fretemaisapi.model.Usuario;
import br.com.fretemais.fretemaisapi.repository.CartaoRepository;
import br.com.fretemais.fretemaisapi.service.CartaoService;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoRepository repo;

	@Autowired
	private CartaoService service;

	@GetMapping("/{usuarioId}")
	public ResponseEntity<List<Cartao>> buscar(@PathVariable Integer usuarioId) {
		List<Cartao> cartoes = repo.findByUsuarioUsuarioId(usuarioId);
		return cartoes.size() > 0 ? ResponseEntity.ok(cartoes) : ResponseEntity.notFound().build();
	}

	@PostMapping("/add")
	public ResponseEntity<Cartao> salvarCartao(@RequestBody Cartao cartao) {
		Cartao cartaoUsuario = service.salvar(cartao);
		return ResponseEntity.ok(cartaoUsuario);
	}

}
