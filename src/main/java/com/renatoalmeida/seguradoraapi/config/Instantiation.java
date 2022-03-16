package com.renatoalmeida.seguradoraapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.renatoalmeida.seguradoraapi.domain.User;
import com.renatoalmeida.seguradoraapi.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria", "55985009068", "Brasilia", "DF");
		User alex = new User(null, "Alex", "77107395041", "São Paulo", "SP");
		User jonh = new User(null, "Jonh", "49882362001", "Recife", "PE");

		userRepository.saveAll(Arrays.asList(maria, alex, jonh));
		
	}

}
