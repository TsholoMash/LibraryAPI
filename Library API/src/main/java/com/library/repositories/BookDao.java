package com.library.repositories;

import org.springframework.data.repository.CrudRepository;

import com.library.entities.Book;

public interface BookDao extends CrudRepository<Book, Long> {

}
