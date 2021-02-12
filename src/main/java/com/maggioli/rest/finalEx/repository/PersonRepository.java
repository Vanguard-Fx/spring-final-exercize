package com.maggioli.rest.finalEx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maggioli.rest.finalEx.model.Person;

public interface PersonRepository extends JpaRepository<Person, String> {
	
}
