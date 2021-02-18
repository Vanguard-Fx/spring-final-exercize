package com.maggioli.rest.finalEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maggioli.rest.finalEx.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
	
}
