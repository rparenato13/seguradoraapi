package com.renatoalmeida.seguradoraapi.util;

import java.util.List;

import com.renatoalmeida.seguradoraapi.services.exception.InvalidArgumentException;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;

public class CpfValidator {

	public static void valida(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
		if(erros.size() > 0){
			throw new InvalidArgumentException("CPF Inválido");
		}
	}

	public static String unformatCpf(String cpf) {
		return new CPFFormatter().unformat(cpf);
	}
	
	public static String formatCpf(String cpf) {
		return new CPFFormatter().format(cpf);
	}


}
