package com.renatoalmeida.seguradoraapi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatoalmeida.seguradoraapi.domain.Apolice;
import com.renatoalmeida.seguradoraapi.dto.ApoliceInsertDTO;
import com.renatoalmeida.seguradoraapi.repository.ApoliceRepository;
import com.renatoalmeida.seguradoraapi.services.exception.ConstraintViolationException;
import com.renatoalmeida.seguradoraapi.services.exception.ObjectNotFoundException;

@Service
public class ApoliceService {
	
	@Autowired
	private ApoliceRepository repository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	public List<Apolice> findAll() {
		return repository.findAll();
	}
	
	public Apolice findById(String id) {
		Optional<Apolice> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("Apólice não encontrada"));
	}
	
	public Apolice findByNumeroApolice(Long numero) {
		Optional<Apolice> opt = repository.findByNumeroApolice(numero);
		return opt.orElseThrow(() -> new ObjectNotFoundException("Apólice não encontrada"));
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
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Apolice update(Apolice newObj) {
		String id = newObj.getId(); 
		Apolice apolice = findById(id);
		
		updateData(apolice, newObj);
		
		validaDatasVigencia(apolice.getInicioVigencia(), apolice.getFimVigencia());
		
		return repository.save(apolice);
		
	}
	
	private void updateData(Apolice apolice, Apolice newObj) {
		apolice.setInicioVigencia(newObj.getInicioVigencia());
		apolice.setFimVigencia(newObj.getFimVigencia());
		apolice.setPlacaVeiculo(newObj.getPlacaVeiculo());
		apolice.setValor(newObj.getValor());
	}

}
