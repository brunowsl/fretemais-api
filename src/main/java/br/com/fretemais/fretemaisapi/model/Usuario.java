package br.com.fretemais.fretemaisapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String primeiroNome;
	private String sobreNome;
	private Integer diaNascimento;
	private Integer mesNascimento;
	private Integer anoNascimento;
	@Column(unique = true)
	private String email;
	private String senha;
	private String cpf;
	private String telefone;
	private LocalDateTime dtCriacao;
	private String firebaseUId;
	
	public Usuario() {
		
	}

}
