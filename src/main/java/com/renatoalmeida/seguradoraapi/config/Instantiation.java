package com.renatoalmeida.seguradoraapi.config;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.renatoalmeida.seguradoraapi.domain.Apolice;
import com.renatoalmeida.seguradoraapi.domain.User;
import com.renatoalmeida.seguradoraapi.repository.ApoliceRepository;
import com.renatoalmeida.seguradoraapi.repository.UserRepository;
import com.renatoalmeida.seguradoraapi.services.SequenceGeneratorService;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public void run(String... args) throws Exception {
		
		insertItensUser();
		insertItensApolice();
		
	}
	
	public void insertItensUser() {
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria", "55985009068", "Brasilia", "DF");
		User alex = new User(null, "Alex", "77107395041", "São Paulo", "SP");
		User jonh = new User(null, "Jonh", "49882362001", "Recife", "PE");

		userRepository.saveAll(Arrays.asList(maria, alex, jonh));
	}
	
	public void insertItensApolice() {
		apoliceRepository.deleteAll();
		
		Calendar hoje = Calendar.getInstance(); 
		hoje.add(Calendar.DATE, -2);
		Date antesDeontem = hoje.getTime();
		hoje.add(Calendar.DATE, 1);
		Date ontem = hoje.getTime();
		hoje.add(Calendar.DATE, 2);
		Date amanha = hoje.getTime();
		hoje.add(Calendar.DATE, 1);
		Date depoisDeamanha = hoje.getTime();

		Apolice apolice1 = new Apolice(null, sequenceGeneratorService.generateSequence(Apolice.SEQUENCE_NAME), antesDeontem, ontem, "ABC0001", 1000.99F);
		Apolice apolice2 = new Apolice(null, sequenceGeneratorService.generateSequence(Apolice.SEQUENCE_NAME), ontem, amanha, "ABC0002", 2000.99F);
		Apolice apolice3 = new Apolice(null, sequenceGeneratorService.generateSequence(Apolice.SEQUENCE_NAME), amanha, depoisDeamanha, "ABC0003", 3000.99F);
		
		apoliceRepository.saveAll(Arrays.asList(apolice1, apolice2, apolice3));
	}

}
