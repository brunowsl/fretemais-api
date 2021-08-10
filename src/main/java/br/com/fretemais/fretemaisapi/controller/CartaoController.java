package br.com.fretemais.fretemaisapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fretemais.fretemaisapi.model.Cartao;
import br.com.fretemais.fretemaisapi.repository.CartaoRepository;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoRepository repo;

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Cartao>> buscar(@PathVariable Integer usuarioId) {
		List<Cartao> cartoes = repo.findByUsuarioUsuarioId(usuarioId);
		return cartoes.size() > 0 ? ResponseEntity.ok(cartoes) : ResponseEntity.notFound().build();
	}

}
