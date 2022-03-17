package com.renatoalmeida.seguradoraapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.renatoalmeida.seguradoraapi.domain.Apolice;
import com.renatoalmeida.seguradoraapi.domain.User;

@Repository
public interface ApoliceRepository extends MongoRepository<Apolice, String> {
	
	@Query("{ 'numero' : ?0 }")
	Optional<User> findByNumeroApolice(Long numero);

}
