package br.com.fretemais.fretemaisapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fretemais.fretemaisapi.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	@Query(value = "SELECT * FROM ENDERECO e WHERE e.usuario_id = ?1", nativeQuery = true)
	public List<Endereco> findByUsuarioUsuarioId(Integer usuarioId);

}
