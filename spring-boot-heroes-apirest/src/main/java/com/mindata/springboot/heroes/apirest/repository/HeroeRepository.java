package com.mindata.springboot.heroes.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mindata.springboot.heroes.apirest.entity.Heroe;

public interface HeroeRepository extends CrudRepository<Heroe, Long> {
	
	@Query("select h from Heroe h where lower(h.nombre) like %?1%")
	public List<Heroe> findByFiestnameEndWith(String nombre);
	
}
