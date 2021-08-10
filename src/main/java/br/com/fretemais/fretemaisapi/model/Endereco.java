package br.com.fretemais.fretemaisapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Endereco {

	@Id
	private Integer enderecoId;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
