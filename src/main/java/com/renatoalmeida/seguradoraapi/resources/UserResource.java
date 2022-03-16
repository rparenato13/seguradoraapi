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

import com.renatoalmeida.seguradoraapi.domain.User;
import com.renatoalmeida.seguradoraapi.dto.UserDTO;
import com.renatoalmeida.seguradoraapi.dto.UserInsertDTO;
import com.renatoalmeida.seguradoraapi.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Users")
@CrossOrigin(origins = "*")
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping("/users")
	@ApiOperation(value="Retorna lista de Usuários")
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map( (user) -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
//	@GetMapping("/users/{id}")
//	@ApiOperation(value="Retorna um usuário pelo id")
//	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
//		User user = service.findById(id);
//		UserDTO userDTO = new UserDTO(user);
//		return ResponseEntity.ok().body(userDTO);
//	}
	
	@GetMapping("/users/{cpf}")
	@ApiOperation(value="Retorna um usuário pelo CPF")
	public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
		User user = service.findByCpf(cpf);
		UserDTO userDTO = new UserDTO(user);
		return ResponseEntity.ok().body(userDTO);
	}
	
	@PostMapping("/users")
	@ApiOperation(value="Insere um usuário")
	public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserInsertDTO userInsertDTO) {
		User userIn = User.fromDTO(userInsertDTO);
		User userSaved = service.insert(userIn);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/users/{id}")
	@ApiOperation(value="Remove um usuário pelo id")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{id}")
	@ApiOperation(value="Atualiza um usuário pelo id")
	public ResponseEntity<UserDTO> insert(@RequestBody UserInsertDTO userInsertDTO, @PathVariable String id) {
		User userIn = User.fromDTO(userInsertDTO);
		userIn.setId(id);
		User userSaved = service.update(userIn);
		UserDTO userDTO = new UserDTO(userSaved);
		return ResponseEntity.ok().body(userDTO);
	}
}
