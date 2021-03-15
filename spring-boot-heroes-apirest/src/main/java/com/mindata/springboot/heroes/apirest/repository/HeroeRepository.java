package com.mindata.springboot.heroes.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindata.springboot.heroes.apirest.entity.Heroe;

public interface HeroeRepository extends CrudRepository<Heroe, Long> {

}
