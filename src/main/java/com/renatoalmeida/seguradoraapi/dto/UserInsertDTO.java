package com.renatoalmeida.seguradoraapi.dto;

import java.io.Serializable;

public class UserInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
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
