package br.com.fretemais.fretemaisapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fretemais.fretemaisapi.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

	@Query(value = "SELECT * FROM fretemais.CARTAO c WHERE c.usuario_id = :usuarioId", nativeQuery = true)
	public List<Cartao> findByUsuarioUsuarioId(@Param("usuarioId") Integer usuarioId);

}
