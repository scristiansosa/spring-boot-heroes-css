package com.mindata.springboot.heroes.apirest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindata.springboot.heroes.apirest.entity.Heroe;
import com.mindata.springboot.heroes.apirest.repository.HeroeRepository;



@RestController
public class HeroeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HeroeController.class);
	@Autowired
	private HeroeRepository heroeRepository;
	
	@PostMapping("crearHeroe")
	public void save(Heroe heroe) {
		heroeRepository.save(heroe);
	}
	
	@GetMapping("/consultarHeroes")
	public List<Heroe> findAll() {
		return (List<Heroe>) heroeRepository.findAll();
	}
	
}
