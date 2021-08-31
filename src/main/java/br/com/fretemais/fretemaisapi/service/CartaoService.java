package br.com.fretemais.fretemaisapi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fretemais.fretemaisapi.model.Cartao;
import br.com.fretemais.fretemaisapi.repository.CartaoRepository;

@Service
public class CartaoService {

	CartaoRepository cartaoRepository;

	PasswordEncoder passwordEncoder;

	public Cartao salvar(Cartao cartao) {
		String encodedPassord = this.passwordEncoder.encode(cartao.getNumero().toString());
		cartao.setNumero(Integer.parseInt(encodedPassord));
		return this.cartaoRepository.save(cartao);
	}

}
