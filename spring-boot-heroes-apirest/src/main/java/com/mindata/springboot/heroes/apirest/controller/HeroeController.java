package com.mindata.springboot.heroes.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

	@GetMapping("/buscarHeroePorId")
	public Optional<Heroe> findById(Long id) {
		return heroeRepository.findById(id);
	}
	
	@Transactional
	@PostMapping("borrarHeroe")
	public void deleteUserById(Long id) {
		heroeRepository.findById(id)
		        .orElseThrow(() -> new IllegalArgumentException("el Heroe con id : " + id +" No existe, por favor intente con otro ID! "));
		heroeRepository.deleteById(id);
	}


}
