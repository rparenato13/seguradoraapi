package com.renatoalmeida.seguradoraapi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;


public class ApoliceInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@ApiModelProperty(value = "Data do início da vigência", required = true, example = "01/01/2022")
	private Date inicioVigencia;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@ApiModelProperty(value = "Data do fim da vigência", required = true, example = "01/02/2022")
	private Date fimVigencia;
	
	@NotBlank(message = "A placa do veiculo é obrigatória")
	@Length(min = 6, max = 7, message = "A placa deve ter no mínimo {min} e no máximo {max} caracteres")
	@ApiModelProperty(value = "Placa do veículo", required = true, example = "ABC0000")
	private String placaVeiculo;
	
	@DecimalMin(value = "0.0", inclusive = false, message = "O valor precisa ser maior do que {value}")
	@Digits(integer=4, fraction=2, message = "Valor maximo permitido deve possuir {integer} digitos e {fraction} casas decimais")
	@ApiModelProperty(value = "Valor da apólice", required = true, example = "1000.00")
	private Float valor;
	
	public ApoliceInsertDTO() {
		
	}

	public ApoliceInsertDTO(Date inicioVigencia, Date fimVigencia, String placaVeiculo, Float valor) {
		super();
		this.inicioVigencia = inicioVigencia;
		this.fimVigencia = fimVigencia;
		this.placaVeiculo = placaVeiculo;
		this.valor = valor;
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
	
}
