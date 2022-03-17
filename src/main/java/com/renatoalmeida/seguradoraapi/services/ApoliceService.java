package com.renatoalmeida.seguradoraapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatoalmeida.seguradoraapi.domain.Apolice;
import com.renatoalmeida.seguradoraapi.dto.ApoliceInsertDTO;
import com.renatoalmeida.seguradoraapi.repository.ApoliceRepository;

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
	
	
}
