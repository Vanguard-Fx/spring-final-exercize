package com.maggioli.rest.finalEx.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.maggioli.rest.finalEx.model.Cart;
import com.maggioli.rest.finalEx.model.Person;
import com.maggioli.rest.finalEx.model.Product;
import com.maggioli.rest.finalEx.repository.CartRepository;
import com.maggioli.rest.finalEx.repository.PersonRepository;

@Service
public class PersonManager {
	
	/*
	- CERCA USER (non serve) *
	- REGISTRAZIONE *
	- CANCELLAZIONE USER *
	- MODIFICA USER (MA NON USERNAME!!!) *
 */
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	public Optional<Person> getById(String userId) {
		return personRepository.findById(userId);
	}

	public boolean addProductToCart(Product product) {
		//TODO: Not implemented
		return false;
	}

	public boolean add(Person person) {
		
		//Controllo la lunghezza
		if(StringUtils.hasText( StringUtils.trimWhitespace(person.getUsername()) ) &&
				person.getUsername().length() < 255 &&
				!personRepository.existsById(person.getUsername()))
		{
			person.setCart(new Cart(person));
			person = personRepository.save(person);
			
			//cartRepository.save(person.getCart());
			return true; //Return true as user has been added
		}
		return false;
	}
	
	public boolean update(Person person) {
		if(person.getUsername().length() < 255 && personRepository.existsById(person.getUsername()))
		{
			personRepository.save(person);
			return true; //Return true as user has been added
		}
		return false;
	}
	
	public boolean delete(String username) {
		if(username.length() < 255 && personRepository.existsById(username))
		{
			personRepository.deleteById(username);
			return true;
		}
		return false;
	}
}
