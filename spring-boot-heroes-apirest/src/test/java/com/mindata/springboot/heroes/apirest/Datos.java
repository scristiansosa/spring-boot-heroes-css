package com.mindata.springboot.heroes.apirest;

import java.util.Arrays;
import java.util.List;

import com.mindata.springboot.heroes.apirest.entity.Heroe;

public class Datos {
	public final static List<Heroe> HEROESLIST = Arrays.asList(new Heroe(1,"Superman","Volar",35),new Heroe(1,"Flash","Velocidad",22));

}
