package com.renatoalmeida.seguradoraapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

public class UserInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "O nome é obrigatório")
	@Length(min = 3, max = 35, message = "O nome deve ter no mínimo {min} e no máximo {max} caracteres")
	@ApiModelProperty(value = "Nome Completo", required = true, example = "João Silva")
	private String name;
	@NotBlank(message = "O CPF é obrigatório")
	@CPF(message = "CPF inválido")
	@ApiModelProperty(required = true, example = "519.076.000-60")
	private String cpf;
	@NotBlank(message = "A cidade é obrigatória")
	@Length(min = 3, max = 35, message = "A cidade deve ter no mínimo {min} e no máximo {max} caracteres")
	@ApiModelProperty(required = true, example = "Acrelândia")
	private String cidade;
	@NotBlank(message = "A UF é obrigatória")
	@Length(min = 2, max = 2, message = "A UF deve possuir 2 caracteres")
	@ApiModelProperty(required = true, example = "AC")
	private String uf;
	
	public UserInsertDTO() {
	}

	public UserInsertDTO(String name, String cpf, String cidade, String uf) {
		this.name = name;
		this.cpf = cpf;
		this.cidade = cidade;
		this.uf = uf;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
