package br.com.fretemais.fretemaisapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fretemais.fretemaisapi.model.Endereco;
import br.com.fretemais.fretemaisapi.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository repo;

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Endereco>> buscar(@PathVariable Integer usuarioId) {
		List<Endereco> enderecos = repo.findByUsuarioUsuarioId(usuarioId);
		return enderecos.size() > 0 ? ResponseEntity.ok(enderecos) : ResponseEntity.notFound().build();
	}

}
