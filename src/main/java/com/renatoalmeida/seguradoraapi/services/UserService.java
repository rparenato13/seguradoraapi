package com.renatoalmeida.seguradoraapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatoalmeida.seguradoraapi.domain.User;
import com.renatoalmeida.seguradoraapi.repository.UserRepository;
import com.renatoalmeida.seguradoraapi.services.exception.ObjectNotFoundException;
import com.renatoalmeida.seguradoraapi.util.CpfValidator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public User findByCpf(String cpf) {
		CpfValidator.valida(cpf); 
		String cpfUnformated = CpfValidator.unformatCpf(cpf);
		Optional<User> user = userRepository.findByCpf(cpfUnformated);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public User insert(User user) {
		String cpf = user.getCpf(); 
		CpfValidator.valida(cpf); 
		String cpfUnformated = CpfValidator.unformatCpf(cpf);
		user.setCpf(cpfUnformated);
		return userRepository.insert(user);
	}
	
}
