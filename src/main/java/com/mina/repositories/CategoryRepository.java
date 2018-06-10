package com.mina.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mina.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
