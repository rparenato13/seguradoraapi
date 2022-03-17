package com.renatoalmeida.seguradoraapi.dto;

import java.io.Serializable;

import com.renatoalmeida.seguradoraapi.domain.Apolice;

public class ApoliceConsultaDTO extends ApoliceDTO implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private Boolean vencida;
		private Integer diasVencida;
		private Integer diasParaVencimento;
		
		
		public ApoliceConsultaDTO(Apolice apolice) {
			super(apolice);
			this.vencida = apolice.isVencida();
			this.diasVencida = apolice.qtdDiasVencida();
			this.diasParaVencimento = apolice.qtdDiasAVencer();
		}

		public Boolean getVencida() {
			return vencida;
		}

		public void setVencida(Boolean vencida) {
			this.vencida = vencida;
		}

		public Integer getDiasVencida() {
			return diasVencida;
		}

		public void setDiasVencida(Integer diasVencida) {
			this.diasVencida = diasVencida;
		}

		public Integer getDiasParaVencimento() {
			return diasParaVencimento;
		}

		public void setDiasParaVencimento(Integer diasParaVencimento) {
			this.diasParaVencimento = diasParaVencimento;
		}
		

}
