package com.mindata.springboot.heroes.apirest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindata.springboot.heroes.apirest.entity.Heroe;
import com.mindata.springboot.heroes.apirest.repository.HeroeRepository;

@SpringBootTest
class SpringBootHeroesApirestApplicationTests {

	HeroeRepository heroeRepository;

	@BeforeEach
	void setUp() {
		heroeRepository = mock(HeroeRepository.class);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void findAll() {

		List<Heroe> heroes = (List<Heroe>) heroeRepository.findAll();
		assertNotNull(heroes);
	}

	void findById() {
		when(heroeRepository.findAll()).thenReturn(Datos.HEROESLIST);
		Optional<Heroe> heroe = heroeRepository.findById(1);
		assertTrue(heroe.isPresent());
	}

}
