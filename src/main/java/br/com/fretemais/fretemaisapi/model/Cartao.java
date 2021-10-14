package br.com.fretemais.fretemaisapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Cartao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartaoId;
	private String numero;
	private Integer cvc;
	private Integer mesExpiracao;
	private Integer anoExpiracao;
	private String nomeProprietario;
	private String bandeira;
	private String junoHash;
	
	public Cartao() {
		
	}

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@JsonProperty("usuario")
	private void unpackNested(Integer usuarioId) {
	    this.usuario = new Usuario();
	    usuario.setUserId(usuarioId);
	}

}
