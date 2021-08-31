package br.com.fretemais.fretemaisapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fretemais.fretemaisapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findUsuarioByFirebaseUId(String UId);

}
