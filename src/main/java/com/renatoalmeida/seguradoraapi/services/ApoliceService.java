package com.renatoalmeida.seguradoraapi.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatoalmeida.seguradoraapi.domain.Apolice;
import com.renatoalmeida.seguradoraapi.dto.ApoliceInsertDTO;
import com.renatoalmeida.seguradoraapi.repository.ApoliceRepository;
import com.renatoalmeida.seguradoraapi.services.exception.ConstraintViolationException;

@Service
public class ApoliceService {
	
	@Autowired
	private ApoliceRepository repository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	public List<Apolice> findAll() {
		return repository.findAll();
	}
	
	public Apolice insert(ApoliceInsertDTO apoliceInsertDTO) {
		
		Apolice apolice = fromInsertDTO(apoliceInsertDTO);
		validaDatasVigencia(apolice.getInicioVigencia(), apolice.getFimVigencia());
		
		return repository.insert(apolice);
	}

	private Apolice fromInsertDTO(ApoliceInsertDTO apoliceInsertDTO) {
		Apolice apolice = new Apolice(
				null, 
				sequenceGeneratorService.generateSequence(Apolice.SEQUENCE_NAME), 
				apoliceInsertDTO.getInicioVigencia(), 
				// Date.from(apoliceInsertDTO.getFimVigencia().atStartOfDay(ZoneId.systemDefault()).toInstant()),
				apoliceInsertDTO.getFimVigencia(),
				apoliceInsertDTO.getPlacaVeiculo(), 
				apoliceInsertDTO.getValor());
		
		return apolice;
	}
	
	public void validaDatasVigencia(Date dataInicioVigencia, Date dataFimVigencia) {
		if(dataInicioVigencia.after(dataFimVigencia)) {
			throw new ConstraintViolationException("Data de início da vigência deve ser anterior a data fim da vigência");
		}
	}
	
	
}
