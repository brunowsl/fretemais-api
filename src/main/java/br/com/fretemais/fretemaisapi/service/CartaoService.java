package br.com.fretemais.fretemaisapi.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fretemais.fretemaisapi.model.Cartao;
import br.com.fretemais.fretemaisapi.repository.CartaoRepository;

@Service
public class CartaoService {

	CartaoRepository cartaoRepository;

	PasswordEncoder passwordEncoder;
	
	public CartaoService(CartaoRepository cartaoRepository) {
		this.cartaoRepository = cartaoRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public Cartao salvar(Cartao cartao) {
		String encodedPassord = this.passwordEncoder.encode(cartao.getNumero());
		cartao.setNumero(encodedPassord);
		return this.cartaoRepository.save(cartao);
	}

}
