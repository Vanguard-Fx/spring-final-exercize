package com.maggioli.rest.finalEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maggioli.rest.finalEx.manager.PersonManager;
import com.maggioli.rest.finalEx.model.Person;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	PersonManager pManager;
	
	@GetMapping(path = "/echo")
	public ResponseEntity<String> getByIdMethod(@RequestParam(name = "value") String value) {
		return ResponseEntity.ok(value);
	}
	
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Person>> getAllMethod() {
		return ResponseEntity.ok(pManager.getAll());
	}
}
