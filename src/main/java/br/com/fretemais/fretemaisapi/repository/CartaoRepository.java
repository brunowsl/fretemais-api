package br.com.fretemais.fretemaisapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fretemais.fretemaisapi.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

	@Query(value = "SELECT * FROM CARTAO c WHERE c.usuario_id = ?1", nativeQuery = true)
	public List<Cartao> findByUsuarioUsuarioId(Integer usuarioId);

}
