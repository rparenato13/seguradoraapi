package com.renatoalmeida.seguradoraapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatoalmeida.seguradoraapi.domain.User;
import com.renatoalmeida.seguradoraapi.repository.UserRepository;
import com.renatoalmeida.seguradoraapi.services.exception.ConstraintViolationException;
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
		
		this.cpfExist(cpfUnformated);

		return userRepository.insert(user);
	}
	
	public void cpfExist(String cpf) {
		Optional<User> existentUser = userRepository.findByCpf(cpf);
		if(existentUser.isPresent()) {
			throw new ConstraintViolationException("CPF já existe na base de dados");
		}
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User newObj) {
		String id = newObj.getId(); 
		User user = findById(id);
		updateData(user, newObj);
		return userRepository.save(user);
	}

	private void updateData(User user, User newObj) {
		user.setName(newObj.getName());
		user.setCpf(newObj.getCpf());
	}
	
}
