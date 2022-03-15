package com.renatoalmeida.seguradoraapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.renatoalmeida.seguradoraapi.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	@Query("{ 'cpf' : ?0 }")
	Optional<User> findByCpf(String cpf);

}
