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
		
		User maria = new User(null, "Maria", "000.000.000-00");
		User alex = new User(null, "Alex", "111.111.111-11");
		User jonh = new User(null, "Jonh", "222.222.222-22");

		userRepository.saveAll(Arrays.asList(maria, alex, jonh));
		
	}

}
