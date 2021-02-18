package com.maggioli.rest.finalEx.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maggioli.rest.finalEx.manager.PersonManager;
import com.maggioli.rest.finalEx.manager.ProductManager;
import com.maggioli.rest.finalEx.model.Person;
import com.maggioli.rest.finalEx.model.Product;

@Controller
@RequestMapping("/user")
public class PersonController {
	@Autowired
	PersonManager personManager;
	
	@Autowired
	ProductManager productManager;
	
	/*
		- CERCA USER (non serve) *
		- INSERISCI NEL CARRELLO -> Cart mananer
		- ELIMINA DAL CARRELLO  -> Cart mananer
		- FINALIZZA CARRELLO -> Cart mananer
		- REGISTRAZIONE 
		- CANCELLAZIONE USER
		- MODIFICA USER (MA NON USERNAME!!!)
	 */
	
	@GetMapping(path = "/get")
	public ResponseEntity<Optional<Person>> getUserByIdMethod(@RequestParam(name = "user_id") String userId) {
		return ResponseEntity.ok(personManager.getById(userId));
	}
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addNewUserMethod(@RequestBody Person person) {
		if(personManager.add(person)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping(path = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addProductMethod(@RequestBody Product product) {
		return ResponseEntity.ok(personManager.addProductToCart(product));
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Person>> getAllMethod() {
		return ResponseEntity.ok(personManager.getAll());
	}
}
