package com.renatoalmeida.seguradoraapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.renatoalmeida.seguradoraapi.domain.Apolice;

public class ApoliceDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Long numero;
	private Date inicioVigencia;
	private Date fimVigencia;
	private String placaVeiculo;
	private Float valor;
	
	public ApoliceDTO() {
		
	}

	public ApoliceDTO(String id, Long numero, Date inicioVigencia, Date fimVigencia, String placaVeiculo, Float valor) {
		super();
		this.id = id;
		this.numero = numero;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
	}
	
	public ApoliceDTO(Apolice obj) {
		this.id = obj.getId();
		this.numero = obj.getNumero();
		this.inicioVigencia = obj.getInicioVigencia();
		this.fimVigencia = obj.getFimVigencia();
		this.placaVeiculo = obj.getPlacaVeiculo();
		this.valor = obj.getValor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApoliceDTO other = (ApoliceDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}
	
}
