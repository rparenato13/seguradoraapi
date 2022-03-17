package com.renatoalmeida.seguradoraapi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renatoalmeida.seguradoraapi.domain.Apolice;
import com.renatoalmeida.seguradoraapi.dto.ApoliceConsultaDTO;
import com.renatoalmeida.seguradoraapi.dto.ApoliceDTO;
import com.renatoalmeida.seguradoraapi.dto.ApoliceInsertDTO;
import com.renatoalmeida.seguradoraapi.services.ApoliceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Apólices")
@CrossOrigin(origins = "*")
public class ApoliceResource {

	@Autowired
	private ApoliceService service;
	
	@GetMapping("/apolices")
	@ApiOperation(value="Retorna lista de apólices")
	public ResponseEntity<List<ApoliceDTO>> findAll() {
		List<Apolice> list = service.findAll();
		List<ApoliceDTO> listDTO = list.stream().map((apolice) -> new ApoliceDTO(apolice)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/apolices/{id}")
	@ApiOperation(value="Retorna uma apólice pelo id")
	public ResponseEntity<ApoliceDTO> findById(@PathVariable String id){
		Apolice apolice = service.findById(id);
		ApoliceDTO apoliceDTO = new ApoliceDTO(apolice);
		return ResponseEntity.ok().body(apoliceDTO);
	}
	
	@GetMapping("/apolices/numero/{numero}")
	@ApiOperation(value="Retorna uma apólice pelo id")
	public ResponseEntity<ApoliceConsultaDTO> findById(@PathVariable Long numero){
		Apolice apolice = service.findByNumeroApolice(numero);
		ApoliceConsultaDTO apoliceConsultaDTO = new ApoliceConsultaDTO(apolice);
		return ResponseEntity.ok().body(apoliceConsultaDTO);
	}
	
	@PostMapping("/apolices")
	@ApiOperation(value="Insere uma apólice")
	public ResponseEntity<ApoliceDTO> insert(@RequestBody @Valid ApoliceInsertDTO apoliceInsertDTO) {
		Apolice apoliceSaved = service.insert(apoliceInsertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(apoliceSaved.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/apolices/{id}")
	@ApiOperation(value="Remove uma apólice pelo id")
	public ResponseEntity<ApoliceDTO> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/apolices/{id}")
	@ApiOperation(value="Atualiza uma apólice pelo id")
	public ResponseEntity<ApoliceDTO> update(@RequestBody @Valid ApoliceInsertDTO apoliceInsertDTO, @PathVariable String id) {
		Apolice apoliceIn = Apolice.fromDTO(apoliceInsertDTO);
		apoliceIn.setId(id);
		Apolice apolice = service.update(apoliceIn);
		ApoliceDTO apoliceDTO = new ApoliceDTO(apolice);
		return ResponseEntity.ok().body(apoliceDTO);
	}
	
}
