package com.renatoalmeida.seguradoraapi.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renatoalmeida.seguradoraapi.domain.User;
import com.renatoalmeida.seguradoraapi.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
//		User maria = new User("1", "Maria", "000.000.000-00");
//		User alex = new User("2", "Alex", "111.111.111-11");
//		List<User> list = new ArrayList<>();
//		list.addAll(Arrays.asList(maria, alex));
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
