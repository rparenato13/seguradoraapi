package com.renatoalmeida.seguradoraapi.util;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class CpfValidator {

	public static boolean valida(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
		if(erros.size() > 0){ 
			System.out.println(erros);//Sysout só para exemplificar, aqui você imprime seus erros, seja na web ou na sua aplicação 
			return false; 
		}
		return true;
	}

}
