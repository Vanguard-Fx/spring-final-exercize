package com.maggioli.rest.finalEx.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggioli.rest.finalEx.model.Person;
import com.maggioli.rest.finalEx.repository.PersonRepository;

@Service
public class PersonManager {
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAll() {
		return personRepository.findAll();
	}
}
