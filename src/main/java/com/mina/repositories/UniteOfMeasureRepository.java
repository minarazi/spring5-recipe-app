package com.mina.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mina.domain.UniteOfMeasure;

public interface UniteOfMeasureRepository extends CrudRepository<UniteOfMeasure, Long>{

	Optional<UniteOfMeasure> findByUom(String uom);
}
