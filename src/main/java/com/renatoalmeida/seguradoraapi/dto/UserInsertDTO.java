package com.renatoalmeida.seguradoraapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class UserInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "O nome é obrigatório")
	@Length(min = 3, max = 35, message = "O nome deve ter no mínimo {min} e no máximo {max} caracteres")
	private String name;
	@CPF(message = "CPF inválido")
	private String cpf;
	
	public UserInsertDTO() {
		
	}

	public UserInsertDTO(String name, String cpf) {
		super();
		this.name = name;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
