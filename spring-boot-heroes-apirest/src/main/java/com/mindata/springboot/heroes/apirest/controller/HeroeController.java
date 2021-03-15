package com.mindata.springboot.heroes.apirest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mindata.springboot.heroes.apirest.entity.Heroe;
import com.mindata.springboot.heroes.apirest.repository.HeroeRepository;

@RestController
public class HeroeController {

	private static final Logger logger = LoggerFactory.getLogger(HeroeController.class);
	@Autowired
	private HeroeRepository heroeRepository;

	@PostMapping("crearHeroe")
	public ResponseEntity<Object> save(Heroe heroe) {
		logger.info("creaHeroe :" + heroe.toString());
		try {
			Heroe crearHeroe = heroeRepository.save(heroe);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(crearHeroe.getId()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error Message: Error al crear el Heroe");
		}
	}

	@GetMapping("/consultarHeroes")
	public List<Heroe> findAll() {
		return (List<Heroe>) heroeRepository.findAll();
	}

	@GetMapping("/buscarHeroePorId")
	public Optional<Heroe> findById(int id) {
		return heroeRepository.findById(id);	
	}

	@Transactional
	@PostMapping("/borrarHeroe")
	public void deleteUserById(int id) {
		heroeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
				"el Heroe con id : " + id + " No existe, por favor intente con otro ID! "));
		heroeRepository.deleteById(id);
	}

	@GetMapping("/buscarHeroeQueContienen")
	public List<Heroe> findByFiestnameEndWith(String nombre) {
		return (List<Heroe>) heroeRepository.findByFiestnameEndWith(nombre);
	}

	@PutMapping("/modificarHeroe")
	public ResponseEntity<Object> setHeroeInfoById(@RequestBody Heroe heroe, @PathVariable final int id) {
		logger.info("creaHeroe :" + heroe.toString());
		try {

			Heroe crearHeroe = heroeRepository.setHeroeInfoById(id, heroe.getNombre(), heroe.getHabilidad(),
					heroe.getEdad());
			;
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(crearHeroe.getId()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error Message: Error al crear el Heroe");
		}
	}

}
