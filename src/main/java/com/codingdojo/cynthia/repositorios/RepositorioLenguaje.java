package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Lenguaje;

@Repository
public interface RepositorioLenguaje extends CrudRepository <Lenguaje, Long> {
	
	List <Lenguaje> findAll();
	
}
