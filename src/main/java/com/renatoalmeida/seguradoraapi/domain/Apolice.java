package com.renatoalmeida.seguradoraapi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.renatoalmeida.seguradoraapi.dto.ApoliceInsertDTO;

@Document
public class Apolice implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Transient
    public static final String SEQUENCE_NAME = "apolices_sequence";
	
	@Id
	private String id;
	private Long numero;
	private Date inicioVigencia;
	private Date fimVigencia;
	private String placaVeiculo;
	private Float valor;
	
	public Apolice() {
		
	}

	public Apolice(String id, Long numero, Date inicioVigencia, Date fimVigencia, String placaVeiculo, Float valor) {
		super();
		this.id = id;
		this.numero = numero;
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
	}
	
	public static Apolice fromDTO(ApoliceInsertDTO apoliceDTO) {
		return new Apolice(null,
				null,
				apoliceDTO.getInicioVigencia(),
				apoliceDTO.getFimVigencia(),
				apoliceDTO.getPlacaVeiculo(),
				apoliceDTO.getValor());
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
		Apolice other = (Apolice) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
	}
	
	
}
