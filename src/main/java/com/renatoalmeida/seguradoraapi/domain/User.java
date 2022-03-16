package com.renatoalmeida.seguradoraapi.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.renatoalmeida.seguradoraapi.dto.UserDTO;
import com.renatoalmeida.seguradoraapi.dto.UserInsertDTO;

@Document
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String cpf;
	private String cidade;
	private String uf;

	
	public User() {
		 
	}


	public User(String id, String name, String cpf, String cidade, String uf) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public static User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(),
				userDTO.getName(),
				userDTO.getCpf(),
				userDTO.getCidade(),
				userDTO.getUf()
				);
	}
	
	public static User fromDTO(UserInsertDTO userDTO) {
		return new User(null,
				userDTO.getName(),
				userDTO.getCpf(),
				userDTO.getCidade(),
				userDTO.getUf());
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	

}
