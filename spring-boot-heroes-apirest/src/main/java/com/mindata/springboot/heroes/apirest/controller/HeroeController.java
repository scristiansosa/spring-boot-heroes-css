package com.mindata.springboot.heroes.apirest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	
	@Cacheable("heroes")
	@GetMapping("/buscarHeroePorId")
	public Optional<Heroe> findById(int id) {
		logger.info("buscar Heroe ID:" + id);
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

	@PutMapping("/modificarHeroe/{id}")
	public ResponseEntity<Object> setHeroeInfoById(@RequestBody Heroe heroe, @PathVariable(value = "id") Integer id) {
		logger.info("creaHeroe :" + heroe.toString());
		try {
			Optional<Heroe> heroeActual = heroeRepository.findById(id);
			heroeActual.get().setEdad(heroe.getEdad());
			heroeActual.get().setNombre(heroe.getNombre());
			heroeActual.get().setHabilidad(heroe.getHabilidad());
			heroeRepository.save(heroeActual.get());

			return ResponseEntity.status(HttpStatus.OK)
					.body("El Heroe se modifico con exito:" + heroeActual.get().toString());
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error Message: Error al crear el Heroe");
		}

	}

}
