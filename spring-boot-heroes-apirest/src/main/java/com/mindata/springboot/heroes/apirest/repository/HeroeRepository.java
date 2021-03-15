package com.mindata.springboot.heroes.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mindata.springboot.heroes.apirest.entity.Heroe;

public interface HeroeRepository extends CrudRepository<Heroe, Integer> {

	@Query("select h from Heroe h where lower(h.nombre) like %?1%")
	public List<Heroe> findByFiestnameEndWith(String nombre);

	@Modifying(clearAutomatically = true)
	@Query("update Heroe h set h.nombre = ?1, h.habilidad = ?2, h.edad = ?3 where h.id = ?4")
	public Heroe setHeroeInfoById(@Param("id") int id, String nombre, String habilidad, int edad);

}
