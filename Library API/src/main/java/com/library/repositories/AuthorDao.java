package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.entities.Author;

public interface AuthorDao  extends CrudRepository<Author, Long>{

}
