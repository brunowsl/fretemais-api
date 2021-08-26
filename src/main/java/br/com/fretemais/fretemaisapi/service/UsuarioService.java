package br.com.fretemais.fretemaisapi.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fretemais.fretemaisapi.model.Usuario;
import br.com.fretemais.fretemaisapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	UsuarioRepository usuarioRepository;

	PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public Usuario salvar(Usuario usuario) {
		String encodedPassord = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encodedPassord);
		
		usuario.setDtCriacao(LocalDateTime.now());
		return this.usuarioRepository.save(usuario);

	}

}
