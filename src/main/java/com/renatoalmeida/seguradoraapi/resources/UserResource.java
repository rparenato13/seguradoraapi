package com.renatoalmeida.seguradoraapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatoalmeida.seguradoraapi.domain.User;
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
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
